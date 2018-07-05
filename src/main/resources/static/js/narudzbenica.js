var token;
function highlightRow(row) {
	// ne reagujemo na klik na header tabele, samo obicne redove
	// this sadrzi red na koji se kliknulo
	if (!$(row).hasClass("header")) {
		// klasa highlighted postavlja pozadinu na plavu
		// njenim dodavanjem ili uklanjanjem oznacavamo da neki red
		// dobija, odnosno gubi selekciju
		// uklanjamo sa trenutno selektovanog
		$(".highlighted").removeClass("highlighted");
		// dodajemo na novi selektovani
		$(row).addClass("highlighted");
		// pozivamo sinhronizaciju, prosledjujemo dati red
		sync($(row));
	}
}

function sync(item) {
	id = item.find(".id").html();
	kolicina = item.find(".kolicina").html();
	poslovnaGodina = item.find(".poslovnaGodina").html();
	poslovniPartner = item.find(".poslovniPartner").html();
	$("#narudzbenicaId").val(id);
	$("#kolicina").val(kolicina);
	$("#poslovnaGodina").val(poslovnaGodina);
	$("#poslovniPartner").val(poslovniPartner);
	
}

$(document).on("click", "tr", function(event) {
	highlightRow(this)
});

$(document).on("click", ".remove", function(event){
	//ne salji get zahtev
	event.preventDefault(); 
	url = $(this).attr("href")
	//red koji se treba izbrisati ako je brisanje na serveru bilo uspesno
	tr_parent = $(this).closest("tr")
	$.ajax({
    	url: url,
    	type: "DELETE",
    	success: function(){
    		//ukloni i na strani 
			tr_parent.remove()
        }
	});
});

$(document).ready(function() {
	token = localStorage.getItem('token');

    if (!token) {
        window.location.replace("/login.html");
    }
	$("#narudzbenicaPickup").click(function() {
		id = $(".highlighted").find(".id").html();
		$("select").val(id);
		$('#narudzbenicaModal').modal('toggle');
	});
	
	$("#first").click(function(){
		goFirst();
	 });
	
	$("#last").click(function(){
		goLast();
	 });
	
	$("#next").click(function(){
		goNext();
	 });
	
	$("#prev").click(function(){
		goPrevious();
	 });

	console.log("Krece ajax");
	$.ajax({
		url : "http://localhost:8080/api/narudzbenice/",
		type: "GET",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},
    	success: function(data) {
					console.log("Uspeo")
					for (i = 0; i < data.length; i++) {
						var newRow = "<tr>"
						+ "<td class=\"id\">"
						+ data[i].id
						+ "</td>"
						+ "<td class=\"kolicina\">"
						+ data[i].kolicina
						+ "</td>"
						+ "<td class=\"poslovnaGodina\">"
						+ data[i].poslovnaGodina
						+ "</td>"
						+ "<td class=\"poslovniPartner\">"
						+ data[i].poslovniPartner
						+ "</td>"
						+ "<td><a class=\"remove\" href='/api/narudzbenice/" + data[i].id + "'>"
						+ "<img src='images/remove.gif'/></a></td>"
						+ "<td style=\"visibility: hidden; max-width: 0px;\" class=\"id\">"
						+ data[i].id + "</td>"
						$("#dataTable").append(newRow)
					}
		},
    	error: function(err) {
    		console.log(err);
    	}
	});
	
	
	$("#add").click(function(){
		// pripremamo JSON koji cemo poslati
			console.log("start");
			formData = JSON.stringify({
	            id : $("#inputForm [name='id']").val(),
	            kolicina :$("#inputForm [name='kolicina']").is(":checked"),
	            poslovnaGodina :$("#inputForm [name='poslovnaGodina']").is(":checked"),
	            poslovniPartner :$("#inputForm [name='poslovniPartner']").is(":checked")
	        });
			console.log(formData);
			$.ajax({
				url: "http://localhost:8080/api/narudzbenice",
				type: "POST",
				data: formData,
				// saljemo json i ocekujemo json nazad
				contentType: "application/json",
				datatype: 'json',
				beforeSend: function (request) {
		            request.setRequestHeader("X-Auth-Token", token);
				},
				success: function(data) {
					var newRow = "<tr>"
					+ "<td class=\"id\">"
					+ data.id
					+ "</td>"
					+ "<td class=\"kolicina\">"
					+ data.kolicina
					+ "</td>"
					+ "<td class=\"poslovnaGodina\">"
					+ data.poslovnaGodina
					+ "</td>"
					+ "<td class=\"poslovniPartner\">"
					+ data.poslovniPartner
					+ "</td>"
					+ "<td><a class=\"remove\" href='/api/narudzbenice/" + data.id + "'>"
					+ "<img src='images/remove.gif'/></a></td>"
					+ +"<td class=\"idCell\">"
					+ data.id + "</td>"
					"</tr>"
					$("#dataTable").append(newRow)
				  }
				});
			$('#inputModal').modal('toggle');
			console.log("end");
	 });
	
	$("#potvrda").on("click", function(event){
		event.preventDefault();
		console.log("Kliknuta potvrda");
		var formData = JSON.stringify({
			id : $("#editForm [name='id']").val(),
            kolicina : $("#editForm [name='kolicina']").val(),
            poslovnaGodina :$("#editForm [name='poslovnaGodina']").is(":checked"),
            poslovniPartner :$("#editForm [name='poslovniPartner']").is(":checked")
        });
		console.log(formData);
		$.ajax({
			url: "http://localhost:8080/api/narudzbenice/" + $("#editForm [name='id']").val(),
			type: "PUT",
			data: formData,
			// saljemo json i ocekujemo json nazad
			contentType: "application/json",
			datatype: 'json',
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
			},
			success: function(data) {
				$(".highlighted").find(".kolicina")[0].innerHTML = data.kolicina;
				$(".highlighted").find(".poslovniPartner")[0].innerHTML = data.poslovniPartner;
				$(".highlighted").find(".poslovnaGodina")[0].innerHTML = data.poslovnaGodina;
			  },
			error: function() {
				console.log("Nije updateovao!")
			}
			});
	});
	
	$("#rollback").click(function(event){
		event.preventDefault();
		sync($(".highlighted"));
	});
});
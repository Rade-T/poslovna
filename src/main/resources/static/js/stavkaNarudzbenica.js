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
	cenaPoJediniciMere = item.find(".cenaPoJediniciMere").html();
	ukupnaCena = item.find(".ukupnaCena").html();
	robaUsluga = item.find(".robaUsluga").html();
	narudzbenica = item.find(".narudzbenica").html();
	$("#id").val(id);
	$("#kolicina").val(kolicina);
	$("#cenaPoJediniciMere").val(cenaPoJediniciMere);
	$("#ukupnaCena").val(ukupnaCena);
	$("#robaUsluga").val(robaUsluga);
	$("#narudzbenica").val(narudzbenica);
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
	$("#stavkeNarudzbenicaPickup").click(function() {
		id = $(".highlighted").find(".id").html();
		$("select").val(id);
		$('#stavkeNarudzbenicaModal').modal('toggle');
	});
	
	$("#logoutLink").on("click", function(event) {
		event.preventDefault();
		logout();
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
		url : "http://localhost:8080/api/stavke-narudzbenica/",
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
						+ "<td class=\"cenaPoJediniciMere\">"
						+ data[i].cenaPoJediniciMere
						+ "</td>"
						+ "<td class=\"ukupnaCena\">"
						+ data[i].ukupnaCena
						+ "</td>"
						+ "<td class=\"robaUsluga\">"
						+ data[i].robaUsluga
						+ "</td>"
						+ "<td class=\"narudzbenica\">"
						+ data[i].narudzbenica
						+ "</td>"
						+ "<td><a class=\"remove\" href='/api/stavke-narudzbenica/" + data[i].id + "'>"
						+ "<img src='images/remove.gif'/></a></td>"
						+ "<td style=\"visibility: hidden; max-width: 0px;\" class=\"id\">"
						+ data[i].id + "</td>"
						$("#dataTable").append(newRow)
						console.log(data);
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
	            cenaPoJediniciMere :$("#inputForm [name='cenaPoJediniciMere']").is(":checked"),
	            ukupnaCena :$("#inputForm [name='ukupnaCena']").is(":checked"),
	            robaUsluga :$("#inputForm [name='robaUsluga']").is(":checked"),
	            narudzbenica :$("#inputForm [name='narudzbenica']").is(":checked"),
	            
	        });
			console.log(formData);
			$.ajax({
				url: "http://localhost:8080/api/stavke-narudzbenica",
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
					+ "<td class=\"kolicna\">"
					+ data.kolicina
					+ "</td>"
					+ "<td class=\"cenaPoJediniciMere\">"
					+ data.cenaPoJediniciMere
					+ "</td>"
					+ "<td class=\"ukupnaCena\">"
					+ data.ukupnaCena
					+ "</td>"
					+ "<td class=\"robaUsluga\">"
					+ data.robaUsluga
					+ "</td>"
					+ "<td class=\"narudzbenica\">"
					+ data.narudzbenica
					+ "</td>"
					+ "<td><a class=\"remove\" href='/api/stavke-narudzbenica/" + data.id + "'>"
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
			id : $("#editForm [name='porezId']").val(),
            kolicina : $("#editForm [name='kolicina']").val(),
            cenaPoJediniciMere :$("#editForm [name='cenaPoJediniciMere']").is(":checked"),
            ukupnaCena :$("#editForm [name='ukupnaCena']").is(":checked"),
            robaUsluga :$("#editForm [name='robaUsluga']").is(":checked"),
            narudzbenica :$("#editForm [name='narudzbenica']").is(":checked")
        });
		console.log(formData);
		$.ajax({
			url: "http://localhost:8080/api/stavke-narudzbenica/" + $("#editForm [name='id']").val(),
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
				$(".highlighted").find(".cenaPoJediniciMere")[0].innerHTML = data.cenaPoJediniciMere;
				$(".highlighted").find(".ukupnaCena")[0].innerHTML = data.ukupnaCena;
				$(".highlighted").find(".robaUsluga")[0].innerHTML = data.robaUsluga;
				$(".highlighted").find(".narudzbenica")[0].innerHTML = data.narudzbenica;
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
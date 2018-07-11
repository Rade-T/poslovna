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
    	beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},
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
	
	$.ajax({
		type: "GET",
		url : "http://localhost:8080/api/robe-usluge",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},})
		.then(
				function(data) {
					console.log("Uspeo")
					for (i = 0; i < data.length; i++) {
						var newOption = '<option value="' + data[i].id + '">'
						+ data[i].naziv + '</option>';
						$("#robaUsluga").append(newOption);
					}
	});
	
	$.ajax({
		type: "GET",
		url : "http://localhost:8080/api/narudzbenice",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},})
		.then(
				function(data) {
					console.log("Uspeo")
					for (i = 0; i < data.length; i++) {
						var newOption = '<option value="' + data[i].id + '">'
						+ data[i].id + '</option>';
						$("#narudzbenica").append(newOption);
					}
	});
	
	$('#inputModal').on('shown.bs.modal', function (e) {
		$.ajax({
			type: "GET",
			url : "http://localhost:8080/api/robe-usluge",
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
	    	},})
			.then(
					function(data) {
						console.log("Uspeo")
						for (i = 0; i < data.length; i++) {
							var newOption = '<option value="' + data[i].id + '">'
							+ data[i].naziv + '</option>';
							$("#robaUslugaSelect").append(newOption);
						}
		});
		
		$.ajax({
			type: "GET",
			url : "http://localhost:8080/api/narudzbenice",
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
	    	},})
			.then(
					function(data) {
						console.log("Uspeo")
						for (i = 0; i < data.length; i++) {
							var newOption = '<option value="' + data[i].id + '">'
							+ data[i].id + '</option>';
							$("#narudzbenicaSelect").append(newOption);
						}
		});
	});
	
	$("#add").click(function(){
		// pripremamo JSON koji cemo poslati
			console.log("start");
			formData = JSON.stringify({
	        
	            kolicina :$("#inputForm [name='kolicina']").val(),
	            cenaPoJediniciMere :$("#inputForm [name='cenaPoJediniciMere']").val(),
	            ukupnaCena :$("#inputForm [name='ukupnaCena']").val(),
	            robaUsluga :$("#inputForm #robaUslugaSelect").val(),
	            narudzbenica :$("#inputForm #narudzbenicaSelect").val()
	            
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
			location.reload();
			$('#inputModal').modal('toggle');
			console.log("end");
	 });
	
	$("#potvrda").on("click", function(event){
		event.preventDefault();
		console.log("Kliknuta potvrda");
		var formData = JSON.stringify({
            kolicina : $("#editForm [name='kolicina']").val(),
            cenaPoJediniciMere :$("#editForm [name='cenaPoJediniciMere']").val(),
            ukupnaCena :$("#editForm [name='ukupnaCena']").val(),
            robaUsluga :$("#editForm [name='robaUsluga']").val(),
            narudzbenica :$("#editForm [name='narudzbenica']").val()
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
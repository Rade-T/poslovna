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
	kolicina = item.find(".kolicina").html();
	id = item.find(".id").html();
	cenaPoJediniciMere = item.find(".cenaPoJediniciMere").html();
	ukupnaCena = item.find(".ukupnaCena").html();
	otpremnica = item.find(".optremnica").html();
	robaUsluga = item.find(".robaUsluga").html();
	
	$("#stavkeOtpremniceId").val(id);
	$("#kolicina").val(kolicina);
	$("#cenaPoJediniciMere").val(cenaPoJediniciMere);
	$("#ukupnaCena").val(ukupnaCena);
	$("#robaUsluga").val(robaUsluga);
	$("#editForm #otpremnica").val(otpremnica);
	
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
    	beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},
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
	$("#porezPickup").click(function() {
		id = $(".highlighted").find(".id").html();
		$("select").val(id);
		$('#porezModal').modal('toggle');
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
		type: "GET",
		url : "http://localhost:8080/api/stavke-otpremnice/",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	}})
		.then(
				function(data) {
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
						+ "<td class=\"optremnica\">"
						+ data[i].optremnica
						+ "</td>"
						+ "<td class=\"robaUsluga\">"
						+ data[i].robaUsluga
						+ "</td>"
						+ "<td><a class=\"remove\" href='/api/stavke-otpremnice/" + data[i].id + "'>"
						+ "<img src='images/remove.gif'/></a></td>"
						+ "<td style=\"visibility: hidden; max-width: 0px;\" class=\"id\">"
						+ data[i].id + "</td>"
						$("#dataTable").append(newRow)
						console.log(data);
					}
				});
	$.ajax({
		type: "GET",
		url : "http://localhost:8080/api/otpremnice",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},})
		.then(
				function(data) {
					console.log("Uspeo")
					for (i = 0; i < data.length; i++) {
						var newOption = '<option value="' + data[i].brojOtpremnice + '">'
						+ data[i].brojOtpremnice + '</option>';
						$("#otpremnica").append(newOption);
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
	
$('#inputModal').on('shown.bs.modal', function (e) {
	$.ajax({
		type: "GET",
		url : "http://localhost:8080/api/otpremnice",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},})
		.then(
				function(data) {
					console.log("Uspeo")
					for (i = 0; i < data.length; i++) {
						var newOption = '<option value="' + data[i].brojOtpremnice + '">'
						+ data[i].brojOtpremnice + '</option>';
						$("#inputModal #otpremnica").append(newOption);
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
						$("#inputModal #robaUsluga").append(newOption);
					}
	});
	});
	
	$("#add").click(function(){
		// pripremamo JSON koji cemo poslati
			console.log("start");
			formData = JSON.stringify({
				kolicina : $("#inputForm [name='kolicina']").val(),
				cenaPoJediniciMere : $("#inputForm [name='cenaPoJediniciMere']").val(),
				ukupnaCena : $("#inputForm [name='ukupnaCena']").val(),
				optremnica : $("#inputForm [name='otpremnica']").val(),
				robaUsluga : $("#inputForm [name='robaUsluga']").val(),

	        });
			console.log(formData);
			$.ajax({
				url: "http://localhost:8080/api/stavke-otpremnice/",
				type: "POST",
				beforeSend: function (request) {
		            request.setRequestHeader("X-Auth-Token", token);
		    	},
				data: formData,
				// saljemo json i ocekujemo json nazad
				contentType: "application/json",
				datatype: 'json',
				success: function(data) {
					var newRow = "<tr>"
					+ "<td class=\"kolicina\">"
					+ data.kolicina
					+ "</td>"
					+ "<td class=\"cenaPoJediniciMere\">"
					+ data.cenaPoJediniciMere
					+ "</td>"
					+ "<td class=\"ukupnaCena\">"
					+ data.ukupnaCena
					+ "</td>"
					+ "<td class=\"otpremnica\">"
					+ data.otpremnica
					+ "</td>"
					+ "<td class=\"robaUsluga\">"
					+ data.robaUsluga
					+ "</td>"
					+ "<td><a class=\"remove\" href='/api/stavke-otpremnica/" + data.id + "'>"
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
			cenaPoJediniciMere : $("#editForm [name='cenaPoJediniciMere']").val(),
			ukupnaCena : $("#editForm [name='ukupnaCena']").val(),
			optremnica : $("#editForm [name='otpremnica']").val(),
			robaUsluga : $("#editForm [name='robaUsluga']").val(),
          
        });
		console.log(formData);
		$.ajax({
			url: "http://localhost:8080/api/stavke-otpremnice/" + $("#editForm [name='stavkeOtpremniceId']").val(),
			type: "PUT",
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
	    	},
			data: formData,
			// saljemo json i ocekujemo json nazad
			contentType: "application/json",
			datatype: 'json',
			success: function(data) {
				$(".highlighted").find(".kolicina")[0].innerHTML = data.kolicina;
				$(".highlighted").find(".cenaPoJediniciMere")[0].innerHTML = data.cenaPoJediniciMere;
				$(".highlighted").find(".ukupnaCena")[0].innerHTML = data.ukupnaCena;
				$(".highlighted").find(".otpremnica")[0].innerHTML = data.otpremnica;
				$(".highlighted").find(".robaUsluga")[0].innerHTML = data.robaUsluga;
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
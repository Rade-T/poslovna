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
	datumOtpremnice = item.find(".datumOtpremnice").html()
	id = item.find(".brojOtpremnice").html()
	osnovica = item.find(".osnovica").html()
	ukupanPDV = item.find(".ukupanPDV").html()
	iznosZaPlacanje = item.find(".iznosZaPlacanje").html()
	poslovnaGodina = item.find(".poslovnaGodina").html()
	poslovnaPartner = item.find(".poslovnaPartner").html()
	narudzbenica = item.find(".narudzbenicaSelect").html()
	$("#datumOtpremnice").val(datumOtpremnice);
	$("#brojOtpremnice").val(id);
	$("#osnovica").val(osnovica);
	$("#ukupanPDV").val(ukupanPDV);
	$("#iznosZaPlacanje").val(iznosZaPlacanje);
	$("#poslovnaGodina").val(poslovnaGodina);
	$("#poslovnaPartner").val(poslovnaPartner);
	$("#naruzbenicaSelect").val(narudzbenica);
	
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
	$("#porezPickup").click(function() {
		id = $(".highlighted").find(".id").html();
		$("select").val(id);
		$('#porezModal').modal('toggle');
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
		url : "http://localhost:8080/api/otpremnice/",
		type: "GET",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},
		success: function(data) {
			console.log("Uspeo")
			for (i = 0; i < data.length; i++) {
				var newRow = "<tr>"
				+ "<td class=\"datumOtpremnice\">"
				+ data[i].datumOtpremnice
				+ "</td>"
				+ "<td class=\"brojOtpremnice\">"
				+ data[i].brojOtpremnice
				+ "</td>"
				+ "<td class=\"osnovica\">"
				+ data[i].osnovica
				+ "</td>"
				+ "<td class=\"ukupanPDV\">"
				+ data[i].ukupanPDV
				+ "</td>"
				+ "<td class=\"iznosZaPlacanje\">"
				+ data[i].iznosZaPlacanje
				+ "</td>"
				+ "<td class=\"poslovnaGodina\">"
				+ data[i].poslovnaGodina
				+ "</td>"
				+ "<td class=\"poslovniPartner\">"
				+ data[i].poslovniPartner
				+ "</td>"
				+ "<td class=\"narudzbenica\">"
				+ data[i].narudzbenica
				+ "</td>"
				
				+ "<td><a class=\"remove\" href='/api/otpremnice/" + data[i].brojOtpremnice + "'>"
				+ "<img src='images/remove.gif'/></a></td>"
				+ "<td style=\"visibility: hidden; max-width: 0px;\" class=\"id\">"
				+ data[i].id + "</td>"
				$("#dataTable").append(newRow)
			}
		}
	});

	$.ajax({
		url : "http://localhost:8080/api/poslovne-godine/",
		type: "GET",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},
    	success: function(data) {
			for (i = 0; i < data.length; i++) {
				var newOption = '<option value="' + data[i].id + '">'
				+ data[i].godina + '</option>';
				$("#poslovnaGodina").append(newOption);
			}
    	}
	});
	
	$.ajax({
		url : "http://localhost:8080/api/poslovni-partneri/",
		type: "GET",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},
    	success: function(data) {
			for (i = 0; i < data.length; i++) {
				var newOption = '<option value="' + data[i].id + '">'
				+ data[i].nazivPartnera + '</option>';
				$("#poslovniPartner").append(newOption);
			}
    	}
	});
	
	$.ajax({
		url : "http://localhost:8080/api/narudzbenice/",
		type: "GET",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},
    	success: function(data) {
			for (i = 0; i < data.length; i++) {
				var newOption = '<option value="' + data[i].id + '">'
				+ data[i].id + '</option>';
				$("#narudzbenicaSelect").append(newOption);
			}
    	}
	});
				
	$('#inputModal').on('shown.bs.modal', function (e) {
		$.ajax({
			url: "http://localhost:8080/api/narudzbenice/",
			type: "GET",
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
	    	},
			success: function(data) {
				for (i = 0; i < data.length; i++) {
					console.log(i);
					var newOption = '<option value="' + data[i].id + '">'
					+ data[i].id + '</option>';
					console.log(data[i]);
					$(e.currentTarget).find('select[name="narudzbenicaSelect"]').append(newOption);
				}
			}
		});
		
		$.ajax({
			url: "http://localhost:8080/api/poslovni-partneri/",
			type: "GET",
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
	    	},
			success: function(data) {
				for (i = 0; i < data.length; i++) {
					console.log(i);
					var newOption = '<option value="' + data[i].id + '">'
					+ data[i].nazivPartnera + '</option>';
					console.log(data[i]);
					$(e.currentTarget).find('select[name="poslovniPartnerSelect"]').append(newOption);
				}
			}
		});
		
		$.ajax({
			url: "http://localhost:8080/api/poslovne-godine/",
			type: "GET",
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
	    	},
			success: function(data) {
				for (i = 0; i < data.length; i++) {
					console.log(i);
					var newOption = '<option value="' + data[i].id + '">'
					+ data[i].godina + '</option>';
					console.log(data[i]);
					$(e.currentTarget).find('select[name="poslovnaGodinaSelect"]').append(newOption);
				}
			}
		});
	});
	
	$("#add").click(function(){
		// pripremamo JSON koji cemo poslati
			console.log("start");
			formData = JSON.stringify({
	            datumOtpremnice : $("#inputForm [name='datumOtpremnice']").val(),
	            brojOtpremnice : $("#inputForm [name='brojOtpremnice']").val(),
	            osnovica : $("#inputForm [name='osnovica']").val(),
	            ukupanPDV : $("#inputForm [name='ukupanPDV']").val(),
	            iznosZaPlacanje : $("#inputForm [name='iznosZaPlacanje']").val(),
	            poslovnaGodina : $("#inputForm [name='poslovnaGodinaSelect']").val(),
	            poslovniPartner : $("#inputForm [name='poslovniPartnerSelect']").val(),
	            narudzbenica : $("#inputForm [name='narudzbenicaSelect']").val()
	            
	        });
			console.log(formData);
			$.ajax({
				url: "http://localhost:8080/api/otpremnice",
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
					+ "<td class=\"datumOtpremnice\">"
						+ data.datumOtpremnice
						+ "</td>"
						+ "<td class=\"brojOtpremnice\">"
						+ data.brojOtpremnice
						+ "</td>"
						+ "<td class=\"osnovica\">"
						+ data.osnovica
						+ "</td>"
						+ "<td class=\"ukupanPDV\">"
						+ data.ukupanPDV
						+ "</td>"
						+ "<td class=\"iznosZaPlacanje\">"
						+ data.iznosZaPlacanje
						+ "</td>"
						+ "<td class=\"poslovnaGodina\">"
						+ data.poslovnaGodina
						+ "</td>"
						+ "<td class=\"poslovniPartner\">"
						+ data.poslovniPartner
						+ "</td>"
						+ "<td class=\"narudzbenica\">"
						+ data.narudzbenica
						+ "</td>"
					+ "<td><a class=\"remove\" href='/api/otpremnice/" + data.brojOtpremnice + "'>"
					+ "<img src='images/remove.gif'/></a></td>"
					+ +"<td class=\"brojOtpremnice\">"
					+ data.brojOtpremnice + "</td>"
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
            datumPrimene : $("#editForm [name='datumOtpremnice']").val(),
            brojOtpremnice : $("#editForm [name='brojOtpremnice']").val(),
	        osnovica : $("#editForm [name='osnovica']").val(),
	        ukupanPDV : $("#editForm [name='ukupanPDV']").val(),
	        iznosZaPlacanje : $("#editForm [name='iznosZaPlacanje']").val(),
	        poslovnaGodina : $("#editForm [name='poslovnaGodina']").val(),
	        poslovniPartner : $("#editForm [name='poslovniPartner']").val(),
	        narudzbenica : $("#editForm [name='narudzbenicaSelect']").val(),
            
        });
		console.log(formData);
		$.ajax({
			url: "http://localhost:8080/api/otpremnice/" + $("#editForm [name='brojOtpremnice']").val(),
			type: "PUT",
			data: formData,
			// saljemo json i ocekujemo json nazad
			contentType: "application/json",
			datatype: 'json',
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
	    	},
			success: function(data) {
				$(".highlighted").find(".datumOtpremnice")[0].innerHTML = data.datumOtpremnice;
				$(".highlighted").find(".brojOtpremnice")[0].innerHTML = data.brojOtpremnice;
				$(".highlighted").find(".osnovica")[0].innerHTML = data.osnovica;
				$(".highlighted").find(".ukupanPDV")[0].innerHTML = data.ukupanPDV;
				$(".highlighted").find(".iznosZaPlacanje")[0].innerHTML = data.iznosZaPlacanje;
				$(".highlighted").find(".poslovnaGodina")[0].innerHTML = data.poslovnaGodina;
				$(".highlighted").find(".poslovniPartner")[0].innerHTML = data.poslovniPartner;
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
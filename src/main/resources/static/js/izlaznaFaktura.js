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
	datumFakture = item.find(".datumFakture").html();
	brojFakture = item.find(".brojFakture").html();
	datumValute = item.find(".datumValute").html();
	datumObracuna = item.find(".datumObracuna").html();
	ukupnoRobe = item.find(".ukupnoRobe").html();
	ukupanRabat = item.find(".ukupanRabat").html();
	ukupanPorez = item.find(".ukupanPorez").html();
	iznosFakture = item.find(".iznosFakture").html();
	iznosFaktureOsnovica = item.find(".iznosFaktureOsnovica").html();
	uplataNaRacun = item.find(".uplataNaRacun").html();
	pozivNaBroj = item.find(".pozivNaBroj").html();
	statusFakture = item.find(".statusFakture").html();
	poslovniPartner = item.find(".poslovniPartner").html();
	poslovnaGodina = item.find(".poslovnaGodina").html();
	otpremnica = item.find(".otpremnica").html();
	
	$("#brojFakture").val(brojFakture);
	$("#datumFakture").val(datumFakture);
	$("#datumValute").val(datumValute);
	$("#datumObracuna").val(datumObracuna);
	$("#ukupnoRobe").val(ukupnoRobe);
	$("#ukupanRabat").val(ukupanRabat);
	$("#ukupanPorez").val(ukupanPorez);
	$("#iznosFakture").val(iznosFakture);
	$("#iznosFaktureOsnovica").val(iznosFaktureOsnovica);
	$("#uplataNaRacun").val(uplataNaRacun);
	$("#pozivNaBroj").val(pozivNaBroj);
	$("#statusFakture").val(statusFakture);
	$("#poslovniPartner").val(poslovniPartner);
	$("#poslovnaGodina").val(poslovnaGodina);
	$("#otpremnica").val(otpremnica);

}

$(document).on("click", "tr", function(event) {
	highlightRow(this)
});

$(document).on("click", ".remove", function(event){
	// ne salji get zahtev
	event.preventDefault(); 
	url = $(this).attr("href")
	// red koji se treba izbrisati ako je brisanje na serveru bilo uspesno
	tr_parent = $(this).closest("tr")
	$.ajax({
    	url: url,
    	type: "DELETE",
    	beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},
    	success: function(){
    		// ukloni i na strani
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
		url : "http://localhost:8080/api/izlazne-fakture/",
		type: "GET",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},
    	success: function(data) {
					console.log("Uspeo")
					for (i = 0; i < data.length; i++) {
						var newRow = "<tr>"
						+ "<td class=\"datumFakture\">"
						+ data[i].datumFakture
						+ "</td>"
						+ "<td class=\"datumValute\">"
						+ data[i].datumValute
						+ "</td>"
						+ "<td class=\"datumObracuna\">"
						+ data[i].datumObracuna
						+ "</td>"
						+ "<td class=\"ukupnoRobe\">"
						+ data[i].ukupnoRobe
						+ "</td>"
						+ "<td class=\"ukupanRabat\">"
						+ data[i].ukupanRabat
						+ "</td>"
						+ "<td class=\"ukupanPorez\">"
						+ data[i].ukupanPorez
						+ "</td>"
						+ "<td class=\"iznosFakture\">"
						+ data[i].iznosFakture
						+ "</td>"
						+ "<td class=\"iznosFaktureOsnovica\">"
						+ data[i].iznosFaktureOsnovica
						+ "</td>"
						+ "<td class=\"uplataNaRacun\">"
						+ data[i].uplataNaRacun
						+ "</td>"
						+ "<td class=\"pozivNaBroj\">"
						+ data[i].pozivNaBroj
						+ "</td>"
						+ "<td class=\"statusFakture\">"
						+ data[i].statusFakture
						+ "</td>"
						+ "<td class=\"poslovniPartner\">"
						+ data[i].poslovniPartner
						+ "</td>"
						+ "<td class=\"poslovnaGodina\">"
						+ data[i].poslovnaGodina
						+ "</td>"
						+ "<td class=\"otpremnica\">"
						+ data[i].otpremnica
						+ "</td>"
						
						+ "<td><a class=\"remove\" href='/api/izlazne-fakture/" + data[i].brojFakture + "'>"
						+ "<img src='images/remove.gif'/></a></td>"
						+ "<td style=\"visibility: hidden; max-width: 0px;\" class=\"brojFakture\">"
						+ data[i].brojFakture + "</td>"
						$("#dataTable").append(newRow)
					}
		},
    	error: function(err) {
    		console.log(err);
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
		url : "http://localhost:8080/api/otpremnice/",
		type: "GET",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},
    	success: function(data) {
			for (i = 0; i < data.length; i++) {
				var newOption = '<option value="' + data[i].brojOtpremnice + '">'
				+ data[i].brojOtpremnice + '</option>';
				$("#otpremnica").append(newOption);
			}
    	}
	});
	
	$('#inputModal').on('shown.bs.modal', function (e) {
		$.ajax({
			url: "http://localhost:8080/api/otpremnice/",
			type: "GET",
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
	    	},
			success: function(data) {
				for (i = 0; i < data.length; i++) {
					console.log(i);
					var newOption = '<option value="' + data[i].brojOtpremnice + '">'
					+ data[i].brojOtpremnice + '</option>';
					console.log(data[i]);
					$(e.currentTarget).find('select[name="otpremnica"]').append(newOption);
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
					$(e.currentTarget).find('select[name="poslovniPartner"]').append(newOption);
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
					$(e.currentTarget).find('select[name="poslovnaGodina"]').append(newOption);
				}
			}
		});
	});
	
	$("#add").click(function(){
		// pripremamo JSON koji cemo poslati
			console.log("start");
			formData = JSON.stringify({
				datumFakture : $("#inputForm [name='datumFakture']").val(),
				datumValute : $("#inputForm [name='datumValute']").val(),
				datumObracuna : $("#inputForm [name='datumObracuna']").val(),
				ukupnoRobe : $("#inputForm [name='ukupnoRobe']").val(),
				ukupanRabat : $("#inputForm [name='ukupanRabat']").val(),
				ukupanPorez : $("#inputForm [name='ukupanPorez']").val(),
				iznosFakture : $("#inputForm [name='iznosFakture']").val(),
				iznosFaktureOsnovica : $("#inputForm [name='iznosFaktureOsnovica']").val(),
				uplataNaRacun : $("#inputForm [name='uplataNaRacun']").val(),
				pozivNaBroj : $("#inputForm [name='pozivNaBroj']").val(),
				statusFakture : $("#inputForm [name='statusFakture']").val(),
				poslovniPartner : $("#inputForm [name='poslovniPartner']").val(),
				poslovnaGodina : $("#inputForm [name='poslovnaGodina']").val(),
				otpremnica : $("#inputForm [name='otpremnica']").val(),
	        });
			console.log(formData);
			$.ajax({
				url: "http://localhost:8080/api/izlazne-fakture",
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
					+ "<td class=\"brojFakture\">"
					+ data.brojFakture
					+ "</td>"
					+ "<td class=\"datumFakture\">"
					+ data.datumFakture
					+ "</td>"
					+ "<td class=\"datumValute\">"
					+ data.datumValute
					+ "</td>"
					+ "<td class=\"datumObracuna\">"
					+ data.datumObracuna
					+ "</td>"
					+ "<td class=\"ukupnoRobe\">"
					+ data.ukupnoRobe
					+ "</td>"
					+ "<td class=\"ukupanRabat\">"
					+ data.ukupanRabat
					+ "</td>"
					+ "<td class=\"ukupanPorez\">"
					+ data.ukupanPorez
					+ "</td>"
					+ "<td class=\"iznosFakture\">"
					+ data.iznosFakture
					+ "</td>"
					+ "<td class=\"iznosFaktureOsnovica\">"
					+ data.iznosFaktureOsnovica
					+ "</td>"
					+ "<td class=\"uplataNaRacun\">"
					+ data.uplataNaRacun
					+ "</td>"
					+ "<td class=\"pozivNaBroj\">"
					+ data.pozivNaBroj
					+ "</td>"
					+ "<td class=\"statusFakture\">"
					+ data.statusFakture
					+ "</td>"
					+ "<td class=\"poslovniPartner\">"
					+ data.poslovniPartner
					+ "</td>"
					+ "<td class=\"poslovnaGodina\">"
					+ data.poslovnaGodina
					+ "</td>"
					+ "<td class=\"otpremnica\">"
					+ data.otpremnica
					+ "</td>"
					+ "<td><a class=\"remove\" href='/api/izlazne-fakture/" + data.brojFakture + "'>"
					+ "<img src='images/remove.gif'/></a></td>"
					+ "<td style=\"visibility: hidden; max-width: 0px;\" class=\"brojFakture\">"
					+ data.brojFakture + "</td>"
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
			datumFakture : $("#editForm [name='datumFakture']").val(),
			datumValute : $("#editForm [name='datumValute']").val(),
			datumObracuna : $("#editForm [name='datumObracuna']").val(),
			ukupnoRobe : $("#editForm [name='ukupnoRobe']").val(),
			ukupanRabat : $("#editForm [name='ukupanRabat']").val(),
			ukupanPorez : $("#editForm [name='ukupanPorez']").val(),
			iznosFakture : $("#editForm [name='iznosFakture']").val(),
			iznosFaktureOsnovica : $("#editForm [name='iznosFaktureOsnovica']").val(),
			uplataNaRacun : $("#editForm [name='uplataNaRacun']").val(),
			pozivNaBroj : $("#editForm [name='pozivNaBroj']").val(),
			statusFakture : $("#editForm [name='statusFakture']").val(),
			poslovniPartner : $("#editForm [name='poslovniPartner']").val(),
			poslovnaGodina : $("#editForm [name='poslovnaGodina']").val(),
			otpremnica : $("#editForm [name='otpremnica']").val(),
			brojFakture : $("#editForm [name='brojFakture']").val(),
        });
		console.log(formData);
		$.ajax({
			url: "http://localhost:8080/api/izlazne-fakture/" + $("#editForm [name='brojFakture']").val(),
			type: "PUT",
			data: formData,
			// saljemo json i ocekujemo json nazad
			contentType: "application/json",
			datatype: 'json',
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
			},
			success: function(data) {
				$(".highlighted").find(".brojFakture")[0].innerHTML = data.brojFakture;
				$(".highlighted").find(".datumValute")[0].innerHTML = data.datumValute;
				$(".highlighted").find(".datumObracuna")[0].innerHTML = data.datumObracuna;
				$(".highlighted").find(".ukupnoRobe")[0].innerHTML = data.ukupnoRobe;
				$(".highlighted").find(".ukupanRabat")[0].innerHTML = data.ukupanRabat;
				$(".highlighted").find(".ukupanPorez")[0].innerHTML = data.ukupanPorez;
				$(".highlighted").find(".iznosFakture")[0].innerHTML = data.iznosFakture;
				$(".highlighted").find(".iznosFaktureOsnovica")[0].innerHTML = data.iznosFaktureOsnovica;
				$(".highlighted").find(".uplataNaRacun")[0].innerHTML = data.uplataNaRacun;
				$(".highlighted").find(".pozivNaBroj")[0].innerHTML = data.pozivNaBroj;
				$(".highlighted").find(".statusFakture")[0].innerHTML = data.statusFakture;
				$(".highlighted").find(".poslovniPartner")[0].innerHTML = data.poslovniPartner;
				$(".highlighted").find(".poslovnaGodina")[0].innerHTML = data.poslovnaGodina;
				$(".highlighted").find(".otpremnica")[0].innerHTML = data.otpremnica;
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
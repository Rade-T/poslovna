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
	rabat = item.find(".rabat").html();
	osnovica = item.find(".osnovica").html();
	pdvIznos = item.find(".pdvIznos").html();
	ukupanIznos = item.find(".ukupanIznos").html();
	pdv = item.find(".pdv").html();
	izlaznaFaktura = item.find(".izlaznaFaktura").html();
	robaUsluga = item.find(".robaUsluga").html();
	$("#id").val(id);
	$("#kolicina").val(kolicina);
	$("#cenaPoJediniMere").val(cenaPoJediniciMere);
	$("#rabat").val(rabat);
	$("#osnovica").val(osnovica);
	$("#PDViznos").val(pdvIznos);
	$("#ukupanIznos").val(ukupanIznos);
	$("#PDV").val(pdv);
	$("#izlaznaFaktura").val(izlaznaFaktura);
	$("#robaUsluga").val(robaUsluga);
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
	$("#stavkeFakturaPickup").click(function() {
		id = $(".highlighted").find(".id").html();
		$("select").val(id);
		$('#stavkeFakturaModal').modal('toggle');
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
		url : "http://localhost:8080/api/stavke-faktura/",
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
						+ "<td class=\"rabat\">"
						+ data[i].rabat
						+ "</td>"
						+ "<td class=\"osnovica\">"
						+ data[i].osnovica
						+ "</td>"
						+ "<td class=\"pdvIznos\">"
						+ data[i].pdvIznos
						+ "</td>"
						+ "<td class=\"ukupanIznos\">"
						+ data[i].ukupanIznos
						+ "</td>"
						+ "<td class=\"pdv\">"
						+ data[i].pdv
						+ "</td>"
						+ "<td class=\"izlaznaFaktura\">"
						+ data[i].izlaznaFaktura
						+ "</td>"
						+ "<td class=\"robaUsluga\">"
						+ data[i].robaUsluga
						+ "</td>"
						+ "<td><a class=\"remove\" href='/api/stavke-faktura/" + data[i].id + "'>"
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
		url : "http://localhost:8080/api/izlazne-fakture/",
		type: "GET",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},
    	success: function(data) {
    		console.log(data);
			for (i = 0; i < data.length; i++) {
				var newOption = '<option value="' + data[i].brojFakture + '">' + data[i].brojFakture + '</option>';
				console.log(newOption);
				$("#izlaznaFaktura").append(newOption);
			}
    	}
	});
	
	$.ajax({
		url : "http://localhost:8080/api/robe-usluge/",
		type: "GET",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},
    	success: function(data) {
			for (i = 0; i < data.length; i++) {
				var newOption = '<option value="' + data[i].Id + '">'
				+ data[i].naziv + '</option>';
				$("#robaUsluga").append(newOption);
			}
    	}
	});
	
	$('#inputModal').on('shown.bs.modal', function (e) {
		$("#add").prop("disabled", true);
		
		$.ajax({
			url: "http://localhost:8080/api/izlazne-fakture/",
			type: "GET",
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
	    	},
			success: function(data) {
				for (i = 0; i < data.length; i++) {
					console.log(i);
					var newOption = '<option value="' + data[i].brojFakture + '">' + data[i].brojFakture + '</option>';
					console.log(data[i]);
					$(e.currentTarget).find('select[name="izlaznaFakturaSelect"]').append(newOption);
				}
			}
		});
	

		$.ajax({
			url: "http://localhost:8080/api/robe-usluge/",
			type: "GET",
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
	    	},
			success: function(data) {
				for (i = 0; i < data.length; i++) {
					console.log(i);
					var newOption = '<option value="' + data[i].id + '">'
					+ data[i].naziv + '</option>';
					console.log(data[i]);
					$(e.currentTarget).find('select[name="robaUslugaSelect"]').append(newOption);
				}
			}
		});
	});
	
	$("#inputForm [name='kolicina']").on("keyup", function(event) {
		var vrednost = $("#inputForm [name='kolicina']").val();
		if (vrednost > 1) {
			$("#add").prop("disabled", false);
		}
	});
	
	$("#add").click(function(){
		// pripremamo JSON koji cemo poslati
			console.log("start");
			formData = JSON.stringify({
	            kolicina :$("#inputForm [name='kolicina']").val(),
	            cenaPoJediniciMere :$("#inputForm [name='cena']").val(),
	            rabat :$("#inputForm [name='rabat']").val(),
	            osnovica :$("#inputForm [name='osnovica']").val(),
	            pdvIznos :$("#inputForm [name='iznosPDV']").val(),
	            ukupanIznos :$("#inputForm [name='ukupanIznos']").val(),
	            pdv :$("#inputForm [name='PDV']").val(),
	            
	            izlaznaFaktura :$("#inputForm [name='izlaznaFakturaSelect']").val(),
	            robaUsluga :$("#inputForm [name='robaUslugaSelect']").val(),
	            kolicina :$("#inputForm [name='kolicina']").val(),
	            
	        });
			console.log(formData);
			$.ajax({
				url: "http://localhost:8080/api/stavke-faktura",
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
					+ "<td class=\"kolicna\">"
					+ data.kolicina
					+ "</td>"
					+ "<td class=\"cenaPoJediniciMere\">"
					+ data.cenaPoJediniciMere
					+ "</td>"
					+ "<td class=\"rabat\">"
					+ data.rabat
					+ "</td>"
					+ "<td class=\"osnovica\">"
					+ data.osnovica
					+ "</td>"
					+ "<td class=\"pdvIznos\">"
					+ data.pdvIznos
					+ "</td>"
					+ "<td class=\"ukupanIznos\">"
					+ data.ukupanIznos
					+ "</td>"
					+ "<td class=\"pdv\">"
					+ data.pdv
					+ "</td>"
					+ "<td class=\"izlaznaFaktura\">"
					+ data.izlaznaFaktura
					+ "</td>"
					+ "<td class=\"robaUsluga\">"
					+ data.robaUsluga
					+ "</td>"
					+ "<td><a class=\"remove\" href='/api/stavke-faktura/" + data.id + "'>"
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
            rabat :$("#editForm [name='rabat']").val(),
            osnovica :$("#editForm [name='osnovica']").val(),
            cenaPoJediniciMere :$("#editForm [name='cenaPoJediniciMere']").val(),
            pdvIznos :$("#editForm [name='pdvIznos']").val(),
            pdv :$("#editForm [name='pdv']").val(),
            izlaznaFaktura :$("#editForm [name='izlaznaFaktura']").val(),
            robaUsluga :$("#editForm [name='robaUsluga']").val(),
        });
		console.log(formData);
		$.ajax({
			url: "http://localhost:8080/api/stavke-faktura/" + $("#editForm [name='id']").val(),
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
				$(".highlighted").find(".rabat")[0].innerHTML = data.rabat;
				$(".highlighted").find(".osnovica")[0].innerHTML = data.osnovica;
				$(".highlighted").find(".pdvIznos")[0].innerHTML = data.pdvIznos;
				$(".highlighted").find(".ukupanIznos")[0].innerHTML = data.ukupanIznos;
				$(".highlighted").find(".pdv")[0].innerHTML = data.pdv;
				$(".highlighted").find(".izlaznaFaktura")[0].innerHTML = data.izlaznaFaktura;
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
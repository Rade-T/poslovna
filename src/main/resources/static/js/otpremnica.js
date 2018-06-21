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
	id = item.find(".id").html()
	osnovica = item.find(".osnovica").html()
	ukupanPDV = item.find(".ukupanPDV").html()
	iznosZaPlacanje = item.find(".iznosZaPlacanje").html()
	poslovnaGodina = item.find(".poslovnaGodina").html()
	poslovnaPartner = item.find(".poslovnaPartner").html()
	procenatL = item.find(".procenatL").html()
	$("#datumOtpremnice").val(datumOtpremnice);
	$("#otpremnicaId").val(id);
	$("#osnovica").val(osnovica);
	$("#ukupanPDV").val(ukupanPDV);
	$("#iznosZaPlacanje").val(iznosZaPlacanje);
	$("#poslovnaGodina").val(poslovnaGodina);
	$("#poslovnaPartner").val(poslovnaPartner);
	$("#procenatL").val(procenatL);
	
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
		url : "http://localhost:8080/Otpremnice/"})
		.then(
				function(data) {
					console.log("Uspeo")
					for (i = 0; i < data.length; i++) {
						var newRow = "<tr>"
						+ "<td class=\"datumOtpremnice\">"
						+ data[i].datumOtpremnice
						+ "</td>"
						+ "<td class=\"otpremnicaId\">"
						+ data[i].otpremnicaId
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
						+ "<td class=\"procenatL\">"
						+ data[i].procenatL
						+ "</td>"
						
						+ "<td><a class=\"remove\" href='/Otpremnice/" + data[i].id + "'>"
						+ "<img src='images/remove.gif'/></a></td>"
						+ "<td style=\"visibility: hidden; max-width: 0px;\" class=\"id\">"
						+ data[i].id + "</td>"
						$("#dataTable").append(newRow)
					}
				});
/*ovo ne znam	
	$.ajax({
		url : "http://localhost:8080/Preduzeca/"})
		.then(
				function(data) {
					console.log("Uspeo")
					for (i = 0; i < data.length; i++) {
						var newOption = '<option value="' + data[i].PIB + '">'
						+ data[i].naziv + '</option>';
						$("#preduzece").append(newOption);
					}
				});
	
	$('#inputModal').on('shown.bs.modal', function (e) {
		$.ajax({
			url: "http://localhost:8080/Preduzeca"})
			.then(
				function(data) {
					console.log("Ucitavanje preduzeca");
					console.log(data);
					for (i = 0; i < data.length; i++) {
						console.log(i);
						var newOption = '<option value="' + data[i].PIB + '">'
						+ data[i].naziv + '</option>';
						console.log(data[i]);
						$(e.currentTarget).find('select[name="preduzeceSelect"]').append(newOption);
					}
			});
	});
*/	
	$("#add").click(function(){
		// pripremamo JSON koji cemo poslati
			console.log("start");
			formData = JSON.stringify({
	            datumPrimene : $("#inputForm [name='datumOtpremnice']").val(),
	            otpremnicaId : $("#inputForm [name='otpremnicaId']").val(),
	            osnovica : $("#inputForm [name='osnovica']").val(),
	            ukupanPDV : $("#inputForm [name='ukupanPDV']").val(),
	            iznosZaPlacanje : $("#inputForm [name='iznosZaPlacanje']").val(),
	            poslovnaGodina : $("#inputForm [name='poslovnaGodina']").val(),
	            poslovniPartner : $("#inputForm [name='poslovniPartner']").val(),
	            procenatL : $("#inputForm [name='procenatL']").val()
	            
	        });
			console.log(formData);
			$.ajax({
				url: "http://localhost:8080/Otpremnice",
				type: "POST",
				data: formData,
				// saljemo json i ocekujemo json nazad
				contentType: "application/json",
				datatype: 'json',
				success: function(data) {
					var newRow = "<tr>"
					+ "<td class=\"datumOtpremnice\">"
						+ data[i].datumOtpremnice
						+ "</td>"
						+ "<td class=\"otpremnicaId\">"
						+ data[i].otpremnicaId
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
						+ "<td class=\"procenatL\">"
						+ data[i].procenatL
						+ "</td>"
					+ "<td><a class=\"remove\" href='/Otpremnice/" + data.id + "'>"
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
			id : $("#editForm [name='otpremnicaId']").val(),
            datumPrimene : $("#editForm [name='datumOtpremnice']").val(),
            otpremnicaId : $("#editForm [name='otpremnicaId']").val(),
	        osnovica : $("#editForm [name='osnovica']").val(),
	        ukupanPDV : $("#editForm [name='ukupanPDV']").val(),
	        iznosZaPlacanje : $("#editForm [name='iznosZaPlacanje']").val(),
	        poslovnaGodina : $("#editForm [name='poslovnaGodina']").val(),
	        poslovniPartner : $("#editForm [name='poslovniPartner']").val(),
	        procenatL : $("#editForm [name='procenatL']").val(),
            
        });
		console.log(formData);
		$.ajax({
			url: "http://localhost:8080/Otpremnice/" + $("#editForm [name='otpremnicaId']").val(),
			type: "PUT",
			data: formData,
			// saljemo json i ocekujemo json nazad
			contentType: "application/json",
			datatype: 'json',
			success: function(data) {
				$(".highlighted").find(".datumOtpremnice")[0].innerHTML = data.datumOtpremnice;
				$(".highlighted").find(".otpremnicaId")[0].innerHTML = data.otpremnicaId;
				$(".highlighted").find(".osnovica")[0].innerHTML = data.osnovica;
				$(".highlighted").find(".ukupanPDV")[0].innerHTML = data.ukupanPDV;
				$(".highlighted").find(".iznosZaPlacanje")[0].innerHTML = data.iznosZaPlacanje;
				$(".highlighted").find(".poslovnaGodina")[0].innerHTML = data.poslovnaGodina;
				$(".highlighted").find(".poslovniPartner")[0].innerHTML = data.poslovniPartner;
				$(".highlighted").find(".procenatL")[0].innerHTML = data.procenatL;
				
				
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
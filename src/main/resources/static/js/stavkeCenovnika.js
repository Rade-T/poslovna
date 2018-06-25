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
	jedinicnaCena = item.find(".jedinicnaCena").html();
	id = item.find(".id").html();
	cenovnik = item.find(".cenovnik").html();
	robaUsluga = item.find(".robaUsluga").html();
	
	$("#robaUslugaId").val(id);
	$("#jedinicnaCena").val(jedinicnaCena);
	$("#cenovnik").val(cenovnik);
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
    	type: "DELETE",
    	success: function(){
    		//ukloni i na strani 
			tr_parent.remove()
        }
	});
});
/*
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
		url : "http://localhost:8080/Porez/"})
		.then(
				function(data) {
					console.log("Uspeo")
					for (i = 0; i < data.length; i++) {
						var newRow = "<tr>"
						+ "<td class=\"nazivPoreza\">"
						+ data[i].nazivPoreza
						+ "</td>"
						+ "<td class=\"vazeci\">"
						+ data[i].vazeci
						+ "</td>"
						+ "<td><a class=\"remove\" href='/Porez/" + data[i].id + "'>"
						+ "<img src='images/remove.gif'/></a></td>"
						+ "<td style=\"visibility: hidden; max-width: 0px;\" class=\"id\">"
						+ data[i].id + "</td>"
						$("#dataTable").append(newRow)
						console.log(data);
					}
				});
	*/
	
	$("#add").click(function(){
		// pripremamo JSON koji cemo poslati
			console.log("start");
			formData = JSON.stringify({
				jedinicnaCena : $("#inputForm [name='jedinicnaCena']").val(),
				cenovnik : $("#inputForm [name='cenovnik']").val(),
				robaUsluga : $("#inputForm [name='robaUsluga']").val(),

	        });
			console.log(formData);
			$.ajax({
				url: "http://localhost:8080/StavkeCenovnika",
				type: "POST",
				data: formData,
				// saljemo json i ocekujemo json nazad
				contentType: "application/json",
				datatype: 'json',
				success: function(data) {
					var newRow = "<tr>"
					+ "<td class=\"jedinicnaCena\">"
					+ data.jedinicnaCena
					+ "</td>"
					+ "<td class=\"cenovnik\">"
					+ data.cenovnik
					+ "</td>"
					+ "<td class=\"robaUsluga\">"
					+ data.robaUsluga
					+ "</td>"
					+ "<td><a class=\"remove\" href='/Stavke cenovnika/" + data.id + "'>"
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
			jedinicnaCena : $("#editForm [name='jedinicnaCena']").val(),
			cenovnik : $("#editForm [name='cenovnik']").val(),
			robaUsluga : $("#editForm [name='robaUsluga']").val(),
          
        });
		console.log(formData);
		$.ajax({
			url: "http://localhost:8080/StavkeCenovnika/" + $("#editForm [name='stavkeCenovnikaId']").val(),
			type: "PUT",
			data: formData,
			// saljemo json i ocekujemo json nazad
			contentType: "application/json",
			datatype: 'json',
			success: function(data) {
				$(".highlighted").find(".jedinicnaCena")[0].innerHTML = data.jedinicnaCena;
				$(".highlighted").find(".cenovnik")[0].innerHTML = data.cenovnik;
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
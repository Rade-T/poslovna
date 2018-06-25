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
	nazivPartnera = item.find(".nazivPartnera").html();
	id = item.find(".poslovniPartnerId").html();
	adresa = item.find(".adresa").html();
	vrstaPartnera = item.find(".vrstaPartnera").html();
	preduzece = item.find(".preduzece").html();
	
	
	
	$("#id").val(id);
	$("#nazivPartnera").val(nazivPartnera);
	$("#adresa").val(adresa);
	$("#vrstaPartnera").val(vrstaPartnera);
	$("#preduzece").val(preduzece);

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
				nazivPartnera : $("#inputForm [name='nazivPartnera']").val(),
				adresa : $("#inputForm [name='adresa']").val(),
				vrstaPartnera : $("#inputForm [name='vrstaPartnera']").val(),
				preduzece : $("#inputForm [name='preduzece']").val(),

	           
	        });
			console.log(formData);
			$.ajax({
				url: "http://localhost:8080/PoslovniPartner",
				type: "POST",
				data: formData,
				// saljemo json i ocekujemo json nazad
				contentType: "application/json",
				datatype: 'json',
				success: function(data) {
					var newRow = "<tr>"
					+ "<td class=\"nazivPartnera\">"
					+ data.nazivPartnera
					+ "</td>"
					+ "<td class=\"adresa\">"
					+ data.adresa
					+ "</td>"
					+ "<td class=\"vrstaPartnera\">"
					+ data.vrstaPartnera
					+ "</td>"
					+ "<td class=\"preduzece\">"
					+ data.preduzece
					+ "</td>"
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
			nazivPartnera : $("#editForm [name='nazivPartnera']").val(),
			adresa : $("#editForm [name='adresa']").val(),
			vrstaPartnera : $("#editForm [name='vrstaPartnera']").val(),
			preduzece : $("#editForm [name='preduzece']").val(),
        });
		console.log(formData);
		$.ajax({
			url: "http://localhost:8080/PoslovniPartner/" + $("#editForm [name='poslovniPartnerId']").val(),
			type: "PUT",
			data: formData,
			// saljemo json i ocekujemo json nazad
			contentType: "application/json",
			datatype: 'json',
			success: function(data) {
				$(".highlighted").find(".nazivPartnera")[0].innerHTML = data.nazivPartnera;
				$(".highlighted").find(".adresa")[0].innerHTML = data.adresa;
				$(".highlighted").find(".vrstaPartnera")[0].innerHTML = data.vrstaPartnera;
				$(".highlighted").find(".preduzece")[0].innerHTML = data.preduzece;
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
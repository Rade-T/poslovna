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

function sync(item){
	PIB = item.find(".PIB").html()
	naziv = item.find(".naziv").html()
	adresa = item.find(".adresa").html()
	maticniBroj = item.find(".maticniBroj").html()
	sifraDelatnosti = item.find(".sifraDelatnosti").html()
	telefon = item.find(".telefon").html()
	email = item.find(".email").html()
	id = item.find(".id").html()
	$("#PIB").val(PIB);
	$("#naziv").val(naziv);
	$("#adresa").val(adresa);
	$("#maticniBroj").val(maticniBroj);
	$("#sifraDelatnosti").val(sifraDelatnosti);
	$("#telefon").val(telefon);
	$("#email").val(email);
	$("#id").val(id);
}

$(document).ready(function() {
	$.ajax({
		url : "http://localhost:8080/Preduzeca/"})
		.then(
			function(data) {
				for (i = 0; i < data.length; i++) {
					var newRow = "<tr>"
					+ "<td class=\"PIB\">" + data[i].PIB + "</td>"
					+ "<td class=\"naziv\">" + data[i].naziv + "</td>"
					+ "<td class=\"adresa\">" + data[i].adresa + "</td>"	
					+ "<td class=\"maticniBroj\">" + data[i].maticniBroj + "</td>"
					+ "<td class=\"sifraDelatnosti\">" + data[i].sifraDelatnosti + "</td>"
					+ "<td class=\"telefon\">" + data[i].telefon + "</td>"
					+ "<td class=\"email\">" + data[i].email + "</td>"
					+ "<td><a class=\"remove\" href='/Preduzeca/" + data[i].PIB + "'>" 
					+ "<img src='images/remove.gif'/></a></td>" +
					+ "<td style=\"visibility: hidden; max-width: 0px;\" class=\"id\">"
					+ data[i].PIB + "</td>"
					+ "</tr>"
					
					$("#dataTable").append(newRow)
				}
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
	
	$("#add").click(function(){
		// pripremamo JSON koji cemo poslati
			console.log("start");
			formData = JSON.stringify({
	            PIB : $("#inputForm [name='PIB']").val(),
	            naziv :$("#inputForm [name='naziv']").val(),
	            adresa :$("#inputForm [name='adresa']").val(),
	            maticniBroj :$("#inputForm [name='maticniBroj']").val(),
	            sifraDelatnosti :$("#inputForm [name='sifraDelatnosti']").val(),
	            telefon :$("#inputForm [name='telefon']").val(),
	            email :$("#inputForm [name='email']").val(),
	        });
			$.ajax({
				url: "http://localhost:8080/Preduzeca",
				type: "POST",
				data: formData,
				// saljemo json i ocekujemo json nazad
				contentType: "application/json",
				datatype: 'json',
				success: function(data) {
					var newRow =  "<tr>"
					+ "<td class=\"PIB\">" + data.PIB + "</td>"
					+ "<td class=\"naziv\">" + data.naziv + "</td>"
					+ "<td class=\"adresa\">" + data.adresa + "</td>"	
					+ "<td class=\"maticniBroj\">" + data.maticniBroj + "</td>"
					+ "<td class=\"sifraDelatnosti\">" + data.sifraDelatnosti + "</td>"
					+ "<td class=\"telefon\">" + data.telefon + "</td>"
					+ "<td class=\"email\">" + data.email + "</td>"
					+ "<td><a class=\"remove\" href='/Preduzeca/" + data.PIB + "'>" 
					+ "<img src='images/remove.gif'/></a></td>" +
					+ "<td style=\"visibility: hidden; max-width: 0px;\" class=\"id\">"
					+ data.PIB + "</td>"
					+ "</tr>"
					
					$("#dataTable").append(newRow)
				  }
				});
			$('#inputModal').modal('toggle');
			console.log("end");
	 });
	
	$("#potvrda").on("click", function(event){
		event.preventDefault();
		console.log("Kliknuta potvrda");
		formData = JSON.stringify({
            PIB : $("#editForm [name='PIB']").val(),
            naziv :$("#editForm [name='naziv']").val(),
            adresa :$("#editForm [name='adresa']").val(),
            maticniBroj :$("#editForm [name='maticniBroj']").val(),
            sifraDelatnosti :$("#editForm [name='sifraDelatnosti']").val(),
            telefon :$("#editForm [name='telefon']").val(),
            email :$("#editForm [name='email']").val(),
        });
		$.ajax({
			url: "http://localhost:8080/Preduzeca/" + $("#editForm [name='PIB']").val(),
			type: "PUT",
			data: formData,
			// saljemo json i ocekujemo json nazad
			contentType: "application/json",
			datatype: 'json',
			success: function(data) {
				$(".highlighted").find(".naziv")[0].innerHTML = data.naziv;
				$(".highlighted").find(".adresa")[0].innerHTML = data.adresa;
				$(".highlighted").find(".maticniBroj")[0].innerHTML = data.maticniBroj;
				$(".highlighted").find(".sifraDelatnosti")[0].innerHTML = data.sifraDelatnosti;
				$(".highlighted").find(".telefon")[0].innerHTML = data.telefon;
				$(".highlighted").find(".email")[0].innerHTML = data.email;
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
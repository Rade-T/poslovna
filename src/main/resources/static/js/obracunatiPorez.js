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
	id = item.find(".id").html()
	stopa = item.find(".stopa").html()
	iznos = item.find(".iznos").html()
	porez = item.find(".porez").html()
	izlaznaFaktura = item.find(".izlaznaFaktura").html()
	$("#id").val(id);
	$("#stopa").val(stopa);
	$("#iznos").val(iznos);
	$("#porez").val(porez);
	$("#izlaznaFaktura").val(izlaznaFaktura);
	
	
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
		url : "http://localhost:8080/api/obracunati-porezi/"})
		.then(
				function(data) {
					console.log("Uspeo")
					for (i = 0; i < data.length; i++) {
						var newRow = "<tr>"
						+ "<td class=\"id\">"
						+ data[i].id
						+ "</td>"
						+ "<td class=\"stopa\">"
						+ data[i].stopa
						+ "</td>"
						+ "<td class=\"iznos\">"
						+ data[i].iznos
						+ "</td>"
						+ "<td class=\"porez\">"
						+ data[i].porez
						+ "</td>"
						+ "<td class=\"izlaznaFaktura\">"
						+ data[i].izlaznaFaktura
						
						+ "<td><a class=\"remove\" href='/api/obracunati-porezi/" + data[i].id + "'>"
						+ "<img src='images/remove.gif'/></a></td>"
						+ "<td style=\"visibility: hidden; max-width: 0px;\" class=\"id\">"
						+ data[i].id + "</td>"
						$("#dataTable").append(newRow)
					}
				});
	
	$.ajax({
		url : "http://localhost:8080/api/preduzeca/"})
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
			url: "http://localhost:8080/api/preduzeca"})
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
	            id : $("#inputForm [name='id']").val(),
	            stopa : $("#inputForm [name='stopa']").val(),
	            iznos : $("#inputForm [name='iznos']").val(),
	            porez : $("#inputForm [name='porez']").val(),
	            izlaznaFaktura : $("#inputForm [name='izlaznaFaktura']").val() 
	        });
			console.log(formData);
			$.ajax({
				url: "http://localhost:8080/api/obracunati-porezi",
				type: "POST",
				data: formData,
				// saljemo json i ocekujemo json nazad
				contentType: "application/json",
				datatype: 'json',
				success: function(data) {
					var newRow = "<tr>"
					+ "<td class=\"datumOtpremnice\">"
						+ "<td class=\"id\">"
						+ data[i].id
						+ "</td>"
						+ "<td class=\"stopa\">"
						+ data[i].stopa
						+ "</td>"
						+ "<td class=\"iznos\">"
						+ data[i].iznos
						+ "</td>"
						+ "<td class=\"porez\">"
						+ data[i].porez
						+ "</td>"
						+ "<td class=\"izlaznaFaktura\">"
						+ data[i].izlaznaFaktura
					+ "<td><a class=\"remove\" href='/api/obracunati-porezi/" + data.id + "'>"
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
			id : $("#editForm [name='id']").val(),
	        stopa : $("#editForm [name='stopa']").val(),
	        iznos : $("#editForm [name='iznos']").val(),
	        porez : $("#editForm [name='porez']").val(),
	        izlaznaFaktura : $("#editForm [name='izlaznaFaktura']").val() 
            
        });
		console.log(formData);
		$.ajax({
			url: "http://localhost:8080/api/obracunati-porezi/" + $("#editForm [name='id']").val(),
			type: "PUT",
			data: formData,
			// saljemo json i ocekujemo json nazad
			contentType: "application/json",
			datatype: 'json',
			success: function(data) {
				$(".highlighted").find(".id")[0].innerHTML = data.id;
				$(".highlighted").find(".stopa")[0].innerHTML = data.stopa;
				$(".highlighted").find(".iznos")[0].innerHTML = data.iznos;
				$(".highlighted").find(".porez")[0].innerHTML = data.porez;
				$(".highlighted").find(".izlaznaFaktura")[0].innerHTML = data.izlaznaFaktura;
				
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
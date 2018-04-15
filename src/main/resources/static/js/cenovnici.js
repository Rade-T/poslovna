//function add() {
//	// pripremamo JSON koji cemo poslati
//	console.log("start");
//	formData = JSON.stringify({
//        datum : $("#inputForm [name='datum']").val(),
//        preduzece :$("#inputForm [name='preduzece']").val(),
//    });
//	$.ajax({
//		url: "/Cenovnici",
//		type: "POST",
//		data: formData,
//		// saljemo json i ocekujemo json nazad
//		contentType: "application/json",
//		datatype: 'json',
//		success: function(data) {
//			var newRow = "<td class=\"datumPrimene\">"
//			+ data[i].datumPrimene
//			+ "</td>"
//			+ "<td class=\"preduzece\">"
//			+ data[i].preduzece
//			+ "</td>"
//			+ "<td><a class=\"remove\" href='/Cenovnici/" + data[i].id + "'>"
//			+ "<img src='images/remove.gif'/></a></td>"
//			+ +"<td class=\"idCell\">"
//			+ data[i].id + "</td>"
//			"</tr>"
//			$("#dataTable").append(newRow)
//		  }
//		});
//	$('#inputModal').modal('toggle');
//	console.log("end");
//}
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
	datumPrimene = item.find(".datumPrimene").html()
	id = item.find(".id").html()
	preduzece = item.find(".preduzece").html()
	$("#datumPrimene").val(datumPrimene);
	$("#id").val(id);
	$("#preduzeceOption").val(preduzece);
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
		url : "http://localhost:8080/Cenovnici/"})
		.then(
				function(data) {
					console.log("Uspeo")
					for (i = 0; i < data.length; i++) {
						var newRow = "<tr>"
						+ "<td class=\"datumPrimene\">"
						+ data[i].datumPrimene
						+ "</td>"
						+ "<td class=\"preduzece\">"
						+ data[i].preduzece
						+ "</td>"
						+ "<td><a class=\"remove\" href='/Cenovnici/" + data[i].id + "'>"
						+ "<img src='images/remove.gif'/></a></td>"
						+ +"<td class=\"idCell\">"
						+ data[i].id + "</td>"
						"</tr>"
						$("#dataTable").append(newRow)
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
	
	$("#add").click(function(){
		// pripremamo JSON koji cemo poslati
			console.log("start");
			formData = JSON.stringify({
	            datumPrimene : $("#inputForm [name='datumPrimene']").val(),
	            preduzece :$("#inputForm [name='preduzeceSelect']").val(),
	        });
			console.log(formData);
			$.ajax({
				url: "http://localhost:8080/Cenovnici",
				type: "POST",
				data: formData,
				// saljemo json i ocekujemo json nazad
				contentType: "application/json",
				datatype: 'json',
				success: function(data) {
					var newRow = "<tr>"
					+ "<td class=\"datumPrimene\">"
					+ data.datumPrimene
					+ "</td>"
					+ "<td class=\"preduzece\">"
					+ data.preduzece
					+ "</td>"
					+ "<td><a class=\"remove\" href='/Cenovnici/" + data.id + "'>"
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
});
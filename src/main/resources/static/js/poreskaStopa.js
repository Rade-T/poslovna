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
	iznosStope = item.find(".iznosStope").html();
	istorijaPoreza = item.find(".istorijaPoreza").html();
	porez = item.find(".porez").html();
	$("#poreskaStopaId").val(id);
	$("#iznosStope").val(iznosStope);
	$("#istorijaPoreza").val(istorijaPoreza);
	$("#porez").val(porez);
	
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
	$("#PoreskaStopaPickup").click(function() {
		id = $(".highlighted").find(".id").html();
		$("select").val(id);
		$('#narudzbenicaModal').modal('toggle');
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
		url : "http://localhost:8080/api/poreske-stope/",
		type: "GET",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},
    	success: function(data) {
					console.log("Uspeo")
					for (i = 0; i < data.length; i++) {
						var newRow = "<tr>"
						+ "<td class=\"iznosStope\">"
						+ data[i].iznosStope
						+ "</td>"
						+ "<td class=\"istorijaPoreza\">"
						+ data[i].istorijaPoreza
						+ "</td>"
						+ "<td class=\"porez\">"
						+ data[i].porez
						+ "</td>"
						+ "<td><a class=\"remove\" href='/api/poreske-stope/" + data[i].id + "'>"
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
		type: "GET",
		url : "http://localhost:8080/api/istorije-poreza",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},})
		.then(
				function(data) {
					console.log("Uspeo")
					for (i = 0; i < data.length; i++) {
						var newOption = '<option value="' + data[i].id + '">'
						+ data[i].datumPrimene+ '</option>';
						$("#istorijaPoreza").append(newOption);
					}
				});
	
	$.ajax({
		type: "GET",
		url : "http://localhost:8080/api/porez",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},})
		.then(
				function(data) {
					console.log("Uspeo")
					for (i = 0; i < data.length; i++) {
						var newOption = '<option value="' + data[i].id + '">'
						+ data[i].nazivPoreza+ '</option>';
						$("#porez").append(newOption);
					}
				});
	
$('#inputModal').on('shown.bs.modal', function (e) {
	$.ajax({
		type: "GET",
		url : "http://localhost:8080/api/istorije-poreza",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},})
		.then(
				function(data) {
					console.log("Uspeo")
					for (i = 0; i < data.length; i++) {
						var newOption = '<option value="' + data[i].id + '">'
						+ data[i].datumPrimene+ '</option>';
						$("#inputModal #istorijaPoreza").append(newOption);
					}
				});
	
	$.ajax({
		type: "GET",
		url : "http://localhost:8080/api/porez",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},})
		.then(
				function(data) {
					console.log("Uspeo")
					for (i = 0; i < data.length; i++) {
						var newOption = '<option value="' + data[i].id + '">'
						+ data[i].nazivPoreza+ '</option>';
						$("#inputModal #porez").append(newOption);
					}
				});
	
	});
	$("#add").click(function(){
		// pripremamo JSON koji cemo poslati
			console.log("start");
			formData = JSON.stringify({
	      
	            iznosStope :$("#inputForm [name='iznosStope']").val(),
	            istorijaPoreza :$("#inputForm [name='istorijaPoreza']").val(),
	            porez :$("#inputForm [name='porez']").val()
	        });
			console.log(formData);
			$.ajax({
				url: "http://localhost:8080/api/poreske-stope",
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
					+ "<td class=\"id\">"
					+ data.id
					+ "</td>"
					+ "<td class=\"iznosStope\">"
					+ data.iznosStope
					+ "</td>"
					+ "<td class=\"istorijaPoreza\">"
					+ data.istorijaPoreza
					+ "</td>"
					+ "<td class=\"porez\">"
					+ data.porez
					+ "</td>"
					+ "<td><a class=\"remove\" href='/PoreskaStopa/" + data.id + "'>"
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
            iznosStope : $("#editForm [name='iznosStope']").val(),
            istorijaPoreza :$("#editForm [name='istorijaPoreza']").val(),
            porez :$("#editForm [name='porez']").val()
        });
		console.log(formData);
		$.ajax({
			url: "http://localhost:8080/api/poreske-stope/" + $("#editForm [name='poreskaStopaId']").val(),
			type: "PUT",
			data: formData,
			// saljemo json i ocekujemo json nazad
			contentType: "application/json",
			datatype: 'json',
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
			},
			success: function(data) {
				$(".highlighted").find(".iznosStope")[0].innerHTML = data.iznosStope;
				$(".highlighted").find(".istorijaPoreza")[0].innerHTML = data.istorijaPoreza;
				$(".highlighted").find(".porez")[0].innerHTML = data.porez;
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
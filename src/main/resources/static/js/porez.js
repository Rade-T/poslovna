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
	nazivPoreza = item.find(".nazivPoreza").html();
	id = item.find(".id").html();
	vazeci = item.find(".vazeci").html();
	console.log("Checkbox je: " + vazeci);
	$("#porezId").val(id);
	$("#nazivPoreza").val(nazivPoreza);
	$("#vazeci").prop('checked', vazeci);
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
		url : "http://localhost:8080/api/porezi/",
		type: "GET",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},
    	success: function(data) {
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
		},
    	error: function(err) {
    		console.log(err);
    	}
	});
	
	$("#add").click(function(){
		// pripremamo JSON koji cemo poslati
			console.log("start");
			formData = JSON.stringify({
	            nazivPoreza : $("#inputForm [name='nazivPoreza']").val(),
	            vazeci :$("#inputForm [name='vazeci']").is(":checked"),
	        });
			console.log(formData);
			$.ajax({
				url: "http://localhost:8080/api/porezi",
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
					+ "<td class=\"nazivPoreza\">"
					+ data.nazivPoreza
					+ "</td>"
					+ "<td class=\"vazeci\">"
					+ data.vazeci
					+ "</td>"
					+ "<td><a class=\"remove\" href='/api/porezi/" + data.id + "'>"
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
            nazivPoreza : $("#editForm [name='nazivPoreza']").val(),
            vazeci :$("#editForm [name='vazeci']").is(":checked"),
        });
		console.log(formData);
		$.ajax({
			url: "http://localhost:8080/api/porezi/" + $("#editForm [name='id']").val(),
			type: "PUT",
			data: formData,
			// saljemo json i ocekujemo json nazad
			contentType: "application/json",
			datatype: 'json',
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
			},
			success: function(data) {
				$(".highlighted").find(".nazivPoreza")[0].innerHTML = data.nazivPoreza;
				$(".highlighted").find(".vazeci")[0].innerHTML = data.vazeci;
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
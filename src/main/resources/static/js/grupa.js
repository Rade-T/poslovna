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
	naziv = item.find(".naziv").html()
	id = item.find(".id").html()
	preduzece = item.find(".preduzece").html()
	porez = item.find(".porez").html()
	$("#naziv").val(naziv);
	$("#id").val(id);
	$("#preduzece").val(preduzece);
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
		url : "http://localhost:8080/api/grupe/",
			type: "GET",
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
	    	},
	    	success: function(data) {
	   
					console.log("Uspeo")
					for (i = 0; i < data.length; i++) {
						var newRow = "<tr>"
						+ "<td class=\"naziv\">"
						+ data[i].naziv
						+ "</td>"
						+ "<td class=\"preduzece\">"
						+ data[i].preduzece
						+ "</td>"
						+ "<td class=\"porez\">"
						+ data[i].porez
						+ "</td>"
						+ "<td><a class=\"remove\" href='/api/grupe/" + data[i].id + "'>"
						+ "<img src='images/remove.gif'/></a></td>"
						+ "<td style=\"visibility: hidden; max-width: 0px;\" class=\"id\">"
						+ data[i].id + "</td>"
						$("#dataTable").append(newRow)
					}
			},
	    	error: function(err) {
	    		console.log(err);
	    	}
		});
	
	$.ajax({
		url : "http://localhost:8080/api/preduzeca/",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
		}})
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
			url: "http://localhost:8080/api/preduzeca",
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
			}})
			.then(
				function(data) {
					console.log("Ucitavanje grupe");
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
	$.ajax({
		url : "http://localhost:8080/api/porez/",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
		}})
		.then(
				function(data) {
					console.log("Uspeo")
					for (i = 0; i < data.length; i++) {
						var newOption = '<option value="' + data[i].id + '">'
						+ data[i].nazivPoreza + '</option>';
						$("#porez").append(newOption);
					}
				});
				
	$('#inputModal').on('shown.bs.modal', function (e) {
		$.ajax({
			url: "http://localhost:8080/api/porez",
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
			}})
			.then(
				function(data) {
					console.log("Ucitavanje poreza");
					console.log(data);
					for (i = 0; i < data.length; i++) {
						console.log(i);
						var newOption = '<option value="' + data[i].id + '">'
						+ data[i].nazivPoreza + '</option>';
						console.log(data[i]);
						$(e.currentTarget).find('select[name="porezSelect"]').append(newOption);
					}
			});
	});
	
	$("#add").click(function(){
		// pripremamo JSON koji cemo poslati
			console.log("start");
			formData = JSON.stringify({
	            naziv : $("#inputForm [name='naziv']").val(),
	            preduzece :$("#inputForm [name='preduzeceSelect']").val(),
	            porez : $("#inputForm [name='porezSelect']").val(),
	        });
			console.log(formData);
			
			
			$.ajax({
				url: "http://localhost:8080/api/grupe",
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
						+ "<td class=\"naziv\">"
						+ data[i].naziv
						+ "</td>"
						+ "<td class=\"preduzece\">"
						+ data[i].preduzece
						+ "</td>"
						+ "<td class=\"porez\">"
						+ data[i].porez
						+ "</td>"
					+ "<td><a class=\"remove\" href='/api/grupe/" + data.id + "'>"
					+ "<img src='images/remove.gif'/></a></td>"
					+ +"<td class=\"id\">"
					+ data.id + "</td>"
					"</tr>"
					$("#dataTable").append(newRow)
					
				  },error: function(e){
					  
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
			id : $("#editForm [name='id']").val(),
			 naziv : $("#editForm [name='naziv']").val(),
	         preduzece :$("#editForm [name='preduzece']").val(),
	         porez :$("#editForm [name='porez']").val(),
        });
		
		console.log(formData);
		$.ajax({
			url: "http://localhost:8080/api/grupe/" + $("#editForm [name='id']").val(),
			type: "PUT",
			data: formData,
			// saljemo json i ocekujemo json nazad
			contentType: "application/json",
			datatype: 'json',
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
			},
			success: function(data) {
				$(".highlighted").find(".naziv")[0].innerHTML = data.naziv;
				$(".highlighted").find(".preduzece")[0].innerHTML = data.preduzece;
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
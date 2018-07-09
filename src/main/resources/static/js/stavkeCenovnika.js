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
	jedinicnaCena = item.find(".jedinicnaCena").html();
	id = item.find(".id").html();
	cenovnik = item.find(".cenovnik").html();
	robaUsluga = item.find(".idRobaUsluge").html();
	
	$("#stavkeCenovnikaId").val(id);
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
    	beforeSend: function(request) {
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
		url : "http://localhost:8080/api/stavke-cenovnika",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	}})
		.then(
				function(data) {
					console.log("Uspeo")
					for (i = 0; i < data.length; i++) {
						console.log(data[i].idRobaUsluge);
						var newRow = "<tr>"
						+ "<td class=\"jedinicnaCena\">"
						+ data[i].jedinicnaCena
						+ "</td>"
						+ "<td class=\"cenovnik\">"
						+ data[i].cenovnik
						+ "</td>"
						+ "<td class=\"idRobaUsluge\">"
						+ data[i].idRobaUsluge
						+ "</td>"
						+ "<td><a class=\"remove\" href='/api/stavke-cenovnika/" + data[i].id + "'>"
						+ "<img src='images/remove.gif'/></a></td>"
						+ "<td style=\"visibility: hidden; max-width: 0px;\" class=\"id\">"
						+ data[i].id + "</td>"
						$("#dataTable").append(newRow)
						console.log(data);
					}
				});
	//DODAVANJE CENOVNIKA U SELECT = editModal
	$.ajax({
		url : "http://localhost:8080/api/cenovnici/",
		type: "GET",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},
    	success: function(data) {
					console.log("Uspeo")
					for(i = 0; i<data.length; i++){
						var newOption = '<option value="' + data[i].id + '">' +
                    	data[i].id + '</option>';
						$("#cenovnik").append(newOption);
						
					}
					
		},
    	error: function(err) {
    		console.log(err);
    	}
	});
	//DODAVANJE ROBE I USLUGA U SELECT = editModal
	$.ajax({
        url: "http://localhost:8080/api/robe-usluge/",
        beforeSend: function(request) {
            request.setRequestHeader("X-Auth-Token", token);
        }
    })
    .then(
        function(data) {
            console.log("Uspeo")
            for(i = 0; i<data.length; i++){
				var newOption = '<option value="' + data[i].id + '">' +
            	data[i].naziv + '</option>';
				$("#robaUsluga").append(newOption);
            }
            
        });

	$('#inputModal').on('shown.bs.modal', function (e) {
		console.log("inputModal");
		//DODAVANJE CENOVNIKA U SELECT = inputModal
		$.ajax({
			url : "http://localhost:8080/api/cenovnici/",
			type: "GET",
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
	    	},
	    	success: function(data) {
						console.log("Uspeo")
						for(i = 0; i<data.length; i++){
							var newOption = '<option value="' + data[i].id + '">' +
	                    	data[i].id + '</option>';
							$("#inputModal #cenovnik").append(newOption);
							
						}
						
			},
	    	error: function(err) {
	    		console.log(err);
	    	}
		});
		//DODAVANJE ROBE I USLUGA U SELECT = inputModal
		$.ajax({
	        url: "http://localhost:8080/api/robe-usluge/",
	        beforeSend: function(request) {
	            request.setRequestHeader("X-Auth-Token", token);
	        }
	    })
	    .then(
	        function(data) {
	            console.log("Uspeo")
	            for(i = 0; i<data.length; i++){
					var newOption = '<option value="' + data[i].id + '">' +
	            	data[i].naziv + '</option>';
					$("#inputModal #robaUsluga").append(newOption);
	            }
	            
	        });
	});
	
	$("#add").click(function(){
		// pripremamo JSON koji cemo poslati
			console.log("start");
			formData = JSON.stringify({
				jedinicnaCena : $("#inputForm [name='jedinicnaCena']").val(),
				cenovnik : $("#inputForm [name='cenovnik']").val(),
				idRobaUsluge : $("#inputForm [name='robaUsluga']").val(),

	        });
			console.log(formData);
			$.ajax({
				url: "http://localhost:8080/api/stavke-cenovnika",
				type: "POST",
				beforeSend: function(request) {
		            request.setRequestHeader("X-Auth-Token", token);
		        },
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
					+ "<td class=\"idRobaUsluge\">"
					+ data.idRobaUsluge
					+ "</td>"
					+ "<td><a class=\"remove\" href='/api/stavke-cenovnika/" + data.id + "'>"
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
			jedinicnaCena : $("#editForm [name='jedinicnaCena']").val(),
			cenovnik : $("#editForm [name='cenovnik']").val(),
			idRobaUsluge : $("#editForm [name='robaUsluga']").val(),
          
        });
		console.log($("#editForm [name='stavkeCenovnikaId']").val());
		console.log(formData);
		$.ajax({
			url: "http://localhost:8080/api/stavke-cenovnika/" + $("#editForm [name='stavkeCenovnikaId']").val(),
			type: "PUT",
			beforeSend: function(request) {
	            request.setRequestHeader("X-Auth-Token", token);
	        },
			data: formData,
			// saljemo json i ocekujemo json nazad
			contentType: "application/json",
			datatype: 'json',
			success: function(data) {
				$(".highlighted").find(".jedinicnaCena")[0].innerHTML = data.jedinicnaCena;
				$(".highlighted").find(".cenovnik")[0].innerHTML = data.cenovnik;
				$(".highlighted").find(".idRobaUsluge")[0].innerHTML = data.idRobaUsluge;
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


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
	datumPrimene = new Date(item.find(".datumPrimene").html())
	console.log(datumPrimene);
	id = item.find(".id").html()
	preduzece = item.find(".preduzece").html()
//	$("#datumPrimene").val(datumPrimene);
	var datum = $("#datumPrimene");
	datum.valueAsDate = datumPrimene;
	console.log(datum);
	$("#id").val(id);
	$("#preduzeceSelect").val(preduzece);
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
    	beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},
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
		url : "http://localhost:8080/api/istorije-poreza/",
		type: "GET",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},
    	success: function(data) {
					console.log("Uspeo")
					for (i = 0; i < data.length; i++) {
						var newRow = "<tr>"
						+ "<td class=\"datumPrimene\">"
						+ data[i].datumPrimene
						+ "</td>"
						+ "<td class=\"preduzece\">"
						+ data[i].preduzece
						+ "</td>"
						+ "<td><a class=\"remove\" href='/api/istorije-poreza/" + data[i].id + "'>"
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
		type: "GET",
		beforeSend: function (request) {
            request.setRequestHeader("X-Auth-Token", token);
    	},
    	success: function(data) {
			console.log("Uspeo")
			for (i = 0; i < data.length; i++) {
				var newOption = '<option value="' + data[i].PIB + '">'
				+ data[i].naziv + '</option>';
				$("#preduzeceSelect").append(newOption);
			}
    	}
	});
				
	$('#inputModal').on('shown.bs.modal', function (e) {
		$.ajax({
			url: "http://localhost:8080/api/preduzeca",
			type: "GET",
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
	    	},
			success: function(data) {
				console.log("Ucitavanje grupe");
				console.log(data);
				for (i = 0; i < data.length; i++) {
					console.log(i);
					var newOption = '<option value="' + data[i].PIB + '">'
					+ data[i].naziv + '</option>';
					console.log(data[i]);
					$(e.currentTarget).find('select[name="preduzeceSelect"]').append(newOption);
				}
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
				url: "http://localhost:8080/api/istorije-poreza/",
				type: "POST",
				data: formData,
				// saljemo json i ocekujemo json nazad
				contentType: "application/json",
				datatype: 'json',
				beforeSend: function (request) {
		            request.setRequestHeader("X-Auth-Token", token);
				},
				success: function(data) {
					console.log(data);
					var newRow = "<tr>"
						+ "<td class=\"datumPrimene\">"
						+ data.datumPrimene
						+ "</td>"
						+ "<td class=\"preduzece\">"
						+ data.preduzece
						+ "</td>"
					+ "<td><a class=\"remove\" href='/api/istorije-poreza/" + data.id + "'>"
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
			 datumPrimene : $("#editForm [name='datumPrimene']").val(),
	         preduzece :$("#editForm [name='preduzeceSelect']").val()
        });
		console.log(formData);
		$.ajax({
			url: "http://localhost:8080/api/istorije-poreza/" + $("#editForm [name='id']").val(),
			type: "PUT",
			data: formData,
			// saljemo json i ocekujemo json nazad
			contentType: "application/json",
			datatype: 'json',
			beforeSend: function (request) {
	            request.setRequestHeader("X-Auth-Token", token);
			},
			success: function(data) {
				$(".highlighted").find(".datumPrimene")[0].innerHTML = data.datumPrimene;
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
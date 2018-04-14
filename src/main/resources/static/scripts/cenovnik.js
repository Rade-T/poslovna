function add() {
		// pripremamo JSON koji cemo poslati
		console.log("start");
		formData = JSON.stringify({
            datum : $("#inputForm [name='datum']").val(),
            preduzece :$("#inputForm [name='preduzece']").val(),
        });
		$.ajax({
			url: "/Cenovnici",
			type: "POST",
			data: formData,
			// saljemo json i ocekujemo json nazad
			contentType: "application/json",
			datatype: 'json',
			success: function(data) {
				var newRow = "<td class=\"datumPrimene\">"
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
		$('#inputModal').modal('toggle');
		console.log("end");
}
$(document).ready(function() {
	$("#loginBtn").on('click', function(event) {
		event.preventDefault();
		var loginData = JSON.stringify({
			username: $("#username").val(),
			password: $("#password").val()
		});
		console.log(loginData);
		$.ajax({
			url: "http://localhost:8080/api/login",
			type: "POST",
			data: loginData,
			contentType: "application/json",
			datatype: 'json',
			success: function(data) {
				localStorage.setItem("token", data.token);
				window.location.replace("/index.html");
				console.log(data);
			},
			error: function() {
				console.log("Login nije uspeo.");
			}
		});
	});
});
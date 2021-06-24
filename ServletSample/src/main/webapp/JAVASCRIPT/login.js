/**
 * Author Saravana Ganesh V
 * Created on 24-06-2021
 */
window.sessionStorage;
$(document).ready(function() {
  $('#login_page').submit(function(e) {
	e.preventDefault();
    var email = $('#email').val();
    var password = $('#password').val();
	var method_name = "login";
	if(!validateEmail(email)){
		$("#validation").text("Invalid email format");
		return false;
	}
	function validateEmail(email) {
		var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		return emailReg.test(email);
	}
	
	
  $.ajax({
      url:'login',
      data:{
    	  "userEmail":email,
    	  "password":password
	  },
      type:'post',
      async:false,
      success: function (data) {
          callbackfn(data)
      },
      error: function (textStatus, errorThrown) {
          callbackfn("Error getting the data")
      }

   });
  function callbackfn(data)
  {
     if(data=="1"){
    	 sessionStorage.setItem("session_email",email);
    	 window.location = 'HTML/home.html';
     }else{
    	 $("#validation").text("Invalid email or password");
     }  
  }
  });

});
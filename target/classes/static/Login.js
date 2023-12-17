function validateRegisterDetails(){
	var inputFirstName=document.getElementById("firstName").value;
	var inputLastName=document.getElementById("lastName").value;
	var letters = /^[A-Za-z]+$/;
	const alphaNum=/^[a-z0-9\_\.]*$/;
	var emailVal = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	const passVal=/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{6,})/;
	var inputUserName=document.getElementById("userName").value;
	var inputEmail=document.getElementById("email").value;
	var inputpwd=document.getElementById("regPass").value;
	//alert(inputpwd);
        if(!inputFirstName.match(letters) || !inputLastName.match(letters))
        {
		  alert('Invalid Name...!\nEnter only alphabets');
		  window.location.reload();
		  return false;
		}
		else if(!inputUserName.match(alphaNum))
		{
		  alert('Invalid Username...!\n Username can only consist of lowercase alphabets and/or Numbers including special characters . and _ ');
		  window.location.reload();
		  return false;
		}
		else if(!inputEmail.match(emailVal))
		{
		  alert('Invalid email...!\n email must be in the format- www.name/company.domain');
		  window.location.reload();
		  return false;
		}
		else if(!inputpwd.match(passVal))
		{
		  alert('Invalid password...!\n 1.must contain at least 1 lowercase alphabetical character \n2.must contain at least 1 uppercase alphabetical character\n3.must contain at least 1 numeric character\n4.must contain at least one special character (!,@,#,$,%,^,&,*)\n5. must have atleast 6 characters ');
		  window.location.reload();
		  return false;
		}
	
		
	}
	
	
/*	function regres(){

    var message = "[[${msg}]]";
    alert(message);

	}*/

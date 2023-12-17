function changeEmailValidation(){ 
	var inputEmail=document.getElementById("changeEmail").value;
	var emailVal = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	 if(!inputEmail.match(emailVal))
		{
		 
		  alert('Invalid email...!\n email must be in the format- www.name/company.domain');
		  window.location.reload();
		  return false;
		}
}
function changePasswordValidation(){
	const passVal=/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{6,})/;
	var inputEmail=document.getElementById("newPassword").value;
	 if(!inputEmail.match(passVal))
		{	  
		  alert('Invalid password...!\n 1.must contain at least 1 lowercase alphabetical character \n2.must contain at least 1 uppercase alphabetical character\n3.must contain at least 1 numeric character\n4.must contain at least one special character (!,@,#,$,%,^,&,*)\n5. must have atleast 6 characters ');
		  window.location.reload();
		  return false;
		}
}
function changePasswordValidation(){
	var letters = /^[A-Za-z]+$/;
	var inputFirstName=document.getElementById("newFirstName").value;
	var inputLastName=document.getElementById("newLastName").value;
	  if(!inputFirstName.match(letters) || !inputLastName.match(letters))
        {
		  alert('Invalid Name...!\nEnter only alphabets');
		  window.location.reload();
		  return false;
		}
}
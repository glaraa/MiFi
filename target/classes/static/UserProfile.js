function userCreationValidation(){
	var fuData = document.getElementById('file2');
        var FileUploadPath = fuData.value;

//To check if user upload any file
        if (FileUploadPath == '') {
            alert("Please upload an image");
            return false;
            }
}
function userProPicValidation(){
	var fuData = document.getElementById('file');
        var FileUploadPath = fuData.value;

//To check if user upload any file
        if (FileUploadPath == '') {
            alert("Please upload an image");
            return false;
            }
}
function userAboutValidation(){
	var fuData = document.getElementById('aboutedit');
        var FileUploadPath = fuData.value;

//To check if user upload any file
        if (FileUploadPath == '') {
            alert("Please enter something in about");
            return false;
            }
}
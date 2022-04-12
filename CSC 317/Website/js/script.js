validateUser = (string) => {
    if(string.length < 3){
        window.alert("Username must be 3 or more alphanumeric characters.");
        string.focus();
        return false;
    }
};
validateInput = (string, obj) => {
    if(string === ''){
        window.alert("Please enter a " + obj);
        string.focus();
        return false;
    }
};
validateLogin = () => {
    let input = document.forms["login"]["uname"].value;
    let psw = document.forms["login"]["psw"].value;

    validateUser(input);


    if(psw.length < 8) {
        window.alert("Password must be at least 8 characters long.");
        psw.focus();
        return false;
    }

    var myJSON = JSON.stringify(input);
    console.log(myJSON);
};
validatePassword(){
	let psw = document.forms["login"]["psw"].value;
	var regex = /^(?=.*[0-9])(?=.*[*!@#$^&])[a-zA-Z0-9!@#$%^&*]{8,}$/;
	if(pw == "") {
		document.getElementById("message").innerHTML = "**Fill the password please!";
		return false;
	}
	if(!regex.test(psw) || pw.length > 15 || pw.length < 8 ){
        	alert("Password must be at least 8 characters long, contain at least one number, one uppercase and one special character");
        	psw.focus();
	        return false;
    	}
}

validateConfirmationPassword(){
	let psw = document.forms["registration"]["inputpsw"].value;
 	let confirmpsw = document.forms["registration"]["inputcpsw"].value;

	if (psw !== confirmpsw) {
        	alert ("Passwords did not match. Please try again.");
        	return false;
    	}
}
validateRegistration = () => {
    let input = document.forms["registration"]["username"].value;
    let psw = document.forms["registration"]["psw"].value;
    let confirmpsw = document.forms["registration"]["cpsw"].value;
    var regex = /^(?=.*[0-9])(?=.*[*!@#$^&])[a-zA-Z0-9!@#$%^&*]{8,}$/;

    validateUser(input);

    if(!regex.test(psw)){
        alert("Password must be at least 8 characters long, contain at least one number, one uppercase and one special character");
        psw.focus();
        return false;
    }

    if (psw !== confirmpsw) {
        alert ("Passwords did not match. Please try again.");
        return false;
    }

    let myJSON = JSON.stringify(input);
    console.log(myJSON);
};
validatePost = () => {
    let post_title = document.forms["postImage"]["title"].value;
    let post_description = document.forms["postImage"]["description"].value;
    let ele1 = "title";
    let ele2 = "description";
    let image_file = document.getElementById('img');
    let path = image_file.value;
    let extensions = /(\.jpg|\.jpeg|\.png|\.bmp|\.gif)$/i;

    validateInput(post_title, ele1);
    validateInput(post_description, ele2);

    if(!extensions.exec(path)){
        alert("Not a valid image. Please upload images that are either jpg, png, bmp or gif");
        return false;
    }

    let myJSON = JSON.stringify(path);
    console.log(myJSON);
};



document.getElementByID("psw").validateRegistration();
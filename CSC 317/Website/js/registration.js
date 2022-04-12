name = document.getElementById('uname')
email = document.getElementById('email')
psw = document.getElementById('psw')
cpsw = document.getElementById('cpsw')
form = document.getElementById('form')
errorElement = document.getElementById('Registration-box')
var regex = /^(?=.*[0-9])(?=.*[*!@#$^&])[a-zA-Z0-9!@#$%^&*]{8,}$/;
cancelB = document.getElementById('cancel')

validateConfirmationPassword(){
    if (psw !== cpsw) {
        alert("Passwords did not match. Please try again.");
        return false;
    }
}

form.addEventListener('submit', (e) => {
    let message = []
    if (name.value === '' || name.value == null) {
        mess.push('Username is required')
        alert('Username is required');
    }
    if (name.value.length < 3) {
        mess.push('Username has to be more that 3 characters')
        alert('Username has to be more that 3 characters');
    }

    if (email.value === '' || email.value == null ) {
        mess.push('Email is required')
        alert('Email is required');

    }
    if (email.value.length < 3) {
        mess.push('Email must be valid')
        alert('Email must be valid');

    }

    if (psw.value === '' || psw.value == null ) {
        mess.push('Password is required')
        alert('Password is required');

    }
    if (psw.value.length < 3) {
        mess.push('Password must be longer than 8 characters')
        alert('Password must be longer than 8 characters');

    }
    if (!regex.test(psw)) {
        mess.push('Password must be at least 8 characters long, contain at least one number, one uppercase and one special character')
        alert("Password must be at least 8 characters long, contain at least one number, one uppercase and one special character");
        psw.focus();
        return false;
    }

    if (psw !== confirmpsw) {
        mess.push('Password Did Not Match')
        alert("Passwords did not match. Please try again.");
        return false;
    }
    validateConfirmationPassword();

    if (message.length > 0) {
        e.preventDefault()
    }

})

cancelButton(){
    cancelB.onclick(){
        location.href = "login.html";
    }
}
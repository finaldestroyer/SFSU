let uname = document.getElementById('uname').value
let email = document.getElementById('email').value
let psw = document.getElementById('psw').value
let cpsw = document.getElementById('cpsw').value
let form = document.getElementById('form')
let errorElement = document.getElementById('Registration-box')
var regex = /^(?=.*[0-9])(?=.*[*!@#$^&])[a-zA-Z0-9!@#$%^&*]{8,}$/;
var regx = /^([a-z 0-9\.-]+)@([a-z0-9- ]+).([a-z]{2,20})$/;
const express = require('express')
const app = express()

document.getElementById("cancelButton").conclick = function(){
    location.href = "index.hbs";
};
function validateUname(){
    if (uname.length < 3) {
        alert('Username has to be more that 3 characters');
        return false;
    }
};
function validateEmail(){
    if(!regx.test(email)){
        alert('Invalid Email');
        return false;
    }
};
function validatePsw(){
    if (psw.value.length < 3) {
        alert('Password must be longer than 8 characters');
        return false;
    }
    if (!regex.test(psw)) {
        alert("Password must contain at least one number, one uppercase and one special character");
        psw.focus();
        return false;
    }
};
function validateInput(){
    if(uname == "" || email == "" || password == "" || cpsw =="" || uname == null || email == null || password == null || cpsw == null){
        if(uname == "" || uname == null){
            alert('Please Fill in Username');
        }
        if(email == "" || email == null){
            alert('Please Fill in Email');
        }
        if(psw == "" || password == null){
            alert('Please Fill in Email');
        }
        if(cpsw == "" || cpsw == null){
            alert('Please Confirm Password');
        }
        return false;
    }
    validateUname();
    validateEmail();
    validatePsw();
    if(psw != cpsw){
        alert("Passwords Do Not Match");
        return false;
    }
};
app.get('csc317db/users',(req,res) =>{
    res.json(users)
});
function checkServer(){
    /*
    //if username exist
    if () {
        alert('Username Already Exist');
        return false;
    }
    //if email exist
    if () {
        alert('Email Already Exist');
        return false;
    }
    //if both username and email doesnt exist, add to database
    if () {
        $query = "INSERT INTO users (username, email, password) VALUES('$username', '$email', '".md5($password)."')";
    }
    */
    $(document).ready(function () {
        $("#formSubmit").on("submit", function (e) {
            e.preventDefault();
            var username = $("#username").val();
            var email = $("#email").val();
            if (username !== "" && email !== "") {
                $.ajax({
                    url: "checkUsername.php",
                    type: "POST",
                    cache: false,
                    data: { username: username, email: email },
                    success: function (result) {
                        if (result == 1) {
                            $("#message").text('Username or Email Already Exists');
                        } else {
                            $("#message").text('Username saved successfully');
                        }
                    }
                });
            } else {
                $("#message").text('Please fill the all fields');
            }
        });
    });
}
function pushUser(){   
    app.post('csc317db/users', async (req, res) => {
        try {
        const hashedPassword = await bcrypt.hash(req.body.psw, 10)
        const user = { name: req.body.uname, password: hashedPassword , email: req.body.email}
        users.push(user)
        //res.status(201).send()
        alert('Success! User Has Been Created');
        return true;
        } catch {
        //res.status(500).send()
        alert('Failed! User Failed To Be Created');
        return false;
        }
    })
}

function registerUser(){
    validateInput();
    checkServer();
    pushUser();
};

form.addEventListener('submit',registerUser());







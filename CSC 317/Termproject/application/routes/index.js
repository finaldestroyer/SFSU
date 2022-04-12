let name = document.getElementById('uname').value
let psw = document.getElementById('psw').value
const express = require('express')
const app = express()
const bcrypt = require('bcrypt')

app.get('/users', (req, res) => {
  res.json(users)
})

app.post('/users/login', async (req, res) => {
  const user = users.find(user => user.name === req.body.name)
  if (user == null) {
    return res.status(400).send('Cannot find user')
  }
  try {
    if(await bcrypt.compare(req.body.password, user.password)) {
      res.send('Success')
    } else {
      res.send('Not Allowed')
    }
  } catch {
    res.status(500).send()
  }
})

function validateUser(){
  
}

document.getElementById("loginButton").conclick = function(){
  if(uname == "" || psw == ""){
    alert("Please Fill in Username");
    return false;
  }
  if(psw == ""){
    alert("Please Fill in Password");
    return false;
  }
  validateUser();
};

document.getElementById("registrationButton").conclick = function(){
  location.href = "registration.hbs";
};








/*form.addEventListener('Login', (e) => {





})*/


/*var router = express.Router();

// GET home page. 
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express', name:"Japheth Wun" });
});

module.exports = router;
*/

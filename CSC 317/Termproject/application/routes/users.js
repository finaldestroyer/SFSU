var express = require('express');
var router = express.Router();
var db = require('../config/database');

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('respond with a resource');
});

router.post('/register',(req,res,next)=>{
  let username = req.body.username;
  let email = req.body.email;
  let password = req.body.inputpsw;

  db.execute("SELECT * FROM users WHERE username=?",[username])
  .then(([results,fields])=>{
    if(results & results.length == 0){
      return db.execute("SELECT * FROM users WHERE email=?",[email])
    }
    else{
        throw new UserError(
          "Registration Failed: Username already exists","/registration",200
        );
    }
  })
  .then(([results,fields])=>{
    if(results && results.length == 0){
      let baseSQL = "INSERT INTO users(username, email, password, created) VALUES (?,?,?,now());"
      return db.execute(baseSQL,[username,email,password])
    }
    else{
      throw new UserError(
        "Registration Failed: Email exists","/registatrion", 200
      );
    }
  })
  .then(([results, fields])=>{
    if(results && results.affectRows){
      successPrint("User.js --> User was created!");
      req.redirect('/login');
    }
    else{
      throw new UserError("Server Error, user could not be created","registration",500);
    }
  });
});

router.post('/login', (req, res, next)=>{
  let username = req.body.username;
  let password = req.body.inputpsw;
  let sql = "SELECT username, password FROM users WHERE username=? and password=?;"
  db.execute(baseSQL,[username,password])
  .then(([results, fields])=>{
    if(results && results.length == 1){
      successPrint(`User ${username} is logged in`);
      res.cookie("logged", username,{expires: new Date(Date.now()+9000), httpOnly: false});
      res.cookie("isLogged","true",{expires: new Date(Date.now()+9000), httpOnly: false});
      res.render('index',{logged:true});
    }
    else{
      throw new UserError("Invalid username and/or password.","/login",200);
    }
  })

})

module.exports = router;

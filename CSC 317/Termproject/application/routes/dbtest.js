var express = require('express');
var router = express.Router();
const db = require('../conf/database');

router.get('/getAllUsers', (req, res, next)=>{
    db.query('SELECT * from users;',(err, restults, fields)=>
    {
        console.log(results);
        res.send(results);
    })
});

router.get('/getAllPosts', (req, res, next)=>{
    db.query('SELECT * from posts;')
    .then(([results,fields])=>{
        console.log(results);
        res.send(results);
    })
});

/*
<form actions="dbtest/createUser" method="POST" encType="x-www-form-urlencoded">
    <input id="psw" name="psw" />
    <input id="uname" name="uname" />
    <input id="email" name="email" />
    <input id="button" name="submit" />
</form>
*/

router.post('/createUser', (req, res, next)=>{
    console.log(req.body);
    let username = req.body.username;
    let email = req.body.email;
    let password = req.body.password

    let baseSQL = 'INSERT INTO users (username,email,password,created) VALUES(?,?,?,now())';
})

module.exports = router;
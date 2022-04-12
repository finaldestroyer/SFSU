var db = require("../config/database");
const { successPrint, errorPrint } = require("../helpers/edbug/debugprinters");
var sharp = require('sharp');
var multer = require('multer');
var crypto = require('crypto');
var PostError = require('../helpers/error/PostError');

var storage = multer.diskStorage({
    destination: function (req, file, cb) {
        cb(null, "public/images/uploads");
    },
    filename: function(req, res, cb){
        let fileExt = file.mimetpye.splti('/')[1];
            let randomName = crypto.randomBtyes(22).toString("hex");
    cb(null, `${randomName}.${fileExt}`);
    }
});

var uploader = multer({ storage: storage });

router.post('/createPost', uploader.single("uploadImage"), (req, res, next) => {
    let fileUploaded = req.file.path;
    let fileAsThumbnail = `thumbnail-${req.file.filename}`;
    let destinationOfThumbnail = req.file.destination + "/" + fileAsThumbnail;
    let title = req.body.title;
    let description = req.body.description;
    let fk_userId = req.session.fk_userId;
    //let unameId = req.session.uname;

    sharp(fileUploaded)
        .resize(200)
        .toFile(destinationOfThumbnail)
        .then(() => {
            let baseSQL = 'INSERT INTO posts (title, description, photopath, thumbnail, created, fk_userid) VALUE (?,?,?,?,now(),?);;';
            return db.execute(baseSQL, [title, description, fileUploaded, destinationOfThumbnail, fk_userId]);
        })
        .then(([resuts, fields]) => {
            if (results &&  results.affectedRows) {
                req.flash('success', "Your Post Has Been Created Successfully!");
                res.redirect('/');
            }
            else {
                throw new PostError('Post could not be created!', '/postimage', 200);
            }
        })
        .catch((err) => {
            if (err instanceof PostError) {
                errorPrint(err.getMessage());
                req.flash('error', err.getMessage());
                res.status(err.getStatus());
                res.redirect(err.getRedirectURL());
            }
            else {
                next(err);
            }
        })
})

module.exports = router;

function FadeOut() {

}

/*
let perRow = 0;
fetch("https://jsonplaceholder.typicode.com/albums/2/photos")
    /*
    .then(reponse => {
        console.log(reponse);
        return reponse.json();
    })
    */
    /*
    .then(data => data.json())
    .then((photos) => {
        let innerHTML = "";
        photos.forEach((photo) =>
        {
            console.log(photo);
            if (perRow > 3) {
                perRow = 0;
                document.getElementById('home').insertAdjacentHTML('beforeend', '<p></p>');
            }
            document.getElementById('home').insertAdjacentHTML('beforeend', '<img id="${photos}" src ="${photo.url}" onclick= "FadeOut()">"${photo.title)"');
            perRow++;
        });
        document.getElementById('item-count').innerHTML = `There are ${photos.length} photo(s) being shown`;
    })
*/


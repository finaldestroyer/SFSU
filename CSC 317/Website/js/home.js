let perRow = 0;
let numberOfPictures = 0;

function FadeOut(id) {
    document.getElementById(id).style.display = "none";
    document.getElementById(photoNum).style.display = "none";
    numberOfPictures--;
    var numPic = "<div class='photoNum' id='photoNum'><p>There are " + numberOfPictures + " photo(s) being shown.</p></div>"
    document.getElementById('home').insertAdjacentHTML('beforeend', numPic);
}


fetch("https://jsonplaceholder.typicode.com/albums/2/photos")
    /*
    .then(reponse => {
        console.log(reponse);
        return reponse.json();
    })
    */
    .then(data => data.json())
    .then((photos) => {
        //let innerHTML = "";
        photos.forEach((photo) => {
            console.log(photo.id);
            var ph = "<div class='img' id='" + photo.id + "'><img onclick=FadeOut(" +  photo.id + ") src = '" + photo.url + "' width=200 height=200> <li> " + photo.title + "</li></div> ";
            console.log(ph);
            document.getElementById('list').insertAdjacentHTML('beforeend', ph);

           numberOfPictures++;
           perRow++;
        });
        var numPic = "<div class='photoNum' id='photoNum'><p>There are " + numberOfPictures + " photo(s) being shown.</p></div>"
        document.getElementById('home').insertAdjacentHTML('beforeend', numPic);
    })
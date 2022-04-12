
function FadeOut() {

}







let perRow = 0;
fetch("https://jsonplaceholder.typicode.com/albums/2/photos")
    /*
    .then(reponse => {
        console.log(reponse);
        return reponse.json();
    })
    */
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
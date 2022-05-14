const URL = 'http://localhost:8080/API/directors';

function getDirectors() {
    fetch(URL)
        .then(x => x.json())
        .then(d => console.log(d))
        .catch(err => console.error(err));
};

function getDirector(id) {
    fetch(URL.concat("/", id))
        .then(x => x.json())
        .then(x => console.log(x))
        .catch(err => console.error(err))
}

function postDirector(newDirector) {
    fetch(URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(newDirector)    
    })
        .then(x => x.json())
        .then(d => console.log(d))
        .catch(err => console.error(err));
}

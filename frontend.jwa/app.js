const URL = 'http://localhost:8080/API/directors';



function getDirectors() {
    fetch(URL)
    .then(x => {
        x.json();
    })
    .then(d => {
       console.log(d); 
    })
    .catch(err => {
        console.error(err)
    })
};

function postDirector(newDirector) {
    fetch(URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*"
            
        },
        body: JSON.stringify(newDirector)    
    })
    .then(x => {
            x.json();
        })
    . then(d => {
            console.log("New director: ", d);
        })
}
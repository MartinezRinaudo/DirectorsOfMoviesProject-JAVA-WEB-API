
    const DIRECTORS = '/API/directors';
    const USERS = '/API/users';

    function loginUser(user) {
        fetch(USERS.concat("/login"), {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(user)    
        })
            .then(x => x.json())
            .then(d => console.log(d))
            .catch(err => console.error(err));
    }

    window.loginUser = loginUser;

    function getDirectors() {
        fetch(DIRECTORS)
            .then(x => x.json())
            .then(d => console.log(d))
            .catch(err => console.error(err));
    }

    window.getDirectors = getDirectors;

    function getDirector(id) {
        console.log(DIRECTORS.concat("/", id));
        fetch(DIRECTORS.concat("/", id))
            .then(x => x.json())
            .then(x => console.log(x))
            .catch(err => console.error(err))
    }

    window.getDirector = getDirector;

    function postDirector(newDirector) {
        fetch(DIRECTORS, {
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


   
        const DIRECTORS = '/API/directors';
        const USERS = '/API/users/';

        function loginUser(userName,password) {
            fetch(USERS.concat("login"), {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({userName, password})    
            })
                .then(x => x.text())
                .then(d => {
                    console.log(d);
                    localStorage.setItem("jwt", d);
                })
                .catch(err => console.error(err));
        }

        function getDirectors() {
            fetch(DIRECTORS,{
                headers: {
                    "Authorization": localStorage.getItem('jwt')
                }
            })
                .then(x => x.json())
                .then(d => console.log(d))
                .catch(err => console.error(err));
        }

        window.getDirectors = getDirectors;

        function getDirector(id) {
            console.log(['/API/directors/',id].join(''));
            fetch(['/API/directors/',id].join(''))
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

export default {loginUser, getDirectors, getDirector};
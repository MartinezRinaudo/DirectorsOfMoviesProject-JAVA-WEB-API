import {useState, useEffect} from 'react'
import '../DirectorTable/style.css'

function Row(props) {
	return (
        <>
            <tr> 
                <td >{props.director.id}</td>
                <td>{props.director.name}</td>
                <td>{props.director.lastname}</td>
                <td><a href={"/directors/" + props.director.id}>Edit</a></td>
           </tr>
        </>
	)
}

function Rows(props) {
   return (props.directors.map( z => <Row director={z}></Row>))
}

function DirectorsTable() {
    let [dataDirectors, updateDirectors] = useState([]);

    useEffect(() => {
        fetch('/API/directors', {
            headers: {
                "Authorization": localStorage.getItem('jwt')
            }})
            .then(x => x.json())
            .then(x => {
                updateDirectors(x);
            })
    }, [])
    
    return (
        <>
            <div className="row height100"></div>        
            <div className="row">
                <div className="col-lg-2"></div>
                <div className="col-lg-8">
                    <table className="table">    
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Lastname</th>
                                <th>Edit</th>
                            </tr>
                        </thead>
                        <tbody>
                            <Rows directors={dataDirectors}></Rows>
                        </tbody>
                    </table>
                </div>
                <div className="col-lg-2"></div>
            </div>
        </>
    )
}

export default DirectorsTable;


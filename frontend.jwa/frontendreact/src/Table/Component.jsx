import react from 'react'
import '../Table/style.css'

function Row(props) {
	return (
            <tr>
                <td>{props.director.id}</td>
                <td>{props.director.name}</td>
                <td>{props.director.lastname}</td>
                <td>{props.director.productions}</td>
           </tr>
	)
}

function Rows(props) {
    console.log(props);

	return props.directors.map(z => (
		<Row director={z}></Row>
    ))
}

function Table() {
    let [dataDirectors, updateDirectors] = react.useState([]);

    react.useEffect(() => {
        fetch('/API/directors')
            .then(x => x.json())
            .then(x => {
                updateDirectors(x.resp)
            })
    },[])

    return (
        <>
            <div class="row height100"></div>        
            <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-lg-8">
                    <table class="table">    
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Lastname</th>
                                <th>Productions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <Rows directors={dataDirectors}></Rows>
                        </tbody>
                    </table>
                </div>
                <div class="col-lg-2"></div>
            </div>
        </>
    )
}

export default Table;


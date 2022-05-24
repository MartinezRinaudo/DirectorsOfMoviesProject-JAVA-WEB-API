import React, {useEffect} from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import DirectorsTable from './DirectorTable/Component' 
import '../node_modules/bootstrap/dist/css/bootstrap.css'
import {Routes, Route, BrowserRouter, useParams, useNavigate} from 'react-router-dom'
import Proxy from '../src/proxy';


function ShowDirector() {
  let {id} = useParams();
  return(
    <h1>Id={id}</h1>
  )
}

function List() {
  return (
    <DirectorsTable></DirectorsTable>
  )
}

function Login() {
  let [userName, setUser] = React.useState('');
  let [password, setPassword] = React.useState('');
  let navigate = useNavigate();

  function doLogIn() {
    Proxy.loginUser(userName, password);
    setTimeout( () => {
      navigate("/home")
    }, 2000)
  }
  
  return (
    <>
      <div className='h-50 d-inline-block'></div>
      <div className='row'>
        <div className='col-md-2'></div>
        <div className='col-md-2'>
          <label>User</label>
        </div>
        <div className='col-md-2'>
          <input onChange={e => setUser(e.target.value)} type='text'></input>
        </div>
        <div className='col-md-4'></div>
        <div className='col-md-2'></div>        
      </div>
      <div className='h-50 d-inline-block'></div>
      <div className='row'>
        <div className='col-md-2'></div>
        <div className='col-md-2'>
          <label>Password</label>
        </div>
        <div className='col-md-2'>
          <input onChange={e => setPassword(e.target.value)} type='password'></input>
        </div>
        <div className='col-md-4'></div>
        <div className='col-md-2'></div>        
      </div>
      <div className='h-50 d-inline-block'></div>
      <div className='row'>
        <div className='col-md-4'></div>
        <div className='col-md-2'>
          <button className='btn btn-secondary' onClick={doLogIn} type="button">Log In</button>
        </div>
        <div className='col-md-4'></div>
        <div className='col-md-2'></div>        
      </div>
    </>
  )
}

function Logout() {
    let navigate = useNavigate();
    
    useEffect( () => {
      localStorage.removeItem('jwt');
      navigate('/login');
    })
  return(<></>)
}

function MainMenu() {
  if(localStorage.getItem('jwt') === null) {
    return (
      <nav className="navbar navbar-expand-lg navbar-light bg-light margen-izquierda">
	      <div className="row">
	  	    <div className="col-md-12 text-center">
			      <h1>Java Web Api - API REST Directors</h1>
		      </div>
	      </div>	  
      </nav>
    )
  } else {
      return (
        <nav className="navbar navbar-expand-lg navbar-light bg-light margen-izquierda">
          <a className="navbar-brand" href="/home">Home</a>
          <a className="navbar-brand" href="/directors">Directors</a>
          <a className="navbar-brand" href="/editDirector">Update Director</a>
          <a className="navbar-brand" href="/logout">Log Out</a>
        </nav>
      )
    }
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <div className="container">
      <MainMenu></MainMenu>
      <BrowserRouter>
        <Routes>
          <Route path='/directors' element={<List/>}></Route>
          <Route path='/logout' element={<Logout/>}></Route>
          <Route path='/directors/:id' element={<ShowDirector/>}></Route>
          <Route path='/login' element={<Login/>}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  </React.StrictMode>,
);

/*
ReactDOM.render(
  <React.StrictMode>
    <div class="container">
      <Title text="Directors API REST - JAVA WEB API"></Title>
      <Table></Table>
    </div>
  </React.StrictMode>,
  document.getElementById('root')
);
*/
// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();

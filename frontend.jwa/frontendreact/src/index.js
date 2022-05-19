import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import Table from './Table/Component' 
import '../node_modules/bootstrap/dist/css/bootstrap.css'
import Title from './Title/Component';
import reactRouter, {Routes, Route, BrowserRouter} from 'react-router-dom'
import '../src/proxy'



function Listado() {
  return (
    <h1>Listado</h1>
  )
}

function NotFound() {
  return (
      <h1>No found</h1>
  )
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path='/listado' element={<Listado/>}></Route>
        <Route path='/' element={<NotFound/>}></Route>
      </Routes>
    </BrowserRouter>
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

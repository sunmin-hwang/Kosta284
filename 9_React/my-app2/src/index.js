import React, { Fragment } from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import PMS from './phones/PMService';
import Clock from './time/Clock';
import Phone from './phones/Phone';

//const, function 사용해서 ui의 내용을 구성
/*
const member = {
  id:"KOSTA",
  pwd:"1234",
  name:"홍종각",
  address:"종각",
}

function getToken(member){
  return member.id + " " + member.name;
}

const uielement = (
  <h1>Hello, {getToken(member)}</h1>
)
*/
const root = ReactDOM.createRoot(document.getElementById('root'));
setInterval(()=>{
  root.render(
    //3. Custom Tag
    <>
      <div>
        <Phone model={"iPhone-16"} made={"Apple"} />
        <Phone model={"갤럭시 s23"} made={"Samsung"} />
        <Phone model={"갤럭시 s24"} made={"Samsung"} />
      </div>
      <Clock />
    </>
  );
},1000);

//2.
/*
root.render(
  //uielement....1
  <React.StrictMode>
    <PMS />
  </React.StrictMode>
);
*/

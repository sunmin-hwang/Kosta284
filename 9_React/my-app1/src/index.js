import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';//.App...App.js생략되어져 있다.

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  //컴포넌트가 들어온다...App.js 파일의 App() 함수 부분의 내용이..
  <h1>안녕 리액트~~!!</h1>
);


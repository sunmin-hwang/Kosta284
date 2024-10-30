import './App.css';
import { BrowserRouter, NavLink, Route, Routes } from "react-router-dom";
import LoginPage from './page/LoginPage';
import BoardPage from './page/BoardPage';
import HomePage from './page/HomePage';
import Login from './components/login/Login';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <nav>
          <NavLink to="/">Home</NavLink> {/* onClick 이벤트로 제어 (a태그는 href로 제어) */}
          <NavLink to="loginPage">Login</NavLink>
          <NavLink to="board">Board</NavLink>
        </nav>
        <Routes>
          <Route path='/' element={<HomePage/>} />
          {/* http://localhost:3000/login/kosta */}
          <Route path='/login/:id' element={<Login/>} />
          <Route path='/loginPage' element={<LoginPage/>} />
          <Route path='/board' element={<BoardPage/>} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

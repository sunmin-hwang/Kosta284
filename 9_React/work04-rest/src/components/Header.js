import React from 'react';
import {Container, Nav, Navbar} from 'react-bootstrap';
import {Link} from 'react-router-dom';


const Header = () => {
    return (
        <div>
            <Navbar bg="primary" data-bs-theme="dark">
                <Container>
                    {/* .을 -로 바꾸고 전부 소문자로 변경...className */}
                    {/* <Navbar.Brand href="#home">Navbar</Navbar.Brand> */}
                    <Link to="/" className='navbar-brand'>Home</Link>
                    <Nav className="me-auto">
                        <Link to="/saveForm" className='nav-link'>글쓰기</Link>
                        <Link to="/joinForm" className='nav-link'>회원가입</Link>
                        <Link to="/loginForm" className='nav-link'>로그인</Link>
                    </Nav>
                </Container>
            </Navbar>
        </div>
    );
};

export default Header;
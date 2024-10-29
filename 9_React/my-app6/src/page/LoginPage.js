import React from 'react';
import Header from '../components/commons/Header';
import Login from '../components/login/Login';
import Footer from '../components/commons/Footer';

const LoginPage = () => {
    return (
        <div>
            {/* 페이지는 컴포넌트의 결합이다. */}
            <Header id="Header입니다."/>
            {/* 이 사이에 Body에 해당하는 컴포넌트가 연결...공용이 아닌 특정한 기능 */}
            <Login id="kosta" pwd="1234" />
            <Footer />
        </div>
    );
};

export default LoginPage;
import React from 'react';
import styled from 'styled-components';

const StyledFooter = styled.div`
    border: 1px solid black;
    height: 100px;
    width: 800px;
    margin: auto;
    list-style: none;
    padding-top: 40px;
    margin-top: 30px;
`

const Footer = () => {
    return (
        <div>
            <StyledFooter>
                <li>오시는길 : 서울 종로구 우정국로 대왕빌딩 7F</li>
                <li>전화번호 : 02-111-1224</li>
            </StyledFooter>
        </div>
    );
};

export default Footer;
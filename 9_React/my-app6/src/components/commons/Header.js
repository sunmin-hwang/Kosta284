import React from 'react';
import styled from 'styled-components';

const StyledHeader = styled.div`
    border: 1px solid black;
    height: 50px;
    display: flex;
    justify-content: space-around;
    width: 800px;
    margin: auto;
    list-style: none;
    padding-top: 20px;
`

const Header = (props) => {
    return (
        <div>
            <h3>{props.id}</h3>
            <StyledHeader>
                <li>Home</li>
                <li>Sign Up</li>
                <li>sign In</li>
            </StyledHeader>
        </div>
    );
};

export default Header;
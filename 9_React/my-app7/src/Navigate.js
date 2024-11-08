import React from 'react';
import { Link } from 'react-router-dom';
import {styled} from 'styled-components'

const StyledNav = styled.ul`
    width: 600px;
    display: flex;
    justify-content: space-around;
    text-align: center;
    font-size: 1.5em;
    margin: 0 auto;
    list-style: none;
`

const Navigate = () => {
    return (
        <div>
            <StyledNav>
                <li><Link style={{textDecoration:'none', color:'crimson'}} to="/">글 목록 보기</Link></li>
                <li><Link style={{textDecoration:'none', color:'crimson'}} to="/write">글 작성하기</Link></li>
            </StyledNav>
        </div>
    );
};

export default Navigate;
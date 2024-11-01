import React from 'react';
import { Card } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const BoardItem = (props) => {
    const {id,title, author} =props.board;
    return (
        <Card>
            <div className='card-body'>
                <div className='card-title'>{title}</div>
                <div className='card-test'>{author}</div>
                <Link to={`/board/${id}`} className='btn btn-primary'>상세보기</Link>
            </div>
        </Card>
    );
};

export default BoardItem;
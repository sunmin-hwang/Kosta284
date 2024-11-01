import React, { useEffect, useState } from 'react';
import { Button, Container, Form } from 'react-bootstrap';
import axios from 'axios'
import { useNavigate, useParams } from 'react-router-dom';

const UpdateForm = () => {
    const navigate = useNavigate();

    const {id} = useParams();
    const [board, setBoard] = useState({
        id:0,
        title:'',
        author:'',
    });

    useEffect(()=>{
        axios({
            url:'http://localhost:9000/boards/' + id,
            method:'get', 
        })
        .then((res)=>{
            setBoard(res.data);
        })
    },[])

    const changeform = (e)=>{
        setBoard({
            ...board,
            [e.target.name]:e.target.value
        })
    }

    const submitBoard = (e)=>{
        e.preventDefault();
        axios({
            url:'http://localhost:9000/boards/' + id,
            method:'put',
            data:board,
        })
        .then((res)=>{
            if(res.status===200){
                navigate(`/board/${id}`);
            }else{
                alert("수정 실패")
            }
        })
        .catch((err)=>{
            alert("어림도 없지");
        })
    }

    return (
        <div>
            <h1>글 수정하기..</h1>
            <Container style={{marginTop:'100px'}}>
                <Form onSubmit={submitBoard}>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <label className='form-label'>Title</label>
                        <input className='form-control' type="text" name="title" value={board.title} onChange={changeform} />
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicPassword">
                        <label className='form-label'>Author</label>
                        <input className='form-control' type="text" name="author" value={board.author} onChange={changeform} />
                    </Form.Group>
                    <Button variant="primary" type="submit">
                        Submit
                    </Button>
                </Form>
            </Container>
        </div>
    );
};

export default UpdateForm;
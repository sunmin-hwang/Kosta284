import React, { useState } from 'react';
import { Button, Container, Form } from 'react-bootstrap';
import axios from 'axios'
import { useNavigate } from 'react-router-dom';

const SaveForm = () => {
    const navigate = useNavigate();

    const [board, setBoard] = useState({
        title:'',
        author:'',
    });

    const changeform = (e)=>{
        //setBoard...board를 새로 만들고 폼에 입력된 값으로 그 객체를 채운다
        setBoard({
            ...board,
            [e.target.name]:e.target.value
        })
    }

    const submitBoard = (e)=>{
        //form 에 걸린 action으로 가는 걸 막고 axios 비동기 통신을 탄다.
        e.preventDefault();
        //비동기 통신으로 폼에 입력된 값으로 board를 생성...이걸 서버에 전달...디빙에 입력
        axios({
            url:'http://localhost:9000/boards',
            method:'post',
            data:board,
        })
        .then((res)=>{
            console.log(res);
            if(res.status===201){
                navigate("/");
            }
        })
        .catch((err)=>{
            alert("어림도 없지");
        })
    }

    return (
        <div>
            <Container style={{marginTop:'100px'}}>
                <Form onSubmit={submitBoard}>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <label className='form-label'>Title</label>
                        <input className='form-control' type="text" name="title" onChange={changeform} />
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicPassword">
                        <label className='form-label'>Author</label>
                        <input className='form-control' type="text" name="author" onChange={changeform} />
                    </Form.Group>
                    <Button variant="primary" type="submit">
                        Submit
                    </Button>
                </Form>
            </Container>
        </div>
    );
};

export default SaveForm;
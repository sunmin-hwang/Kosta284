import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import axios from 'axios'
import { Button } from 'react-bootstrap';

const Detail = () => {
    const navigate = useNavigate();

    const {id} = useParams();
    //비동기로 id에 해당하는 Board를 받아올것이다.
    //그 값을 상태값으로 저장..
    const [board, setBoard] = useState({
        id:0,
        title:'',
        author:'',
    })

    useEffect(()=>{
        axios({
            url:'http://localhost:9000/boards/' + id,
            method:'get',
        })
        .then((res)=>{
            console.log(res);
            setBoard(res.data);
        })
    },[])

    const deleteBoard = (id)=>{
        axios({
            url:'http://localhost:9000/boards/' + id,
            method:'delete',
        })
        .then((res)=>{
            if(res.status===200){
                navigate("/");
            }else{
                alert("삭제 실패...");
            }
        })
    }

    const updateBoard = ()=>{
        // alert("이도ㅓ....");
        navigate(`/updateForm/${id}`);
    }

    return (
        <div>
            <h1>상세글 보기</h1>
            <br/>
            <Button variant="warning" onClick={updateBoard}>수정</Button>
            {'    '}
            <Button variant="danger" onClick={()=>deleteBoard(board.id)}>삭제</Button>
            <hr/>

            <h3>{board.id}</h3>
            <h3>{board.title}</h3>
            <h3>{board.author}</h3>
        </div>
    );
};

export default Detail;
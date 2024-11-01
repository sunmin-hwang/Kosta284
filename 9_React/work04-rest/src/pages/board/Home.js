import React, { useEffect, useState } from 'react';
import BoardItem from './BoardItem';
import axios from 'axios'

const Home = () => {
    const [boards, setBoards] = useState([]);

    useEffect(()=>{
        //디비 연결...axios가 호출
        axios({
            url:"http://localhost:9000/boards",
            method:"get",
        })
        .then((res)=>{  //res.data
            console.log('res -->', res);
            console.log('res.data -->', res.data);
            setBoards(res.data);
        })
        .catch((err)=>{
            console.log(err);
        })
    }, []);

    return (
        <div>
            <h1>Board List...</h1>
            {
                boards.map((board)=>(
                    <BoardItem board={board} key={board.id} />
                ))
            }
        </div>
    );
};

export default Home
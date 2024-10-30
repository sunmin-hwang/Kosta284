import React from 'react';

const textColor = {color:'magenta'}

const Home = (props) => {
    //const boards = props.boards;
    const {boards,setBoards} = props;//구조분할 할당
    return (
        <div>
            <h1 style={textColor} >Home Page...</h1>
            <button onClick={()=>setBoards([])}>전체 삭제🧨💥</button>
            {boards.map((board)=>(
                <h3>
                    TITLE : {board.title} &nbsp;&nbsp;
                    CONTENT : {board.content}
                </h3>
            ))}
        </div>
    );
};

export default Home;
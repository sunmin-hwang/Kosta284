import React from 'react';
import Footer from '../components/commons/Footer';

const WritePage = () => {
    const handleWrite = ()=>{
        //게시글 하나가 생성..
        let board = {id:6, title:'폼 입력값', content:'폼 입력값2'}
    }
    return (
        <div>
            <h1>Write Page....</h1>
            <form>
                <input type='text' placeholder='제목을 입력....' />
                <input type='text' placeholder='내용을 입력....' />
                <button type='button' onClick={handleWrite}>글쓰기</button>
            </form>
            <Footer />
        </div>
    );
};

export default WritePage;
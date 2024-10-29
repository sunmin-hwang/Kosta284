import { useEffect, useState } from 'react';
import './App.css';
//import User, { id, name } from './user/User';

function App() {
  //let count = 0;
  const [count, setCount] = useState(0);
  const [search, setSearch] = useState(0);

  // const add = ()=>{//선언적 함수 정의 || 익명 함수 정의
  //   setCount(count+1);
  //   console.log("count ---> " + count);
  // }

  //3. 서버에서 클라이언트의 요청을 수행한 후 데이터를 반환...10을 리턴
  //   2번에서는 버튼 클릭해서 상태값 count를 변경했지만 실제로는 서버에서 받은 데이터를 할당...
  const ajaxData = ()=>{
    let serverCount = 10;
    setCount(serverCount);
  }

  //4.useEffect(()=>{}, []) []은 어떤 상태값에도 의존하지 않겠다는 의미
  useEffect(()=>{//실행시점 -- 1. 화면이 첫 랜더링(최초의 마운트)될 때 2. 상태값이 변경될 때마다.
    console.log("useEffect App 실행됨...");
    ajaxData(); // 화면이 먼저 랜더링 된 후에 서버의 데이터를 받아온다. 
  },[search])

  return (
    <>
      {/* 1. 증가된 조회수가 회면에 반영될려면 변수를 state로 변경 !! useState() 사용 */}
      {/* <h2>조회수 : {count}</h2>
      <User />
      Member ID : {id} <br/>
      Member Name : {name}
      <br/><b>---------------------------------</b>
      <button onClick={add}>조회수 증가하기</button> */}
      
      {/* 2. 버튼 누를때마다 useEffect가 시행된다.
          상태값이 바뀔 때..setCount사 호출될 때 App의 return이 동작하는데
          리엑트 엔진은 이전화면과 비교해서 변경된 부분만을 다시 랜더링한다. */}
      <h2>Hello React....useEffect!!</h2>

      <h2>조회수 증가하기 {count}</h2>
      <h2>검색 아이디 : {search}</h2>
      <button onClick={()=>{
        setCount(count+1);
      }}>증가하기</button>

      <button onClick={()=>{
        setSearch("KOSTA");
      }}>조회하기</button>
    </>
  );
}

export default App;

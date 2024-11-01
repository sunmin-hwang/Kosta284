import './App.css';
import axios from 'axios';
// import {BrowserRouter, Route, Routes} from 'react-router-dom'
// import ListPage from './pages/ListPage';
// import WritePage from './pages/WritePage';
// import Navigate from './Navigate';

function App() {
  const selectAll = ()=>{
    axios.get('https://jsonplaceholder.typicode.com/posts')
      .then((result)=>{
        // console.log(result.data);
        result.data.map((item)=>{
          console.log(item.id + ", " + item.title);
        })
      })
      .catch((err)=>{
        console.log(err);
      })      
  }
  const selectById = ()=>{
    axios({
      url:"https://jsonplaceholder.typicode.com/posts/1",
      method:"get",
      //data:
    })
    .then((result)=>{
      console.log(result.data);
    })
    .then(()=>{
      //이런 부분이 CallBack Hell을 만나지 않게 하는 중요한 부분
      console.log("성공한 후에 할 일은 여기서도 계속됩니다...")
    })
    .catch((err)=>{
      console.log(err);
    })
  }
  return (
    <div className="App">
      {/* <BrowserRouter>
        <Navigate />
        <Routes>
          <Route path="/" element={<ListPage />} />
          <Route path="/write" element={<WritePage />} />
        </Routes>
      </BrowserRouter> */}
      
      {/* <ListPage /> */}

      <button onClick={selectAll}>get-selectAll</button>
      <button onClick={selectById}>get-selectById</button>
    </div>
  );
}

export default App;

import {useState} from 'react';
import './App.css';

//서버에서 받아온 데이터...
//let location = "인도";
function location() {
  return "인도";
}

const styles = {color:"crimson", fontSize:"30px"};

function App() {
  //여행지가 변경되면 그때마다 화면의 내용이 변경...상태값으로 처리해야 한다...useState()
  let locations = ["인도", "라오스", "마다가스카르", "스페인", "하와이"];
  let [loc, setLoc] = useState(["Best Like Trip ~~", locations]);
  let [likes, setLikes] = useState([0,0,0,0,0]);
  return (
    <div className="App">
      <div className="nav">
         태어난 김에 세계일주
      </div>
      {/* getElementById("h3").innerHTML = location; */}
      {/* <h3 style={styles}>{location()}여행 Blog 작성</h3> */}
      {locations.map((location, index)=>(
        <div className='list'>
          <h3>{location}<span onClick={()=>{
            let like = [...likes];
            like[index]++; 
            setLikes(like);
          }}>👍</span></h3>
          <p>{loc[0]} {likes[index]}</p><hr/>
        </div>
      ))}
      {/* <div className='list'>
        <h3>{loc[1][0]}</h3>
        <p>{loc[0]}</p><hr/>
      </div>
      <div className='list'>
        <h3>{loc[1][1]}</h3>
        <p>{loc[0]}</p><hr/>
      </div>
      <div className='list'>
        <h3>{loc[1][2]}</h3>
        <p>{loc[0]}</p><hr/>
      </div>
      <div className='list'>
        <h3>{loc[1][3]}</h3>
        <p>{loc[0]}</p><hr/>
      </div>
      <div className='list'>
        <h3>{loc[1][4]}</h3>
        <p>{loc[0]}</p><hr/>
      </div> */}
    </div>
  );
}

export default App;

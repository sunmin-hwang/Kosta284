import './App.css';

//const, let.... var를 거의 사용하지 않는다.
const a = "Hello";
const b = 100;
function App() {
  return (
    <>
      <div>
        <h1 className='box-style'>{a==="Hi" || "Hello"} React~~!!</h1>
        <h2>React 공부한지 {b===100 ? "100시간" : "3시간"} 되는날</h2>
      </div>
    </>
  );
}

export default App;

import logo from './logo.svg';
import './App.css';

function App() { //App 함수는 컴포넌트
  return (
    <div className="App">
      <header className="App-header">
        {/* npm start 프로젝트 실행과 동시에 수정된 부분을 다시 반영
            개발서버를 처음에 실행할 때는 화면이 뜨기까지 오래 걸리지만
            다음부터느 바로바로 화면이 갱신
        */}
        <h1>Hello React~~!!</h1>
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;

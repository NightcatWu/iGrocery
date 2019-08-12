import React from 'react';
// import logo from './logo.svg';
import './App.css';
import TodoList from './components/TodoList'

function App() {
  console.log('launching...',process.env)
  return (
    <div className="App">
      <TodoList />
    </div>
  );
}

export default App;

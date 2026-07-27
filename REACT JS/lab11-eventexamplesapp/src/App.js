import React, { useState } from 'react';

function Counter() {
  const [count, setCount] = useState(0);
  const increment = () => {
    setCount(count + 1);
    sayHello();
  };
  const decrement = () => setCount(count - 1);
  const sayHello = () => alert('Hello! Static message.');
  return (
    <div>
      <h3>Counter</h3>
      <p>Count: {count}</p>
      <button onClick={increment}>Increment</button>
      <button onClick={decrement}>Decrement</button>
    </div>
  );
}

function WelcomeButton() {
  const handleClick = (msg) => alert(msg);
  return (
    <div>
      <h3>Welcome</h3>
      <button onClick={() => handleClick('welcome')}>Say Welcome</button>
    </div>
  );
}

function ClickButton() {
  const handleClick = (e) => {
    alert('I was clicked');
    console.log(e);
  };
  return <button onClick={handleClick}>Click Me</button>;
}

function CurrencyConvertor() {
  const [rupees, setRupees] = useState(0);
  const [euro, setEuro] = useState(0);
  const handleSubmit = (e) => {
    e.preventDefault();
    const rate = 0.012;
    setEuro(rupees * rate);
  };
  return (
    <div>
      <h3>Currency Converter</h3>
      <form onSubmit={handleSubmit}>
        <input type="number" value={rupees} onChange={(e) => setRupees(e.target.value)} placeholder="Rupees" />
        <button type="submit">Convert</button>
      </form>
      <p>Euro: {euro.toFixed(2)}</p>
    </div>
  );
}

function App() {
  return (
    <div>
      <Counter />
      <WelcomeButton />
      <ClickButton />
      <CurrencyConvertor />
    </div>
  );
}

export default App;

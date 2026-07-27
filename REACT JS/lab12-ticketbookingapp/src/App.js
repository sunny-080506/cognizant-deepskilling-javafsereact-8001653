import React, { useState } from 'react';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const GuestPage = () => (
    <div>
      <h2>Guest Page</h2>
      <p>Please login to book tickets.</p>
      <button onClick={() => setIsLoggedIn(true)}>Login</button>
    </div>
  );

  const UserPage = () => (
    <div>
      <h2>User Page</h2>
      <p>Flight Details: ...</p>
      <button onClick={() => setIsLoggedIn(false)}>Logout</button>
    </div>
  );

  return (
    <div>
      {isLoggedIn ? <UserPage /> : <GuestPage />}
    </div>
  );
}

export default App;

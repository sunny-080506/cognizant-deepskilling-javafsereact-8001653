import React, { useState } from 'react';

function Register() {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [errors, setErrors] = useState({});

  const validate = () => {
    const err = {};
    if (name.length < 5) err.name = 'Name must be at least 5 characters';
    if (!email.includes('@') || !email.includes('.')) err.email = 'Email must contain @ and .';
    if (password.length < 8) err.password = 'Password must be at least 8 characters';
    return err;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const err = validate();
    if (Object.keys(err).length === 0) {
      alert('Registration successful!');
      setName('');
      setEmail('');
      setPassword('');
      setErrors({});
    } else {
      setErrors(err);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Register</h2>
      <div>
        <label>Name:</label>
        <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
        {errors.name && <span style={{color:'red'}}>{errors.name}</span>}
      </div>
      <div>
        <label>Email:</label>
        <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
        {errors.email && <span style={{color:'red'}}>{errors.email}</span>}
      </div>
      <div>
        <label>Password:</label>
        <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
        {errors.password && <span style={{color:'red'}}>{errors.password}</span>}
      </div>
      <button type="submit">Register</button>
    </form>
  );
}

export default Register;

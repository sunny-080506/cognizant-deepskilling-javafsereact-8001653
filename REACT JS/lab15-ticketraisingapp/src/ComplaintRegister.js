import React, { useState } from 'react';

function ComplaintRegister() {
  const [name, setName] = useState('');
  const [complaint, setComplaint] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const refNo = Math.floor(Math.random() * 100000);
    alert(`Complaint registered! Reference Number: ${refNo}`);
    setName('');
    setComplaint('');
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Register Complaint</h2>
      <div>
        <label>Employee Name:</label>
        <input type="text" value={name} onChange={(e) => setName(e.target.value)} required />
      </div>
      <div>
        <label>Complaint:</label>
        <textarea value={complaint} onChange={(e) => setComplaint(e.target.value)} required />
      </div>
      <button type="submit">Submit</button>
    </form>
  );
}

export default ComplaintRegister;

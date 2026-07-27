import React from 'react';

function App() {
  const office = { name: 'Downtown Office', rent: 55000, address: '123 Main St' };
  const offices = [
    { name: 'Office A', rent: 45000, address: 'Street 1' },
    { name: 'Office B', rent: 65000, address: 'Street 2' },
    { name: 'Office C', rent: 58000, address: 'Street 3' },
  ];

  const heading = <h1>Office Space Rental</h1>;
  const image = <img src="https://via.placeholder.com/300" alt="office" />;

  return (
    <div>
      {heading}
      {image}
      <h2>Office Details</h2>
      <p>Name: {office.name}</p>
      <p>Rent: <span style={{ color: office.rent < 60000 ? 'red' : 'green' }}>${office.rent}</span></p>
      <p>Address: {office.address}</p>
      <h3>All Offices</h3>
      <ul>
        {offices.map((o, idx) => (
          <li key={idx}>
            {o.name} - Rent: <span style={{ color: o.rent < 60000 ? 'red' : 'green' }}>${o.rent}</span> - {o.address}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;

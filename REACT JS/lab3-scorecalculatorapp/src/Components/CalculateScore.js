import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore({ Name, School, Total, goal }) {
  const average = Total / goal;
  return (
    <div className="score-card">
      <h2>Student Score</h2>
      <p><strong>Name:</strong> {Name}</p>
      <p><strong>School:</strong> {School}</p>
      <p><strong>Total:</strong> {Total}</p>
      <p><strong>Goal:</strong> {goal}</p>
      <p><strong>Average:</strong> {average.toFixed(2)}</p>
    </div>
  );
}

export default CalculateScore;

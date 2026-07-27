import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);
  return (
    <div className={`card ${theme}`}>
      <h3>{employee.name}</h3>
      <button className={theme}>Details</button>
    </div>
  );
}

export default EmployeeCard;

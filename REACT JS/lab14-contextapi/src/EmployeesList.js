import React from 'react';
import EmployeeCard from './EmployeeCard';

function EmployeesList() {
  const employees = [{ name: 'John' }, { name: 'Jane' }];
  return (
    <div>
      {employees.map((emp, idx) => <EmployeeCard key={idx} employee={emp} />)}
    </div>
  );
}

export default EmployeesList;

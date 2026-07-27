import React from 'react';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore Name="John Doe" School="ABC High" Total={450} goal={500} />
    </div>
  );
}

export default App;

import React from 'react';

function ListofPlayers() {
  const players = [
    { name: 'Virat', score: 85 },
    { name: 'Rohit', score: 90 },
    { name: 'Dhoni', score: 70 },
    { name: 'Rahul', score: 45 },
    { name: 'Kohli', score: 95 },
    { name: 'Sharma', score: 60 },
    { name: 'Pant', score: 55 },
    { name: 'Jadeja', score: 75 },
    { name: 'Ashwin', score: 40 },
    { name: 'Bumrah', score: 30 },
    { name: 'Shami', score: 20 }
  ];

  const lowScorers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>All Players</h2>
      <ul>
        {players.map((p, idx) => (
          <li key={idx}>{p.name} - {p.score}</li>
        ))}
      </ul>
      <h3>Players with score below 70</h3>
      <ul>
        {lowScorers.map((p, idx) => (
          <li key={idx}>{p.name} - {p.score}</li>
        ))}
      </ul>
    </div>
  );
}

export default ListofPlayers;

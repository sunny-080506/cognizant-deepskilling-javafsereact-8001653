import React from 'react';

function IndianPlayers() {
  const T20players = ['Virat', 'Rohit', 'Dhoni'];
  const RanjiTrophy = ['Rahul', 'Jadeja', 'Ashwin'];
  const merged = [...T20players, ...RanjiTrophy];

  const evenPlayers = merged.filter((_, idx) => idx % 2 === 0);
  const oddPlayers = merged.filter((_, idx) => idx % 2 !== 0);

  return (
    <div>
      <h2>Indian Players</h2>
      <h3>Odd Team Players</h3>
      <ul>{oddPlayers.map((p, i) => <li key={i}>{p}</li>)}</ul>
      <h3>Even Team Players</h3>
      <ul>{evenPlayers.map((p, i) => <li key={i}>{p}</li>)}</ul>
      <h3>Merged (T20 + Ranji)</h3>
      <ul>{merged.map((p, i) => <li key={i}>{p}</li>)}</ul>
    </div>
  );
}

export default IndianPlayers;

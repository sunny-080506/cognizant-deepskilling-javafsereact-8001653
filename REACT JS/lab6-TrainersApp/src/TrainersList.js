import React from 'react';
import { Link } from 'react-router-dom';

function TrainersList({ trainers }) {
  return (
    <ul>
      {trainers.map(t => (
        <li key={t.trainerId}>
          <Link to={`/trainer/${t.trainerId}`}>{t.name}</Link>
        </li>
      ))}
    </ul>
  );
}

export default TrainersList;

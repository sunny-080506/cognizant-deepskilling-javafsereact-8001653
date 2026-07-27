import React, { useState, useEffect } from 'react';
import GitClient from './GitClient';

function App() {
  const [repos, setRepos] = useState([]);
  useEffect(() => {
    const client = new GitClient();
    client.getRepositories('techiesyed')
      .then(names => setRepos(names))
      .catch(err => console.error(err));
  }, []);
  return (
    <div>
      <h2>Repositories</h2>
      <ul>
        {repos.map((repo, idx) => <li key={idx}>{repo}</li>)}
      </ul>
    </div>
  );
}

export default App;

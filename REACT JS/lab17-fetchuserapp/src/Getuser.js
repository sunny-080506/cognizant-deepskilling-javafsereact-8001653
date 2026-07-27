import React, { Component } from 'react';

class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = { user: null };
  }

  componentDidMount() {
    fetch('https://api.randomuser.me/')
      .then(response => response.json())
      .then(data => {
        const user = data.results[0];
        this.setState({
          user: {
            title: user.name.title,
            first: user.name.first,
            last: user.name.last,
            picture: user.picture.large
          }
        });
      })
      .catch(err => console.error(err));
  }

  render() {
    const { user } = this.state;
    if (!user) return <div>Loading...</div>;
    return (
      <div>
        <h2>User Details</h2>
        <img src={user.picture} alt="user" />
        <p>Title: {user.title}</p>
        <p>First Name: {user.first}</p>
        <p>Last Name: {user.last}</p>
      </div>
    );
  }
}

export default Getuser;

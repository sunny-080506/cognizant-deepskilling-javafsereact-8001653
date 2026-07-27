import React, { Component } from 'react';

class Cart extends Component {
  render() {
    const { itemname, price } = this.props;
    return (
      <div>
        <span>{itemname}</span> - <span>${price}</span>
      </div>
    );
  }
}

export default Cart;

import React, { Component } from 'react';
import Cart from './Cart';

class OnlineShopping extends Component {
  constructor(props) {
    super(props);
    this.state = {
      items: [
        { itemname: 'Laptop', price: 1000 },
        { itemname: 'Phone', price: 500 },
        { itemname: 'Headphones', price: 50 },
        { itemname: 'Mouse', price: 20 },
        { itemname: 'Keyboard', price: 30 },
      ]
    };
  }

  render() {
    return (
      <div>
        <h2>Shopping Cart</h2>
        {this.state.items.map((item, index) => (
          <Cart key={index} itemname={item.itemname} price={item.price} />
        ))}
      </div>
    );
  }
}

export default OnlineShopping;

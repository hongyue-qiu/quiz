import React from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter,Switch,Route,Link} from 'react-router-dom'
import Home from './Home.js';
import Order from './Order';
import Goods from './Goods';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <BrowserRouter>
            <div className="header">
                <Link className="nav_link" to="/">商城</Link>
                <Link className="nav_link" to="/order">订单</Link>
                <Link className="nav_link" to="/goods">添加商品</Link>
            </div>
            <Switch>
                <Route exact path='/' component={Home}/>
                <Route exact path='/order' component={Order}/>
                <Route exact path='/goods' component={Goods}/>
            </Switch>
        </BrowserRouter>

      </header>
    </div>
  );
}

export default App;

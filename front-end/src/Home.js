import React, {Component} from 'react';
// import GoodsItem from './GoodsItem'
import './home.css'
import './goodsItem.css';

class Home extends Component{

    state = {
        orders:[]
    }

    async componentDidMount() {
        const response = await fetch('http://localhost:8080/order');
        const data = await response.json();
        this.setState({
            orders: data,
        })

    }

    render() {
        return (<div className="home">
            <div className="main">
                <div className="allGoods">
                    {/*<GoodsItem/>*/}
                    {
                        this.state.orders.map((order, index) => {
                            return <GoodsItem item = {order} key = {`order${index}`}></GoodsItem>
                        })
                    }
                </div>
                <div className="shopping-cart">购</div>
                <div className="shopping-cart-list"></div>
            </div>
        </div>);
    }

};

class GoodsItem extends Component {
    handleAddItem(){

    }
    render() {
        return (
            <div className="oneItem">
                <img className="item-img" src={this.props.item.url}/>
                <p className="item-title">{this.props.item.name}</p>
                <p className="item-price">{`单价：${this.props.item.price}元/${this.props.item.units}`}</p>
                <button className="item-add" onClick={this.handleAddItem}>+</button>
            </div>
        );
    }

};

export default Home;
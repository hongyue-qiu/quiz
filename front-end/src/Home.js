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
                    <GoodsItem/>
                    {
                        this.state.orders.map((order, index) => {
                            return <GoodsItem item = {order} key = {`order${index}`}></GoodsItem>
                        })
                    }
                </div>
            </div>
        </div>);
    }

};

class GoodsItem extends Component {
    render() {
        return (
            <div className="oneItem">
                <img className="item-img" src="https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1603422390&di=f32cd295bac48531d16d47a96ced24ce&src=http://img1.pclady.com.cn/pclady/1008/12/589623_cb4aa1.jpg"/>
                <p className="item-title">可乐</p>
                <p className="item-price">单价：1元/瓶</p>
            </div>
        );
    }

};

export default Home;
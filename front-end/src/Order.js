import React, {Component} from 'react';
import './order.css';

class Order extends Component {

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
        return (<div className="order">
            <div className="main">
                <table className="order_table">
                    <thead>
                    <tr>
                        <td className="">名字</td>
                        <td className="">单价</td>
                        <td className="">数量</td>
                        <td className="">单位</td>
                        <td className="">操作</td>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.orders.map((order, index) => {
                            return <OrderItem item = {order} key = {`order${index}`}></OrderItem>
                        })
                    }
                    </tbody>
                </table>
            </div>
        </div>);
    }

};

class OrderItem extends Component {

    handleDeleteOrder = () => {
        console.log(this.props.item);
        fetch('http://localhost:8080/order', {
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(this.props.item),
            method: 'DELETE'
        }).then(response => {
            if (response.status === 204) {
                window.location.reload();
            }
        });
    }

    render() {
        return <tr>
            <td>{this.props.item.name}</td>
            <td>{this.props.item.price}</td>
            <td>{this.props.item.goodsNumber}</td>
            <td>{this.props.item.units}</td>
            <td>
                <input className="delete" type="submit" value="删除" onClick={this.handleDeleteOrder}></input>
            </td>
        </tr>
    }
}

export default Order;
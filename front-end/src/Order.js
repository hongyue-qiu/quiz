import React, {Component} from 'react';
import './order.css';

class Order extends Component {

    render() {
        return (<div className="order">
            <div className="main">
                <table className="order_table">
                    <tr>
                        <td className="">名字</td>
                        <td className="">单价</td>
                        <td className="">数量</td>
                        <td className="">单位</td>
                        <td className="">操作</td>
                    </tr>
                    <tr>
                        <td className="">可乐</td>
                        <td className="">1</td>
                        <td className="">2</td>
                        <td className="">瓶</td>
                        <td className="">
                            <input type="button" className="delete" value="删除"/>
                        </td>
                    </tr>
                </table>
            </div>
        </div>);
    }

};

export default Order;
import React, {Component} from 'react';
import './goods.css';

class Goods extends Component {
    render() {
        return (
            <div className="goods">
                <div className="main">
                    <h2>添加商品</h2>
                    <form>
                        <div className="row">
                            <label htmlFor="name" className="label">名称</label>
                            <input className="text" type="text" placeholder="名称" />
                        </div>
                        <div className="row">
                            <label htmlFor="price" className="label">价格</label>
                            <input className="text" type="text" placeholder="价格" />
                        </div>
                        <div className="row">
                            <label htmlFor="units" className="label">单位</label>
                            <input className="text" type="text" placeholder="单位" />
                        </div>
                        <div className="row">
                            <label htmlFor="photo" className="label">图片</label>
                            <input className="text" type="text" placeholder="图片" />
                        </div>
                        <input className="submit" type="submit" value="提交"/>

                    </form>
                </div>
            </div>
        );
    }

};

export default Goods;
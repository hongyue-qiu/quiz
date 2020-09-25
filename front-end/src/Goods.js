import React, {Component} from 'react';
import './goods.css';

class Goods extends Component {
    state = {
        name:"",
        price:"",
        units:"",
        photo:"",
    }
    handleFileChange = (filed,e) =>{
        this.setState({
            [filed]:e.target.value
        })
    }
    submit = (e) =>{
        e.method = 'POST';
        e.target = '_blank'
        e.action = 'http://localhost:8080/oder';
    }
    async componentDidMount() {


    }
    render() {
        return (
            <div className="goods">
                <div className="main">
                    <h2>添加商品</h2>
                    <form  onSubmit={this.submit}>
                        <div className="row">
                            <label htmlFor="name" className="label">名称</label>
                            <input className="text" type="text" placeholder="名称"
                            value={this.state.name}
                            onChange={(e) => this.handleFileChange("name", e)}
                            id="name"/>
                        </div>
                        <div className="row">
                            <label htmlFor="price" className="label">价格</label>
                            <input className="text" type="text" placeholder="价格"
                                   value={this.state.price}
                                   onChange={(e) => this.handleFileChange("price", e)}
                                   id="price"/>
                        </div>
                        <div className="row">
                            <label htmlFor="units" className="label">单位</label>
                            <input className="text" type="text" placeholder="单位"
                                   value={this.state.units}
                                   onChange={(e) => this.handleFileChange("units", e)}
                                   id="name"/>
                        </div>
                        <div className="row">
                            <label htmlFor="photo" className="label">图片</label>
                            <input className="text" type="text" placeholder="图片" />
                        </div>
                        <input className="submit" type="submit" value="提交"
                               disabled={!this.state.name || !this.state.price || !this.state.units}
                        onClick={(e) => this.submit(e)}/>

                    </form>
                </div>
            </div>
        );
    }

};

export default Goods;
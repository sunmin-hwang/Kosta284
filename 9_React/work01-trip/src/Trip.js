import Img1 from "./assets/1.jpg";
import Img3 from "./assets/3.jpg";
import Img5 from "./assets/5.jpg";

import "./App.css";

function Trip() {
    return(
        <div className="imgLayer">
            <img src={Img1} alt="a" className="img" />
            <img src={Img3} alt="a" className="img" />
            <img src={Img5} alt="a" className="img" />
        </div>
    )
}

export default Trip;
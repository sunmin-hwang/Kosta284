import "./Movie.css"
const movie = "듄 파트2.";
const header = "100만 관객 동원";
const content = movie + header;
const url = "https://i.namu.wiki/i/EBnXxQjDFnQRItujvTQ61BBkgCb5-rqskUO9uhVXncxZU_I_gkzd3FBN2VDwCYo637zDjzJtdmdAHj_g7l9mow.webp";

function reservation() {
    alert("영화 예매 확인되었습니다~~!!");
}

function Movie() {
    return(
        <>
            <div className="movie">
                <h2 className="content">{movie}</h2>
                <h2 className="content">{header}</h2>
                <img src={url} alt="aa" className="movieImg" />
                <button onClick={reservation}>영화 예매하기</button>
            </div>
        </>
    )
}

export default Movie
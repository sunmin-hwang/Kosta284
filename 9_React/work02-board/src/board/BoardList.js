import Board from "./Board";

const comments=[
    {
        writer:"홍종각",
        comment:"금요일 퇴근하고 싶은 아침공기",
    },
    {
        writer:"Tomas",
        comment:"여기는 쉬카고 입니다",
    },
    {
        writer:"제시",
        comment:"폭행은 나쁜겁니다",
    }
]

function BoardList(props) {
    return(
        <>
            {comments.map((comment)=>{
                return(
                    <Board writer={comment.writer} comment={comment.comment} />
                );
            })}
        </>
    )
}

export default BoardList;
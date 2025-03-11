//수정 버튼을 클릭 했을 때 콘솔에 출력
//form method의 값을 콘솔에 출력력
//삭제 버튼을 클릭 했을 때 콘솔에 출력
//form action의 주소값을 콘솔에 출력
const up = document.getElementById("up");
const del = document.getElementById("del");
const frm = document.getElementById("frm");
const addCart = document.getElementById("addCart")
const addComment = document.getElementById("addComment");
const comment = document.getElementById("comment");
const commentsListResult = document.getElementById("commentsListResult");

const deleteComments = document.getElementsByClassName("deleteComments");


//
for(let dc of deleteComments) {
    dc.addEventListener("click", () => {
        console.log(dc.getAttribute("data-board-num"));
    })
}

commentsListResult.addEventListener("click", (e) => {
    if(e.target.classList.contains('deleteComments')){
        let boardNum = e.target.getAttribute("data-board-num");
        
        console.log("boardNum :" + boardNum);
    }
    
})


getList();

//
async function getList() {
    console.log("?????")
    let pNum = addCart.getAttribute('data-product-num')
    let url='./listComments'
    //절대경로 또는 상대경로 입력
    
    fetch(url + `?productNum=${pNum}`)
    .then(r => r.text())
    .then(r => {
        commentsListResult.innerHTML=r;
    })
    .catch(e => console.log(e))
    
}


//
commentsListResult.addEventListener("click", (e) => {
    if(e.target.classList.contains('pages')){
        let p = e.target.getAttribute("data-page-num");
        getList(p);
    }
})


//
async function add() {
    
}


//
addComment.addEventListener("click", ()=>{
    console.log("adco");
    console.log(comment.value);
    console.log(addCart.getAttribute('data-product-num'));

    f1();
    getList();
    //
    

})


let f1 = function(){

    let pNum = addCart.getAttribute('data-product-num');
    let bCon = comment.value;

    // 동기식 비동기식
    // 'post'
    let url='./addComments';
    //절대경로 또는 상대경로 입력
    
    fetch(url, {
        method : 'POST',
        headers : {
            "Content-type" : "application/x-www-form-urlencoded; charset=UTF-8"
        },
        body : `productNum=${pNum}&boardContent=${bCon}`
    })
    .then(r => r.text())
    .then(r => {
        if(r.trim()*1 > 0){

        } else {

        }
    })

    }



// let param = new URLSearchParams();
//     param.append("productNum", pNum);
//     param.append("boardContent", bCon);
    
//     let url='./addComments';
//     fetch(url, {
//         method : 'POST',
//         headers : {
//             "Content-type" : "application/x-www-form-urlencoded; charset=UTF-8"
//         },
//         body : param
//     })


// //
// function makeForm(pNum, bCon){
//     let f = new FormData();
//     f.append("productNum", pNum);
//     f.append("boardContent", bCon);

// }


// //
// function makeParam(pNum, bCon){

// }


//
addCart.addEventListener("click", ()=>{
    let num = addCart.getAttribute("data-product-num")

    let s = `hello ${num}` 
    // ` ` 을 쓰면 문자와 변수를 +로 합친 것과 같다
    // JS에서 ${}는 EL이 아니고, 선언된 변수를 갖다가 쓴다는 뜻이다
    fetch(`../users/addCart?productNum=${num}`)
    .then(res => res.text())
    .then(res => {
        if(res.trim()=="1"){ //parseInt("1"), "1"+1
            let r = confirm("장바구니로 이동?")
            if(r){
                location.href='../users/carts';
            }
        } else {
            alert('장바구니 등록 실패')
        }

    }) .catch(r => {
        alert('장바구니 등록 실패')
    })
})

try {
    up.addEventListener("click", function(){
        console.log(frm.method) //GET
        console.log(frm.getAttribute("method"))//null
        console.log("수정")
        frm.action="./update";
        frm.submit();
    })
} catch (error) {
    
}

del.addEventListener("click", function(){
    console.log(frm.action); //url
    console.log(frm.getAttribute("action"));//uri
    console.log("삭제")

    let check = confirm("정말 삭제???");
    if(check){
        frm.action="./delete";
        frm.method="POST";
        frm.submit();
    }
})



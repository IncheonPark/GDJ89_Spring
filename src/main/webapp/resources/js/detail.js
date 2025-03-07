//수정 버튼을 클릭 했을 때 콘솔에 출력
//form method의 값을 콘솔에 출력력
//삭제 버튼을 클릭 했을 때 콘솔에 출력
//form action의 주소값을 콘솔에 출력
const up = document.getElementById("up");
const del = document.getElementById("del");
const frm = document.getElementById("frm");
const addCart= document.getElementById("addCart")

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
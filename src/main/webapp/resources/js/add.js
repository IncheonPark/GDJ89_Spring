
const addInput = document.getElementsByClassName("addInput");
const addForm = document.getElementById("addForm");
const sub1 = document.getElementById("sub1");

sub1.addEventListener("click", function(){
    let check = true;
    for (let i of addInput) {
        if(i.value.length == 0){
            alert(i.id+"이 비어있습니다.");
            i.focus();
            check = false;
            break;
        }
    
    }

    if(check){
        addForm.submit();
    }

})

    


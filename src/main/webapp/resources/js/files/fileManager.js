
const files = document.getElementById("files");
const addFile = document.getElementById("addFile");
let count = 0;

addFile.addEventListener("click", function(){
    
    if(count < 5){
        let div1 = document.createElement("div");
        let label1 = document.createElement("label");
        let input1 = document.createElement("input");
        let inputX = document.createElement("input");

        let c1 = document.createAttribute("class");
        c1.value = "mb-3";
        div1.setAttributeNode(c1);

        let c2 = document.createAttribute("class");
        c2.value = "form-label";
        label1.setAttributeNode(c2);
        label1.InnerText = "첨부파일";

        let c3 = document.createAttribute("class");
        c3.value = "form-control";
        let t3 = document.createAttribute("type");
        t3.value = "file";
        let n3 = document.createAttribute("name");
        n3.value = "attaches"+count;
        
        input1.setAttributeNode(c3);
        input1.setAttributeNode(t3);
        input1.setAttributeNode(n3);

        let c4 = document.createAttribute("class");
        c4.value = "remove-File";
        let t4 = document.createAttribute("type");
        t4.value = "button";
        let v4 = document.createAttribute("value");
        v4.value = "X";
        let i4 = document.createAttribute("id");
        i4.value = "X_id"+count;

        inputX.setAttributeNode(c4);
        inputX.setAttributeNode(t4);
        inputX.setAttributeNode(v4);
        
        label1.append(input1);
        label1.append(inputX);
        div1.append(label1);
        files.append(div1);
        
        count++;
        
        inputX.addEventListener("click", function(){
            label1.parentNode.remove();
            count--;
        })

    } else {
        alert("파일 추가는 5개까지만 가능합니다");       
        
    }

    
    

})


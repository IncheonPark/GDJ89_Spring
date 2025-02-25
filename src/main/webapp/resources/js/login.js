/**
 * 
 */
 
 const userName = document.getElementById("userName");
 const password = document.getElementById("password");
 const checkEmpty = document.getElementById("checkEmpty");

 checkEmpty.addEventListener("click", function(){
    alert("userName은 : " + userName.value);
    alert("password는 : " + password.value);
 })
function loginForm(){
    var emailFromPage = document.getElementById("email").value;
    var passwordFromPage = document.getElementById("parola").value;
    
    
    $.post("http://localhost:8085/user/login",{"email": emailFromPage, 
                                              "password": passwordFromPage}, function(responseFromJava){
        
        if(responseFromJava == "ok")
            location.href="Home.html"
        else
            alert("Date incorecte");
        
        
    });
    
}
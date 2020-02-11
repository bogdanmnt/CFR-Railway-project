function add(){
    var name = document.getElementById("nume").value;
    var lat = document.getElementById("lat").value;
    var lng = document.getElementById("long").value;
    $.post("http://localhost:8080/salut",{
        "mesaj":name
       
        
    }, function(response){
        if(response=="create")
            alert("Statie adaugata !");
        
        
    });
    
    
}
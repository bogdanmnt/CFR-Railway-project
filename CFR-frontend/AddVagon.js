function add(){
    var nrLocuri = document.getElementById("nrLocuri").value;
    var clasa = document.getElementById("clasa").value;
    var pret = document.getElementById("pret").value;
    $.post("http://localhost:8085/vagoane/create",{
        "nrLocuri":nrLocuri,
        "clasa":clasa,
        "pret":pret
        
        
    }, function(response){
        
            alert("Vagon adaugat !");
        location.href="vagoane.html";
        
    });
    
    
}
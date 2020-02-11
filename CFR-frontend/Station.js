function getStationsFromBackend(){
    var toateStatiile="<tr><th>Nume</th> <th>Latitudine</th><th>Longitudine</th><th>Stergere</th></tr>";
    $.get("http://localhost:8085/stations/get",
         {},
         function(responseFromBackend){
        for(let i=0; i<responseFromBackend.length; i++){
            toateStatiile=toateStatiile+ "<tr> <td>" + responseFromBackend[i].name
            +"</td> <td>" + responseFromBackend[i].lat + "</td> <td>" + responseFromBackend[i].lng + "</td><td><butoon id='remove' onClick='remove("+responseFromBackend[i].id+")'>Sterge</button> </td></tr>";
        }
        document.getElementById("statii").innerHTML=toateStatiile;
    });
    
    
    
}

getStationsFromBackend();

function remove(idStation){
        
    $.post("http://localhost:8085/stations/remove",
          {"stationId":idStation},
          function(response){
           alert("Statie Stearsa");
    getStationsFromBackend();
           });
}
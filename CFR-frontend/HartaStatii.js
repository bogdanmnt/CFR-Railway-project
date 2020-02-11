function initMap() {
    var mapOptions = {
        center: new google.maps.LatLng(40, 41),
        zoom: 5,
        mapTypeId: google.maps.MapTypeId.HYBRID
    }
    var map = new google.maps.Map(document.getElementById("map"), mapOptions);
    var statia1 = {
        lat: 47.158,
        lng: 27.601
    }
    getStationsFromBackend(map);
}

function getStationsFromBackend(map) {
    $.get("http://localhost:8085/stations/get", {},
        function (responseFromBackend) {
            for (let i = 0; i < responseFromBackend.length; i++) {
                var statia1 = {
                    lat: responseFromBackend[i].lat,
                    lng: responseFromBackend[i].lng
                };

                var statia1Marker = new google.maps.Marker({
                    position: statia1,
                    map: map,
                    title: responseFromBackend[i].name,
                    animation: google.maps.Animation.DROP
                });
            }
        });



}

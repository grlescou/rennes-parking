
//localStorage.clear();
var parkingList=[];
var distance = 500;
var myCurrentLocation=[];
var MySaveData= {};
var MySaveData= JSON.parse(getStoredValue('dataObjLocat'));

console.log(MySaveData);

if (MySaveData)
{   console.log("my save Data = true");
  distance = MySaveData.dist;
  console.log(MySaveData.dist);
  myCurrentLocation[0] = MySaveData.lat;
  console.log(MySaveData.lat);
  myCurrentLocation[1] = MySaveData.lon;
  console.log(MySaveData.lon);



}
else {
console.log("my save Data = false");
  distance = 500;;
  myCurrentLocation=[ 48.11005808, -1.681636388];

}


console.log(distance);
console.log(myCurrentLocation);

function  changeLocation() {
 console.log(" on button click changeLocation");
var form = document.getElementById("locForm");
 myCurrentLocation[0] = locForm['lat'].value;
 myCurrentLocation[1] = locForm['lon'].value;
 distance = locForm['dist'].value;
 MySaveData = {};
 MySaveData.dist = locForm['dist'].value;
 MySaveData.lat = locForm['lat'].value;
 MySaveData.lon = locForm['lon'].value;
console.log(MySaveData);
 storeValue('dataObjLocat', JSON.stringify(MySaveData));

/*
 var form = document.getElementById("locForm");
 form['lat'].value = myCurrentLocation[0] ;
 form['lon'].value = myCurrentLocation[1] ;
 form['dist'].value = distance ; */

 return false;
}


function initForm(myCurrentLocation, distance){

  document.getElementById("locForm").elements.item(0).value = myCurrentLocation[0] ;
  document.getElementById("locForm").elements.item(1).value = myCurrentLocation[1] ;
  document.getElementById("locForm").elements.item(2).value  = distance ;

}

function loadTable (parkingList){

  console.log("ready to generate list");
    var parkingtable = document.getElementById( 'parkingtable' );



  for (var i = 0; i < parkingList.length; i++) {

            var Tdiv = document.createElement("div");
            Tdiv.className ="tdiv";
            var Ttile = document.createElement("div");
            Ttile.className = "ttile";


            var image = document.createElement("img");
            image.className ="iconParking";
            image.src = 'img/parking.png';

            var imgDiv = document.createElement("div");
            imgDiv.className = "imgdiv";
            imgDiv.append(image);


            var Tkey = document.createElement("div");
            Tkey.className ="tkey";
            var p = document.createElement("p");
            //console.log(parkingList[i].fields.key);
            p.append(parkingList[i].fields.key);
            Tkey.append(p);

            var Tdistance = document.createElement("div");
            Tdistance.className = "tdistance";
            var pdistance = document.createElement("p");
            //console.log(parkingList[i].fields.key);
            pdistance.append(parkingList[i].fields.dist+" m");
            Tdistance.append(pdistance);

            Ttile.appendChild(imgDiv);
            Ttile.appendChild(Tkey);
            Ttile.appendChild(Tdistance);


            Tdiv.appendChild(Ttile);

            var TContent = document.createElement("div");
            TContent.className ="tcontent";

            var Tmax = document.createElement("div");
            Tmax.className ="tmax";

            var pmax = document.createElement("p");
            pmax.append("Capacity: "+parkingList[i].fields.max);
            Tmax.append(pmax);

            var Tfree = document.createElement("div");
            Tfree.className ="tfree";

            var pfree = document.createElement("p");
            pfree.append(parkingList[i].fields.free+ " place(s)");
            Tfree.append(pfree);

              TContent.appendChild(Tmax);
              TContent.appendChild(Tfree);

                Tdiv.appendChild(TContent);

            parkingtable.appendChild(Tdiv);


}

}

function loadCurrentLocation(map, loc) {
  var myLocationIcon = L.icon({
     iconUrl: './img/pin_1.png',
     iconSize: [50, 50]
 });

  var marker = new L.marker([myCurrentLocation[0],myCurrentLocation[1]], {icon: myLocationIcon})
    .bindPopup("<div id='popupdiv'> <img src='img/pin_1.png' width='25px' height='25px'/> <h3>My current Location</h3> <hr/> \
    ("+myCurrentLocation[0]+","+myCurrentLocation[1]+")</div>")
       .addTo(map);
}



function findAllParking(map, loc, dist) {
  var parkings = [];
  $.ajax({
    type: 'GET',
    url: 'http://localhost:8080/api/v1/parking/lat/'+loc[0]+'/lon/'+loc[1]+'/dist/'+dist+'/',
    data :[],
    dataType: "json", // data type of response
    success: function (parkingList, textStatus, msg) {
      console.log(textStatus);
        console.log(msg);
      console.log(parkingList);
      //parkings = data;

      var myParkingIcon = L.icon({
         iconUrl: './img/pin.png',
         iconSize: [50, 50]
     });


      for (var i = 0; i < parkingList.length; i++) {


           marker = new L.marker([parkingList[i].fields.geo[0],parkingList[i].fields.geo[1]], {icon: myParkingIcon})
               .bindPopup("<div id='popupdiv'> <img src='img/parking.png' width='25px' height='25px'/> <h3> \
               <p>Parking: "+ parkingList[i].fields.key+ "<hr/> </p> </h3><p>status: "+parkingList[i].fields.status+" </p>  \
               <h4>Tarif</h4> <hr/> \
               <p>15 mins: €"+parkingList[i].fields.tarif_15+" </p>  \
               <p>30 mins: €"+parkingList[i].fields.tarif_30+" </p>  \
               <p>1h: €"+parkingList[i].fields.tarif_1h+" </p>  \
               <p>1h30: €"+parkingList[i].fields.tarif_1h30+" </p>  \
               <p>2h: €"+parkingList[i].fields.tarif_2h+" </p>  \
               <p>3h: €"+parkingList[i].fields.tarif_3h+" </p>  \
               <p>4h: €"+parkingList[i].fields.tarif_4h+" </p>  \
               <h4>Time schedule organization</h4> <hr/><p> "+parkingList[i].fields.orgahoraires+" </p>  <hr/>\
               <p>Location: ("+parkingList[i].fields.geo[0]+","+parkingList[i].fields.geo[1]+" )</p>  \
             <hr/>  </div>")
                .addTo(map);
                   }
    loadCurrentLocation(map, loc);
    loadTable (parkingList);


    },
    error: function (msg, textStatus, errorThrow) {
      console.log(msg);
        console.log(textStatus);
      console.log(errorThrow);
      parkings = [];
    }
  });
  console.log("before return");

}





function initialize() {
  console.log("initialize");
    //var layers = ["terrain", "watercolor","toner"];

    //parkingList=[];
    //distance = 500;;
    //myCurrentLocation=[ 48.11005808, -1.681636388];

  /*  var form = document.getElementById("locForm");
     myCurrentLocation[0] = locForm['lat'].value;
     myCurrentLocation[1] = locForm['lon'].value;
     distance = locForm['dist'].value;

      var form = document.getElementById("locForm");
      form['lat'].value = myCurrentLocation[0] ;
      form['lon'].value = myCurrentLocation[1] ;
      form['dist'].value = distance ;
*/

        console.log(MySaveData);

        var terrain = new L.StamenTileLayer("terrain");
      //  var watercolor = new  L.StamenTileLayer("watercolor");
      //  var toner= new  L.StamenTileLayer("toner");

        var bases = {
            "Terrain":terrain
        }

        L.Map = L.Map.extend({
                             openPopup: function(popup) {
                             //        this.closePopup();  // just comment this
                             this._popup = popup;

                             return this.addLayer(popup).fire('popupopen', {
                                                              popup: this._popup
                                                              });
                             }
                             }); /***  end of hack ***/

                             // [ 48.11005808, -1.681636388]
        var map = new L.Map('map', {
                            center: [ myCurrentLocation[0], myCurrentLocation[1]],
                            zoom:14,
                            layers:terrain
                            })

        findAllParking(map,myCurrentLocation, distance);

        var popmaps = function(feature,layer){
            var popUp = feature.properties.name
            layer.bindPopup(String(popUp));
        }

         L.control.layers(bases).addTo(map);

        //  var myLocationIcon = L.icon({
        //     iconUrl: './img/pin_1.png',
        //     iconSize: [50, 50]
        // });
        //
        //  var marker = new L.marker([myCurrentLocation[0],myCurrentLocation[1]], {icon: myLocationIcon})
        //    .bindPopup("<div id='popupdiv'> <img src='img/pin_1.png' width='25px' height='25px'/> <h3>My current Location</h3> <hr/> \
        //    ("+myCurrentLocation[0]+","+myCurrentLocation[1]+")</div>")
        //       .addTo(map);

         var myParkingIcon = L.icon({
            iconUrl: './img/pin.png',
            iconSize: [50, 50]
        });

         // for (var i = 0; i < parkingList.length; i++) {
         //
         //
         //      marker = new L.marker([parkingList[i].fields.geo[0],parkingList[i].fields.geo[1]], {icon: myParkingIcon})
         //          .bindPopup("<div id='popupdiv'> <img src='img/parking.png' width='25px' height='25px'/> <h3> \
         //          <p>Parking: "+ parkingList[i].fields.key+ "<hr/> </p> </h3><p>status: "+parkingList[i].fields.status+" </p>  \
         //          <h4>Tarif</h4> <hr/> \
         //          <p>15 mins: €"+parkingList[i].fields.tarif_15+" </p>  \
         //          <p>30 mins: €"+parkingList[i].fields.tarif_30+" </p>  \
         //          <p>1h: €"+parkingList[i].fields.tarif_1h+" </p>  \
         //          <p>1h30: €"+parkingList[i].fields.tarif_1h30+" </p>  \
         //          <p>2h: €"+parkingList[i].fields.tarif_2h+" </p>  \
         //          <p>3h: €"+parkingList[i].fields.tarif_3h+" </p>  \
         //          <p>4h: €"+parkingList[i].fields.tarif_4h+" </p>  \
         //          <h4>Time schedule organization</h4> <hr/><p> "+parkingList[i].fields.orgahoraires+" </p>  \
         //        <hr/>  </div>")
         //           .addTo(map);
         //              }

        /*
         L.geoJson(parkingList, {
                   pointToLayer:function (feature, latlng) {
                   return L.marker(latlng, {

                                         fillColor: "#000000",
                                         color: "green",

                                         opacity: 1,

                                         });
                   },
                   onEachFeature:popmaps
                   }).addTo(map);
                    */


}





function storeValue(key, value) {
    if (localStorage) {
        localStorage.setItem(key, value);
    } else {
        $.cookies.set(key, value);
    }
}

function getStoredValue(key) {
    if (localStorage) {
        return localStorage.getItem(key);
    } else {
        return $.cookies.get(key);
    }
}

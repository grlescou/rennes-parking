# rennes-parking

The project consists  the development of an application that allows to display the car parking of the city of Rennes using their open data API. See link: https://data.rennesmetropole.fr/explore/dataset/export-api-parking-citedia/api/


**Functionality** 

All the functionalities realized are as follows:
-listing of car parking based on the location indicated by the person
-visualization of the car parking on a map

**Installation guide**

To launch the project:

1) download the project source code by cloning it from github using :
```
git clone https://github.com/grlescou/rennes-parking.git
```

Then enter the parking directory, the root of the project.

2) Use the following command to compile the application and produce the .jar of it: 
```
mvn package
```

3) To execute the application use the following command:
```
java -jar target/parking-0.0.0.1-SNAPSHOT.jar
```

-Notes that the default port 8080 can be changed at any time in the resources file → 
application.properties by modifying the server.port parameter

-After launching the application, the site is accessible via the browser by typing the following link: http://localhost:8080/

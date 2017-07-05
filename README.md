# marklogicexercise
Description:
   1. Create a repository on github to share your exercise.   
   2. Make a web application in a platform of your choice that responds to GET /hello with the JSON structure   {'hello' : ['marklogic',       'world']}    Make a commit in your repo that captures this web application in working state.

   3. Add an endpoint that responds to GET /adderToOne?inc=1  with {'answer' : 2 }.  The endpoint should add the value of the 'inc'           parameter to 1, so  /adderToOne?inc=10 should return {'answer':11}
   4. Add an endpoint that responds to POST /stateful?delta=1   with { 'total' : 1 }.   This endpoint will add whatever number is in           'delta' to a stateful variable held by the servder.  
      So if you call it a second time, adds your value to the previous total.  
      So a second call /stateful?delta=3 would result in {'total' : 4} because the previous state of '1' is added to the new delta '3'. 
      As a bonus, make the total survive a server restart.

   5. Bonus question - make the first endpoint return   "<hello>MarkLogic World</hello>"  if the accept: application/xml header is sent       with the GET request 

   6. Provide enough documentation so I can start the webapp from command line.  If you implement in Spring MVC as I'm expecting, then I       don't need much info
      to get going.  If you use node, I might need prerequisites too.

Running Environment:
   1. Language: Java
   2. java version: "1.8.0_45"
   3. maven version: "3.3.3"
   4. server: tomcat
   5. framework: Java Spring Boot

How to build the application:
   $ mvn spring-boot:run

Explain: 
   1. set up hello web service support for two data format of json and xml
      response xml format:
          curl --header "Accept: application/xml" http://localhost:8080/marklogic/hello
          result: <HelloResponse><hello>marklogic world</hello></HelloResponse>
      response json format: 
          curl --header "Accept: application/json" http://localhost:8080/marklogic/hello
          result: {"hello":["marklogic","world"]}

   2. set up adderToOne web service 
       example:
          $ curl --header "Accept: application/json" http://localhost:8080/marklogic/adderToOne?inc=10
          result: {"answer":11}

   3. set up state web service
       example: 
          $ curl --header "Accept: application/json" -d "delta=10" -X POST http://localhost:8080/marklogic/stateful
          result: {"total":10}
          do $ curl --header "Accept: application/json" -d "delta=15" -X POST http://localhost:8080/marklogic/stateful again
          result:{"total":25}

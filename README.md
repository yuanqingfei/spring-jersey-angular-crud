# spring-jersey-angular-crud
angular crud sample with Jersey on the backend

For DEV:

     tomcat:start

For Package:

     cd src/main/webapp
     bower install	
     sbt docker
     docker tag xxx 192.168.0.117:5000/jersey-crud
     docker push 192.168.0.117:5000/jersey-crud

On Server:

     docker pull 192.168.0.117:5000/jersey-crud
     docker run --rm --name jersey-crud -p 8080:8080 localhost:5000/jersey-crud

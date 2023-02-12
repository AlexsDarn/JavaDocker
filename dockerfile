FROM openjdk
WORKDIR /
ADD cliente.jar cliente.jar
#EXPOSE 1234
CMD java -jar cliente.jar
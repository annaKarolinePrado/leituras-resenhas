
JAVA 8

compilar e dar deploy no projeto
 mvn clean install; Copy-Item -Path "C:\Projetos\full\leituras-resenhas\target\leituras-resenhas.war" -Destination "C:\Servidores\wildfly-25.0.0.Final\standalone\deployments"

api
http://localhost:8080/leituras-resenhas/

Iniciar wildfly modo debug
acessar a pasta bin do wildfly exemplo(C:\Servidores\wildfly-25.0.0.Final\bin)
e executar o comando ./standalone.bat --debug

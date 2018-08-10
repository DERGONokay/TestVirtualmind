# Test Virtualmind - Damian Lisas

Testeado en Linux Ubuntu 16.04

Requisitos:
  - Java 8
  - Maven 3.x
  - MySQL
  - Python3
    -MySQL module
    
Instalacion:
1. Ejecutar "crearBBDD.py"
2. Ejecutar "poblarBBDD.py"
3. Entrar en "restful" y ejecutar: 'mvn clean package'
4. Ejecutar: 'java -jar target/restful-1.0.0-SNAPSHOT.jar'. Opcional se puede modificar el puerto mediante el flag --server.port='numero del puerto'

#!/usr/bin/env python3

import MySQLdb

# Abro la conexion con la base de datos
print ("Abriendo conexion...")
db = MySQLdb.connect("localhost","root","root")

# Creo el cursor
cursor = db.cursor()

# Creo la base de datos
print ("Creando base de datos...")
cursor.execute("CREATE DATABASE IF NOT EXISTS test;")
print ("Base de datos creada con nombre 'test'")
# Accedo a la base de datos
cursor.execute("USE test;")

# Creo la tabla
print ("Creando tabla para usuarios...")
cursor.execute("CREATE TABLE IF NOT EXISTS User (id int not null primary key, nombre varchar(255), apellido varchar(255), email varchar(255), password varchar(255));")
print ("Tabla 'User' creada!")

# Cierro la conexion
print ("Cerrando la conexion... Bye bye!")
db.close()

#!/usr/bin/env python3

import MySQLdb

# Abro la conexion con la base de datos
print ("Abriendo conexion...")
db = MySQLdb.connect("localhost","root","root")

# Creo el cursor
cursor = db.cursor()

# Accedo a la BBDD
print ("Accediendo a la BBDD con nombre 'test'...")
cursor.execute("USE test;")

# Pueblo la base de datos
print ("Poblando BBDD...")
sql = "INSERT INTO test.User (id, nombre, apellido, email, password) VALUES"
try:	
	for i in range(100):
		num = str(i)
		print (sql+" ("+num+",'nombre"+num+"','apellido"+num+"','email"+num+"@gmail.com','password"+num+"');")
		cursor.execute(sql+" ("+num+",'nombre"+num+"','apellido"+num+"','email"+num+"@gmail.com','password"+num+"');")
	db.commit()
	print ("Base de datos poblada!")
except:
	db.rollback()
	print("Fallo durante la poblacion, rollback realizado")

# Cierro la conexion
print ("Cerrando conexion... Bye bye!")
db.close()

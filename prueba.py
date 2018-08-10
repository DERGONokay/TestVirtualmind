#!/usr/bin/python

sql = "INSERT INTO User (id, nombre, apellido, email, password) VALUES"
for i in range(10):
        num = str(i)
        print(sql+" ("+num+",'nombre"+num+"','apellido"+num+"','email"+num+"@gmail.com','password"+num+"');")

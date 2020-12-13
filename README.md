# Servicio de desinfecciones COVID-19  
![alt text](https://github.com/dmarcob/desinfeccionCOVID/blob/main/images/index.png)  
### Despliegue de la aplicacin web con docker
```
unzip docker.zip
cd docker/
sh make.sh
```

#### ¿Qué problema resuelve este sistema de información?  
 Permite que el usuario pueda solicitar a una compañía externa la desinfección de COVID-19 en   
 un local u oficina pertenecientes al usuario.  

#### ¿Qué funcionalidad implementa este sistema de información?  
 1. El usuario puede enviar solicitudes de desinfección.  
 2. El usuario puede actualizar su informacin personal.  
 3. El usuario puede ver su historial de solicitudes.  
 4. El usuario puede ver los servicios que ofrece la empresa de desinfección.   
 5. El administrador del sistema de informacin puede ver las solicitudes enviadas por los usuarios.  
 6. EL administrador puede aceptar, denegar y finalizar las solicitudes enviadas por los usuarios.  
 7. El sistema envía un correo electrónico a un usuario cuando el administrador deniega o acepta una petición suya.  
 
#### ¿En qué contexto se ha realizado este proyecto?  
 Se ha realizado como prácticas de la asignatura Sistemas de Información de 3º de Ingeniería informática.  
 
#### ¿Qué tecnologías usa este proyecto?  
 se ha desarrollado con la tecnología Java EE(servlets), Javascrip, CSS, html y SQL  
 
#### ¿Qué funcionalidad ha generado mayor dificultad en su implementacin?  
 La paginación de las solicitudes de los usuarios al ser mostradas al administrador y al propio usuario  
 en su historial de solicitudes.  
 
#### ¿Qué aspectos se pueden mejorar?  
Se debe mejorar la seguridad del sistema reforzando la contraseña del usuario administrador y eliminando las vulnerabilidades  
de XSRF en el perfil del usuario.   
Además como mejora falta implementar la eliminación de la cuenta de un usuario y conectar los servicios con la base de datos.  


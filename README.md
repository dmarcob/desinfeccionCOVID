# Servicio web de desinfección de COVID-19  
![alt text](https://github.com/dmarcob/desinfeccionCOVID/blob/main/images/index.png)  
## Despliegue de la aplicación web con docker
```bash
unzip docker.zip
cd docker/
sh make.sh
```
## Sobre el sistema de información
* **¿Qué problema resuelve este sistema de información?**  
 Permite que el usuario pueda solicitar a una compañía externa la desinfección de COVID-19 en   
 un local u oficina pertenecientes al usuario.  

* **¿Qué funcionalidad implementa este sistema de información?**  
 :heavy_check_mark: El usuario puede enviar solicitudes de desinfección.  
 :heavy_check_mark: El usuario puede actualizar su informacin personal.  
 :heavy_check_mark: El usuario puede ver su historial de solicitudes.  
 :heavy_check_mark: El usuario puede ver los servicios que ofrece la empresa de desinfección.   
 :heavy_check_mark: El administrador del sistema de informacin puede ver las solicitudes enviadas por los usuarios.  
 :heavy_check_mark: EL administrador puede aceptar, denegar y finalizar las solicitudes enviadas por los usuarios.  
 :heavy_check_mark: El sistema envía un correo electrónico a un usuario cuando el administrador deniega o acepta una petición suya.  
 
* **¿En qué contexto se ha realizado este proyecto?**  
 Se ha realizado como prácticas de la asignatura Sistemas de Información de 3º de Ingeniería informática.  
 
* **¿Qué tecnologías usa este proyecto?**  
 se ha desarrollado con la tecnología Java EE(servlets), Javascrip, CSS, html y SQL  
 
* **¿Qué funcionalidad ha generado mayor dificultad en su implementacin?**  
 La paginación de las solicitudes de los usuarios al ser mostradas al administrador y al propio usuario  
 en su historial de solicitudes.  
 
* **¿Qué aspectos se pueden mejorar?**  
Se debe mejorar la seguridad del sistema reforzando la contraseña del usuario administrador y eliminando las vulnerabilidades  
de XSRF en el perfil del usuario.   
Además como mejora falta implementar la eliminación de la cuenta de un usuario y conectar los servicios con la base de datos.  


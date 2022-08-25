Servicio disponibles para pruebas: 

Swgger: http://localhost:8080/swagger-ui/index.html

La prueba esta desarrollada con Spring Boot 2.4.5.

Contiene MapStrcut para automatizacion de mapeos y creacion de objetos, 

Asi como Specifications para structurar consultas esta desarrollado sobre una Linea 

base estructurada con Arquitectura Exagonal. Contiene Swagger como componente de documentacion 

Como componente de integracion con las interfaces propuestas en el ejecicios se implemento un gateway 

con FeignClient. Cuanta con Manejo de Exepciones personalizado para reportar errores. Como Bd para la tabla que se creo 

se implementa BD en memoria en este Caso H2 todo esta implementado con Spring data, Jparepository para gestionar las entidades

hay disponibles componentes de paginacion, auditoria y de mas pero para la prueba no vi necesaria tanta complejidad. 

Se hace gestion e inyeccion de Beans para cargar la Data de las interfaces. 


Manuel Felipe Lemus. 






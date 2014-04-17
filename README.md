Ein einfacher REST-Service, der die drei Methoden GET, PUT und POST versteht. Es können verschiedene Begrüßungen hinterlegt werden, 
die über eine GET-Anfrage ausgelesen werden. Alle Begrüßungen werden im Arbeitsspeicher gehalten, so dass keine Datenbank u. ä. 
nötig ist. 

## Beispiel Nutzung

Eine Begrüßung kann mit curl über eine PUT-Anfrage gesetzt werden: 

    curl -X PUT -d greeting=Ola http://localhost:8080/simple-rest-service/service/ulrich

Diese kann über GET abgefragt werden: 

    curl -X GET http://localhost:8080/simple-rest-service/service/ulrich

Und mit DELETE gelöscht werden: 

    curl -X DELETE http://localhost:8080/simple-rest-service/service/ulrich

## Hinweise zur Implementierung

Es ist nicht möglich mit der `@RequestParam` [Annotation bei PUT-Anfragen][1] zu arbeiten. Daher wurde hier mit der 
`@RequestBody` Annotation [auf die Parameter-Map der Anfrage zu gegreifen][2].

Der Name der Begrüßung sollte in der URL kodiert werden und auch "/" enthalten können. Daher konnte nicht die `@PathVariable` 
Annotation verwendet werden. Eine Alternative stellt die [implementierung eines `WebArgumentResolver`][3] da ([ab Spring 3.1 
`HandlerMethodArgumentResolver`][4]). 


[1]: https://jira.spring.io/browse/SPR-7414 
[2]: http://stackoverflow.com/questions/5894270/springmvc-is-not-recognizing-request-body-parameters-if-using-put  
[3]: http://stackoverflow.com/questions/12393937/spring-mvc-implementation-of-webargumentresolver
[4]: http://stackoverflow.com/questions/12357817/upgrading-to-spring-3-1-seems-to-break-my-customwebargumentresolver/12358370#12358370

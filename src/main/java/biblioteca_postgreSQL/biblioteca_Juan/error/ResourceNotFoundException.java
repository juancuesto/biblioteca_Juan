package biblioteca_postgreSQL.biblioteca_Juan.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName; //indica nombre del recurso(fruta/frutas/etc)
    private String filedName;  //indica el nombre del campo(id / nombre /etc)
    private Object fieldValue; //indica el valor del campo (p.ej si es id su valor 1,2...el que sea)

    public ResourceNotFoundException(String resourceName, String filedName, Object fieldValue) {
        super(String.format("el recurso %s no fue encontrado con %s = %s  ",resourceName,filedName,fieldValue));
        this.resourceName = resourceName;
        this.filedName = filedName;
        this.fieldValue = fieldValue;
    }
    public ResourceNotFoundException(String resourceName) {
        super(String.format("en el recurso %s no se ha encontrado el elemento buscado ",resourceName));
        this.resourceName = resourceName;
    }
}

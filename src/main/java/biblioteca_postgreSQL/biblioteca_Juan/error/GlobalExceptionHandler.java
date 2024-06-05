package biblioteca_postgreSQL.biblioteca_Juan.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundExcepcion(ResourceNotFoundException ex,
                                                                        WebRequest webRequest){
        ApiResponse apiResponse=new ApiResponse(ex.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(value = BadRequestExcepcion.class)
    public ResponseEntity<ApiResponse> handlerBadRequestExcepcion(BadRequestExcepcion ex,
                                                                  WebRequest webRequest) {
        ApiResponse apiResponse = new ApiResponse(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}

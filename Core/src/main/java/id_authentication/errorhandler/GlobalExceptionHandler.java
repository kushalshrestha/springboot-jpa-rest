package id_authentication.errorhandler;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorType> handleException(Exception ex) {
        return new ResponseEntity<CustomErrorType>(new
                CustomErrorType("An error occurred: " + ex.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<CustomErrorType> handleNotFoundException(ChangeSetPersister.NotFoundException ex) {
        return new ResponseEntity<CustomErrorType>(new
                CustomErrorType("Resource not found: " + ex.getMessage()),HttpStatus.NOT_FOUND);

    }
}

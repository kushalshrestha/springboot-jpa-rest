package id_authentication.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PayloadNotValidException extends RuntimeException{
    private String message;
    public PayloadNotValidException(String message){
        this.message = message;
    }
}

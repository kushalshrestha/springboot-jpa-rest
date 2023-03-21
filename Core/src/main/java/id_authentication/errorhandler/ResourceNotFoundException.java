package id_authentication.errorhandler;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException{
    private String message;
    public ResourceNotFoundException(String message){
        this.message = message;
    }
}


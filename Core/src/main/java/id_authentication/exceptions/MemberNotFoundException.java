package id_authentication.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberNotFoundException extends RuntimeException{
    private String message;
    public MemberNotFoundException(String message) {
        super(message);

    }
}

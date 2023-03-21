package id_authentication.errorhandler;

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

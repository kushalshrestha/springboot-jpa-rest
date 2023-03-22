package id_authentication.dto.request;

import lombok.Data;

@Data
public class TransactionCreateDTO {

    private long badgeId;
    private long planId;
    private long locationId;
}
package id_authentication.dto.collection;

import id_authentication.dto.CheckInValidatorDTO;
import id_authentication.dto.LocationDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CheckInValidatorDTOs {
    List<CheckInValidatorDTO> checkInValidatorDTOS = new ArrayList<>();
    public void addToList(CheckInValidatorDTO CheckInValidatorDTO){
        checkInValidatorDTOS.add(CheckInValidatorDTO);
    }
}

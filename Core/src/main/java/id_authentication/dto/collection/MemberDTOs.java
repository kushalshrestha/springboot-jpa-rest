package id_authentication.dto.collection;

import id_authentication.dto.MemberDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MemberDTOs {
    private List<MemberDTO> members=new ArrayList<MemberDTO>();


    public void addMemberDTO(MemberDTO memberDTO) {
        members.add(memberDTO);
    }
}

package id_authentication.service.implementation;
import id_authentication.domain.Badge;
import id_authentication.dto.BadgeDTO;
import id_authentication.repositories.BadgeRepository;
import id_authentication.service.BadgeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class BadgeServiceImp implements BadgeService {
    private final BadgeRepository badgeRepository;
    private  final ModelMapper modelMapper;

    @Override
    public BadgeDTO createBadge(BadgeDTO badgeDTO) {

        Badge badge2 =modelMapper.map(badgeDTO, Badge.class);
        badgeRepository.save(badge2);
        BadgeDTO createdBadgeDTO= modelMapper.map(badge2, BadgeDTO.class);
        return createdBadgeDTO;
    }
    @Override
    public BadgeDTO updateBadge(BadgeDTO badgeDTO, Long BadgeNumber) {
        var oldBadge = badgeRepository.findById(BadgeNumber);
        if (oldBadge.isPresent()) {
            Badge badge1 = oldBadge.get();
            badge1.setStatus(badgeDTO.getStatus());
            badge1.setExpiryDate(badgeDTO.getExpiryDate());
            badgeRepository.save(badge1);
            BadgeDTO  updateBadgeDTO= modelMapper.map(badge1, BadgeDTO.class);
            return updateBadgeDTO;
        } else {
            throw new RuntimeException("BadgeNumber Doesn't Exist");
        }
    }

    @Override
    public BadgeDTO getBadge(Long badgeNumber) {
        Optional<Badge> oldBadge = badgeRepository.findById(badgeNumber);
        if (oldBadge.isPresent()) {
            Badge badge1 = oldBadge.get();
            BadgeDTO badge2 = modelMapper.map(badge1, BadgeDTO.class);
            return badge2;
        }
        else{
            throw new RuntimeException("BadgeNumber Doesn't Exist");
        }
    }
    @Override
    public List<BadgeDTO> getAllBadges() {

          return badgeRepository.findAll().stream().map(badge ->
            modelMapper.map(badge,BadgeDTO.class)).collect(Collectors.toList());
    }

    @Override
    public BadgeDTO deleteBadge(Long BadgeNumber) {
        Optional<Badge> oldBadge= badgeRepository.findById(BadgeNumber);
        if( oldBadge.isPresent()) {
            oldBadge.get().setStatus("INACTIVE");
            return modelMapper.map(oldBadge.get(),BadgeDTO.class);
        }else{
            throw new RuntimeException("BadgeNumber Doesn't Exist");
        }
    }
}
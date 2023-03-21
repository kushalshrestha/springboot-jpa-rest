package id_authentication.service.implementation;

import id_authentication.domain.Badge;
import id_authentication.dto.BadgeDTO;
import id_authentication.repositories.BadgeRepository;
import id_authentication.service.BadgeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class BadgeServiceImp implements BadgeService {
    @Autowired
    private final BadgeRepository badgeRepository;
    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public BadgeDTO createBadge(BadgeDTO badgeDTO) {

        Badge badge2 = modelMapper.map(badgeDTO, Badge.class);
        Badge updatedBadge = badgeRepository.save(badge2);
        badgeRepository.updateMemberId(updatedBadge.getId(), badgeDTO.getMemberId());
        BadgeDTO createdBadgeDTO = modelMapper.map(badge2, BadgeDTO.class);
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
            BadgeDTO updateBadgeDTO = modelMapper.map(badge1, BadgeDTO.class);
            return updateBadgeDTO;
        } else {
            throw new RuntimeException("BadgeNumber Doesn't Exist");
        }



        }

    @Override
    public BadgeDTO getBadge(Long id) {
        Optional<Badge> oldBadge = badgeRepository.findById(id);
        System.out.println("-----------------------------"+oldBadge.get().getBadgeNumber());
        if (oldBadge.isPresent()) {
            return modelMapper.map(oldBadge.get(), BadgeDTO.class);
        } else {
            throw new RuntimeException("Badge Doesn't Exist");
        }
    }

    @Override
    public List<BadgeDTO> getAllBadges() {
        List<Badge> testBadge=badgeRepository.findBadges();

        return testBadge.stream()
                .map(badge -> modelMapper.map(badge, BadgeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BadgeDTO deleteBadge(Long id) {
        Optional<Badge> oldBadge = badgeRepository.findById(id);
        if (oldBadge.isPresent()) {
            oldBadge.get().setStatus("INACTIVE");
            Badge updatedBadge = oldBadge.get();
            badgeRepository.save(updatedBadge);
            return modelMapper.map(updatedBadge, BadgeDTO.class);
        } else {
            throw new RuntimeException("Badge Doesn't Exist");
        }

    }
}

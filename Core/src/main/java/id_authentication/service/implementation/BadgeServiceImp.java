package id_authentication.service.implementation;

import id_authentication.domain.Badge;
import id_authentication.repositories.BadgeRepository;
import id_authentication.service.BadgeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class BadgeServiceImp implements BadgeService {
    private  final BadgeRepository badgeRepository;



    @Override
    public Badge createBadge(Badge badge) {

       return badgeRepository.save(badge);
    }

    @Override
    public Badge updateBadge(Badge badge, Long BadgeNumber) {
        var oldBatch = badgeRepository.findById(BadgeNumber);
        if (oldBatch.isPresent()) {
            Badge badge1 = oldBatch.get();
            badge1.setStatus(badge.getStatus());
            badge1.setExpiryDate(badge.getExpiryDate());

            return badgeRepository.save(badge1);
        }
        else {return createBadge(badge);}
    }

    @Override
    public Badge getBadge(Long BadgeNumber) {
        return null;
    }

    @Override
    public Badge removeBadge(Long BadgeNumber) {
        return null;
    }
}

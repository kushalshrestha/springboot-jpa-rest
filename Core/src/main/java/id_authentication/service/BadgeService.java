package id_authentication.service;


import id_authentication.domain.Badge;
import id_authentication.dto.BadgeDTO;

import java.util.List;

public interface BadgeService {
    public BadgeDTO createBadge(BadgeDTO badgeDTO);

    BadgeDTO getBadge(Long BadgeId);

    List<BadgeDTO> getAllBadges();

    BadgeDTO updateBadge(BadgeDTO badge, Long BadgeId);

    BadgeDTO deleteBadge(Long BadgeId);


}

package id_authentication.service;


import id_authentication.domain.Badge;
import id_authentication.dto.BadgeDTO;

import java.util.List;

public interface BadgeService {
    public BadgeDTO createBadge(BadgeDTO badgeDTO);
    BadgeDTO updateBadge(BadgeDTO badge, Long BadgeNumber);
    BadgeDTO getBadge(Long BadgeNumber);
     List<BadgeDTO> getAllBadges();
    BadgeDTO deleteBadge(Long BadgeNumber);



}

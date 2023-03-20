package id_authentication.service;


import id_authentication.domain.Badge;

import java.util.List;

public interface BadgeService {
    Badge createBadge(Badge badge);
    Badge updateBadge(Badge badge, Long BadgeNumber);
    Badge getBadge(Long BadgeNumber);
     List<Badge> getAllBadges();
    Badge deleteBadge(Long BadgeNumber);



}

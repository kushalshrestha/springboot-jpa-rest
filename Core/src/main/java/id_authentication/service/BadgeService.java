package id_authentication.service;


import id_authentication.domain.Badge;

public interface BadgeService {
    Badge createBadge(Badge badge);
    Badge updateBadge(Badge badge, Long BadgeNumber);
    Badge getBadge(Long BadgeNumber);
    Badge removeBadge(Long BadgeNumber);


}

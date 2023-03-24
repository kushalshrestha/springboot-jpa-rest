package id_authentication.domain;

public enum BadgeStatus {
ACTIVE("ACTIVE"),INACTIVE("INACTIVE");
    private String value;

    private BadgeStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

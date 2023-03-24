package id_authentication.domain;

public enum MembershipType {
    LIMITED("LIMITED"),UNLIMITED("UNLIMITED"),CHECKER("CHECKER");

    private String value;

    private MembershipType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

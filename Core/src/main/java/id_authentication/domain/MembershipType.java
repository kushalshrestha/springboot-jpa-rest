package id_authentication.domain;

public enum MembershipType {
    LIMITED("Limited"),UNLIMITED("Unlimited"),CHECKER("checker");

    private String value;

    private MembershipType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

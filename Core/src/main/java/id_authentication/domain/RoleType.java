package id_authentication.domain;

public enum RoleType {
    ADMIN("ADMIN"),STUDENT("STUDETN"),FACULTY("FACULTY"),STAFF("STAFF");
    private String value;

    private RoleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

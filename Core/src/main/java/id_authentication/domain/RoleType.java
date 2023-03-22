package id_authentication.domain;

public enum RoleType {
    ADMIN("admin"),STUDENT("Student"),FACULTY("Faculty"),STAFF("Staff");
    private String value;

    private RoleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

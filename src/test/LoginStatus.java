package test;

import java.io.Serializable;

public enum LoginStatus implements Serializable {

    NOT_LOGGED_IN("NL"),
    LOGGED_IN("LI"),
    LOGGED_OUT("LO");

    private LoginStatus(String value) {
        this.value = value;
    }

    public static LoginStatus getLoginStatus(String status) {
        if ("NL".equals(status)) {
            return NOT_LOGGED_IN;
        } else if ("LI".equals(status)) {
            return LOGGED_IN;
        } else if ("LO".equals(status)) {
            return LOGGED_OUT;
        } else {
            return null;
        }
    }


    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
package racingcar.domain;

public class Name {

    private static final int NAME_LOWER_BOUND = 1;
    private static final int NAME_UPPER_BOUND = 5;
    private static final String INVALID_NAME_LENGTH_MESSAGE = "차의 이름은 1자 이상 ~ 5자 이하여야 합니다.";

    private final String value;

    public Name(final String name) {
        validate(name);
        this.value = name;
    }

    private void validate(final String name) {
        if (name.length() < NAME_LOWER_BOUND || NAME_UPPER_BOUND < name.length()) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
        }
    }

    public String getValue() {
        return value;
    }
}

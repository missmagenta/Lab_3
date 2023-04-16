package abstractThings;

public enum Location {
    INITIAL("initial"),
    FOOD_COMPARTMENT("food compartment");

    private final String value;

    public String getLocation() {
        return value;
    }

    Location(String value) {
        this.value = value;
    }
}

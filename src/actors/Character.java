package actors;

public abstract class Character {
    protected String name;

    Character(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


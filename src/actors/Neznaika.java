package actors;


import java.util.Objects;

public class Neznaika extends SpaceTraveler {
    public Neznaika(String name) {
        super(name);
    }

    public void contradict(Ponchik ponchik) {
        System.out.println(getName() + " возразил to " + ponchik.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Neznaika that = (Neznaika) obj;
        return getName().equals(that.getName());
    }

    @Override
    public String toString() {
        return "Neznaika{" +
                "name='" + getName() + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

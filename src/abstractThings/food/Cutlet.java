package abstractThings.food;

public class Cutlet extends SpaceFood {
    public Cutlet() {
        super("cutlet");
    }

    @Override
    public String toString() {
        return "Cutlet{" +
                "foodName='" + foodName + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}

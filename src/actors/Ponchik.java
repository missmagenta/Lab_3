package actors;

import abstractThings.Location;
import abstractThings.food.SpaceFood;
import abstractThings.State;

import java.util.Objects;

public class Ponchik extends SpaceTraveler {
    private State state = State.AWAKE;
    public Ponchik(String name) {
        super(name);
    }

    public void sleep() {
        this.state = State.SLEEP;
        System.out.println(getName() + " заснул с недоеденной " +
                getCurrentConsumableFood().getFoodName() + " во рту");
    }

    public void revise(SpaceFood spaceFood) {
        if (state == State.AWAKE) {
            System.out.println(getName() + " должен произвести в " + Location.FOOD_COMPARTMENT.getLocation() +
                    " ревизию и проверить качество всех " + spaceFood.getFoodName() + ", которые имеют оценку " +
                    spaceFood.getGrade().getFoodGrade());
        } else {
            System.out.println(getName() + " is not able to revise food because he is sleeping");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Ponchik that = (Ponchik) obj;
        return getName().equals(that.getName());
    }

    @Override
    public String toString() {
        return "Ponchik{" +
                "name='" + getName() + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

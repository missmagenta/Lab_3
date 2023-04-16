package actors;

import abstractThings.Location;
import abstractThings.food.FoodGrade;
import abstractThings.food.SpaceFood;

import java.util.Objects;

public class Ponchik extends SpaceTraveler {
    public Ponchik(String name) {
        super(name);
    }

    public void sleep() {
        System.out.println(getName() + " заснул с недоеденной " +
                getCurrentConsumableFood().getFoodName() + " во рту");
    }

    public void revise(SpaceFood spaceFood) {
        if (spaceFood.getGrade() == null) {
            spaceFood.setGrade(FoodGrade.UNKNOWN);
        }
        System.out.println(getName() + " должен произвести в " + Location.FOOD_COMPARTMENT.getLocation() +
                " ревизию и проверить качество всех " + spaceFood.getFoodName() + ", которые имеют оценку " +
                spaceFood.getGrade().getFoodGrade());
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

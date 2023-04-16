package abstractThings.food;

import java.util.Objects;

public class SpaceFood {
    protected String foodName;
    protected FoodGrade grade;
    protected Integer totalPortions;
    protected int consumedPortionsByFoodType;
    protected static int totalConsumedPortions;

    public SpaceFood(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setConsumedPortionsByFoodType(int consumedPortionsByFoodType) {
        totalConsumedPortions += consumedPortionsByFoodType;
        this.consumedPortionsByFoodType = consumedPortionsByFoodType;
    }

    public int getConsumedPortionsByFoodType() {
        return this.consumedPortionsByFoodType;
    }

    public FoodGrade getGrade() {
        return this.grade;
    }

    public void setGrade(FoodGrade value) {
        this.grade = value;
    }

    public int getRemainingPortionCount() {
        if (totalPortions == null) {
            System.out.println("Remaining portions: Total portions minus " + totalConsumedPortions);
            return -1;
        } else {
            int remainingPortions = totalPortions - totalConsumedPortions;
            System.out.println("Remaining portions: " + remainingPortions);
            return remainingPortions;
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
        SpaceFood that = (SpaceFood) obj;
        return Objects.equals(foodName, that.foodName);
    }

    @Override
    public String toString() {
        return "SpaceFood{" +
                "foodName='" + foodName + '\'' + ", grade='" + grade + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodName);
    }
}

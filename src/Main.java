import abstractThings.Dialog;
import abstractThings.Location;
import abstractThings.food.Cutlet;
import abstractThings.food.FoodGrade;
import abstractThings.food.Sausage;
import abstractThings.food.SpaceFood;
import actors.Neznaika;
import actors.Ponchik;
import actors.SpaceTraveler;

public class Main {
    public static void main(String[] args) {
        SpaceTraveler traveler = new SpaceTraveler("Space Travelers");
        Ponchik ponchik = new Ponchik("Ponchik");
        Neznaika neznaika = new Neznaika("Neznaika");
        Dialog dialog = new Dialog();
        SpaceFood spaceDish = new SpaceFood("Space dish");
        SpaceFood sausage = new Sausage();
        SpaceFood cutlet = new Cutlet();

        traveler.setInWeightlessness(true);

        dialog.addParticipant(ponchik);
        dialog.say(ponchik, "Ну что ж, поскольку мы летим на Луну и назад все пути отрезаны, теперь у нас только одна задача:" +
                "пробраться обратно в пищевой отсек и как следует позавтракать.");
        dialog.setTopic(ponchik, "Breakfast in Space");
        dialog.addParticipant(neznaika);
        dialog.say(neznaika, "Мы ведь только что завтракали.");
        neznaika.contradict(ponchik);
        dialog.say(ponchik, "Так разве это был настоящий завтрак? " +
                "Этот завтрак был пробный, так сказать, черновой, тренировочный.");
        dialog.say(neznaika, " Как это — тренировочный?");
        dialog.say(ponchik, "Ну, мы ведь завтракали в космосе первый раз. " +
                "Значит, вроде как бы не завтракали, а только как бы осваивали процесс питания в космосе, то есть тренировались. " +
                "Зато теперь, когда тренировка закончена, мы можем позавтракать по-настоящему");
        dialog.say(neznaika, "Что ж, это, пожалуй, можно.");

        dialog.removeParticipant(neznaika);
        dialog.removeParticipant(ponchik);

        traveler.setLocation(Location.INITIAL);
        traveler.moveTo(Location.FOOD_COMPARTMENT);

        neznaika.setHungry(false);
        neznaika.setCurrentConsumableFood(cutlet);
        cutlet.setConsumedPortionsByFoodType(1);
        neznaika.eat();

        spaceDish.setGrade(FoodGrade.UNKNOWN);
        ponchik.setHungry(true);
        ponchik.revise(spaceDish);
        ponchik.setCurrentConsumableFood(sausage);
        sausage.setConsumedPortionsByFoodType(10);
        ponchik.eat();
        ponchik.sleep();

        spaceDish.getRemainingPortionCount();
    }
}
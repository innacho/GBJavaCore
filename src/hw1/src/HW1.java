package hw1.src;

import java.util.Locale;

public class HW1 {

    public static void main(String[] args) {
        Creature human = new Human("John",7.4, 0.8);
        Creature cat = new Cat("Barsic",8.41, 1.1);
        Creature robot = new Robot("iBot",20.8, 2.5);
        Creature[] creatures = {human, cat, robot};

        int obstacle_length = 8;
        Obstacle[] obstacles = new Obstacle[obstacle_length];
        for(int i = 0; i < obstacle_length; i+=2 ){
            obstacles[i] = new Treadmill(obstacle_length + i*0.1);
            obstacles[i+1] = new Wall(obstacle_length*0.1 + i*0.1);
        }

        System.out.println("\nCompetition begins!");
        for (Creature creature : creatures) {
            System.out.println("\nCurrent competitor: " + creature.getClass() + " " + creature.getName() + " with speed " + creature.getRunningSpeed() + " and jumping height " + creature.getJumpingHeight());
            for (Obstacle obstacle : obstacles) {
                System.out.format(Locale.ROOT, "\nCurrent obstacle is %s" + " with value %.2f\n", obstacle.getType(), obstacle.get());
                boolean success = true;
                switch(obstacle.getType()){
                    case "wall":
                        success = creature.jump(obstacle.get());
                        break;
                    case "treadmill":
                        success = creature.run(obstacle.get());
                        break;
                    default:
                        System.out.println("Wrong obstacle");
                        break;
                }
                if(!success) {
                    System.out.println("\nCurrent competitor " + creature.getClass() + " " + creature.getName() + " is out!");
                    break;
                }
            }
        }
    }
}

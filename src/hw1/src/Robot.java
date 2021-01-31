package hw1.src;

public class Robot implements Creature {
    private String name;
    private double running_speed;
    private double jumping_height;

    public Robot(String name, double running_speed, double jumping_height){
        this.name = name;
        this.setRunningSpeed(running_speed);
        this.setJumpingHeight(jumping_height);
    }

    public String getName(){
        return this.name;
    }

    public void setRunningSpeed(double running_speed){
        if (running_speed >= 0) {
            this.running_speed = running_speed;
        } else {
            System.out.println("Please, enter correct running speed");
        }
    }

    public double getRunningSpeed() {
        return running_speed;
    }

    public void setJumpingHeight(double jumping_height){
        if (jumping_height >= 0) {
            this.jumping_height = jumping_height;
        } else {
            System.out.println("Please, enter correct jumping height");
        }
    }

    public double getJumpingHeight() {
        return jumping_height;
    }

    public boolean run(double speed){
        boolean res = (running_speed >= speed);
        String message = (res) ? "Robot " + this.getName() +  " managed to run treadmill." : "Robot " + this.getName() +  " couldn't run treadmill.";
        System.out.println(message);
        return res;
    }

    public boolean jump(double height){
        boolean res = (jumping_height >= height);
        String message = (res) ? "Robot " + this.getName() +  " managed to jump over the wall." : "Robot " + this.getName() +  " couldn't jump over the wall.";
        System.out.println(message);
        return res;
    }
}
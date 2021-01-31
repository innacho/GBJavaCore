package hw1.src;

public class Treadmill extends Obstacle {
    private String TYPE = "treadmill";

    public Treadmill(double velocity){
        super(velocity);
        //System.out.println("Current obstacle is " + TYPE + " with speed " + velocity);
    }

    @Override
    public String getType(){
        return TYPE;
    }
}
package hw1.src;

public class Wall  extends Obstacle {
    private String TYPE = "wall";

    public Wall(double height){
        super(height);
        //System.out.println("Current obstacle is " + TYPE + " with height " + height);
    }

    @Override
    public String getType(){
        return TYPE;
    }
}
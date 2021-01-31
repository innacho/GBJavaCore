package hw1.src;

public class Obstacle {
    private double value;

    public Obstacle(double value){
        this.value = value;
    }

    public void set(double value){
        if (value >= 0) {
            this.value = value;
        } else {
            System.out.println("Please, enter correct obstacle value");
        }
    }

    public double get() {
        return value;
    }
    public String getType(){ return "default";};
}




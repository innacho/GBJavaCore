package hw3.src;

import java.util.ArrayList;

public class Box <T extends Fruit>{
    ArrayList<T> fruits = new ArrayList<T>();

    public void addToBox(T fruit) {
        fruits.add(fruit);
    }

    public T removeFromBox(int i) {
        return fruits.remove(i);
    }

    public int getBoxSize(){
        return fruits.size();
    }

    public String showType() {
        if(this.getBoxSize() > 0) return (fruits.get(0).getClass().getName());
        else return "unknown";
    }

    public void printBox(){
        System.out.println("Current box has " + this.getBoxSize() + " elements of type " + this.showType());
    }

    public float getBoxWeight(){
        return this.getBoxSize()*fruits.get(0).getWeight();
    }

    public boolean compareBoxes(Box<?> another) {
        return Math.abs(this.getBoxWeight() - another.getBoxWeight()) < 0.0001;
    }

    public void pourOverToBox(Box<T> another) {
       for(int i = this.getBoxSize() - 1; i >= 0; i--){
                T fruit = this.removeFromBox(i);
                another.addToBox(fruit);
            }
    }

}

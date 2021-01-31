package hw1.src;

public interface Creature {
    boolean run(double value);
    boolean jump(double value);
    double getRunningSpeed();
    double getJumpingHeight();
    String getName();
}
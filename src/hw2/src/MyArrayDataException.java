package hw2.src;

public class MyArrayDataException extends RuntimeException {
    private int i;
    private int j;

    public MyArrayDataException () {
    }

    public MyArrayDataException(String s) {
        super(s);
    }

    public MyArrayDataException(String message, int i, int j) {
        super(message);
        this.i = i;
        this.j = j;
    }

    public String getIndex(){
        return (i) + Integer.toString(j);
    }
}
package hw2.src;

public class MyArraySizeException extends RuntimeException {

    public MyArraySizeException () {
    }

    public MyArraySizeException(String s) {
        super(s);
    }
}
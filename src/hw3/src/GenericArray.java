package hw3.src;

public class GenericArray<T> {
    private T[] elements;

    public GenericArray(T... elements) {
        this.elements = elements;
    }

    public String showType() {
       return ("with type T " + elements[0].getClass().getName());
    }

    public void printArray(){
        System.out.print("Current array " + this.showType() +" is: ");
        for (T element : elements) {
            System.out.print(" " + element);
        }
        System.out.println();
    }

    public T[] changeElements(int i, int j){
        try{
            T temp;
            temp = elements[i];
            elements[i] = elements[j];
            elements[j] = temp;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Wrong index value in parameters!");
        }
        return this.elements;
    }
}

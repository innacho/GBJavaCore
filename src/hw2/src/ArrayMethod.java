package hw2.src;

public class ArrayMethod extends HW2 {

    public int[][] arrayMethod (String[][] array) throws MyArraySizeException, MyArrayDataException {
        if ( array.length != SIZE || array[0].length != SIZE ){
            throw new MyArraySizeException("Wrong array size!");
        }

        int[][] res_array = new int[SIZE][SIZE];
        int sum = 0;

        for ( int i = 0; i < SIZE; i++){
            for ( int j = 0; j < SIZE; j++){
                try{
                    res_array[i][j] =  Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(e.getMessage(), i, j);
                }
                sum += res_array[i][j];
            }
        }

        System.out.println("Sum of array elements:  " + sum);
        return res_array;
    }
}

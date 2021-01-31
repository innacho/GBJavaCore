package hw2.src;

public class HW2 {
    public static int SIZE = 4;
    public static int REAL_SIZE = 4;
    //для проверки MyArraySizeException можно установить другое значение REAL_SIZE

    public static void main(String[] args) {
        String[][] array = new String[REAL_SIZE][REAL_SIZE];
        ArrayMethod arr = new ArrayMethod();

        //заполение массива строками, которые легко преобразуются в числа
        //для этого массива вызов функции arrayMethod должен сработать без исключений
        for ( int i = 0; i < REAL_SIZE; i++){
             for ( int j = 0; j < REAL_SIZE; j++){
                 array[i][j] = i +  Integer.toString(j);
             }
         }

        //для проверки MyArrayDataException поменяем одно из значений массива
        //array[2][3] = "test";

        //вывод исходного массива
        for ( int i = 0; i < REAL_SIZE; i++){
            for ( int j = 0; j < REAL_SIZE; j++){
                System.out.print(array[i][j] + ' ');
            }
            System.out.println();
        }
        System.out.println();

        try{
            int[][] res_array = arr.arrayMethod(array);

            //вывод преобразованного массива
            System.out.println("Res array");
            for ( int i = 0; i < REAL_SIZE; i++){
                for ( int j = 0; j < REAL_SIZE; j++){
                    System.out.print(" "+ res_array[i][j]);
                }
                System.out.println();
            }

        } catch ( MyArraySizeException e){
            System.out.println("Exception: Wrong incoming array size!");
        } catch (MyArrayDataException e) {
            System.out.println("Exception: Wrong element in array " + e.getMessage() +  " at index " + e.getIndex() );
        }

    }
}
package hw3.src;

public class HW3 {
    public static void main(String args[]) {
    //первое задание по перемене местами элементов обобщенного массива
    GenericArray<String> genStrArr = new GenericArray<>("1", "2", "3", "4", "5");
    genStrArr.printArray();
    genStrArr.changeElements(2,4);
    genStrArr.printArray();

    //поймать ошибку с индексом массива
        genStrArr.changeElements(-2,4);
        genStrArr.changeElements(12,4);

    //массив числового типа
    GenericArray<Integer> genIntArr = new GenericArray<>(1, 2, 3, 4, 5);
    genIntArr.printArray();
    genIntArr.changeElements(3,0);
    genIntArr.printArray();

    //второе задание: коробки с фруктами
        System.out.println("\n Second task: fruit boxes!\n");
        Box<Apple> appleBox1 = new Box();
        for(int i = 0; i < 6; i++){
            appleBox1.addToBox(new Apple());
        }

        Box<Apple> appleBox2 = new Box();
        for(int i = 0; i < 8; i++){
            appleBox2.addToBox(new Apple());
        }

        Box<Orange> orangeBox1 = new Box();
        for(int i = 0; i < 4; i++){
            orangeBox1.addToBox(new Orange());
        }

        Box<Orange> orangeBox2 = new Box();
        for(int i = 0; i < 3; i++){
            orangeBox2.addToBox(new Orange());
        }

        appleBox1.printBox();
        System.out.println(appleBox1.getBoxWeight());
        orangeBox1.printBox();
        System.out.println(orangeBox1.getBoxWeight());

                System.out.print("Comparing boxes weight:  ");
                if (appleBox1.compareBoxes(orangeBox1)) {
                    System.out.println("boxes have equal weight.");
                } else {
                    System.out.println("boxes have different weight.");
                }

        appleBox1.printBox();
        appleBox2.printBox();
        System.out.println("Pouring over the boxes, the result would be: ");
        appleBox1.pourOverToBox(appleBox2);
        appleBox1.printBox();
        appleBox2.printBox();
    }
}

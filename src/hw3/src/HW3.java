package hw3.src;

//   Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
//   Задача:
//
//   -Даны классы: Fruit, Apple extends Fruit, Orange extends Fruit.
//   -Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
//   поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//   -Для хранения фруктов внутри коробки использовать ArrayList
//   -Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их
//   количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
//   -Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
//   которую подадут в compare() в качестве параметра. true – если их массы равны,
//   false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
//   -Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
//   Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
//   Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
//   -Не забываем про метод добавления фрукта в коробку.

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

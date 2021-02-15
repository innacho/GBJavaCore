package hw5.src;

import java.io.*;
import java.util.Arrays;

public class HW5 {
    public static void main(String args[]) throws IOException {
        File file = new File("./file.csv");
        file.createNewFile();

        //creating header
        String[] header = {"Value1","Value2","Value3"};

        //creating data
        //n - number of rows
        int n = 5;
        int[][] data = new int[n][3];
        for(int i = 0; i < n; i++){
            data[i][0] = 100 + i;
            data[i][1] = 200 + i;
            data[i][2] = 300 + i;
        }

        //создание объекта с данными
        AppData appData = new AppData(header, data);
        //вывод объекта на экран
        System.out.println(appData.toString());

        //сериализация объекта с данными
        byte[] byteAppData = null;
        try (ByteArrayOutputStream barrOut = new ByteArrayOutputStream();
             ObjectOutputStream objOut = new ObjectOutputStream(barrOut)) {
            objOut.writeObject(appData);
            byteAppData = barrOut.toByteArray();
            System.out.println("Данные до сериализации: " + appData.toString());
            System.out.println("Вот так он выглядит в байтовом представлении: " + Arrays.toString(byteAppData));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //запись сериализованного объекта в файл
        try (FileOutputStream out = new FileOutputStream(file)) {
            out.write(byteAppData);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //чтение файла целиком, будем читать набор байт
        byte[] byteDataFromFile = new byte[byteAppData.length];
        try (InputStream in = new BufferedInputStream(new FileInputStream(file))) {
             in.read(byteDataFromFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Из файла: " + byteDataFromFile.toString());

    //теперь будем выполнять десериализацию
        AppData readData = null;
        try (ByteArrayInputStream barrIn = new ByteArrayInputStream(byteDataFromFile);
             ObjectInputStream objIn = new ObjectInputStream(barrIn)) {
            readData = (AppData) objIn.readObject();
            System.out.println("Результат десериализации: " + readData);
        } catch (Exception e) {
            e.printStackTrace();
        }




        file.delete();
    }
}

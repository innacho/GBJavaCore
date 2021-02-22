package hw6.src;

// С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге на период времени,
// пересекающийся со следующим занятием (например, выборка погода на следующие 5 дней - подойдет)
// Подобрать источник самостоятельно. Можно использовать api accuweather, порядок следующий:
// зарегистрироваться, зарегистрировать тестовое приложение для получения api ключа, найдите
// нужный endpoint и изучите документацию. Бесплатный тарифный план предполагает получение погоды
// не более чем на 5 дней вперед (этого достаточно для выполнения д/з).

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class HW6 {
    public static void main(String args[]) throws IOException, URISyntaxException {

        System.out.println("Введите город, в котором хотите узнать погоду:");

        //чтение из консоли
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();

        // Экземпляр класса OkHttpClient выполняет всю работу по созданию и отправке запросов
        // Построим экземпляр класса с помощью паттерна проектирования builder
        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build();

        // Экземпляр класса Request тоже создается через Builder
        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com")
                .build();

        String apiKey = "ZnKd4kTYc68bc36GD8GEqWoC70D6IGMB";

        RequestBody authBody = RequestBody.create(authBodyString, JSON);

        request = new Request.Builder()
                .url("https://restful-booker.herokuapp.com/locations/v1/cities/search")
                .header("Content-type", "application/json")
                .post(authBody)
                .build();

        Response responseWithToken = client.newCall(request).execute();
        System.out.println(responseWithToken.code());
        System.out.println(responseWithToken.headers());

        String responseBody = responseWithToken.body().string();

        System.out.println(responseBody);

        // Распарсим строку чтобы взять токен (показать боль работы с json, чтобы на следующем занятии показать jackson)
        String token = responseBody.split(":")[1];




    }
}

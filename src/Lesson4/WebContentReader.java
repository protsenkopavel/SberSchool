package Lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebContentReader {
    public void start() {
        boolean validURL = false;
        String urlInput = "";

        while (!validURL) {
            System.out.print("Введите URL ресурса: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                urlInput = reader.readLine();
                readContent(urlInput);
                validURL = true;
            } catch (IOException e) {
                System.out.println("Некорректный адресс: " + e.getMessage());
            }
        }
    }

    public void readContent(String url) {
        try {
            URL urlObject = new URL(url);
            URLConnection connection = urlObject.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка при чтении содержимого сайта: " + e.getMessage());
        }
    }
}

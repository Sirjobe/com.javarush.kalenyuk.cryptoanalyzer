import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    public String fileInput () throws IOException {
        Scanner enteringFile = new Scanner(System.in);
        System.out.println("Укажите путь к файлу который необходимо зашифровать");
        String way = enteringFile.nextLine(); // путь к файлу
       // int key = enteringFile.nextInt(); // ключ шифрования
        Path fileInput = Path.of(way); // Открытие файла
        if(Files.isRegularFile(fileInput)){ // проверка пути к файлу
            List <String> content = Files.readAllLines(fileInput); // записывает содержимое в список строк
         // return Encryption.coder(content.toString(),key);
         //   return Encryption.decoder(content.toString(),key);
            return content.toString();
        }else {
            return null;
        }

    }
    public void fileOutput (String content) throws IOException {
        Scanner fileOutput = new Scanner(System.in);
        System.out.println("Укажите путь и имя файла для его сохранения в формате:\"c:\\директория\\имя файла.расширение файла\"");
        String createFile = fileOutput.nextLine();
        Files.createFile(Path.of(createFile));// создание файла и открытие файла
        BufferedWriter bufOutput = new BufferedWriter(new FileWriter(createFile));// создаем буфер
        bufOutput.write(content); // запись строк в файл
        bufOutput.close();// закрытие файла
    }
}

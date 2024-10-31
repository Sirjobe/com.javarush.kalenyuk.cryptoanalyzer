import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Applicateon {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        String way = console.nextLine(); // путь к файлу
        int key = console.nextInt(); // ключ шифрования
        String result; // Запись зашифрованного текста
        Path fileInput = Path.of(way); // Открытие файла
        if(Files.isRegularFile(fileInput)){ // проверка пути к файлу
            List <String> content = Files.readAllLines(fileInput); // записывает содержимое в список строк
            result=Encryption.encrypt(content.toString(),key);
            System.out.println(result);
        }else {
            System.out.println("Проверьте корректность введенного пути к файлу");
        }
        System.out.println("Укажите путь и имя файла для его сохранения в формате:\"c:\\директория\\имя файла.расширение файла\"");
        String createFile = console.nextLine();
        Files.createFile(Path.of(createFile));


    }
}

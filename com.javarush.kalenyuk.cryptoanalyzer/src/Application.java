import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Application {
    public static void main(String[] args) throws IOException {
        FileManager fileManager = new FileManager();
        Encryption encryption = new Encryption();
        BruteForce bruteForce = new BruteForce();
        boolean lie = false;
        String directory = null;
        String nameFile = null;
        Scanner console = new Scanner(System.in);
        System.out.println("Выберите необходимую операцию:\n" +
                "     1. Шифрование\n" +
                "     2. Расшифровка с ключом\n" +
                "     3. Brute force\n" +
                "     4. Статистический анализ\n" +
                "     0. Выход\n" +
                "Введите номер необходимого пункта:");
        int number = console.nextInt();
        switch (number){
            case 1 -> fileManager.fileOutput(encryption.coder(fileManager.fileInput()));
            case 2 -> fileManager.fileOutput(encryption.decoder(fileManager.fileInput()));
            case 3 -> bruteForce.bruteForce();
//            case 4 -> StatisticalAnalyzer;
            case 0 -> System.out.println("");
        }
        System.out.println("Благодарим за использование нашей программы");
    }
}

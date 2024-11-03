import java.io.IOException;
import java.util.Scanner;


public class Application {
    public static void main(String[] args) throws IOException {
        FileManager fileManager = new FileManager();
        Encryption encryption = new Encryption();
      //  fileManager.fileInput();
        Scanner console = new Scanner(System.in);
        System.out.println("Выберите необходимую операцию...");
        int number = console.nextInt();
        switch (number){
            case 1 -> fileManager.fileOutput(encryption.coder(fileManager.fileInput()));
            case 2 -> fileManager.fileOutput(encryption.decoder(fileManager.fileInput()));
        }
        System.out.println("Благодарим за использование нашей программы, ваше требование выполнено");
//         fileManager.fileOutput(fileManager.fileInput());
    }
}

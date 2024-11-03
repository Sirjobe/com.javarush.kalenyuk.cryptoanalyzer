import java.util.InputMismatchException;
import java.util.Scanner;

public class Encryption {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е','ё', 'ж', 'з',
            'и','й','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э','ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public String coder (String symbol){
        Scanner console = new Scanner(System.in);
        boolean lie = false;
        StringBuilder stringBuilder = new StringBuilder();
        int key = 0;
        while (!lie) {
            System.out.println("Введите ключ шифрования");
            if (console.hasNextInt()) {
                key = console.nextInt();
                char[] chars = symbol.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (int j = 0; j < ALPHABET.length; j++) {
                        int count = (j + key) % ALPHABET.length;
                        if (chars[i] == ALPHABET[j]||chars[i]==Character.toUpperCase(ALPHABET[j])){
                            if (Character.isUpperCase(chars[i])){
                                chars[i] = Character.toUpperCase(ALPHABET[count]);
                            }else {
                                chars[i] = ALPHABET[count];
                            }
                            stringBuilder.append(chars[i]);
                            break;
                        }
                    }
                }
                lie = true;
            } else {
                System.out.println("Ошибка! Введите ключ в пределах от 0 до 40");
                console.next(); // очищаем неправильный ввод
            }
        }
        return stringBuilder.toString();
    }
    public String decoder (String symbol) throws InputMismatchException{
        Scanner console = new Scanner(System.in);
        boolean lie = false;
        StringBuilder stringBuilder = new StringBuilder();
        int key = 0;
        while (!lie) {
            System.out.println("Введите ключ шифрования ");
            if(console.hasNextInt()) {
                key = console.nextInt();
                char[] chars = symbol.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (int j = 0; j < ALPHABET.length; j++) {
                        int count = ALPHABET.length - (key % ALPHABET.length);
                        if (chars[i] == ALPHABET[j]||chars[i]==Character.toUpperCase(ALPHABET[j])){
                            if (Character.isUpperCase(chars[i])){
                                chars[i] = Character.toUpperCase(ALPHABET[(j + count) % ALPHABET.length]);
                            }else {
                                chars[i] = ALPHABET[(j + count) % ALPHABET.length];
                            }
                            stringBuilder.append(chars[i]);
                            break;
                        }
                    }
                }
                lie = true;
            }
                else {
                    System.out.println("Ошибка! Введите ключ в пределах от 0 до 40");
                    console.next(); // очищаем неправильный ввод
                }
            }
        return stringBuilder.toString();
    }


}

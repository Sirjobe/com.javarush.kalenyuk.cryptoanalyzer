import java.util.Scanner;

public class Encryption {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е','ё', 'ж', 'з',
            'и','й','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э','ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    public static void main(String[] args) { // проверка с консоли
//        Scanner console = new Scanner(System.in);
//        String text = console.nextLine();
//        int key = console.nextInt();
//        System.out.println(text);
//        char[] chars = text.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            chars[i]=encrypt(chars[i], key);
//        }
//        String encrypt = new String(chars);
//        System.out.println(encrypt);


    }
    public static String encrypt(String symbol, int key){
//        if(key>0||key<=ALPHABET.length){ //проверка введнного ключа
//
//        }else {
//            System.out.println("Введенно некоректное значение ключа шифрования: "+key);// Оповещение пользователя о некорректном вводе ключа
//        }
        char[] chars = symbol.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                if(chars[i]==ALPHABET[j]&&(j+key)<=ALPHABET.length){
                    chars[i] = ALPHABET[j+key];
                    break;
                }
                else if(j+key>ALPHABET.length) {
                    chars[i] = ALPHABET[(j+key)%ALPHABET.length];
                    break;
                }
            }
        }
        String tmp = new String(chars);
        return tmp;
    }
}

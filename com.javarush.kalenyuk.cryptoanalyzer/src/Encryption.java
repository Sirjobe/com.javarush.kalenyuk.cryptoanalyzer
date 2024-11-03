import java.util.Scanner;

public class Encryption {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е','ё', 'ж', 'з',
            'и','й','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э','ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
  //  public static void main(String[] args) { // проверка с консоли
//        Scanner console = new Scanner(System.in);
//        String text = console.nextLine();
//        int key = console.nextInt();
//        System.out.println(text);
//        char[] chars = text.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            chars[i]=decoder(chars[i], key);
//        }
//        String encrypt = new String(chars);
//        System.out.println(encrypt);
//
//
//    }
    public String coder (String symbol){
//        if(key>0||key<=ALPHABET.length){ //проверка введнного ключа
//
//        }else {
//            System.out.println("Введенно некоректное значение ключа шифрования: "+key);// Оповещение пользователя о некорректном вводе ключа
//        }
        Scanner console = new Scanner(System.in);
        System.out.println("Введите ключ шифрования");
        int key = console.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = symbol.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                int count = (j+key)%ALPHABET.length;
                if(chars[i]==ALPHABET[j]){
                    chars[i] = ALPHABET[count];
                    stringBuilder.append(chars[i]);
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }
    public String decoder (String symbol){
        Scanner console = new Scanner(System.in);
        System.out.println("Введите ключ шифрования");
        int key = console.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = symbol.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                int count = ALPHABET.length-(key%ALPHABET.length);
                if(chars[i]==ALPHABET[j]){
                    chars[i] = ALPHABET[(j+count)%ALPHABET.length];
                    stringBuilder.append(chars[i]);
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }
}

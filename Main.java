package encryptdecrypt;
 
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        char[] chars = scanner.nextLine().toCharArray();
        int shift = scanner.nextInt();
        switch (operation) {
            case "enc":
                getEncryption(chars, shift);
                break;
            case "dec":
                getDecryption(chars, shift);
                break;
            default:
                System.out.println("Unknown operation");
                break;
        }
    }
 
    public static void getDecryption(char[] chars, int shift) {
        for (char item : chars) {
            char shiftItem = (char) (item - shift);
            System.out.print(shiftItem);
 
        }
    }
 
    public static void getEncryption(char[] chars, int shift) {
        for (char item : chars) {
            char shiftItem = (char) (item + shift);
            System.out.print(shiftItem);
        }
    }
}

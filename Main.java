package encryptdecrypt;
 
public class Main {
 
    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";
 
        for (int i = 0; i < args.length; i += 2) {
            if (args[i].equals("-mode")) {
                mode = args[i+1];
 
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i+1]);
 
            } else if (args[i].equals("-data")) {
                data = args[i+1];
            }
        }
 
        switch (mode) {
            case "enc":
                getEncryption(data, key);
                break;
            case "dec":
                getDecryption(data, key);
                break;
            default:
                System.out.println("Unknown operation");
                break;
        }
    }
 
    public static void getDecryption(String data, int key) {
        for (char item : data.toCharArray()) {
            char shiftItem = (char) (item - key);
            System.out.print(shiftItem);
        }
    }
 
    public static void getEncryption(String data, int key) {
        for (char item : data.toCharArray()) {
            char shiftItem = (char) (item + key);
            System.out.print(shiftItem);
        }
    }
}

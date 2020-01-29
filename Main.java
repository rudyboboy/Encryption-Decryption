package encryptdecrypt;
 
import java.io.*;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";
        String in = "";
        String out = "";
        String modeOutput="";
 
        for (int i = 0; i < args.length; i += 2) {
            if (args[i].equals("-mode")) {
                mode = args[i+1];
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i+1]);
            } else if (args[i].equals("-data")) {
                data = args[i+1];
            } else if (args[i].equals("-in")) {
                in = args[i+1];
            }else if (args[i].equals("-out")) {
                out = args[i+1];
            }
        }
        if(!in.isEmpty() && data.isEmpty()){
            File file = new File(in);
            int count = 0;
 
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    data = scanner.nextLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        switch (mode) {
            case "enc":
                modeOutput=getEncryption(data, key);
                break;
            case "dec":
                modeOutput=getDecryption(data, key);
                break;
            default:
                System.out.println("Unknown operation");
                break;
        }
        if(out.isEmpty()){
            System.out.print(modeOutput);
        }else{
            File file = new File(out);
 
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(modeOutput);
            } catch (IOException e) {
                System.out.print("Error");
            }
        }
    }
 
    public static String getDecryption(String data, int key) {
        String shiftItem = "";
        for (char item : data.toCharArray()) {
            String c = String.valueOf((char) (item - key));
            shiftItem += c;
        }
        return shiftItem;
    }
 
    public static String getEncryption(String data, int key) {
        String shiftItem = "";
        for (char item : data.toCharArray()) {
            String c = String.valueOf((char) (item + key));
            shiftItem += c;
        }
        return shiftItem;
    }
}

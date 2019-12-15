import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        final String[] ds = new String[] {
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };

        FileReader fileReader = new FileReader("sample.txt");
        Scanner scanner = new Scanner(fileReader);


        String text = "";
        while (scanner.hasNextLine()){
            text = text + scanner.nextLine();
        }
        fileReader.close();

        System.out.println("old text:");
        System.out.println(text);
        for(char charNumber = '0'; charNumber <= '9'; charNumber++)
            text = text.replaceAll(String.valueOf(charNumber),  ds[charNumber - '0'] );

        System.out.println("new text:");
        System.out.println(text);


    }
}

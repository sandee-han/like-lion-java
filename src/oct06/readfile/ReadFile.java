package oct06.readfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


// 내 코드
public class ReadFile {
    private String filename;

    void readOneLetter() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line= br.readLine();
        System.out.println(line.charAt(0));
        System.out.println();
    }

    void readTwoLetters() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        System.out.print(line.charAt(0));
        System.out.println(line.charAt(1));
        System.out.println();

    }

    void readNumLetters(int num) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            try {
                for (int i = 0; i < num; i++) {
                    System.out.print(line.charAt(i));
                }
            } catch (StringIndexOutOfBoundsException e) {

            }
            System.out.println("\n");
        }
    }

    void readOneLine() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        System.out.println(line);
    }

    public ReadFile(String filename) {
        this.filename = filename;
    }

    public static void main(String[] args) throws IOException {
        ReadFile readFile = new ReadFile("afile.txt");
        readFile.readOneLetter();
        readFile.readTwoLetters();
        readFile.readNumLetters(15);
        readFile.readOneLine();
    }
}

package oct06.readfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// 강사님 설명 코드
public class FileExercise {

    public void printFiles() throws FileNotFoundException{
        // FileNotFoundException 은 파일이 없을 수도 있으므로 만들어둔다.
        // ./ 루트 디렉토리로 접근 가능
        File dir = new File("./");
        // File("C:\\"); 으로 C드라이브를 디렉토리로 설정 가능


        // 현재 디렉토리에 있는 파일
        File files[] = dir.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }
    // 파일명
    /*
    .\.git
    .\.gitignore
    .\.idea
    .\aa_file.txt
    .\afile.txt
    .\java-project-push-exercise.iml
    .\out
    .\README.md
    .\src
     */

    public char readAChar() throws IOException{
        // FileReader("여기에 원하는 파일의 디렉토리.파일명."); 적으면 파일의 데이터를 불러온다.
        FileReader fileReader = new FileReader("./aa_file.txt");

        // read 쓰려면 IOException 선언해야함
        return (char)fileReader.read();
    }

    public static void main(String[] args) throws IOException {
        FileExercise fileExercise = new FileExercise();
        char c = fileExercise.readAChar();
        System.out.println(c);
    }
}
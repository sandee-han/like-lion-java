package oct07.population_rok;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PopulationStatistics {

    public String fromToString(PopulationMove populationMove) {
        return populationMove.getFromSido() + "," + populationMove.getToSido() + "\n";
    }

    public void createAFile(String filename) {
        File file = new File(filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // List<String>을 지정한 파일에 write
    public void write(List<String> strs, String filename) {
        File file = new File(filename);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String str : strs) {
                writer.write(str);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<PopulationMove> readByLine(String filename) throws IOException {
//        FileReader fileReader = new FileReader((filename));
//        BufferedReader reader = new BufferedReader(fileReader);
        // 아래 new BufferedReader(new FileReader(filename)); 이 부분과 동일하다

        List<PopulationMove> pml = new ArrayList<>();
        FileReader fileReader = new FileReader(new File(filename));
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String line = "";
        while ((line = reader.readLine()) != null) {
            PopulationMove pm = parse2(line);
            pml.add(pm);
        }
        reader.close();
        return pml;
    }

    // 파일 생성시 사용
    // readByLine 여기를 parse로 변경해야댐 damn..
    public PopulationMove parse(String data) {
        String[] split = data.split(",");
        int fromSido = Integer.parseInt(split[6]);
        int toSido = Integer.parseInt(split[0]);

        return new PopulationMove(fromSido, toSido);
    }

    // 전입,전출 나눌 때 사용
    public PopulationMove parse2(String data) {
        String[] split = data.split(",");
        int fromSido = Integer.parseInt(split[0]);
        int toSido = Integer.parseInt(split[1]);

        return new PopulationMove(fromSido, toSido);
    }

    public void readByChar(String filename) throws IOException {
        FileReader fileReader = new FileReader(new File(filename));

        String fileContents = "";
        while (fileContents.length() < 1_000_000) {
            char c = (char) fileReader.read();
            fileContents += c;
            System.out.println(fileContents);
        }
        System.out.println(fileContents);
    }

    // 요오즘 서타일
    public void readByLine2(String filename) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {

//        FileReader fileReader = new FileReader(address);
        // 여기까진 파일을 읽지 않는다.

//        populationStatistics.readFileByLine(address);
//        populationStatistics.readByLine2(address);


        // from_to.txt 파일 생성 시 사용
//        String address = "C:\\Users\\iwmis\\Documents\\문서류\\멋사\\기타 자료\\Mdis 2021 data\\2021_인구관련연간자료_20220927_66125.csv";
//        PopulationStatistics populationStatistics = new PopulationStatistics();
//        List<PopulationMove> pml = populationStatistics.readByLine(address);
//
//        List<String> strings = new ArrayList<>();
//        for (PopulationMove pm : pml) {
//            String fromTo = populationStatistics.fromToString(pm);
//            strings.add(fromTo);
//        }
//
//        populationStatistics.write(strings, "./from_to.txt");

        // 파일 전입, 전출 출력시 사용
        String address = "./from_to.txt";
        PopulationStatistics populationStatistics = new PopulationStatistics();
        List<PopulationMove> pml = populationStatistics.readByLine(address);
        List<String> strings = new ArrayList<>();

        for (PopulationMove pm : pml) {
            System.out.printf("전입:%s, 전출:%s\n", pm.getFromSido(), pm.getToSido());
        }
        populationStatistics.write(strings, "./from_to.txt");
    }
}
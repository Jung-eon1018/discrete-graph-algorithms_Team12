import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Parser {
    public static List<int[][]> parseInput1(String fileName) {
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        // TODO: 그래프 변환 처리
        return null; // TODO: 수정 필요
    }

    public static List<int[][]> parseInput2(String fileName) {
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // TODO: 그래프 변환 처리
        return null; // TODO: 수정 필요
        
    }
}

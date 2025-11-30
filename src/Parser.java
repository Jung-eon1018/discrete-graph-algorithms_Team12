import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {
    public static List<int[][]> parseInput1(String fileName) {
        List<int[][]> graphList1 = new ArrayList<>();
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                if (!scanner.hasNextInt()) break;

                int howManyNodes = scanner.nextInt();
                scanner.nextLine();

                int[][] graph = new int[howManyNodes + 1][howManyNodes + 1];

                for (int i = 0; i < howManyNodes; i++) {
                    if (!scanner.hasNextLine()) break;

                    String line = scanner.nextLine().trim();
                    if (line.isEmpty()) {
                        i--;
                        continue;
                    }

                    Scanner lineScanner = new Scanner(line);
                    int sourceNode = lineScanner.nextInt();

                    while (lineScanner.hasNextInt()) {
                        int targetNode = lineScanner.nextInt();
                        graph[sourceNode][targetNode] = 1;

                    }
                    lineScanner.close();
                }
                graphList1.add(graph);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("파일을 찾을 수 없습니다: " + fileName, e);
        }

        return graphList1;
    }
        public static List<int[][]> parseInput2(String fileName) {
        List<int[][]> graphList2 = new ArrayList<>();
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                if (!scanner.hasNextInt()) break;

                int howManyNodes = scanner.nextInt();
                scanner.nextLine();

                int[][] graph = new int[howManyNodes + 1][howManyNodes + 1];

                for (int i = 0; i < howManyNodes; i++) {
                    if (!scanner.hasNextLine()) break;

                    String line = scanner.nextLine().trim();
                    if (line.isEmpty()) {
                        i--;
                        continue;
                    }

                    Scanner lineScanner = new Scanner(line);
                    int sourceNode = lineScanner.nextInt();

                    while (lineScanner.hasNextInt()) {
                        int targetNode = lineScanner.nextInt();
                        int weight = lineScanner.nextInt();
                        graph[sourceNode][targetNode] = weight;
                    }
                    lineScanner.close();
                }
                graphList2.add(graph);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("파일을 찾을 수 없습니다: " + fileName, e);
        }

        // TODO: 그래프 변환 처리
        return graphList2; // TODO: 수정 필요
        
    }
}

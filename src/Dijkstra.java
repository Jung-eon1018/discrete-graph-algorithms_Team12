import java.util.List;

public class Dijkstra {
    public static void searchGraph(List<int[][]> graphList) {
        System.out.println("2. 최단 경로 구하기 수행 결과");
        int graphIndex = 1;

        for (int[][] g : graphList) {
            System.out.println("그래프 [" + graphIndex + "]");
            System.out.println("----------------------------");
            System.out.println("시작점: 1");

            dijkstra(g);

            System.out.println("=========================");
            graphIndex++;
        }
    }


    private static void dijkstra(int[][] graph) {

        printPath();
    }


    private static void printPath() {

    }
}

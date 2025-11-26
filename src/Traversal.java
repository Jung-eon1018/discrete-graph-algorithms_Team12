import java.util.List;

public class Traversal {
    public static void searchGraph(List<int[][]> graphList) {
        System.out.println("1. 그래프 탐방 수행 결과");
        int graphIndex = 1;
        for (int[][] g : graphList) {
            System.out.println("그래프 [" + graphIndex + "]");
            System.out.println("----------------------------");

            System.out.println("깊이 우선 탐색");
            dfs(g);
            System.out.println();

            System.out.println("너비 우선 탐색");
            bfs(g);
            System.out.println();

            System.out.println("============================");
            graphIndex++;

        }
    }

    private static void dfs(int[][] graph) {

    }

    private static void bfs(int[][] graph) {

    }
}

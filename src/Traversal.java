import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        int n = graph.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        int start = 0;
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int v = queue.poll();
            System.out.println(v+" ");

            for(int i = 0; i < n; i++) {
                if(!visited[i] && graph[v][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }

    }
}

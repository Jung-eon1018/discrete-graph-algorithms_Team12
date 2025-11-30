import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversal {

    // 방문 여부 체크변수
    private static boolean[] visited;
    // 출력 경로 저장 StringBuilder
    private static StringBuilder sb;

    public static void searchGraph(List<int[][]> graphList) {
        System.out.println("1. 그래프 탐방 수행 결과");
        int graphIndex = 1;
        for (int[][] g : graphList) {
            System.out.println("그래프 [" + graphIndex + "]");
            System.out.println("----------------------------");

            System.out.println("깊이 우선 탐색");
            sb = new StringBuilder();
            visited = new boolean[g.length];
            dfs(g, 1); //시작점은 항상 1번 정점
            System.out.println(sb.toString());

            System.out.println("너비 우선 탐색");
            bfs(g);
            System.out.println();

            System.out.println("============================");
            graphIndex++;

        }
    }

    // graph: 인접 행렬, v: 현재 방문 중인 정점
    private static void dfs(int[][] graph, int v) {
        visited[v] = true;

        //처음이면 숫자만, 아니면 "-숫자"
        if (sb.length() == 0) {
            sb.append(v);
        } else {
            sb.append("-").append(v);
        }

        // 인접한 정점 탐색 (1번부터 끝까지)
        for (int i = 1; i < graph.length; i++) {
            // 연결되어 있고(1), 아직 방문하지 않았으면(!visited)
            if (graph[v][i] == 1 && !visited[i]) {
                dfs(graph, i); // 재귀 호출
            }
        }
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

import java.util.List;

public class Dijkstra {
    private static final int INF = Integer.MAX_VALUE;

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
        int n = graph.length - 1; // 총 노드 개수
        int startNode = 1; // 시작점

        int[] dist = new int[n + 1]; // dist[i]: 시작점(1)에서 i번 노드까지의 최단 거리
        boolean[] visited = new boolean[n + 1]; // visited[i]: i번 노드의 최단 거리가 확정되었는지 여부 (true면 방문 완료)
        int[] prev = new int[n + 1]; // prev[i]: 최단 경로상에서 i번 노드 바로 직전에 방문한 노드 (경로 역추적용)

        // 배열들 초기화
        for (int i = 1; i <= n; i++) {
            dist[i] = INF;      // 모든 거리를 무한대로 초기화
            visited[i] = false; // 방문 여부 초기화 (모두 false, 미방문)
            prev[i] = -1;       // 이전 노드 없음으로 초기화
        }

        dist[startNode] = 0; //시작점 [1] 초기화

        // 다익스트라 알고리즘
        for (int i = 1; i <= n; i++) {

            // 초기값 초기화
            int minIdx = -1; // 현재까지 발견된 가장 짧은 노드
            int minVal = INF; // minIdx까지 최단거리

            // 방문하지 않은 노드 중, 현재까지 발견된 최단 거리가 가장 짧은 노드(minIdx) 선택
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && dist[j] < minVal) {
                    minVal = dist[j];
                    minIdx = j;
                }
            }

            // 더 이상 방문할 수 있는(연결된) 노드가 없으면 탐색 중단
            if (minIdx == -1) break;

            // 선택된 노드를 방문 처리 (최단 거리 확정)
            visited[minIdx] = true;

            // 선택된 노드(minIdx)를 거쳐서 인접한 노드(j)로 가는 거리가 더 짧은지 확인
            for (int j = 1; j <= n; j++) {
                if (graph[minIdx][j] > 0 && !visited[j]) {
                    if (dist[minIdx] != INF && dist[minIdx] + graph[minIdx][j] < dist[j]) {
                        // 최단 거리 갱신
                        dist[j] = dist[minIdx] + graph[minIdx][j];
                        // 경로 역추적을 위해 이전 노드를 기록
                        prev[j] = minIdx;
                    }
                }
            }
        }

        // 경로 복원, 출력 기능 필요
        printPath();
    }


    private static void printPath() {

    }
}

import java.util.ArrayList;
import java.util.Collections;
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
        printPath(dist, prev, n);
    }

    //  경로 및 거리 출력 메서드
    private static void printPath(int[] dist, int[] prev, int n) {
        // 시작점(1)을 제외하고 2번 노드부터 출력
        for (int i = 2; i <= n; i++) {
            System.out.print("정점 [" + i + "]: ");

            if (dist[i] == INF) {
                System.out.println("경로 없음");
                continue;
            }

            // 경로 복원 (Backtracking)
            // 도착점(i)에서 시작하여 prev 배열을 타고 시작점까지 거슬러 올라감
            List<Integer> path = new ArrayList<>();
            int current = i;
            while (current != -1) {
                path.add(current);
                current = prev[current];
            }

            // 거슬러 올라갔으므로 순서를 뒤집어야 올바른 경로(1 -> ...)가 됨
            Collections.reverse(path);

            // 경로 출력 형식 만들기 (예: 1 - 4 - 3 - 5)
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < path.size(); j++) {
                sb.append(path.get(j));
                if (j < path.size() - 1) {
                    sb.append(" - ");
                }
            }

            System.out.println(sb.toString() + ", 길이: " + dist[i]);
        }
    }
}

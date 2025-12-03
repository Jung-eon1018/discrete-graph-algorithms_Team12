import util.FileName;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<int[][]> graphList1 = Parser.parseInput1(FileName.INPUT1);
        if (graphList1 != null) Traversal.searchGraph(graphList1);
//        List<int[][]> graphList2 = Parser.parseInput2(FileName.INPUT2);
//        if (graphList2 != null) Dijkstra.searchGraph(graphList2);

    }


}

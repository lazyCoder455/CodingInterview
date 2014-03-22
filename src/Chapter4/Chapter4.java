package Chapter4;

/**
 * Created by lazyCoder455 on 3/15/14.
 */
public class Chapter4 {

    public static boolean isRoute(GraphNode a, GraphNode b) {
        //assume DAG
        if (a.adjacencyList.size() == 0) return false;
        else {
            for (int i = 0; i < a.adjacencyList.size(); i++) {
                if (a.adjacencyList.get(i) == b) {
                    return true;
                }
            }
        }
        boolean answer = false;
        for (int i = 0; i < a.adjacencyList.size(); i++) {
            answer |= isRoute(a.adjacencyList.get(i), b);
        }
        return answer;
    }

}

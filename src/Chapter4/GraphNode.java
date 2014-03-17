package Chapter4;

import java.util.ArrayList;

/**
 * Created by lazyCoder on 3/16/14.
 */
public class GraphNode {
    public int data;
    public ArrayList<GraphNode> adjacencyList;

    public GraphNode(int data) {
        this.data = data;
    }

    public GraphNode(int data, ArrayList<GraphNode> adjacencyList) {
        this.adjacencyList = adjacencyList;
        this.data = data;
    }

    public void addChild(GraphNode child) {
        adjacencyList.add(child);
    }
}

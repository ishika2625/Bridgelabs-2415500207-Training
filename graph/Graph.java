package graph;

public class Graph {
    int[][] matrix;

    Graph(int vertex) {
        matrix = new int[vertex][vertex];
    }

    public void addEdge(int source, int destination) {
        matrix[source][destination] = 1;
        matrix[destination][source] = 1; //for un-directed graph
    }

    public void printGraph() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(4, 3);
        graph.printGraph();
    }

    
}

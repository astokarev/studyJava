package Trees.ex1;

public class State {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Graph graph1 = new Graph();
        graph.addVertex('A'); //0
        graph.addVertex('B'); //1
        graph.addVertex('C'); //2
        graph.addVertex('D'); //3
        graph.addVertex('E'); //4
        graph.addVertex('F'); //5
        graph.addVertex('G'); //6
        graph.addVertex('J'); //7
        graph.addVertex('K'); //8
        graph.addVertex('L'); //9

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,4);
        graph.addEdge(3,5);
        graph.addEdge(5,6);
        graph.addEdge(6,7);


        System.out.println("Visits: ");
        graph.passInDeep();
        //graph.bfc();
        System.out.println(graph.search(graph.getVertex(0), graph.getVertex(9)));

    }
}

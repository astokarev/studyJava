package Trees.ex1;

import java.util.Stack;

public class Graph {
    private final int MAX_VERTS = 10;
    private Vertex vertexArray[]; //массив вершин
    private int adjMat[][]; // матрица смежности
    private int nVerts; // текущее количество вершин
    private Stack<Integer> stack;

    public Graph() {
        vertexArray = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
        stack = new Stack<>();
    }

    public void addVertex(char lab) {
        vertexArray[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexArray[v].getLabel());
    }

    public void passInDeep(int index) {
        vertexArray[0].setWasVisited(true);
        displayVertex(0);
        stack.push(0);

        while (!stack.empty()) {
            int v = getAdjVertex(stack.peek()); // вынуть индекс смежной веришины, еckи есть 1, нету -1
            if (v == -1) {
                stack.pop();
            } else {
                vertexArray[v].setWasVisited(true);
                displayVertex(v);
                stack.push(v);
            }
        }

        for (int j = 0; j < nVerts; j++) {  // сброс флагов
            vertexArray[j].wasVisited = false;
        }

    }

    private int getAdjVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && vertexArray[j].wasVisited == false) {
                return j; //возвращает первую найденную вершину
            }
        }
        return -1;
    }
}

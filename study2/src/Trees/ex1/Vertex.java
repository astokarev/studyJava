package Trees.ex1;

import java.util.ArrayList;

public class Vertex {
    private char label;  // метка А например
    public boolean wasVisited;
    private Graph.States state;
    private ArrayList<Vertex> myChildren;

    public Graph.States getState() {
        return state;
    }

    public void setState(Graph.States state) {
        this.state = state;
    }



    public Vertex(final char label) {
        state = Graph.States.Unvisited;
        this.label = label;
        wasVisited = false;
        myChildren = new ArrayList<Vertex>();
    }



    public char getLabel() {
        return this.label;
    }

    public boolean isVisited() {
        return this.wasVisited;
    }

    public void setWasVisited(final boolean wasVisited) {
        this.wasVisited = wasVisited;
    }


    public void addChild(Vertex child) {
        myChildren.add(child);
    }

    public Boolean isPathTo(Vertex v) {
        for(Vertex child : myChildren) {
            if (child == v) return true;
            if(child.isPathTo(v)) return true;
        }
        return false;
    }
  }

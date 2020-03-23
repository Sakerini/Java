package com.company.graph;

public class Edge implements Comparable<Edge> {
    private Vertex fromVertex;
    private Vertex toVertex;
    private int value;

    public Edge(Vertex fromVertex, Vertex toVertex, int value) {
        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Vertex getFromVertex() {
        return fromVertex;
    }

    public Vertex getToVertex() {
        return toVertex;
    }

    @Override
    public String toString() {
        return "From: " + fromVertex.getName() + " To: " + toVertex.getName() + " Value: " + value;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.value - edge.value;
    }
}

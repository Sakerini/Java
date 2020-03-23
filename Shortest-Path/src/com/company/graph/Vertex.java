package com.company.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Vertex {
    private String name;
    private boolean visited = false;
    private ArrayList<Edge> edges = new ArrayList<>();
    private int shortestDistance = -1;
    private Vertex shortestDistancePreviousVertex = null;

    public int getShortestDistance() {
        return shortestDistance;
    }

    public Vertex getShortestDistancePreviousVertex() {
        return shortestDistancePreviousVertex;
    }

    public void setShortestDistancePreviousVertex(Vertex shortestDistancePreviousVertex) {
        this.shortestDistancePreviousVertex = shortestDistancePreviousVertex;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public void setShortestDistance(int shortestDistance) {
        this.shortestDistance = shortestDistance;
    }

    public Vertex(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void addEdge(Edge newEdge) {
        this.edges.add(newEdge);
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        return name.toString() + ", visited: " + visited + " " + Arrays.toString(edges.toArray());
    }
}

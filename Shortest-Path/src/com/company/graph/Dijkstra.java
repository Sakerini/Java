package com.company.graph;

import com.sun.jdi.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dijkstra {

    public static void calculateDistances(ArrayList<Edge> edges) {
        assert (edges != null);

        for (int i = 0; i < edges.size(); i++) {
            Vertex fromVertex = edges.get(i).getFromVertex();
            Vertex toVertex = edges.get(i).getToVertex();
            int travelledDistance = edges.get(i).getFromVertex().getShortestDistance();
            int distanceToEdge = travelledDistance + edges.get(i).getValue();
            if (toVertex.getShortestDistance() == -1) {
                toVertex.setShortestDistance(distanceToEdge);
                toVertex.setShortestDistancePreviousVertex(fromVertex);
            } else {
                if (distanceToEdge < toVertex.getShortestDistance()) {
                    toVertex.setShortestDistance(distanceToEdge);
                    toVertex.setShortestDistancePreviousVertex(fromVertex);
                }
            }
        }
    }
    public static void recursiveProbing(Map<String, Vertex> graph, String source) {
        Vertex currentVertex = graph.get(source);
        currentVertex.setVisited(true);
        ArrayList<Edge> sortedEdgeList = currentVertex.getEdges();
        sortedEdgeList.sort(Edge::compareTo);

        calculateDistances(sortedEdgeList);

        //calculate

        for (int i = 0; i < sortedEdgeList.size(); i++) {
            if (sortedEdgeList.get(i).getToVertex().isVisited() == false) {
                recursiveProbing(graph, sortedEdgeList.get(i).getToVertex().getName());
            }
        }
    }
    public static void calculateShortestPathFromSource(Map<String, Vertex> graph, String source) {
        Vertex startVertex = graph.get(source);
        startVertex.setVisited(true);
        startVertex.setShortestDistance(0);
        recursiveProbing(graph, source);
    }
}

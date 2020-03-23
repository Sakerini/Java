package com.company;

import com.company.graph.Dijkstra;
import com.company.graph.Edge;
import com.company.graph.Vertex;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void addEdges (Vertex vertexOne, Vertex vertexTwo, int value) {
        Edge tempEdge = new Edge(vertexOne, vertexTwo, value);
        vertexOne.addEdge(tempEdge);
        tempEdge = new Edge(vertexTwo, vertexOne, value);
        vertexTwo.addEdge(tempEdge);
    }

    public static Map<String, Vertex> readFromFile(String fileName) throws Exception {
        Scanner fileReader = new Scanner(new File(fileName));
        int lineCounter = 0;
        Map<String, Vertex> cityMap = new HashMap<String, Vertex>();

        while (fileReader.hasNextLine()) {
            lineCounter++;
            String readString = fileReader.nextLine();
            String[] splittedLine = readString.split(" ");

            Vertex vertexOne;
            if (!cityMap.containsKey(splittedLine[0])) {
                vertexOne = new Vertex(splittedLine[0]);
                cityMap.put(splittedLine[0], vertexOne);
            } else {
                vertexOne = cityMap.get(splittedLine[0]);
            }

            Vertex vertexTwo;
            if (!cityMap.containsKey(splittedLine[1])) {
                vertexTwo = new Vertex(splittedLine[1]);
                cityMap.put(splittedLine[1], vertexTwo);
            } else {
                vertexTwo = cityMap.get(splittedLine[1]);
            }

            int value = Integer.parseInt(splittedLine[2]);

            addEdges(vertexOne, vertexTwo, value);
        }
        System.out.println();
        return cityMap;
    }

    public static void main(String[] args) {
        Map<String, Vertex> cityMap = null;
        try {
            cityMap = readFromFile("src/com/company/Routes.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (cityMap != null) {
            for (Map.Entry<String, Vertex> vertex : cityMap.entrySet()) {
                System.out.println(vertex.getValue().toString());
            }

            System.out.println();
            System.out.println();

            Dijkstra.calculateShortestPathFromSource(cityMap, "Smolyan");
            //TODO PRINT PATHS
        }
    }
}

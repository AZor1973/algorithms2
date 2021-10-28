package ru.azor.lesson7;

import java.util.*;

public class GraphDistance implements Graph {
    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;

    public GraphDistance(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }


    public void addEdge(String startLabel, String secondLabel, int distance) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return;
        }

        adjMatrix[startIndex][endIndex] = distance;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        return false;
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel) {
        return false;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
    }

    @Override
    public void dfs(String startLabel) {
    }

    public void findShortestWay() {
        int shortest = Integer.MAX_VALUE;
        int distance = 0;
        List<Vertex> route = new ArrayList<>();
        Map<Integer, List<Vertex>> options = new HashMap<>();
        Vertex vertex;
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[0][i] != 0) {
                vertex = vertexList.get(0);
                do {
                    assert vertex != null;
                    visitedVertex(route, vertex);
                    distance += distance(vertex);
                    vertex = getNearUnvisitedVertex(vertex);
                    vertexList.get(i).setVisited(true);
                } while (vertex != null);
                options.put(distance, List.copyOf(route));
                route.clear();
                if (distance < shortest) {
                    shortest = distance;
                }
                distance = 0;
            }
        }
        showResult(options, shortest);
    }

    private void showResult(Map<Integer, List<Vertex>> options, int shortest) {
        for (Integer integer : options.keySet()) {
            for (int i = 0; i < options.get(integer).size(); i++) {
                System.out.print(options.get(integer).get(i).getLabel() + " ");
            }
            System.out.println("= " + integer + " км.");
        }
        System.out.println("-----------------------------------");
        System.out.print("Кратчайший маршрут: " + shortest + " км - ");
        for (int i = 0; i < options.get(shortest).size(); i++) {
            System.out.print(options.get(shortest).get(i).getLabel() + " ");
        }
        System.out.println();
    }

    @Override
    public void bfs(String startLabel) {
    }

    public void fillGraph() {
        this.addVertex("Москва");
        this.addVertex("Тула");
        this.addVertex("Липецк");
        this.addVertex("Воронеж");
        this.addVertex("Рязань");
        this.addVertex("Тамбов");
        this.addVertex("Саратов");
        this.addVertex("Калуга");
        this.addVertex("Орёл");
        this.addVertex("Курск");
        this.addEdge("Москва", "Тула", 183);
        this.addEdge("Тула", "Липецк", 291);
        this.addEdge("Липецк", "Воронеж", 125);
        this.addEdge("Москва", "Рязань", 198);
        this.addEdge("Рязань", "Тамбов", 278);
        this.addEdge("Тамбов", "Саратов", 384);
        this.addEdge("Саратов", "Воронеж", 531);
        this.addEdge("Москва", "Калуга", 177);
        this.addEdge("Калуга", "Орёл", 213);
        this.addEdge("Орёл", "Курск", 163);
        this.addEdge("Курск", "Воронеж", 222);
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] != 0 && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private int distance(Vertex vertex) {
        int distance = 0;
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] != 0 && !vertexList.get(i).isVisited()) {
                distance = adjMatrix[currentIndex][i];
                break;
            }
        }
        return distance;
    }

    private void visitedVertex(List<Vertex> list, Vertex vertex) {
        list.add(vertex);
    }
}

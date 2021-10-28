package ru.azor.lesson7;

public class ShortestWay {
    public static void main(String[] args) {
        GraphDistance graph = new GraphDistance(10);
        graph.fillGraph();
        graph.display();
        graph.findShortestWay();
    }


}

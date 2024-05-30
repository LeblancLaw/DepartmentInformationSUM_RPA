package org.recap.graph;

public class Edge {
    private final String targetNode;
    private final double weight;

    public Edge(String targetNode, double weight) {
        this.targetNode = targetNode;
        this.weight = weight;
    }

    public String getTargetNode() {
        return targetNode;
    }

    public double getWeight() {
        return weight;
    }
}

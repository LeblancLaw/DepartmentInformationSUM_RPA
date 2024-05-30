package org.recap.graph;

import org.recap.sentence.Similarity;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Graph {

    public enum SimilarityMethods { COSINE_SIMILARITY, JACCARD_SIMILARITY }

    public static WeightedGraph makeWeightedGraph(Map<String, List<String>> sentencesWithWords, SimilarityMethods similarityMethods){
        WeightedGraph graph = new WeightedGraph();


        for (Map.Entry<String, List<String>> entrySource : sentencesWithWords.entrySet()) {
            graph.addNode(entrySource.getKey());

            for (Map.Entry<String, List<String>> entryTarget : sentencesWithWords.entrySet()) {
                if (!Objects.equals(entrySource.getKey(), entryTarget.getKey())) {
                    float similarity = 0f;
                    if (similarityMethods == SimilarityMethods.COSINE_SIMILARITY)
                        similarity = Similarity.calculateCosineSimilarity(entrySource, entryTarget);
                    else if (similarityMethods == SimilarityMethods.JACCARD_SIMILARITY)
                        similarity = Similarity.calculateCosineSimilarity(entrySource, entryTarget);

                    graph.addEdge(entrySource.getKey(), entryTarget.getKey(), similarity);
                }
            }
        }

        return graph;
    }
}

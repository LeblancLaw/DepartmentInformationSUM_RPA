package org.recap;

import org.recap.graph.Graph;
import org.recap.graph.TextRank;
import org.recap.graph.WeightedGraph;
import org.recap.sentence.Extractor;
import org.recap.sentence.Splitter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Summarizer {
    public List<String> summarize(String text, Graph.SimilarityMethods similarityMethods) {
        List<String> sentences = Splitter.split(text); // split sentence

        sentences = sentences.stream()
                .map(sentence -> sentence.replaceAll("\\.{2,}", ".")) // transe
                .map(sentence -> sentence.replaceAll("[?!~ㅠ]", "")) // delete
                .collect(Collectors.toList());

        int sentencesSize = sentences.size();
        int recapSize = Math.round((1/20f)*sentencesSize+4); //
        //
        //

        Map<String, List<String>> wordsWithSentences = Extractor.extract(sentences); //

        //
        WeightedGraph graph = Graph.makeWeightedGraph(wordsWithSentences, similarityMethods); //
        return TextRank.calculateTextRank(graph, recapSize).stream().map(Map.Entry::getKey).collect(Collectors.toList());
    }
}

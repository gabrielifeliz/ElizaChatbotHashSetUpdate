package com.company;

import java.util.*;

public class ElizaModifications {

    /* This method is responsible for splitting first-person sentence
        and returns a second-person sentence */
    public String replaceWords(HashMap<String, String> map, String message) {

        // Initialize new sentence to empty string
        String newSentence = "";
        // Convert the first-person sentence into an array of words using split
        String[] response = message.split(" ");
        for (int i = 0; i < response.length; i++) {

            // Change first person to second person with if-else statements
            if (map.containsKey(response[i]))
                response[i] = map.get(response[i]);

            // Add words separated by spaces if it's not the last word. If it is, just add the last word
            newSentence += ((i != response.length - 1) ? (response[i] + " ") : (response[i]));
        }
        return newSentence;
    }

    public String hedgeDisplay(Random random, HashSet<String> hedges) {

        Iterator iteratorHedges = hedges.iterator();
        int hedgeId =  random.nextInt(hedges.size());
        String hedge = iteratorHedges.next().toString();
        for (int count = 0; count < hedgeId; count++)
            hedge = iteratorHedges.next().toString();

        return hedge;
    }

    public String qualifierDisplay(Random random, HashSet<String> qualifiers) {

        Iterator iteratorQualifiers = qualifiers.iterator();
        int qualifierId =  random.nextInt(qualifiers.size());
        String qualifier = iteratorQualifiers.next().toString();
        for (int count = 0; count < qualifierId; count++)
            qualifier = iteratorQualifiers.next().toString();

        return qualifier;
    }
}

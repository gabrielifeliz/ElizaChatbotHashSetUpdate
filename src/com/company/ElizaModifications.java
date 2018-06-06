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

    /* This method is responsible for generating a random qualifier */
    public String hedgeOrQualifierDisplay(Random random, HashSet<String> hashSet) {

        Iterator iteratorHashSet = hashSet.iterator();
        int hasSetId =  random.nextInt(hashSet.size());
        String response = iteratorHashSet.next().toString();
        for (int count = 0; count < hasSetId; count++)
            response = iteratorHashSet.next().toString();

        return response;
    }
}

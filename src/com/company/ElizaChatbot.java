package com.company;

import java.util.*;

public class ElizaChatbot {

    public static void main(String[] args) {

        // Create Random and Scanner objects
        // Also, create ElizaModifications objects to use methods inside it
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();
        ElizaModifications modifications = new ElizaModifications();

        // Initialize answer to an empty string
        String answer;

        // Add first-person pronouns as keys with their second-person equivalencies as values to a hash map
        HashMap<String, String> replacements = new HashMap<>();
        replacements.put("I", "you");
        replacements.put("me", "you");
        replacements.put("my", "your");
        replacements.put("am", "are");

        // Create ArrayList of Strings and add hedges to it
        HashSet<String> hedges = new HashSet<>();
        hedges.add("Please tell me more.");
        hedges.add("Many of my patients tell me the same thing.");

        // Prompt the user to enter his or her problem and get the response
        System.out.print("Good day. What is your problem? Enter your response here or Q to quit: ");
        answer = keyboard.nextLine();

        // Initialize loop count to zero
        int loopCount = 0;
        // Continue the dialogue between Eliza and the user until the user enter Q or q
        while (!(answer.equalsIgnoreCase("Q"))) {
            // Create dialogues with the user if the loop count is not 8
            if (loopCount != 8) {
                // Create ArrayList and add qualifiers with the second-person version of user's responses
                HashSet<String> qualifiers = new HashSet<>();
                // Assign returned String from replaceWords
                String secondPersonSentence = modifications.replaceWords(replacements, answer);
                qualifiers.add("Why do you say that " + secondPersonSentence + "?");
                qualifiers.add("You seem to think that " + secondPersonSentence + ".");
                qualifiers.add("So, you are concerned that " + secondPersonSentence + ".");

                // Display Eliza's response to the user randomly
                System.out.print(
                        (random.nextBoolean()
                                ? (modifications.hedgeOrQualifierDisplay(random, hedges))
                                : (modifications.hedgeOrQualifierDisplay(random, qualifiers)))
                                + " Enter your response here or Q to quit: ");
                answer = keyboard.nextLine();
            } else {
				/* If the loop counts gets to 8,
					the "chat-bot" breaks the while loop and terminates the program */
                System.out.print("It is getting late, maybe we had better quit");
                break;
            }
            loopCount++;
        }

        // Close Scanner object
        keyboard.close();
    }
}
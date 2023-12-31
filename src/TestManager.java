/**
 * Nitzan Saar
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/* Extend this to evaluate the fraction of spam and ham emails your classifier identifies correctly. */

public class TestManager {

    public static void main(String args[]) throws FileNotFoundException {
        FreqDist spam = new FreqDist();
        FreqDist ham = new FreqDist();
        String filename;
        ArrayList<String> words;
        Processor p;
        Predictor pr = new Predictor();
        double spamval, hamval;
        int correctSpam = 0;
        int correctHam = 0;
        int spamEmails = 0;
        int hamEmails = 0;

        /* read in 100 spam and store in a FreqDist. */
        File spamFolder = new File("spamtrain");
        String[] spamFiles = spamFolder.list();
        for (int i = 0; i < spamFiles.length; i++) {
            filename = spamFiles[i];
            p = new Processor("spamtrain/" + filename);
            words = p.parseFile("spamtrain/" + filename);
            for (int j = 0; j < words.size(); j++) {
                spam.add(words.get(j));
            }
        }

        /* read in 100 ham and store in a FreqDist */

        File hamFolder = new File("hamtrain");
        String[] hamFiles = hamFolder.list();
        for (int i = 0; i < hamFiles.length; i++) {
            filename = hamFiles[i];
            p = new Processor("hamtrain/" + filename);
            words = p.parseFile("hamtrain/" + filename);
            for (int j = 0; j < words.size(); j++) {
                ham.add(words.get(j));
            }
        }

        /* take 50 spam test emails, compute loglikelihood */

        File spamTestFolder = new File("spamtest");
        String[] spamTestFiles = spamTestFolder.list();
        for (int i = 0; i < spamTestFiles.length; i++) {
            filename = spamTestFiles[i];

            p = new Processor("spamtest/" + filename);
            words = p.parseFile("spamtest/" + filename);
            spamval = pr.computeLogLikelihood(spam, words);
            hamval = pr.computeLogLikelihood(ham, words);
            System.out.println(spamval + " " + hamval);
            if (spamval > hamval) {
                System.out.println("Correct");
                correctSpam++;
            } else {
                System.out.println("Incorrect");
            }
            spamEmails++;
        }

        /* take 50 ham test emails, compute loglikelihood */

        File hamTestFolder = new File("hamtest");
        String[] hamTestFiles = hamTestFolder.list();
        for (int i = 0; i < hamTestFiles.length; i++) {
            filename = hamTestFiles[i];
            p = new Processor("hamtest/" + filename);
            words = p.parseFile("hamtest/" + filename);
            spamval = pr.computeLogLikelihood(spam, words);
            hamval = pr.computeLogLikelihood(ham, words);
            System.out.println(spamval + " " + hamval);
            if (spamval < hamval) {
                System.out.println("Correct");
                correctHam++;
            } else {
                System.out.println("Incorrect");
            }
            hamEmails++;
        }

        /* keep track of the number of correctly classified spam and ham, and display the totals
        * at the end. Only thing to do here*/
        System.out.println("--------------------------------------");
        System.out.println("Results:");
        System.out.println("Spam: " + correctSpam + " correct out of " + spamEmails + " emails");
        System.out.println("Ham: " + correctHam + " correct out of " + hamEmails + " emails");
        System.out.println("Total score: " + (correctSpam + correctHam) + "%");
   }
}









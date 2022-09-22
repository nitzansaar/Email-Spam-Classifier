import java.util.ArrayList;
import java.util.HashMap;

public class Predictor {

    /* you do this one. */

    public Predictor(){}
    public double computeLogLikelihood(FreqDist fd, ArrayList<String> wordsToScore) {
        double score = 0;
        double numerator;
        double denominator;
        double log;

        for(int i = 0; i < wordsToScore.size(); i++){
            fd.add(wordsToScore.get(i));
        }

        for(int i = 0; i < wordsToScore.size(); i++){
            numerator = fd.get(wordsToScore.get(i));
            denominator = fd.getTotalCount();
            log = Math.log(numerator / denominator);
            score += log;
        }
        return score;
    }



}

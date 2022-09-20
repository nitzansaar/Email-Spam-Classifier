import java.util.ArrayList;

public class Predictor {

    /* you do this one. */

    public Predictor(){}
    public double computeLogLikelihood(FreqDist fd, ArrayList<String> wordsToScore) {
        fd.getFrequencies();
        return fd.getTotalCount();
    }



}

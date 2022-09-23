import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProcessorTest {
    public static Processor p = new Processor("1114.3ee361561ee25d914e377dd8473a9cb6");
    public static ArrayList<String> words;

    static {
        try {
            words = p.parseFile("1114.3ee361561ee25d914e377dd8473a9cb6");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static HashMap<String, Integer> frequencies = new HashMap<>();
    public static FreqDist f = new FreqDist();

    public static void main (String[] args) throws FileNotFoundException {
        testProc();
        testFreq();
        testPred();
    }

    public static void testProc() throws FileNotFoundException {
        System.out.println("Testing Processor:");
        String testStripPunc = p.stripPunctuation("Hello!");
        boolean testJunk = p.isJunk("Howdy");
        boolean testJunk2 = p.isJunk("94uhqfbwe");
        boolean testStop = p.isStopword("herself");
        boolean testStop2 = p.isStopword("Michaelangelo");
        p.setFilename("This is a test");

        System.out.println(p.getFilename());
        System.out.println(words.toString());
        System.out.println("Should say Hello: " + testStripPunc);
        System.out.println("Should say false: " + testJunk);
        System.out.println("Should say true: " + testJunk2);
        System.out.println("Should say true: " + testStop);
        System.out.println("Should say false: " + testStop2);
    }

    public static void testFreq() throws FileNotFoundException {
        System.out.println("Testing FreqDist:");
        for (int i = 0; i < words.size(); i++){
            f.add(words.get(i));
            frequencies.put(words.get(i), i);
        }
        f.setTotalCount(f.getTotalCount());
        System.out.println(f.getFrequencies());
        System.out.println("Should say 7: " + f.get("id"));
        System.out.println("Should say 1: " + f.get("nonexistent"));
        System.out.println("Should say 9: " + f.get("tue"));
        System.out.println("These numbers should be the same: " + f.getTotalCount() + " & " + words.size());

}
    public static void testPred() throws FileNotFoundException {
        System.out.println("Testing Predictor:");
        Predictor predictor = new Predictor();
        Processor processor = new Processor("Test.txt");
        ArrayList<String> wordList = processor.parseFile("Test.txt");
        FreqDist freqDist = new FreqDist();
        System.out.println("These numbers should be the same: " + (Math.log(1.0/4.0) * 4) +
                        " & " + predictor.computeLogLikelihood(freqDist, wordList));

    }



}

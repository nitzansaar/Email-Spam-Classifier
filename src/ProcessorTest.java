import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProcessorTest{

    public static void main (String[] args) throws FileNotFoundException {
        testProc();
        testFreq();
    }

    public static void testProc() throws FileNotFoundException {

        Processor p = new Processor("1114.3ee361561ee25d914e377dd8473a9cb6");
        ArrayList<String> words = p.parseFile("1114.3ee361561ee25d914e377dd8473a9cb6");

        boolean testJunk = p.isJunk("Howdy");
        boolean testJunk2 = p.isJunk("94uhqfbwe");
        boolean testStop = p.isStopword("herself");
        boolean testStop2 = p.isStopword("Michaelangelo");
        p.setFilename("File1");

        System.out.println(p.getFilename());
        System.out.println(words.toString());
        System.out.println("Should say false: " + testJunk);
        System.out.println("Should say true: " + testJunk2);
        System.out.println("Should say true: " + testStop);
        System.out.println("Should say false: " + testStop2);
    }

    public static void testFreq() throws FileNotFoundException {
        // not sure how to use "setFrequencies cus its being weird about passing a hashmap as a param
        HashMap<String, Integer> frequencies = new HashMap<>();
        FreqDist f = new FreqDist();
        Processor p = new Processor("1114.3ee361561ee25d914e377dd8473a9cb6");
        ArrayList<String> words = p.parseFile("1114.3ee361561ee25d914e377dd8473a9cb6");

        for (int i = 0; i < words.size(); i++){
            f.add(words.get(i));
            frequencies.put(words.get(i), i);
        }
        f.setTotalCount(f.getTotalCount());
        System.out.println(f.getFrequencies());
        System.out.println(f.get("id"));
        System.out.println(f.getTotalCount());

}
    public static void testPred(){
        Predictor p = new Predictor();
        p.computeLogLikelihood();

    }



}

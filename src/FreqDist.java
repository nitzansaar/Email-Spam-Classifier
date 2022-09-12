/* A freqDist is a wrapper for a Map that will tell us, for a given list of words, how often each word appeared
in a corpus. You should not need to modify this - you'll only need to use it. */

import java.util.HashMap;
public class FreqDist {
    HashMap<String, Integer> frequencies;
    int totalCount;

    public FreqDist() {
        frequencies = new HashMap<String, Integer>();
        totalCount = 0;
    }

    public HashMap<String, Integer> getFrequencies() {
        return frequencies;
    }

    public void setFrequencies(HashMap<String, Integer> frequencies) {
        this.frequencies = frequencies;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    
    public void add(String newWord) {
        int val;
        if (frequencies.containsKey(newWord)) {
           val = frequencies.get(newWord);
           frequencies.put(newWord, val+1);
        } else {
            frequencies.put(newWord, 1);
        }
        totalCount += 1;
    }
    
    /* if a word is not present in our frequency dictionary, assume it has a count of 1. */
    int get(String newWord) {
        if (frequencies.containsKey(newWord)) {
            return frequencies.get(newWord);
        } else {
            return 1;
        }
    }
}

package LeetCode;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class prob1408 {
    public static List<String> stringMatching(String[] words) {
        List<String> output = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for(int j = 0; j < words.length; j++) {
                //skip itself when comparing
                if ((words[i].contains(words[j])) && (i != j) && (words[i].length() > words[j].length())) {
                    output.add(words[j]);
                }
            }
        }
        Collections.sort(output);
        for (int i = 0; i < output.size()-1; i++) {
            System.out.println(output);
            if (output.get(i).equals(output.get(i+1))) {
                output.remove(i+1);
                i--;
            }
        }
        return output;
    }
    public static void main(String[] args) {
        String[] s = {"jxh","jxhp","zkzw","hfzkzw","zdmrp","gshfzkzw","plpu","mzkzw","ruvvy","esgshfzkzwt","deg","csjxhp"};
        System.out.println(stringMatching(s));
    }
}

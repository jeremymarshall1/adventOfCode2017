import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day4 implements Solution {
    @Override
    public void solve(String[] args) {
        String dupeRegexPattern = "(?i)\\b(\\w+)\\b[\\w\\W]*\\b\\1\\b";
        Pattern dupePattern = Pattern.compile(dupeRegexPattern);

        BufferedReader inStream;
        String fileName = "./adventOfCode2017/src/files/day4.txt";

        int numValidLines = 0;

        try {
            inStream = new BufferedReader(new FileReader(fileName));
            String line = inStream.readLine();
            while (line != null) {
                String[] sentence = line.split(" ");
                int dupe = 0;

                for(int x = 0; x < sentence.length; x++) {
                    char[] words = sentence[x].toCharArray();
                    Arrays.sort(words);
                    //System.out.println(letters);
                    sentence[x] = new String(words);
                    //System.out.println(sentence[x]);

                    for(int y = 0; y < sentence.length; y++) {
                        if(y != x) {
                            if (sentence[x].equals(sentence[y])) {
                                dupe++;
                            }
                        }

                    }
                    }
                if(dupe == 0) {
                    numValidLines++;
                }

                line = inStream.readLine();
            }
        } catch (IOException err) {
            System.out.println(err);
        }

        System.out.println(numValidLines);

    }
}
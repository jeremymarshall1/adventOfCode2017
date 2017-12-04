import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day4 implements Solution {
    @Override
    public void solve(String[] args) {
        String dupeRegexPattern = "(?i)\\b(\\w+)\\b[\\w\\W]*\\b\\1\\b";
        Pattern dupePattern = Pattern.compile(dupeRegexPattern);

        BufferedReader inStream;
        String fileName = "/home/jeremy/adventOfCode2017/src/files/day4.txt";

        int numValidLines = 0;

        try {
            inStream = new BufferedReader(new FileReader(fileName));
            String line = inStream.readLine();
            while (line != null) {
                Matcher m = dupePattern.matcher(line);
                if(!m.find()){
                    numValidLines++;
                }
                //System.out.println(line);
                line = inStream.readLine();
            }
        } catch (IOException err) {
            System.out.println(err);
        }

        System.out.println(numValidLines);

    }
}
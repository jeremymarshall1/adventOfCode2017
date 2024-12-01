import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class day9 implements Solution {
    @Override
    public void solve(String[] args) {
        BufferedReader inStream = null;
        String fileName = "./adventOfCode2017/src/files/day9.txt";
        String line;

        char c;
        Boolean ignore = false;
        Boolean inGarbage = false;
        Boolean inGroup = false;

        int numStartGroup = 0;
        int score = 0;
        int garbageCount = 0;

        try {
            inStream = new BufferedReader(new FileReader(fileName));
            line = inStream.readLine();
            //line = "<{!>}>,";

            for(int x = 0; x < line.length(); x++) {
                c = line.charAt(x);

                //check if '!' was encountered before
                if(ignore){
                    ignore = false;
                    continue;
                }

                if(c =='!') {
                    ignore = true;
                    continue;
                }

                //check if garbage starts or ends
                if(c == '<') {
                    if(inGarbage) {
                        garbageCount++;
                    } else {
                        inGarbage = true;
                    }
                    continue;
                }

                if(c == '>') {
                    inGarbage = false;
                    continue;
                }

                if(inGarbage) {
                    garbageCount++;
                }

                if(c == '{' && !inGarbage) {
                    numStartGroup++;
                    inGroup = true;
                    continue;
                }

                if(c == '}' && !inGarbage) {
                    if(numStartGroup == 0){
                        inGroup = false;
                    }
                    score += numStartGroup;
                    numStartGroup--;
                    continue;
                }

                if(c == ',' && !(inGroup || inGarbage)) {
                    ignore = false;
                    inGarbage = false;
                    numStartGroup = 0;
                    inGroup = false;
                }
            }

            System.out.println("The score is: " + score);
            System.out.println("The garbage count is: " + garbageCount);

        } catch (IOException err) {
            System.out.println(err);
        }

    }
}
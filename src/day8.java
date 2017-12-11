import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class day8 implements Solution {
    @Override
    public void solve(String[] args) {
        BufferedReader instream;
        String fileName = "/home/jeremy/adventOfCode2017/src/files/day8.txt";
        String line = null;
        String [] splitLine;
        Boolean increase = false;
        int compareValue = 0;
        int tempvalue = 0;
        String key = null;
        int value = 0;

        try {
            instream = new BufferedReader(new FileReader(fileName));
            line = instream.readLine();

            while (line != null){
                splitLine = line.split(" ");

                //System.out.println(section);

                //add register
                if(!registers.containsKey(splitLine[0])){
                    registers.put(splitLine[0], 0);
                }

                //check instruction
                if(splitLine[1].contentEquals("inc")) {
                    increase = true;
                } else {
                    increase = false;
                }

                //add second register
                if(!registers.containsKey(splitLine[4])){
                    registers.put(splitLine[4], 0);
                }

                //add compare int
                compareValue = Integer.parseInt(splitLine[6]);

                if (compare(splitLine[5], registers.get(splitLine[4]), compareValue)){
                    if (increase) {
                        tempvalue = registers.get(splitLine[0]) + Integer.parseInt(splitLine[2]);
                    } else {
                        tempvalue = registers.get(splitLine[0]) - Integer.parseInt(splitLine[2]);
                    }
                    registers.put(splitLine[0], tempvalue);

                    if(registers.get(splitLine[0]) > value) {
                        value = registers.get(splitLine[0]);
                    }
                }

                line = instream.readLine();
            }

            System.out.println("The highest value is: " + value);

            value = 0;

            for (Map.Entry<String, Integer> item: registers.entrySet()){
                if(item.getValue() > value) {
                    key = item.getKey();
                    value = item.getValue();
                }
            }

            System.out.println("The current highest value is: " + value);

        } catch (IOException err) {
            System.out.println(err);
        }




    }

    public day8(){
        registers = new HashMap<>();
    }



    private boolean compare(String operator, int first, int second) {

        switch (operator) {
            case "==":
                return equalsOp(first, second);
            case ">=":
                return greaterEqual(first, second);
            case "<=":
                return lesserEqual(first, second);
            case ">":
                return greater(first, second);
            case "<":
                return lesser(first, second);
            case "!=":
                return notEqual(first, second);
        }

        System.out.println("Something broke");
        return false;
    }

    private boolean equalsOp(int first, int second) {
        if (first == second) {
            return true;
        }

        return false;
    }

    private boolean greaterEqual(int first, int second) {
        if (first >= second) {
            return true;
        }

        return false;
    }

    private boolean lesserEqual(int first, int second) {
        if (first <= second) {
            return true;
        }

        return false;
    }

    private boolean greater (int first, int second) {
        if (first > second){
            return true;
        }

        return false;
    }

    private boolean lesser(int first, int second) {
        if (first < second) {
            return true;
        }

        return false;
    }

    private boolean notEqual(int first, int second) {
        if (first != second) {
            return true;
        }

        return false;
    }

    private Map<String, Integer> registers;

}
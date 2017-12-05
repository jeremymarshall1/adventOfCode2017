import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class day5 implements Solution{
    @Override
    public void solve(String[] args) {
        String fileName = "/home/jeremy/adventOfCode2017/src/files/day5.txt";
        ArrayList<Integer> instructionArray = new ArrayList<Integer>();
        try {
            BufferedReader inStream = new BufferedReader(new FileReader(fileName));
            String line = inStream.readLine();
            while(line != null) {
                instructionArray.add(Integer.parseInt(line));
                line = inStream.readLine();
            }
        } catch (IOException err) {
            System.out.println(err);
        }

        int steps = 0;
        int currentIndex = 0;

        while(currentIndex < instructionArray.size()) {
            int offset = 1;
            if(instructionArray.get(currentIndex) >= 3) {
                offset = -1;
            }
            int newIndex = currentIndex + instructionArray.get(currentIndex);
            instructionArray.set(currentIndex, (instructionArray.get(currentIndex)) + offset);
            currentIndex = newIndex;
            steps++;
        }

        System.out.println(steps);

    }
}
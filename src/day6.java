import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

class day6 implements Solution {
    @Override
    public void solve(String[] args) {
        String input = "0\t5\t10\t0\t11\t14\t13\t4\t11\t8\t8\t7\t1\t4\t12\t11";
        String[] inputArray = input.split("\\t");
        int[] memBank = new int[inputArray.length];
        int maxValue = 0;
        int maxIndex = 0;
        int cycles = 0;
        ArrayList<String> oldListings = new ArrayList<>();
        ArrayList<Integer> cycleOfListings = new ArrayList<>();

        for (int x = 0; x < inputArray.length; x++) {
            memBank[x] = Integer.parseInt(inputArray[x]);
        }

        while (!duplicateFound(oldListings, Arrays.toString(memBank))) {
            oldListings.add(Arrays.toString(memBank));
            cycleOfListings.add(cycles);
            maxIndex = findMax(memBank);
            maxValue = memBank[maxIndex];

            memBank[maxIndex] = 0;
            for(int x = maxValue; x > 0; x--) {
                maxIndex++;
                if(maxIndex >= memBank.length){
                    maxIndex = 0;
                }

                memBank[maxIndex]++;
            }

            cycles++;
        }
        int diffIndex = 0;

        diffIndex =  cycles - (oldListings.indexOf(Arrays.toString(memBank)));
        System.out.println(cycles + ", " + diffIndex);

    }

    private int findMax(int[] memArray) {
        int maxValue = memArray[0];
        int maxIndex = 0;

        for(int x = 0; x < memArray.length; x++) {
            if(memArray[x] > maxValue) {
                maxValue = memArray[x];
                maxIndex = x;
            }
        }

        return maxIndex;
    }

    private boolean duplicateFound(ArrayList<String> oldList, String currList){
        return oldList.contains(currList);
    }
}
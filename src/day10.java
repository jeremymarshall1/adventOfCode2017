import java.util.*;

class day10 implements Solution {
    @Override
    public void solve(String[] args) {
        String rawInput = "129,154,49,198,200,133,97,254,41,6,2,1,255,0,191,108";
        String[] input = rawInput.split(",");

        //String[] input = {"3", "4", "1", "5"};
        String[] inputArray = new String[256];
        int currIndex = 0;
        int skipSize = 0;
        for(int x = 0; x < inputArray.length; x++){
            inputArray[x] = String.valueOf(x);
        }

        populateList(inputArray);

        for(String s: input){
            ArrayList<CircleListNode> tempCLN;

            tempCLN = getSubList(currIndex, Integer.parseInt(s));

            reverseList(tempCLN, currIndex);

            currIndex = currIndex + Integer.parseInt(s) + skipSize;

            if(currIndex > inputArray.length){
                currIndex -= inputArray.length;
            }

            skipSize++;

        }


        System.out.println(list.get(0).getValue() * list.get(1).getValue());



    }

    public day10(){
        list = new ArrayList<>();
    }

    private ArrayList<CircleListNode> getSubList(int start, int length){
        ArrayList<CircleListNode> temp = new ArrayList<>();
        CircleListNode item = list.get(start);

        while(length > 0){
            temp.add(item);
            item = item.getNext();
            length--;
        }

        return temp;
    }

    private void reverseList(ArrayList<CircleListNode> inputList, int startIndex){
        ArrayList<Integer> temp = new ArrayList<>();
        CircleListNode currListNode = list.get(startIndex);

        for(int x = inputList.size() - 1; x >=0; x--){
            temp.add(inputList.get(x).getValue());
        }

        for(int x = 0; x < inputList.size(); x++){

            currListNode.setValue(temp.get(x));

            currListNode = currListNode.getNext();

        }
    }

    private void populateList(String[] inputArray){
        for(String s: inputArray){
            CircleListNode cln = new CircleListNode();
            cln.addValue(Integer.parseInt(s));
            if(list.size() >= 1){
                cln.setNext(list.get(0));
                cln.setPrev(list.get(list.size()-1));

            }

            if(list.size() >= 1){
                list.get(list.size()-1).setNext(cln);
            }

            list.add(cln);
        }

        list.get(0).setPrev(list.get(list.size() - 1));
    }

    ArrayList<CircleListNode> list;
}
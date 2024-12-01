import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class day7 implements Solution {
    @Override
    public void solve(String[] args) {
        BufferedReader inStream;
        String fileName = "./adventOfCode2017/src/files/day7.txt";
        String line = null;
        try {
            inStream = new BufferedReader(new FileReader(fileName));
            line = inStream.readLine();
            while (line  != null) {
                String tempLine = line.replaceAll("[(|)]|[\\->]", "");
                line = tempLine.replaceAll(", ",",");
                tower.add(addSection(line));
                line = inStream.readLine();
            }


        } catch (IOException err) {
            System.out.println(err);
        }

        for(myTree section: tower){
            section = setParent(section);
        }

        myTree root = tower.get(0);
        String currParentName;

        System.out.println("Now trying to find root");

        while(root.getParent() != null) {
            currParentName = root.getParent();
            for(myTree finder: tower) {
                if (finder.getName().contentEquals(currParentName)) {
                    root = finder;
                }
            }
        }

        System.out.println(root.getName());


    }

    private myTree addSection(String line) {
        String [] splitLine = line.split(",|\\s");
        myTree treeSection = new myTree(splitLine[0], Integer.parseInt(splitLine[1]));

        if (splitLine.length > 2) {
            for(int x = 2; x < splitLine.length; x++){
                treeSection.addChild(splitLine[x]);
            }
        }

        if(treeSection.getChildren().size() > 0) {
            treeSection.getChildren().remove(0);

        }

        return treeSection;
    }

    private myTree setParent(myTree treeSection) {
        for(String child: treeSection.getChildren()) {
            for(myTree treeNode: tower) {
                if (treeNode.getName().contentEquals(child)) {
                    treeNode.addParent(treeSection.getName());
                }
            }
        }

        return treeSection;
    }

    private List<myTree> tower = new ArrayList<myTree>();

}
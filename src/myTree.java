import java.util.ArrayList;
import java.util.List;

public class myTree {
    private String name = null;
    private int weight = 0;
    private List<String> children = new ArrayList<>();
    private String parent = null;

    public myTree(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public void addParent(String parent) {
        this.parent = parent;
    }

    public void addChild(String child) {
        this.children.add(child);
    }

    public String getName() {
        return this.name;
    }

    public int getWeight() {
        return this.weight;
    }

    public List<String> getChildren() {
        return this.children;
    }

    public String getParent() {
        return this.parent;
    }


}
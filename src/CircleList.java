class CircleListNode {
    private CircleListNode next;
    private CircleListNode prev;

    private int value;

    public CircleListNode(){
        value = 0;
        next = this;
        prev = this;
    }

    public void addValue(int item){
        value += item;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int newValue){
        value = newValue;
    }

    public void setNext(CircleListNode cln){
        next = cln;
    }

    public void setPrev(CircleListNode cln){
        prev = cln;
    }

    public CircleListNode getNext(){
        return next;
    }

    public CircleListNode getPrev(){
        return prev;
    }
}
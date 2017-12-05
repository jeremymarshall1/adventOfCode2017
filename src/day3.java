public class day3 implements Solution {
    @Override
    public void solve(String[] args) {
        int startNum = 23;
        int circleNum = 0;
        int lastSquare = 0;

        for(int x = 1; (x * x) < startNum; x += 2){
            circleNum++;
            lastSquare = x;
        }

        System.out.println(startNum - lastSquare);
        //System.out.println(circleNum);
    }
}
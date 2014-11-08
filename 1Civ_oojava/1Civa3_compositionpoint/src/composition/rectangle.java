package composition;


public class rectangle  {

    private point upperLeft, lowerRight;
    
    public rectangle() {
        upperLeft = new point();
        lowerRight = new point();
    }
    
    public rectangle(int x1, int y1, int x2, int y2) {
        upperLeft = new point(x1, y1);
        lowerRight = new point(x2, y2);
    }
    
    public point getUpperLeft() {
        return upperLeft;
    }   
    
    public point getLowerRight() {
        return lowerRight;
    }   
    
}

package nested;

public class Main {
    
    public Main() {
        NestedPoint p = new NestedPoint(1, 2);
        
        System.out.println(p.getX());
        System.out.println(p.getY());
    }
    
    public static void main(String[] args) {
        Main demo = new Main();
    }
    
    private class NestedPoint {
        private int x, y;

        public NestedPoint () {
            x = y = 0;
        }

        public NestedPoint (int x, int y) {
            this.x = x;
            this.y = y;
        }
    
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }
    }
    
}


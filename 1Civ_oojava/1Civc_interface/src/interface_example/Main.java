package interface_example;

public class Main {
    
    public Main() {
        Ball ball = new Ball(1.2);
        Box  box  = new Box(1.1, 2.2, 3.3);
        
        System.out.println("area of ball = " + ball.Area());
        System.out.println("area of box = " + box.Area());

        System.out.println("combined area = " + combineAreas(ball, box));
        System.out.println("combined area = " + combineAreas(box, ball));
    }
    
    private double combineAreas(Shape a, Shape b) {
        return a.Area() + b.Area();
    }
    
    public static void main(String[] args) {
        Main demo = new Main();
    }
   
}

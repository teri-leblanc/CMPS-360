package interface_example;

public class Ball implements Shape{
    private double radius;
    
    public Ball() {
        radius = 0;
    }
    
    public Ball(double r) {
        radius = r;
    }
    
    public double Area() {
        return radius * radius * PI;
    }
    
}

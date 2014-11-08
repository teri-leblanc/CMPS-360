package interface_example;

public class Box implements Shape {
    private double l, w, d;

    public Box() {
        l = w = d =0;
    }
    
    public Box(double l, double w, double d) {
        this.l = l;
        this.w = w;
        this.d = d;
    }
    
    public double Area() {
        return l * w * d;
    }
}

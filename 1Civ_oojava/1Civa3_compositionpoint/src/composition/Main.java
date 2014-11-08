package composition;

import javax.swing.JOptionPane;

public class Main {
    private rectangle r;
    
    public Main() {
        setPoints();
        showPoints();        
    }
    
    private void setPoints() {
        r = new rectangle(
                Integer.parseInt(JOptionPane.showInputDialog("Enter X1")),
                Integer.parseInt(JOptionPane.showInputDialog("Enter Y1")),
                Integer.parseInt(JOptionPane.showInputDialog("Enter x2")),
                Integer.parseInt(JOptionPane.showInputDialog("Enter Y2"))
                );
    }
    
    private void showPoints() {
        point upperLeft = r.getUpperLeft();
        point lowerRight = r.getLowerRight();
        String report = "x1 = " + upperLeft.getX() + "\n" +
                        "Y1 = " + upperLeft.getY() + "\n" +
                        "X2 = " + lowerRight.getX() + "\n" +
                        "Y2 = " + lowerRight.getY();
        
        JOptionPane.showMessageDialog(null, report);
    }
    
    public static void main(String[] args) {
        Main demo = new Main();
    }
    
}


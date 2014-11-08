package inheritance;

import javax.swing.JOptionPane;

public class Main {
    private point3d p;
    
    public Main() {
        p = new point3d();
        
        setPoint();
        
        showPoint();        
    }
    
    private void setPoint() {
        p = new point3d(
                Integer.parseInt(JOptionPane.showInputDialog("Enter X")),
                Integer.parseInt(JOptionPane.showInputDialog("Enter Y")),
                Integer.parseInt(JOptionPane.showInputDialog("Enter Z"))
                );
    }
    
    private void showPoint() {
        String report = "x = " + p.getX() + "\n" +
                        "Y = " + p.getY() + "\n" +
                        "Z = " + p.getZ();
        
        JOptionPane.showMessageDialog(null, report);
    }
    
    public static void main(String[] args) {
        Main demo = new Main();
    }
    
}


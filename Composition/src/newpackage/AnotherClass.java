/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newpackage;

/**
 *
 * @author Teri
 */
public class AnotherClass {
    private double d = 0;

    public double getD() {
        return d;
    }

    public void setD(double d) {
        if(d < 1 && d >= 0)
            this.d = d;
    }
    
}

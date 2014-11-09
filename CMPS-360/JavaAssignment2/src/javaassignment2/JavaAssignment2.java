/**
 *@Author:      Terianne LeBlanc Bolding
 *CLID:         TLL6799
 *Class:        CMPS360
 *Assignment:   assignment-2
 *Due Date:     9/16/2014 23:55 PM
 *Description: Project that simulates (models) and tests a Galton Box. 
 */

package javaassignment2;

public class JavaAssignment2 {
    private GaltonBoxSim []boxSim; //Private array to hold the GaltonBoxSim objects.
    /**
     * @param args the command line arguments
     */

    /**
Prototype: public JavaAssignment2();
Description: Default Constructor for JavaAssignment2 that Creates an array of 5 GaltonBoxSim objects and runs simulation. 
Precondition(s): Constructor must be called.
Postcondition(s): Output of 5 GaltonBox simulations will be displayed.
Visibility: Public
*/  
    public JavaAssignment2()
    {
        boxSim = new GaltonBoxSim[5];
        int boxes = 6;
        for(int i = 0; i < 5; i++){
            boxSim[i]= new GaltonBoxSim(boxes);
            boxes++;
        }
        //Run Simulation for each object in box sim. Output the totals at the end of each run.
        int count = 6;
        for(GaltonBoxSim b : boxSim){
            java.util.Random balls = new java.util.Random();
            System.out.println();
            System.out.println();
            System.out.println("----------Simulation run for " + count +" number of bins-------------");
            b.runSim(balls.nextInt(81)+20);
            b.boxTotal();
            count++;
        }
        System.out.println();
        System.out.println("--------------------Results-----------------------");
        //Output all totals for each GaltonboxSim object for easier reading.
        for(GaltonBoxSim b : boxSim){
            b.boxTotal();
            count++;
        }
    }       
    public static void main(String[] args) {
        new JavaAssignment2();
    
    }
    
}

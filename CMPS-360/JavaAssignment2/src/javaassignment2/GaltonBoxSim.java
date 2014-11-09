/**
 *@Author:      Terianne LeBlanc Bolding
 *CLID:         TLL6799
 *Class:        CMPS360
 *Assignment:   assignment-2
 *Due Date:     9/16/2014 23:55 PM
 *Description: Project that simulates (models) and tests a Galton Box. 
 */

package javaassignment2;


public class GaltonBoxSim {
final private int []galtonBoxes;  //Number of bins in the Galton Box. Range 2 to 20 inclusive.
private int currentBin; //Used to keep trak of which bin, during simulation, the ball is lined up with.
private int numBalls; //Number of balls to drop during simulation.
/**
Prototype: public GaltonBoxSim();
Description: Default Constructor for GaltonBoxSim. 
Precondition(s): Instance object of GaltonBoxSim() must be created
Postcondition(s): Creates a Galton Box of 10 bins.
Visibility: Public
*/    
    public GaltonBoxSim(){
        galtonBoxes = new int[10];
    }
/**
Prototype: public GaltonBoxSim(int numBins);
Description: Parameter Constructor for GaltonBoxSim. 
Precondition(s): Instance object of GaltonBoxSim() must be created and an integer between 2 and 20 inclusive passed as parameter
Postcondition(s): Creates a Galton Box of numBins bins if between 1 and 21, else sets galtonBoxes to 10.
Visibility: Public
*/
    public GaltonBoxSim(int numBins){
        if(numBins > 1 && numBins < 21)
            galtonBoxes = new int[numBins];
        else
            galtonBoxes = new int[10];
    }
/**
Prototype: public void runSim();
Description: Method that simulates the fall of a ball from the top of the Galton Box into a bin at the bottom.
Precondition(s): Instance object of GaltonBoxSim() must be created.
Postcondition(s): Outputs the path of the ball as it falls using R for a fall to the right of a pin and L for a fall to the left of a pin.
*   *The final output will be of all 5 GaltonBox object bin sets displaying the number of balls in each bin along with the number of balls dropped for sim.
Visibility: Public
*/   
    public void runSim(int numBall){
        numBalls = numBall;
        for (int j = 0; j < numBall; j++)
        {
            java.util.Random ballDirection = new java.util.Random();
            currentBin = 0;
            for(int i = 0; i < galtonBoxes.length-1;i++)
            { 
            if( ballDirection.nextInt(2) == 1)
                {
                    System.out.println("      R");
                    currentBin ++; 
                } 
                else
                {
                    System.out.println("L"); 
                }
            }
                galtonBoxes[currentBin]++;
        }
    }
/**
Prototype: public void boxTotal();
Description: Method to output the final total in each bin after a simulation.
Precondition(s): Instance object of GaltonBoxSim() must be created and a simulation using GaltonBoxSim must have been run.
Postcondition(s): Output the final total in each bin.
Visibility: Public
*/     
    public void boxTotal(){
        for(int i = 0; i < galtonBoxes.length;i++)
        {
            System.out.print(i+":"+galtonBoxes[i]+" ");
        }
        System.out.print("number of balls: "+ numBalls);
        System.out.println();
    }
}




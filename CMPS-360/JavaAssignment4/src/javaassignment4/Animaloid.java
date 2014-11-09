/**
 *@Author:      Terianne LeBlanc Bolding
 *CLID:         TLL6799
 *Class:        CMPS360
 *Assignment:   assignment-4
 *Due Date:     9/25/2014 23:55 PM
 *Description: Demonstrate your classes by creating reference variables of each non­abstract class type and using those 
reference variables to refer to objects of each non­abstract class.  Create enough variables to use all 
constructors.  Using the objects, call all public members access able by each object.  
Additionally, create an array of type Alien and assign at least one object of each non­abstract class to each 
reference element of the array, then loop through the array calling each available method for each object 
referenced by an element.  Always show returned values.
        
 */
package javaassignment4;

public class Animaloid extends Alien implements Status{
    private int numLegs, numArms, numHeads, numEyes, numEars; //number of legs, arms, heads, eyes, and ears of alien
    /**
Prototype: Animaloid(String homePlanet, String breatheWhat, String eatWhat, 
* double earthFraction,int numArms,int numLegs,int numHeads,int numEyes, int numEars);
Description: Constructor for class Animaloid. 
Precondition(s): Instance object Animaloid must be created and all correct params passed
Postcondition(s): params set to class variables
Visibility: Public
*/
    public Animaloid(String homePlanet, String breatheWhat, String eatWhat, double earthFraction,int numArms,
            int numLegs,int numHeads,int numEyes, int numEars){
        
        super(homePlanet, breatheWhat, eatWhat, earthFraction);
        this.numLegs = numLegs;
        this.numArms= numArms;
        this.numHeads = numHeads;
        this.numEyes= numEyes; 
        this.numEars = numEars;
    }
    /**
Prototype: returnEarthYears(int AlienYears)
Description: returns the number of earth years per alien year.
Precondition(s): Alien object created with integer representing a number of alien years passed
Postcondition(s): double returned representing the number of earth years per alien year
Visibility: Public
*/
    public double returnEarthYears(int AlienYears){
        
        return super.getAlienYear()*(double)AlienYears;
    }
    /**
Prototype: grasperCount();
Description: Return number of tentacles, arms or legs.
Precondition(s): Instance object must be created
Postcondition(s): number of arms legs and tentacles added returned int.
Visibility: Public
*/
    public int grasperCount(){
    
        return numLegs+numArms;
    }
    /**
Prototype: getNumLegs();
Description: number of legs returned.
Precondition(s): Instance object created
Postcondition(s): integer representing the number of legs returned
Visibility: Public
*/    
    public int getNumLegs(){
        return numLegs;
    }
    /**
Prototype: getNumArms();
Description: number of arms returned.
Precondition(s): Instance object created
Postcondition(s): integer representing the number of arms returned
Visibility: Public
*/
    public int getNumArms() {
        return numArms;
    }
    /**
Prototype: getNumHeads();
Description: number of heads returned.
Precondition(s): Instance object created
Postcondition(s): integer representing the number of heads returned
Visibility: Public
*/
    public int getNumHeads() {
        return numHeads;
    }
    /**
Prototype: getNumEyes();
Description: number of eyes returned.
Precondition(s): Instance object created
Postcondition(s): integer representing the number of eyes returned
Visibility: Public
*/
    public int getNumEyes() {
        return numEyes;
    }
    /**
Prototype: getNumEars();
Description: number of ears returned.
Precondition(s): Instance object created
Postcondition(s): integer representing the number of ears returned
Visibility: Public
*/
    public int getNumEars() {
        return numEars;
    }
     /**
Prototype: toString()
Description: Overridden toString returns info about animaloid.
Precondition(s): Instance object created
Postcondition(s): string returned containing all info regarding animaloid
Visibility: Public
*/ 
    
    public String toString(){
    
        return "Animaloid Alien with:  "+numLegs+" legs ; "
                   + +numArms+" Arms ; "+numHeads+" Heads ; "+numEyes+" Eyes; "+ numEars+" Ears "
                   + "; From the planet "+super.getHomePlanet()+"; Breathes "+super.getBreatheWhat()+"; Eats "+super.getEatWhat()+
                   "; Planets Yearly Cylce compared to Earth "+ super.getAlienYear();
    }
}

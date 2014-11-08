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

public class Humanoid extends Animaloid{

    
     /**
Prototype: Humanoid(String homePlanet, String breatheWhat, String eatWhat,double earthFraction);
Description: Constructor for class Humanoid
Precondition(s): correct parameters passed
Postcondition(s): passed parameters passed and initiated with super
Visibility: Public
*/   
    public Humanoid(String homePlanet, String breatheWhat, String eatWhat,double earthFraction){
    
        super(homePlanet,breatheWhat,eatWhat,earthFraction,2,2,1,2,2);
        
    
    }
    /**
Prototype: returnEarthYears(int AlienYears)
Description: returns the number of earth years per alien year.
Precondition(s): Alien object created with integer representing a number of alien years passed
Postcondition(s): double returned representing the number of earth years per alien year
Visibility: Public
*/    
    public double returnEarthYears(int AlienYears){
    
        return super.returnEarthYears(AlienYears);
    }
    /**
Prototype: grasperCount();
Description: Return number of tentacles, arms or legs.
Precondition(s): Instance object must be created
Postcondition(s): number of arms legs and tentacles added returned int.
Visibility: Public
*/        
    public int grasperCount(){
    
        return super.getNumLegs()+ super.getNumArms();
    }
    /**
Prototype: toString()
Description: Overridden toString returns info about humanoid.
Precondition(s): Instance object created
Postcondition(s): string returned containing all info regarding humanoid
Visibility: Public
*/
    
    public String toString(){
    
           return "Humanoid Animaloid Alien with:  "+super.getNumLegs()+" legs ; "
                   + super.getNumArms()+" Arms ; "+super.getNumHeads()+" Heads ; "+super.getNumEyes()+" Eyes; "+ 
                   super.getNumEars()+" Ears "+ "; From the planet "+super.getHomePlanet()+"; "
                   + "Breathes "+super.getBreatheWhat()+"; Eats "+super.getEatWhat()+
                   "; Planets Yearly Cylce compared to Earth "+ super.getAlienYear();
    }
}

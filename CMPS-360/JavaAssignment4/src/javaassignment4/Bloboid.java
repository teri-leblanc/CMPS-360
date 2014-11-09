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

public class Bloboid extends Alien implements Status{
        int numTentacles; // number of tentacles
        String gooType; //type of goo
    /**
Prototype: public Bloboid(String homePlanet, String breatheWhat, String eatWhat, double earthFraction, int numTentacles, String gooType);
Initializes Instance object of Bloboid by calling super.
Precondition(s):parameters must be passed
Postcondition(s): passed parameters initialized.
Visibility: Public
*/
    public Bloboid(String homePlanet, String breatheWhat, String eatWhat, double earthFraction, int numTentacles, String gooType){
        super(homePlanet,breatheWhat,eatWhat,earthFraction);
        this.numTentacles = numTentacles;
        this.gooType = gooType;
    
    }
    /**
Prototype: returnEarthYears(int AlienYears)
Description: returns the number of earth years per alien year.
Precondition(s): Alien object created with integer representing a number of alien years passed
Postcondition(s): double returned representing the number of earth years per alien year
Visibility: Public
*/
    public double returnEarthYears(int AlienYears){
    
        return super.getAlienYear()* (double)AlienYears;
    }
    /**
Prototype: grasperCount();
Description: Return number of tentacles, arms or legs.
Precondition(s): Instance object must be created
Postcondition(s): number of arms legs and tentacles added returned int.
Visibility: Public
*/
    public int grasperCount(){
    
        return numTentacles;
    }
    /**
Prototype: String getGooType();
Description: Returns type of goo .
Precondition(s): Instance object created
Postcondition(s): goo type returned in string
Visibility: Public
*/
    public String getGooType() {
        return gooType;
    }
     /**
Prototype: toString()
Description: Overridden toString returns info about bloboid.
Precondition(s): Instance object created
Postcondition(s): string returned containing all info regarding bloboid
Visibility: Public
*/   
    public String toString(){
        return "Bloboid Alien From the planet "+super.getHomePlanet()+"; Breathes "+super.getBreatheWhat()+"; Eats "+super.getEatWhat()+
                   "; Planets Yearly Cylce compared to Earth "+ super.getAlienYear() + numTentacles+" Tentacles; "+gooType+ " goo";
        
    }
}

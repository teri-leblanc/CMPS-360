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

abstract class Alien {
    private String homePlanet, breatheWhat, eatWhat; //Where the alien is from , what it breathes, and what it eats
    private double alienYear; // one alien year in a fraction of earth years
    /**
Prototype: Alien();
Description: Constructor for class Alien. 
Precondition(s): Instance object of Alien() must be created
Postcondition(s): all strings set to unknown and double set to 0
Visibility: Public
*/
    public Alien(){
        homePlanet = "unknown";
        breatheWhat = "unknown";
        eatWhat = "unknown";
        alienYear = 0.0;
    }
    /**
Prototype: Alien();
Description: Constructor for class Alien
Precondition(s): 3 strings and one double must be passed
Postcondition(s): home planet set, breathe set, eat set, and alien year set to earthfraction.
Visibility: Public
*/
    public Alien(String homePlanet, String breatheWhat, String eatWhat,double earthFraction){
        this.homePlanet = homePlanet;
        this.breatheWhat = breatheWhat;
        this.eatWhat = eatWhat;
        this.alienYear = earthFraction;
        
    }
    /**
Prototype: setAlienYear( double earthFraction)
Description: sets the alien year per earth year fraction 
Precondition(s): Double passed
Postcondition(s): Double set to alienYear
Visibility: Private
*/
    private void setAlienYear( double earthFraction)
    {
        alienYear = earthFraction;
    }
     /**
Prototype: getAlienYear();
Description: alienYear returned
Precondition(s): Instance object alien or inherited created
Postcondition(s): alienYear double returned
Visibility: Public
*/   
    public double getAlienYear(){
        return alienYear;
    }
     /**
Prototype: returnEarthYears(int AlienYears)
Description: Abstract class

*/   
    abstract double returnEarthYears(int AlienYears);
    /**
Prototype: String getHomePlanet().
Description: Return homePlanet string
Precondition(s): Instance object  must be created
Postcondition(s): return string homeplanet
Visibility: Public
*/
    public String getHomePlanet() {
        return homePlanet;
    }
    /**
Prototype: String getBreatheWhat() .
Description: Return breathewhat string
Precondition(s): Instance object  must be created
Postcondition(s): return string breathwhat
Visibility: Public
*/
    public String getBreatheWhat() {
        return breatheWhat;
    }
    /**
Prototype: String getEatWhat().
Description: Return eatWhat string
Precondition(s): Instance object  must be created
Postcondition(s): return string eatWhat
Visibility: Public
*/
    public String getEatWhat() {
        return eatWhat;
    }
    

    
}


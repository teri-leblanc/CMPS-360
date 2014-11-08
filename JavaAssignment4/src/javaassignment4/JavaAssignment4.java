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
import java.util.ArrayList;
/**
 *
 * @author Teri
 */
public class JavaAssignment4 {
    ArrayList<Alien> aliens;
    /**
     * @param args the command line arguments
     */
    /**
Prototype: JavaAssignment4();
Description: Constructor for class JavaAssignment4. 
Precondition(s): Instance object of JavaAssignment4() must be created
Postcondition(s): 
Visibility: Public
*/
    public JavaAssignment4(){
     
//---Animaloid---///
        Animaloid a1 = new Animaloid("Planet Animaloid", "carbon", "flesh", 3.0/2.0, 10, 15, 16 , 30, 5);
        System.out.println("-----------------Animaloid----------------");
        System.out.println("Alien Year: "+a1.getAlienYear()+ " Home Planet: " + a1.getHomePlanet()
                + " Eats: "+a1.getEatWhat()+" Breathes: "+a1.getBreatheWhat());
        System.out.println(" Number of Earths years for 5 alien years: " + a1.returnEarthYears(5));
        System.out.println(a1.getNumLegs()+" legs ; "
                   +a1.getNumArms()+" Arms ; "+a1.getNumHeads()+" Heads ; "+a1.getNumEyes()+" Eyes; "+ 
                   a1.getNumEars()+" Ears ");
        System.out.println("Grasper Count: " + a1.grasperCount());
        System.out.println("toString: "+ a1.toString());
        System.out.println();
//---Humanoid---///
        Humanoid h1 = new Humanoid("Planet Humanoid", "hydrogen", "fruits", 11.0/2.0);
                System.out.println("-----------------Humanoid----------------");
        System.out.println("Alien Year: "+h1.getAlienYear()+ "Home Planet: " + h1.getHomePlanet()
                + " Eats: "+h1.getEatWhat()+" Breathes: "+h1.getBreatheWhat());
        System.out.println(" Number of Earths years for 5 alien years: " + h1.returnEarthYears(5));
        System.out.println(h1.getNumLegs()+" legs ; "
                   +h1.getNumArms()+" Arms ; "+h1.getNumHeads()+" Heads ; "+h1.getNumEyes()+" Eyes; "+ 
                   h1.getNumEars()+" Ears ");
        System.out.println("Grasper Count: " + h1.grasperCount());
        System.out.println("toString: "+ h1.toString());
        System.out.println();
//---Bloboid---///
        Bloboid b1 = new Bloboid("Planet Bloboid", "nitrogen", "metal", 1.0/2.0,10,"ugly green");
        System.out.println("-----------------Bloboid----------------");
        System.out.println("goo Type : " +b1.getGooType() + "Grasper Count: " + b1.grasperCount());
        System.out.println("Alien Year: "+b1.getAlienYear()+ " Home Planet: " + b1.getHomePlanet()
                + " Eats: "+b1.getEatWhat()+" Breathes: "+b1.getBreatheWhat());
        System.out.println("toString: "+ b1.toString());
        System.out.println();
        
        
        //Create ArrayList and add one of each alien types.
     aliens = new ArrayList<>();
     aliens.add(new Animaloid("Planet Animaloid", "carbon", "flesh", 3.0/2.0, 10, 15, 16 , 30, 5));
     aliens.add(new Humanoid("Planet Humanoid", "hydrogen", "fruits", 11.0/2.0));
     aliens.add(new Bloboid("Planet Bloboid", "nitrogen", "metal", 1.0/2.0,10,"ugly green"));
     System.out.println("-------Array List will be printed---");
     for(Alien a : aliens){
         System.out.println("-------To String object printed will follow----------");
         System.out.println(a.toString());
         System.out.println("-------Available Methods will be called----------");
         System.out.println(" Home Planet: " + a1.getHomePlanet()
                + " Eats: "+a1.getEatWhat()+" Breathes: "+a1.getBreatheWhat()+" "+a.returnEarthYears(5)+" earth years ");
         System.out.println();
         
     }
    }
    public static void main(String[] args) {
        new JavaAssignment4();
    
   
    }
    
}

/**
 *@Author:      Terianne LeBlanc Bolding
 *CLID:         TLL6799
 *Class:        CMPS360
 *Assignment:   Project 2
 *Due Date:     11/9/2014 23:55 PM
 *Description: Creates a server / client system that allows use of the handler client and the user of the spy client to send 
 * encrypted messages to and from each other based on the “Solitaire” encryption scheme designed by Bruce Schneier 
 * (and used in the 1999 novel Cryptonomicon by Neal Stephenson).
 */

package solitairencryption;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SolitairEncryption {

    String OrigMessage; // Message to be encrypted.
    String EncryptedMessage; //Message to be decrypted
    ArrayList<Integer> keys; //KeyStream Keys
    ArrayList<Integer> messageInt; // Message converted to integers
    ArrayList<Integer> newMessageInt; // Integers once messageInt subtract or adds  keys
    ArrayList<String> newMessageString; // Final integers converted back to string
    private List<String> cards = new ArrayList<>(); // Holds the deck of cards
    public Map<String,Integer> alphabet; // Go from alphabet to integer
    public Map inverseAlphabet; // Go from integer to alphabet.
    private Scanner scanner;  //Read from file
    String outPutMessage;  //Final message to be outputted

     /**
Prototype: SolitairEncryption();
Description: Constructor for class Solitair Encryption.
Precondition(s): Instance object created.
Postcondition(s): Cards deck has been populated and alphabet map and inverse alphabet map has been populated.
Visibility: Public
*/   
    public SolitairEncryption(){
        alphabet = new HashMap<String,Integer>();
        inverseAlphabet = new HashMap<Integer,String>();

        populateCards();
        alphabet.put("A", 1); alphabet.put("B", 2);alphabet.put("C", 3);alphabet.put("D", 4); alphabet.put("E", 5);
        alphabet.put("F", 6); alphabet.put("G", 7);alphabet.put("H", 8);alphabet.put("I", 9);alphabet.put("J", 10);
        alphabet.put("K", 11);alphabet.put("L", 12);alphabet.put("M", 13);alphabet.put("N", 14);alphabet.put("O", 15);
        alphabet.put("P", 16);alphabet.put("Q", 17);alphabet.put("R", 18);alphabet.put("S", 19);alphabet.put("T", 20);
        alphabet.put("U", 21);alphabet.put("V", 22);alphabet.put("W", 23);alphabet.put("X", 24);alphabet.put("Y", 25);
        alphabet.put("Z", 26);
        inverseAlphabet.put(1,"A"); inverseAlphabet.put( 2,"B");inverseAlphabet.put(3,"C");inverseAlphabet.put(4,"D"); inverseAlphabet.put(5,"E");
        inverseAlphabet.put(6,"F"); inverseAlphabet.put(7,"G");inverseAlphabet.put(8,"H");inverseAlphabet.put(9,"I");inverseAlphabet.put(10,"J");
        inverseAlphabet.put(11,"K");inverseAlphabet.put(12,"L");inverseAlphabet.put(13,"M");inverseAlphabet.put(14,"N");inverseAlphabet.put(15,"O");
        inverseAlphabet.put(16,"P");inverseAlphabet.put(17,"Q");inverseAlphabet.put(18,"R");inverseAlphabet.put(19,"S");inverseAlphabet.put(20,"T");
        inverseAlphabet.put(21,"U");inverseAlphabet.put(22,"V");inverseAlphabet.put(23,"W");inverseAlphabet.put(24,"X");inverseAlphabet.put(25,"Y");
        inverseAlphabet.put(26,"Z");

        

    }
        /**
Prototype:String encrypt(String origMessage){;
Description: Encrypts and string message.
Precondition(s): String Message passed
Postcondition(s): Encrypted message returned.
Visibility: Public
*/
    public String encrypt(String origMessage){
        this.OrigMessage = origMessage;
        keys = new ArrayList<>();
        messageInt = new ArrayList<>();
        newMessageInt = new ArrayList<>();
        newMessageString = new ArrayList<>();
        outPutMessage = "";
        toPlainText();
        toNumbers();
        getKeyArray();
        addKeyMessage();
        addKeyString();
        return outPutMessage;
    
    }
        /**
Prototype: String decrypt(String EncryptedMessage);
Description: Takes in an encrypted message and decrypts it. 
Precondition(s): Message sent has to have been encrypted with the same key.
Postcondition(s): Decrypted message returned.
Visibility: Public
*/
    public String decrypt(String EncryptedMessage){
        this.EncryptedMessage = EncryptedMessage;
        keys = new ArrayList<>();
        messageInt = new ArrayList<>();
        newMessageInt = new ArrayList<>();
        newMessageString = new ArrayList<>();
        outPutMessage = "";
        toNumbers();
        getKeyArray();
        addKeyMessageD();
        addKeyString();
        return outPutMessage;
    }
        /**
Prototype: private void toPlainText()
Description: create the plaintext by removing the spaces and punctuation in the message and convert all characters to upper case.
Precondition(s): Encrypt() has been called.
Postcondition(s): All punctuation and white spaces have been removed and all characters are put in Upper Case.
Visibility: Public 
*/
    private void toPlainText(){
        EncryptedMessage = OrigMessage.replaceAll("\\W", "");
        EncryptedMessage = EncryptedMessage.toUpperCase();
        
    }
        /**
Prototype: private void toNumbers()
Description: Convert the plaintext message from letters into numbers.
Precondition(s): Encrypt() must be called.
Postcondition(s): The plaintext message has been converted from letters to numbers using the alphabet map.
Visibility: Private
*/
    private void toNumbers(){
        char[] tempChar = new char[EncryptedMessage.length()];
        tempChar = EncryptedMessage.toCharArray();
        for(char a:tempChar){
            
            messageInt.add(alphabet.get(Character.toString(a)));
        }
        
     }
        
        /**
Prototype: private void addKeyMessageD()
Description: Subtract the keystream numbers from the ciphertext numbers, subtracting 26 to any resulting number that is greater
* then 26.
Precondition(s):  An object of this class must have been created and encrypt() called.
Postcondition(s): An arrayList of resulting numbers has been collected and stored in newMessageInt.
Visibility: Private
*/
    private void addKeyMessage(){
        for(int i = 0 ; i < messageInt.size();i++){
            
            int temp = messageInt.get(i) + keys.get(i);
            if (temp > 26) temp = (temp - 26);
            
            newMessageInt.add(temp);
        }
        
    }
        /**
Prototype: private void addKeyMessageD()
Description: Subtract the keystream numbers from the ciphertext numbers, adding 26 to any resulting number that is less than 1.
Precondition(s):  An object of this class must have been created and decrypt() called.
Postcondition(s): An arrayList of resulting numbers has been collected and stored in newMessageInt.
Visibility: Private
*/
    private void addKeyMessageD(){
        for(int i = 0 ; i < messageInt.size();i++){
            int temp = messageInt.get(i) - keys.get(i);
            if (temp < 1) temp = (temp + 26);
            newMessageInt.add(temp);
        }
    
    }
        /**
Prototype: private void addKeyString()
Description: Converts the numbers back to letters.
Precondition(s): An object of this class must have been created and encrypt() or decrypt() called.
Postcondition(s): All integers would have been converted to String and concatinated with outPuteMessage.
Visibility: Public
*/
    private void addKeyString(){
        for(int i = 0; i < newMessageInt.size(); i++){
            newMessageString.add(inverseAlphabet.get(newMessageInt.get(i)).toString());
            outPutMessage = outPutMessage + newMessageString.get(i);
        }
    }
     /**
Prototype: public void populateCards()
Description: A scanner object will go into key.data file and store all values into and ArrayList cards. 
Precondition(s): SolitairEncryption object created and a valid simulated deck of card values exist in a key.data file in
* the projects local directory.
Postcondition(s): An arrayList cards has been populated with all data from key.data file.
Visibility: Public
*/   
    public void populateCards(){
        File file = new File("key.data");
        try{
            scanner = new Scanner(file);
        }
        catch(FileNotFoundException e){
            System.out.println("No key.data file found");
        
        }
        while(scanner.hasNextLine()){
           cards.add(scanner.nextLine());
       }
        scanner.close();
    
    }
        /**
Prototype: private void getKeyArray()
Description: Creates an array of all keystream numbers.
Precondition(s): PopulateCards() must have been run and encrypt() or decrypt() must have been called.
Postcondition(s):An array of size messageInt.size() with integers received from solitareKey() will be stored.
Visibility: Private
*/
    private void getKeyArray(){
        for(int i = 0; i < messageInt.size(); i++){
               keys.add(solitareKey());
        }
    }
        /**
Prototype: private int solitareKey();
Description: Creates the Keystream number to begin letter encryption.
Precondition(s): PopulateCards() must have been run and encrypt() or decrypt() must have been called.
Postcondition(s): An integer between 0 and 26 will be returned.
Visibility: Private
*/
    private int solitareKey(){
        /*
        Find the A joker. Move it one card down in the deck (if possible). 
        Otherwise if the A joker was found on the bottom card of the deck, 
        move it so that it is just below the top card of the deck.
        */
        int AJindex = 0; // Store Index of the A Joker
        for(int i = 0; i < cards.size();i++){
            if(cards.get(i).equals("JA")){
                if(i == 54){ 
                   cards.remove(54);
                   cards.add(1,"JA");
                   AJindex = 1;
                   break;
                }
                else{
                    Collections.swap(cards,i+1,i);
                    AJindex = i+1;
                    break;
                }
            }
        }
        /*
        Find the B joker. Move it two cards down in the deck, assuming that the deck is a loop. I. e., 
        if the B joker is the bottom card of the deck, move the B joker to just below the second card 
        from the top of the deck. If the B joker is one up from the bottom card, the move the B joker 
        so that it is just below the top card of the deck. If the B joker is two up from the bottom 
        card, it becomes the top card.
        */
        int BJindex = 0; //Store Index of the B Joker
            for(int i = 0; i < cards.size();i++){
            if(cards.get(i).equals("JB")){
                if(i == 54){ 
                   cards.remove(54);
                   cards.add(2,"JB");
                   BJindex = 2;
                   break;
                }
                else if(i == 53){
                    cards.remove(53);
                    cards.add(1,"JB");
                    BJindex = 1;
                    break;
                }
                else if(i == 52){
                    cards.remove(52);
                    cards.add(0,"JB");
                    BJindex = 0;
                    break;
                }
                else{
                    Collections.swap(cards,i+2,i);
                    BJindex = i+2;
                    break;
                }
            }
        }
            /*
            Perform a triple cut. Swap the cards above the joker nearest to the top
            of the deck with the cards below the joker closest to the bottom of the 
            deck. The jokers and the cards between them don't move.
            */
            List newList = new ArrayList<String>();
            if(AJindex < BJindex){
            
                newList.addAll(cards.subList(BJindex+1, 54));
                newList.addAll(cards.subList(AJindex, BJindex+1));
                newList.addAll(cards.subList(0, AJindex));
            
            }
            else{
                newList.addAll(cards.subList(AJindex+1, 54));
                newList.addAll(cards.subList(BJindex, AJindex+1));
                newList.addAll(cards.subList(0, BJindex));
            
            }
            /*
            Perform a count cut. 
            First, look at the bottom card and convert it into a number from 1 through 53.
            Converting the card to a number requires that you use the bridge order of suits: clubs, diamonds, hearts, and spades. 
            If the card is a club, it is the value shown [note: Ace=1, Jack=11, Queen=12, King=13]. If the card is a 
            diamond, it is the face value plus 13. If it is a heart, it is the face value plus 26. If it is a spade, 
            it is the face value plus 39. Either joker is a 53.
            A deck with a joker as the bottom card will remain unchanged. If the card on the bottom is not a joker, count down 
            from the top card to the card in the location given by the number calculated from the bottom card. The 
            first card (top card) is location 1, the second card from the top is location 2, etc. Cut after the card 
            that you counted down to, leaving the bottom card on the bottom.
            */
            cards  = newList;
            int count = SuitCardValue(53); // Convert bottom card to a number

            List newList2 = new ArrayList<String>();
            newList2.addAll(cards.subList(count+1,53));
            newList2.addAll(cards.subList(0, count+1));
            newList2.add(53, cards.get(53));
            cards = newList2;
            
            /*
            Find the output card. To do this, look at the top card. Convert it into a number 
            from 1 through 53 in the same manner as step 4. Count down that many cards. 
            (Count the top card as number one.) If you hit a joker, start over again with step 1. 
            If the card you identified is not a joker, it is the first output 
            card, i. e. the card that will be converted to a keystream number. Note that this 
            step does not modify the state of the deck.
            */
               count = 0;
               count  = SuitCardValue(0);
               if (count == 53){
                   solitareKey();
               }
             /*
               Convert the output card to a number. As in steps 4 and 5, use the bridge suits to order them. 
               From lowest to highest, we have clubs, diamonds, hearts, and spades. A­clubs through K­clubs is 1 through 13, A­diamonds 
               through K­diamonds is 14 though 26, A­hearts through K­hearts is 1 through 13, and A­spades 
               through K­spades is 14 through 26.  
             */
             if(cards.get(count).contains("D") || cards.get(count).contains("S") )  {
                return FaceCardValue(count) + 13;
             
             }
             else if(cards.get(count).contains("C") || cards.get(count).contains("H")){
                 return FaceCardValue(count);
             }
             return 0;
    }
        
    
    /**
Prototype: private int SuitCardValue(int index);
Description: Takes in a given index and looks up the card, it then returns the suit value for that card.
Precondition(s): PopulateCards() has been run and Index between 0 and 54 passed
Postcondition(s): Integer value of the card suit along with the face card value will be returned.
Visibility: Private
*/
    private int SuitCardValue(int index){
        int count = 0;
                if(cards.get(index).contains("D")){
                count = count + 13;
                count = count + FaceCardValue(index);    
                        }
            else if(cards.get(index).contains("H")){ 
                count = count + 26;
                count = count + FaceCardValue(index); }
            else if(cards.get(index).contains("S")){ 
                count = count + 39;
                count = count + FaceCardValue(index);
            }
            else if(cards.get(index) == "JA" || cards.get(index) == "JB") count = 53;
            else count = FaceCardValue(index);
         return count;
    }
        /**
Prototype: private int FaceCardValue(int index);
Description: Takes in a given index and looks up that card, it then returns the integer value on the card.
Precondition(s): PopulateCards() has been run and Index between 0 and 54 passed.
Postcondition(s): Integer value of the card will be returned based on specified face value.
Visibility: Private
*/
    private int FaceCardValue(int index){
        char temp = cards.get(index).charAt(1);
        String stemp = Character.toString(temp);
        if (stemp.equals("J")){
            return 11;
        }
        else if (stemp.equals("A")){
            return 1;
        }
       else if (stemp.equals("Q")){
            return 12;
        }
       else if (stemp.equals("K")){
            return 13;
        }
       else if (stemp.equals("T")){
           return 10; 
       }
       return Character.getNumericValue(temp);
    
        
    }
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
}



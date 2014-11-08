/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author Teri
 */
public class SolitairEncryption {

    String OrigMessage;
    String EncryptedMessage;
    ArrayList<String> newm = new ArrayList<>();
    ArrayList<Integer> keys;
    ArrayList<Integer> messageInt;
    ArrayList<Integer> newMessageInt;
    ArrayList<String> newMessageString;
    private List<String> cards = new ArrayList<>();
    public Map<String,Integer> alphabet;
    public Map inverseAlphabet;
    private Scanner scanner;
    Map suits  = new HashMap();
    String outPutMessage;

    
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
        suits.put("A",1);suits.put("J",11);suits.put("Q",12);suits.put("K",13);suits.put("D",13);suits.put("H",26);suits.put("S",39);

        

    }
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
    private void toPlainText(){
        EncryptedMessage = OrigMessage.replaceAll("\\W", "");
        EncryptedMessage = EncryptedMessage.toUpperCase();
        
    }
    private void toNumbers(){
        char[] tempChar = new char[EncryptedMessage.length()];
        tempChar = EncryptedMessage.toCharArray();
        //System.out.println(tempChar.length);
        for(char a:tempChar){
            
            messageInt.add(alphabet.get(Character.toString(a)));
        }
        
        }
    //subtract before converting to string
    private void addKeyMessage(){
        for(int i = 0 ; i < messageInt.size();i++){
            
            int temp = messageInt.get(i) + keys.get(i);
            if (temp > 26) temp = (temp - 26);
            
            newMessageInt.add(temp);
        }
        
    }
    //subtract before converting to string
    private void addKeyMessageD(){
        for(int i = 0 ; i < messageInt.size();i++){
            int temp = messageInt.get(i) - keys.get(i);
            if (temp < 1) temp = (temp + 26);
            newMessageInt.add(temp);
        }
    
    }
    //Change int to string. last step
    private void addKeyString(){
        for(int i = 0; i < newMessageInt.size(); i++){;
         newMessageString.add(inverseAlphabet.get(newMessageInt.get(i)).toString());
           outPutMessage = outPutMessage + newMessageString.get(i);
           
        }
        //System.out.println(outPutMessage);
    }
    
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
    private void getKeyArray(){
        for(int i = 0; i < messageInt.size(); i++){
               keys.add(solitareKey());
        
        }
        
    
    }
    private int solitareKey(){
        //Move the AJ
        int AJindex = 0;
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
        //Move the BJ
        int BJindex = 0;
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
         /*  for(int i = 0; i < cards.size();i++){
               System.out.println(cards.get(i));
           }
            System.out.println(cards.size());
            System.out.println("\n" );  */
            //Do a Triple Cut
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
            //Peform a CountCut
            cards  = newList;
            int count = SuitCardValue(53);

            List newList2 = new ArrayList<String>();
               newList2.addAll(cards.subList(count+1,53));
               newList2.addAll(cards.subList(0, count+1));
               newList2.add(53, cards.get(53));
               cards = newList2;
                
            
         // 
               count = 0;
               count  = SuitCardValue(0);
               if (count == 53){
                   solitareKey();
               }
              
            /*  for(int i = 0; i < cards.size();i++){
               System.out.println(cards.get(i));
           }
           System.out.println(cards.size());
            System.out.println("\n" );  */
             if(cards.get(count).contains("D") || cards.get(count).contains("S") )  {
                return FaceCardValue(count) + 13;
             
             }
             else if(cards.get(count).contains("C") || cards.get(count).contains("H")){
                 return FaceCardValue(count);
             }
             return 0;
    }
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
        SolitairEncryption encrypt = new SolitairEncryption();
        System.out.println(encrypt.encrypt(" a long message once"));
        SolitairEncryption decrypt = new SolitairEncryption();
        System.out.println(decrypt.decrypt("OHECCUZZV"));
        
    }
}



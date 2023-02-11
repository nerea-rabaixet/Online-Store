/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;
import java.util.LinkedList;

/**
 *
 * @author Hey
 */
public class Seller extends User{
    private String accountNumber;
    private LinkedList <Item> soldItems;
    private LinkedList <Item> availableItems;
    
    public Seller(String n, String id,String p, String a, LinkedList<Item> avaliableItems){
        super(n,id,p);
        accountNumber = a;
        soldItems = new LinkedList<>();
        this.availableItems = avaliableItems;
    }
    public LinkedList<Item> getAvailableItems(){
        return availableItems;
    }
    
    public boolean isInAvalItems(Item i){ 
        
        int cout = 0;
        int len = availableItems.size();
        while(cout < len){
            if (availableItems.get(cout).getName().equals(i.getName())){
                return true;
            }
            cout++;
        }
        return false;
    }
    
    public void sell(Item i){ // ET DONA UN ITEM I LI DONES DINERS  
        //if i is in avaliableItems then remove the quantity (-) and add those to soldItems
        //if (isInAvalItems)
        
        if(deposit(i.getPrice())){
            if(isInAvalItems(i)){
                availableItems.remove(i);
                soldItems.add(i);
            }
        }
              
    }
    
    public LinkedList <Item> getSoldItems(){
        return soldItems;
    }
    
    public void addAvailableItem(Item i){
        availableItems.add(i);
    }
    private boolean deposit(double price){
        //segons el profe!!
        return true;
    }

}

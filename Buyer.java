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
public class Buyer extends User{
    private String accountNumber;
    private LinkedList <Item> boughtItems;
    
    public Buyer(String n, String id,String p, String a){
        super(n,id,p);
        accountNumber = a;
        boughtItems = new LinkedList<>();
    }
    
    public LinkedList<Item> getBoughtItems(){
        return boughtItems;
    }
    
     public void buy(Item i){
        if(pay(i.getCost())){
            if (i.getQuant() <= i.getRemainingQuant()){
                boughtItems.add(i);
                double a = i.getRemainingQuant() - i.getQuant();
                i.setRemainingQuant((int) a);
            }
        }
    }
    
    public boolean pay(double price){
        return true;
    }
}


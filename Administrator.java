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

public class Administrator extends User {
    
    public Administrator(String n, String id,String p){
        super(n,id,p);
    }
    public boolean expel(LinkedList <User> l,User u){
        if(l.remove(u)){
            return true;
        }
        return false;
    }
    public boolean manageAuction(AuctionItem a,int[] date){
        if(a.frozen(date)){
            return true;
        }
        return false;
    }
    public void printStock(LinkedList<AuctionItem> items){
        for(int i=0;i<items.size();i++){
            AuctionItem it = items.get(i);
            System.out.println("Name of the item: " + it.getName()+ ", minimum price to retrieve: " + it.getCost());            
        }
    }
}
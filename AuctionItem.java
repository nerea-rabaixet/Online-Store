package onlinestore;

import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Hey
 */
public class AuctionItem extends Item {
    private static final double fee = 5.00; // EUROS
    private static final double commision = 5/100; // PERCENTAGE
    private double currentPrice;
    private Buyer bidder;
    private int deadline[];
    
    public AuctionItem(String n, String t, double[] s, double c, double startingPrice,int d[]) {
        super(n, t, s, c);
        currentPrice = startingPrice;
        deadline = d;       
    }
    public double getPrice(){
        return currentPrice;
    }
    public double calculateProfit(){
        double profit = (currentPrice+fee)*(1+commision)-getCost();
        return profit;
    }
    public void makeBid(Buyer buyer, double p){
        if (!(p < currentPrice)){
            bidder = buyer;
            currentPrice = p;
        }
    }
    public boolean frozen(int d[]){
        /* if(d < deadline) then false else true; */
        /* d consists on day,month,year in this order */
        if (d[2] < deadline[2]) return false;
        else if (d[1] < deadline[1]) return false;
        else if (d[0] < deadline[0]) return false;
        return true;
    }
    public Buyer getBuyer(){
        return bidder;
    }
    public int[] getDeadline(){
        return deadline;
    }
    
}

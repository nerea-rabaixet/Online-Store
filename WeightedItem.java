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
public class WeightedItem extends Item {
    private double pricePerWeight;
    private double weight;
    private double weightRemaining;
    
    public WeightedItem(String n, double w){
        super(n);
        weight = w;
    }
    
    public WeightedItem(String n, String t, double s[],double c, double wprice, double w){
        super(n,t,s,c);
        pricePerWeight = wprice;
        weight = w;
    }
    public double getPrice(){
        return pricePerWeight*weight;
    }
    public double getQuant(){
        return weight;
    }
    
    public double calculateProfit(){
        return getPrice()-super.getCost();
    }
    public double sell(double w){
        return weightRemaining; ///ni putissima idea nomes poso per posar
    }
}

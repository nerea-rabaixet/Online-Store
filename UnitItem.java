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
public class UnitItem extends Item {
    private double unitPrice;
    private int quantity;
    private int quantityRemaining;
    
    public UnitItem(String n, int q){
        super(n);
        quantity = q;
    }
    
    public UnitItem(String n, String t, double s[], double c, double unprice, int q){
        super(n,t,s,c);
        unitPrice = unprice;
        quantity = q;
        quantityRemaining = q;
    }
    public double getPrice(){
        return unitPrice * quantity;
    }
    public double getQuant(){
        return quantity;
    }
    public double getRemainingQuant(){
        return quantityRemaining;
    }
    public void setRemainingQuant(int q){
        quantityRemaining = q;
    }
    
    public double calculateProfit(){
        return (getPrice()-super.getCost());//MALLLLLL NOMES XK NO DONI ERROR
    }
    public double sell(int q){
        if(q<=quantityRemaining){
            quantityRemaining-= q;
            return unitPrice*q;
        }
        return 0.0;//hauria de returnar k no es pot vendre x tant el preu serà 0.0 
    }
}
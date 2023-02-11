package onlinestore;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;


public class Item {
    private String name;
    private String type;
    private double size[] = new double[3];
    private double cost;
    private Package pack;
    
    public Item(String n){
        name = n;
    }
    
    public Item(String n, String t, double s[],double c){//s[3]
        name = n;
        type = t;
        size = s;
        cost = c;
        pack = assignBestPackage();
        
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public double[] getSize(){
        return size; //ns si tota
    }
    public double getCost(){
        return cost;
    }
    public Package getPackage(){
        return pack;
    }
    
    public void setName(String n){
        name = n;
    }
    public void setType(String t){
        type = t;
    }
    public void setSize(double s[]){
        size = s; //ns si tota
    }
    public void setCost(double c){
        cost = c;
    }
    
    public Package assignBestPackage(){
        /*
        boolean condition = size[2] < 3;
        
        int i = 0;
        if (lp.size() != 0) {
            while(lp.get(i) != null){

                pack = lp.get(i);
                Box box = (Box) pack;
                Envelope env = (Envelope) pack;

                if (box.isSuitable(size) && (condition)) lp.add(box);
                else if (env.isSuitable(size) && !(condition)) lp.add(env);
                else System.out.println("Error, no package found.");

                i++;
            }
        }
*/      
                boolean condition = (int) size[2] >=  3;
                
               
                /*Box box = (Box) pack;
                Envelope env = (Envelope) pack;*/
                Box box = new Box((int) size[0], (int) size[1], (int) size[2]);
                Envelope env = new Envelope((int)size[0],(int)size[1],"New_envelope");
                   // BOX TINDRA WIDTH HEIGHT I DEPTH DE LA CAIXA GUANYADORA
                if (box.isSuitable(size) && (condition)) return box;
                else if (env.isSuitable(size) && !(condition)) return env;
                else System.out.println("Error, no package found."); return null;
        
    }
    public double getPrice(){
        return cost;
    }
    public double calculateProfit(){
        return cost;
    }
    public double getQuant(){
        return 0;
    }
    public double getRemainingQuant(){
        return 0;
    }
    public void setRemainingQuant(int q){
        
    }
    
}

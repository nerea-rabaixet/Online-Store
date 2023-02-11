/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

/**
 *
 * @author Hey
 */
public class Envelope extends Package{
    
    private String name;
    public Envelope(int w, int h, String n){
        super(w,h);
        name = n;
    }
    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }
    public int getDepth(){
        return 0;
    }
    
    public boolean isSuitable(double size[]){//[2]
        int env_model_1[] = {7,7};
        int env_model_2[] = {5,5};
        int env_model_3[] = {3,3};
        
        int env_models[][] = {env_model_1,env_model_2,env_model_3};
        
        for (int i = 0; i < 3; i++){
            if ((size[0] <= env_models[i][0]) && 
                (size[1] <= env_models[i][1])){
                setWidth(env_models[i][0]);
                setHeight(env_models[i][1]);
                return true;
            }
        }
        return false;
    }
    
}


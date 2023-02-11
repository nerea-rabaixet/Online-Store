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
public class Box extends Package {
    private int depth;
    
    public Box(int w, int h, int d){
        super(w,h);
        depth = d;
    }
    
    public int getDepth(){
        return depth;
    }
    public void setDepth(int d){
        depth = d;
    }
    public boolean isSuitable(double size[]){ // A L'HORA DE PASSAR-LI HEM DE FER int size[] = new int [3] i li passem size.
        int box_model_1[] = {7,7,7};
        int box_model_2[] = {5,5,5};
        int box_model_3[] = {3,3,3};
        
        int box_models[][] = {box_model_3,box_model_2,box_model_1};
        
        for (int i = 0; i < 3; i++){
            if ((size[0] <= box_models[i][0]) && 
                (size[1] <= box_models[i][1]) &&
                (size[2] <= box_models[i][2])){
                setWidth(box_models[i][0]);
                setHeight(box_models[i][1]);
                depth = box_models[i][2];
                return true;
            }
        }
        return false;
    }
    
    
}
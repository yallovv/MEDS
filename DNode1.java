/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs210p2;

/**
 *
 * @author yousef
 */
public class DNode1 {
    String drugName ;
    String indicator;
    String target ;
    String classification ;
    DNode1 parent ;
    DNode1 left;
    DNode1 right;
    int size;

    public DNode1(String drugName, String indicator, String target, String classification, DNode1 parent, DNode1 left, DNode1 right) {
        this.drugName = drugName;
        this.indicator = indicator;
        this.target = target;
        this.classification = classification;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public DNode1() {
    }
    
    
     public static int compareTo(DNode1 d1,DNode1 d2) {
        if(d1.drugName.compareTo(d2.drugName)>0){
            return 1;}
        else if(d1.drugName.compareTo(d2.drugName)<0){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "DNode1{" + "drugName=" + drugName + ", indicator=" + indicator + ", target=" + target + ", classification=" + classification + ", parent=" + parent + ", left=" + left + ", right=" + right + ", size=" + size + '}';
    }

    
     
}

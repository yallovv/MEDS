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
public class DNode {
    
    String drugName;
    String indicator;
    String target;
    String classification;
    DNode next;

    public DNode(String drugName, String indicator, String target, String classification) {
        this.drugName = drugName;
        this.indicator = indicator;
        this.target = target;
        this.classification = classification;
    }
    public DNode(){
        
    }
    
    public int compareTo(DNode d1,DNode d2) {
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
        return "DNode{" + "drugName=" + drugName + ", indicator=" + indicator + ", target=" + target + ", classification=" + classification + '}';
    }
    
    
    
}

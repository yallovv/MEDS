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
public class DNode2 extends DNode1{
    
    String drugName;
    Node head;
    int size;

    public DNode2(String drugName, Node head, int size) {
        this.drugName = drugName;
        this.head = head;
        this.size = size;
    }

    public static int compareTo(DNode2 d1,DNode2 d2) {
        
    	if(d1.drugName.compareToIgnoreCase(d2.drugName)>0){
            return 1;}
    	else if(d1.drugName.compareToIgnoreCase(d2.drugName)<0){
            return -1;
    	}else{
            return 0;
    	}     	
    }

    @Override
    public String toString() {
        return "DNode2{" + "drugName=" + drugName + ", head=" + head + ", size=" + size + '}';
    }
    
    
    
    
}

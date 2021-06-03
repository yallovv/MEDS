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
public class Node {
    
    String indicator;
    String target;
    String classification;
    Node next;

    public Node(String indicator, String target, String classification, Node next) {
        this.indicator = indicator;
        this.target = target;
        this.classification = classification;
        this.next = next;
    }
    public static int compareTo(DNode d1,DNode d2) {
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
        return "Node{" + "indicator=" + indicator + ", target=" + target + ", classification=" + classification + ", next=" + next + '}';
    }
    
}

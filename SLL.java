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

public class SLL {
    
    DNode head;
    DNode next;
    int size;

    public SLL() {
        head=null;
        size=0;
    }

    public void insert(DNode t) {
        if (head == null) {
            head = t;
            t.next = null;
            size++;
            return;
        }

        //add the new node N to the head of the list
        t.next = head;
        head = t;
        size++;
        return;
    }

    @Override
    public String toString() {
        String str = "";
        DNode temp = head;
        
        while (temp != null) {
            str += ", " + temp;
            temp = temp.next;
        }
        return str;
    }
}




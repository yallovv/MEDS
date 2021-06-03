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


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DBST {

    DNode1 root;
    private int size;

    public int size() {
        return size;
    }

    public DBST() {
        root = null;
        size = 0;
    }

    public void readBST(String filename) throws FileNotFoundException {

            Scanner s = new Scanner(new File(filename));
            while (s.hasNext()) {
                

                String[] line = s.nextLine().split(",");
                
                if(line.length != 4){
                String name = line[0].toUpperCase();
                DNode1 drug = new DNode1(name,null,null,null,null,null,null);
                insert(drug);
            }
            else{
                String drugName = line[0];
                String indicator = line[1];
                String target = line[2];
                String classification = line[3];

                DNode1 drug = new DNode1(drugName, indicator, target, classification, null, null, null);

                insert(drug);

            }
              
        }
}
    public void insert(DNode1 D) {
        D.parent = D.left = D.right = null;
        if (root == null) {
            root = D;
            size++;
        } else {
            DNode1 temp = root;
            while (true) {
                if (DNode1.compareTo(D, temp) >= 0) {
                    if (temp.right == null) {
                        temp.right = D;
                        D.parent = temp;
                        size++;
                        break;
                    } else {
                        temp = temp.right;
                    }
                } else {
                    if (temp.left == null) {
                        temp.left = D;
                        D.parent = temp;
                        size++;
                        break;
                    } else {
                        temp = temp.left;
                    }
                }
            }
        }
    }

    public DNode1 search(String name) {

        DNode1 temp = root;
        while (temp != null) {
            if (temp.drugName.equalsIgnoreCase(name)) {
                return temp;
            } else if (name.compareToIgnoreCase(temp.drugName) > 0) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
            return temp;
        }
        return null;

    }

    
    public int countNode(DNode1 temp, String drugName) {

        if (temp == null) {
            return 0;
        }
        if (temp.drugName.equalsIgnoreCase(drugName)) {
            return 1 + countNode(temp.left, drugName) + countNode(temp.right, drugName);
        }
        return countNode(temp.left, drugName) + countNode(temp.right, drugName); 
 
    }
    
    public int numberOfRecords(String drugName){
        DNode1 temp = root;
        int count = countNode(root, drugName);
        
        return count;
    }
    
}




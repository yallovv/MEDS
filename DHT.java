/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs210p2;
//import java.io.BufferedReader;
//import java.io.File;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.util.Scanner;
/**
 *
 * @author yousef
 */
    

public class DHT {

    DNode [] HT;
    Node next;
    int size;

    public DHT() {
        
        HT = new DNode[27];
        for (int i = 0; i < HT.length ; i++) {
            HT[i] = new DNode();
        }
    }

    
    public void dhtFileRead(File filename) throws FileNotFoundException {
        
        Scanner In = new Scanner(filename);
        
        while (In.hasNext()) {
            
            String line = In.nextLine();
            String [] arr = line.split(",");
            
            if(arr.length != 4){
                String name = arr[0].toUpperCase();
                DNode drug = new DNode(name,null,null,null);
                insert(drug);
            }
            else{

            String name = arr[0].toUpperCase();
            String indicator = arr[1];
            String target = arr[2];
            String classification = arr[3];

            DNode drug = new DNode(name,indicator,target,classification);
                    
            insert(drug);
            }
        }
    }

    
    public int hash(String drgName){
        
        
        char ch = drgName.charAt(0);
        int index = (int) ch % 27; 
        
        return index;

    }
   
    
    public void insert(DNode N) {
        
        int index = hash(N.drugName);

        
        if(HT[index] == null){
            HT[index] = N;
            size++;
        }
        else if(HT[index] != null){
            N.next = HT[index];
            HT[index]= N;
            size++;
        }
        else
            throw new IllegalStateException("Could not insert");

    }
    
    public String search(String drgName) {
        
        int index = hash(drgName);
        DNode tmp = HT[index];
        int count = 0;
        
        for (DNode d: HT) {

                if(d.drugName != null){
                    if(d.drugName.equalsIgnoreCase(drgName))
                    count++;
                }
            
                if(d.next != null){

                    tmp = d;
                    while(tmp.next != null){

                        if(tmp.drugName.equalsIgnoreCase(drgName))
                            count++;
                            tmp = tmp.next;
                    }

                }
            }
        
//        if(HT[index] != null || tmp.next != null){
//            
//                if(tmp.drugName.compareTo(HT[index].drugName) == 0)
//                    count++;
//            
//            while(tmp.next != null){
//                
//                if(tmp.drugName.compareTo(drgName) == 0){
//                    //str += tmp.toString() + "\n";
//                    count++;                   
//                }
//                
//                tmp = tmp.next;
//            }
//
//        }
    return "Total records found for " + drgName + " " + count ;
    }
    
    
    @Override
    public String toString() {
        String str = "";
        
        for (DNode d: HT) {
            
            if(d.next != null){
            
                while(d.next != null){
                    str += d.toString() + "\n";
                    d = d.next;
                }
                    
            }
            str += d.toString() + "\n";
        }
        return str;
    }
}




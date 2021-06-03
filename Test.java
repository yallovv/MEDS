/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs210p2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author yousef
 */
public class Test {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        
        //File file = new File("sample1.text");
//        Java jar YourGroupID sample1.text <D> <usfda10000>
        System.out.println("Java jar <FileName.text> <D> <U>");
        
        Scanner In = new Scanner(System.in);
        String [] arr = In.nextLine().split(" ");
    
        String fileName = arr[3];
        int struct = Integer.parseInt(arr[4]);
        String drgName = arr[5];
        
        File file = new File(fileName);
        
        switch(struct){
            
            case 1:{
                
                DBST bst = new DBST();
                System.out.println("Reading file...");
                double time1 = System.currentTimeMillis();
                bst.readBST(fileName);
                double BSTread = (System.currentTimeMillis() - time1)/1000;
                System.out.println("Total Time to read data: "+ BSTread +" seconds");
                double BSTsearch = (System.currentTimeMillis() - time1)/1000;
                System.out.println("Starting search at time: " + BSTsearch +" seconds");
                System.out.println("Records found for " + drgName + " are " + bst.numberOfRecords(drgName));
                double endSearch = (System.currentTimeMillis() - time1)/1000;
                System.out.println("Ending search at time :" +  (endSearch - BSTsearch) + " seconds");
                System.out.println("Total time taken: " + (BSTsearch + BSTread) );
                
            }break;
            
            case 2:{
                DBSTLL bst = new DBSTLL();
                System.out.println("Reading file...");
                double time1 = System.currentTimeMillis();
                bst.DBSTLLFileRead(file);
                double DHTread = (System.currentTimeMillis() - time1)/1000;
                System.out.println("Total Time to read data: "+ DHTread +" seconds");
                double DHTsearch = (System.currentTimeMillis() - time1)/1000;
                System.out.println("Starting search at time: " + DHTsearch +" seconds");
                System.out.println(bst.search(drgName) );
                System.out.println("Ending search at time : " + DHTsearch +" seconds");
                System.out.println("Total time taken: " + (DHTsearch + DHTsearch) );
                
            }break;
           
            case 3:{
                
                DHT ht = new DHT();
                System.out.println("Reading file...");
                double time1 = System.currentTimeMillis();
                ht.dhtFileRead(file);
                double DHTread = (System.currentTimeMillis() - time1)/1000;
                System.out.println("Total Time to read data: "+ DHTread +" seconds");
                double DHTsearch = (System.currentTimeMillis() - time1)/1000;
                System.out.println("Starting search at time: " + DHTsearch +" seconds");
                System.out.println(ht.search(drgName) );
                System.out.println("Ending search at time : " + DHTsearch +" seconds");
                System.out.println("Total time taken: " + (DHTsearch + DHTsearch) );
                
            }
            
           
            
        }
        
        }
       
    }
    

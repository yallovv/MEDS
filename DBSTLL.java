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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LENOVO
 */
public class DBSTLL {
 	DNode2 root;
 	int totalSize;
        
        
        
	public DBSTLL() {
	}
        
        public void DBSTLLFileRead(File filename) throws FileNotFoundException {
        
        Scanner In = new Scanner(filename);
        
        while (In.hasNext()) {
            
            String line = In.nextLine();
            String [] arr = line.split(",");
            
            if(arr.length != 4){
                String name = arr[0].toUpperCase();
                Node info = new Node(null,null,null,null);
                DNode2 drug = new DNode2(name,info,0);
                insert(drug);
            }
            else{

            String name = arr[0].toUpperCase();
            String indicator = arr[1];
            String target = arr[2];
            String classification = arr[3];
            
            Node info = new Node(indicator,target,classification,null);
            
            DNode2 drug = new DNode2(name,info,0);
                    
            insert(drug);
            }
        }
    }
 	
 	public void insert(DNode2 newNode)
	{
    	if(this.root==null){
        	totalSize++;
        	root = newNode;
        	newNode.size++;
        	return;
    	}
    	DNode2 temp = root;
    	while(true) 
    	{
        	if(newNode.drugName.compareTo(temp.drugName) > 0)
        	{
            	//go right
            	if(temp.right==null)
            	{//insert N;
                	temp.right = newNode;
                	totalSize++;
                	newNode.parent = temp;
                	newNode.size++;
                	return;
            	}
            	temp = (DNode2) temp.right;
        	}
        	else if(newNode.drugName.compareTo(temp.drugName) < 0)
        	{
            	//go left!
            	if(temp.left==null)
            	{
                	//insert N;
                	temp.left = newNode;
                	totalSize++;
                	newNode.parent = temp;
                	newNode.size++;
                	return;
            	}
            	temp = (DNode2) temp.left;
        	} else{
            	newNode.head.next = temp.head;
            	temp.head = newNode.head;
            	temp.size++;
            	return;
        	}
    	}    	
	}
	
	public String search(String drugName){
    	if(root ==null){
        	return null;
    	}else{
        	DNode2 temp =root;
        	while(true){
            	if(drugName.compareTo(temp.drugName) > 0){
                	if(temp.right==null){
                	return null;
            	}
             	temp =  (DNode2) temp.right;  
            	}else if(drugName.compareTo(temp.drugName) < 0)
        	{
            	//go left
            	if(temp.left==null){
                	return null;
            	}
            	temp = (DNode2) temp.left;
        	}else if(drugName.compareTo(temp.drugName) ==0) //found it!
        	{
        	Node temph = temp.head;
        	while(temph != null){
        	System.out.println("this "+temph);
        	temph = temph.next;
        	}
        	return "Total Records found for"+ drugName +" is "+ temp.size;
        	}
            	}
        	}
    	}

    @Override
    public String toString() {
        return "DBSTLL{" + "root=" + root + ", size=" + totalSize + '}';
    }
}




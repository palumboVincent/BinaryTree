/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palumbo.test.database;

/**
 *
 * @author vp009
 */
public class BTree 
{
    
    
    Node root = null;
    
    public void addNode(int value)
    {
        Node temp = new Node();
        temp.myValue = value;
        
        if(root == null)
        {
            root = temp;
            return;
        }  
        else
        {
            recAddNode(temp, root);
        }
    }
    
    private void recAddNode(Node newNode, Node current) // recursive algorithm
    {
        if(newNode.myValue > current.myValue)
        {
            if(current.right == null)
            {
                current.right = newNode;
            }
            else
            {
                recAddNode(newNode, current.right);
            }            
        }
        
        else if(newNode.myValue < current.myValue)
        {
            if(current.left == null)
            {
                current.left = newNode;
            }
            else
            {
                recAddNode(newNode, current.left);
            }            
        }
    return;
    }  
    
    public void printMe()
    {
        System.out.println(recPrintMe(root));
    }
    
    private String recPrintMe(Node myNode)
    {
        String printString = "";
        
        if(myNode.left != null)
        {
            printString += recPrintMe(myNode.left);
        }
        printString +=  " " + myNode.myValue;
        
        if(myNode.right != null)
        {
            printString += recPrintMe(myNode.right);
        }
        
        return printString;    
    }
    
    public boolean search(int key )
     {
         boolean isItThere;
         isItThere = recSearch(key, root);
         return isItThere;
     }
     
     
     private boolean recSearch(int key, Node myNode)
     {
     
         boolean fromLeft, fromRight;
         fromLeft=false;
         fromRight=false;
         
         if(key == myNode.myValue)
         {
           return true;
         }
         else
         {
             if(myNode.left!= null)
             {
                 fromLeft = recSearch(key, myNode.left);
             }
             if(myNode.right != null)
             {
                 fromRight = recSearch(key, myNode.right);
             }
         }
         if(fromLeft || fromRight)
             return true;
         else
             return false;
             
     }
     public void count()
     {
         int leftCount, rightCount;
         System.out.println(" Root's value " + root.myValue);
         
         if(root.left != null)
         {
             leftCount = recCount(root.left);
             System.out.println(" Root.left count " + leftCount);
         }
         if(root.right != null)
         {
             rightCount = recCount(root.right);
             System.out.println(" Root.right count " + rightCount);
         }
     }
     
    private int recCount(Node myNode) // recursion count
    {
        int tempCount = 0;
        
        if(myNode.left != null)
        {
            tempCount += recCount(myNode.left);            
        }
        if(myNode.right != null)
        {
            tempCount += recCount(myNode.right);
        }
        tempCount++;
        System.out.println(" " +tempCount);
        return tempCount;
    }
    private Node rotateRight(Node myNode)  
    {
        Node temp1 = myNode;
        Node target = myNode.left;
        Node anchor = null;
        while (target.right != null) // used to see how far right taget can go
        {
            anchor = target;
            target = target.right;                        
        }
            
        anchor = target.left;
        
        target.left = myNode.left;
        target.right = myNode;
        return target;                
    }
    
    private Node rotateLeft(Node myNode)  
    {
        Node temp1 = myNode;
        Node target = myNode.right;
        Node anchor = null;
        while (target.left != null) // used to see how far left target can go
        {
            anchor = target;
            target = target.left;                        
        }
            
        anchor = target.right;
        
        target.right = myNode.right;
        target.left = myNode;
        return target;                
    }
    
    public void balance(Node myNode)
    {
        int leftCount = 0;
        int rightCount = 0;
        
        
    }
}

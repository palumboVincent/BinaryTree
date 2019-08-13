/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palumbo.test.database;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author vp009
 */

// this should be called PalumboSpring2018BTree, not PalumboTestDatabase. Im dumb
public class PalumboTestDatabase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BTree btree = new BTree();
        Random rnd = new Random();
        Scanner scn = new Scanner(System.in);
        
        for (int i = 0; i < 25; i++)
        {
            int rNum = rnd.nextInt(1000);
            System.out.println(rNum + " ");
            btree.addNode(rNum);
        }
        System.out.println("\n ");        
        System.out.println("Pick a number to search for:");
        int lookFor;
        lookFor = scn.nextInt();
        boolean result;
        result = btree.search(lookFor);
        if(result)
        {
            System.out.print("Value found! ");
        }
        else
        {
            System.out.print("Value NOT found! ");
        }
        System.out.println(" ");
        btree.printMe();
        System.out.println("\n ");

        btree.count();
        
    }
    
}

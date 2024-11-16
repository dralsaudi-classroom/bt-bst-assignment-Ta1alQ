package com.example.project;

import java.util.Stack;

public class TreeUser {
    public static <T> int countLeaves(BT<T> bt) {
        int count = 0;

        if (bt.empty()) {
            return count; // Return 0 if the tree is empty
        }

        Stack<BT<T>> stack = new Stack<>();
        bt.find(Relative.Root); // Set current to the root node
        stack.push(bt);

        BT<T> current = bt;
        
        while (!stack.isEmpty()) {
        	stack.pop();
            // Check if the current node is a leaf
            if (current.isLeaf()) {
                count++;
            } else {
               if(current.find(Relative.RightChild)) {
            	   stack.push(current);
            	   current.find(Relative.Parent);
               }
               if(current.find(Relative.LeftChild)) {
            	   if(current.isLeaf())
            		   count++;
               }
               else { 
            	   current = stack.pop();
               }
            }
        }
       

        
    
        System.out.println("TreeUser Says " + count);
        return count; // Return total count of leaves
    }
}

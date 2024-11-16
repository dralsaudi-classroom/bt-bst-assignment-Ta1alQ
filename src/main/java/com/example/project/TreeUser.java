package com.example.project;

public class TreeUser {
	
    public static <T> int countLeavesHelper(BT<T> bt) {
    	int sum = 0;
        if(bt.isLeaf())
            return 1;

        if(bt.find(Relative.LeftChild)){
            sum += countLeavesHelper(bt);
            bt.find(Relative.Parent);
        }

        if(bt.find(Relative.RightChild)){
            sum += countLeavesHelper(bt);
            bt.find(Relative.Parent);
        }

        return sum;

    }
    
    public static <T> int countLeaves(BT<T> bt) {
        if(bt.empty())
            return 0;

        bt.find(Relative.Root);

        return countLeavesHelper(bt);
    }
}
import com.sun.source.tree.BinaryTree;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class test {
    //write a function that Given a file and a char c, count the number of times that c appear in the file.
    public static int countChar(String path, char c) throws IOException {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    //Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
    //
    //The following rules define a valid string:
    //
    //Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    //Any right parenthesis ')' must have a corresponding left parenthesis '('.
    //Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    //'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
    public static boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left.push(i);
            } else if (s.charAt(i) == '*') {
                star.push(i);
            } else {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }
        while (!left.isEmpty() && !star.isEmpty()) {
            if (left.pop() > star.pop()) {
                return false;
            }
        }
        return left.isEmpty();
    }

    //a function that checks Check whether a binary tree is a full binary tree or not
    public static boolean isFullTree(Nodee root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            return isFullTree(root.left) && isFullTree(root.right);
        }
        return false;
    }








    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //Given a file and a char c, count the number of times that c appear in the file.
        System.out.println(countChar("src\\Hi.txt", 'a'));
        //Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
        System.out.println(checkValidString("(*))"));
        //Check whether a binary tree is a full binary tree or not
        BinaryTreee tree = new BinaryTreee();
        tree.root = new Nodee(10);
        tree.root.left = new Nodee(20);
        tree.root.right = new Nodee(30);
        tree.root.left.left = new Nodee(40);
        tree.root.left.right = new Nodee(50);
        tree.root.right.right = new Nodee(60);
        if (isFullTree(tree.root)) {
            System.out.println("The Binary tree is full");
        } else {
            System.out.println("The Binary tree is not full");
        }
    }
}

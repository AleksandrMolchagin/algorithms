import java.util.PriorityQueue;
import java.util.Comparator;
/**
 *  Huffman's algorithm
 * 
 *  A greedy algorithm that produces an optimal binary character code by constrictiong a binary tree corresponding to an optimal code.
 *  
 *  Time complexity: O(n)
 *
 *  @author Aleksandr Molchagin, based on https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/
 *  @version May 22, 2021
 */

/**
 *  Basic node structure.
 **/
class Node {
    char symbol;
    int frequency;
    double frequencyDouble;
    Node left;
    Node right;
}

/**
 *  Comparator class to compare nodes.
 **/
class NodeComparator implements Comparator<Node>{
    /**
     *  Returns difference between node's frequency. (FOR INT)
     **/
    public int compare(Node a, Node b){
        return a.frequency - b.frequency;
    }
    /**
     *  Returns difference between node's frequency. (FOR DOUBLE)
     **/
    public double compare(Node a, Node b){
        return a.frequencyDouble - b.frequencyDouble;
    }
}

public class Huffman {
    /**
     *  Function to print nodes and their codes.
     * 
     *  @param  root - a node
     *  @param  s - a string with new code
     **/
    public static void printNodesCodes(Node root, String s){
        //check if there is no left and right nodes attached to the give one, and if the symbol is a character 
        if (root.left == null && root.right == null && Character.isLetter(root.symbol)) {
            System.out.println("\t\t"+root.symbol + ":" + s);
            return;
        }
        //recursive calls to print left and right sub-tree of the tree
        printNodesCodes(root.left, s + "0");
        printNodesCodes(root.right, s + "1");
    }
    /**
     *    The Huffman algorithm for frequency in integers.
     *    @param array - array of characters (symbols)
     *    @param frequency - array of integers with frequencies of symbols above
     **/
    public static void HuffmanWithIntFreq(char[] array, int[]frequency){
        //Create a prioroty queue for exercise 26
        PriorityQueue<Node> q = new PriorityQueue<Node>(array.length, new NodeComparator());
        //Initialize all nodes
        for (int i = 0; i < array.length; i++){
            Node node = new Node();
            node.symbol = array[i];
            node.frequency = frequency[i];
            node.frequencyDouble = -1.2345;
            node.left = null;
            node.right = null;
            q.add(node);
        }
        //Root node
        Node root = null;

        while (q.size() > 1){
            //First minimum node
            Node a = q.peek();
            q.poll();
            //Second minimum node
            Node b = q.peek();
            q.poll();

            //A central node which frequency is equal to the frequancies of the two minimum nodes above
            Node centralNode = new Node();
            centralNode.frequency = a.frequency + b.frequency;
            centralNode.frequencyDouble = -1.2345;
            centralNode.symbol = '-';

            //Make given nodes as children of a new node
            centralNode.left = a;
            centralNode.right = b;

            //Marking new node as a root node
            root = centralNode;
            q.add(centralNode);
        }
        printNodesCodes(root, "");
    }
    /**
     *    The Huffman algorithm for frequency in double.
     *    @param array - array of characters (symbols)
     *    @param frequency - array of double with frequencies of symbols above
     **/
    public static void HuffmanWithDoubleFreq(char[] array, double[]frequency){
        //Create a prioroty queue for exercise 26
        PriorityQueue<Node> q = new PriorityQueue<Node>(array.length, new NodeComparator());
        //Initialize all nodes
        for (int i = 0; i < array.length; i++){
            Node node = new Node();
            node.symbol = array[i];
            node.frequencyDouble = frequency[i];
            node.frequency = -1;
            node.left = null;
            node.right = null;
            q.add(node);
        }
        //Root node
        Node root = null;

        while (q.size() > 1){
            //First minimum node
            Node a = q.peek();
            q.poll();
            //Second minimum node
            Node b = q.peek();
            q.poll();

            //A central node which frequency is equal to the frequancies of the two minimum nodes above
            Node centralNode = new Node();
            centralNode.frequencyDouble = a.frequencyDouble + b.frequencyDouble;
            centralNode.symbol = '-';

            //Make given nodes as children of a new node
            centralNode.left = a;
            centralNode.right = b;

            //Marking new node as a root node
            root = centralNode;
            q.add(centralNode);
        }
        printNodesCodes(root, "");
    }
    /**
     *  The main function initiates execution of this program.
     *    @param    String[] args not used in this program
     *              (but main methods always need this parameter)
     **/
    public static void main(String[] args){
        System.out.print("\n\tWelcome to Huffman’s algorithm program. (Java)\n");

        System.out.print("\n\tExercise 26 from the book:\n\n");
        //Instance from exercise 26
        char[] array26 = {'A', 'B', 'I', 'M', 'S', 'X', 'Z'};
        int[] frequency26 = {12, 7, 18, 10, 9, 5, 2};
        HuffmanWithIntFreq(array26, frequency26);

        System.out.print("\n\tExercise 27 from the book:\n\n");
         //Instance from exercise 27
         char[] array27 = {'c', 'e', 'i', 'r', 's', 't', 'x'};
         double[] frequency27 = {0.11, 0.22, 0.16, 0.12, 0.15, 0.10, 0.14};
         HuffmanWithDoubleFreq(array27, frequency27);  

         System.out.print("\n\n\tProgram done.\n\n");

    }       
}
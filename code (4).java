import java.util.*;

public class Main {

    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    
    public static int max(Node node){
        int max = Integer.MIN_VALUE;
        
        
        for(Node child : node.children){
            int cm = max(child);
            
            max = Math.max(max,cm);
        }
        
        max = Math.max(node.data,max);
        return max;
        
    }


    public static void main(String[] args) {

        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1,
                     -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Stack<Node> st = new Stack<>();
        Node root = null;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (!st.isEmpty()) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

      
        int treeSize = max(root);
        System.out.println("max of the tree: " + treeSize);
    }
}

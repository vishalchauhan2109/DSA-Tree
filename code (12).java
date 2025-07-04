import java.util.*;

public class Main {

    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

 
    
    public static boolean search(Node node,int val){
        
        if(node.data == val){
            return true;
        }
        
        for(Node child : node.children){
            boolean s = search(child,val);
            
            if(s == true){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1,
                     30, 70, -1, 80, 110, -1, 120, -1, -1,
                     90, -1, -1, 40, 100, -1, -1, -1};

        Stack<Node> st = new Stack<>();
        Node root = null;

        for(int val : arr){
            if(val == -1){
                st.pop();
            } else {
                Node t = new Node();
                t.data = val;

                if(!st.isEmpty()){
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        // display(root);
        // oneline(root);
        System.out.print(search(root,1000));
        // display(root);
    }
}
import java.util.*;

public class Main {

    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    
    public static void level (Node node){
        Queue<Node> q = new ArrayDeque<>();
        
        Queue<Node> cq = new ArrayDeque<>();
        
        q.add(node);
        
        while(q.size() > 0){
            
            node = q.remove();
            System.out.print(node.data + "  ");
            
            for(Node child : node.children){
                cq.add(child);
                
            }
            
            if(q.size() == 0){
                q = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
       
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

      level(root);
      
    }
}
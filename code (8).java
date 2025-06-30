import java.util.*;

public class Main {

    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    
    public static void level (Node node){
        Stack<Node> q = new Stack<>();
        Stack<Node> cq = new Stack<>();
        int level = 0;
        q.push(node);
        
        while(q.size() > 0){
            
            node = q.pop();
            System.out.print(node.data + "  ");
            
            if(level%2 == 0){
                for(int i = 0; i < node.children.size(); i++){
                    Node child = node.children.get(i);
                    cq.push(child);
                }
            }else{
                for(int i = node.children.size()-1; i >= 0;  i--){
                    Node child = node.children.get(i);
                    cq.push(child);
                }
                
            }
            if(q.size() == 0){
                q = cq;
                cq = new Stack<>();
                level++;
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
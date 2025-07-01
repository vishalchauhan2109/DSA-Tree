import java.util.*;

public class Main {

    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
        
        Node(){
            
        }
        Node(int data){
            this.data = data;
        }
    }
    
    public static void level (Node node){
        Queue<Node> mq = new ArrayDeque<>();
       
        mq.add(node);
        mq.add(new Node(-1));
        while(mq.size() > 0){
            node = mq.remove();
            if(node.data  != -1){
                System.out.print(node.data + "  ");
             
            for(Node child : node.children){
                mq.add(child);
                
            }
                
               
            }
            else{
                
                if(mq.size() > 0){
                mq.add(new Node(-1));
                System.out.println();
                }
            
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






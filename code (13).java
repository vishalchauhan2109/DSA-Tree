import java.util.*;

public class Main {

    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    
       public static void display(Node node){ 
        String str = node.data + " -> ";
        for(Node child : node.children){
            str += child.data + " , ";
        }
        str += ".";
        System.out.println(str);

        for(Node child : node.children){
            display(child);
        }
    }
    
    public static void oneline(Node node){
        
        for(Node child : node.children){
            oneline(child);
        }
        
        while(node.children.size() > 1){
            
            Node lc = node.children.remove(node.children.size() - 1);
            Node sc = node.children.get(node.children.size() - 1);
            Node sct = getTail(sc);
            // System.out.println(sct.data);
            sct.children.add(lc);
            
        }
    }
    
    public static Node getTail(Node node){
        while(node.children.size() == 1){
            node = node.children.get(0);
        }
        return node;
        
    }
    public static void leafRemove(Node node){
        for(int i = node.children.size() - 1; i >= 0; i--){
            Node child = node.children.get(i);
            if(child.children.size() == 0){
                node.children.remove(child);
            }
        }
        for(Node child : node.children){
            leafRemove(child);
        }
        
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
        oneline(root);
        display(root);
    }
}
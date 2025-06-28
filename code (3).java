import java.util.*;

public class Main {
    
    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    

    
    static int size(Node node){
        int s = 0;
        
        for(Node child : node.children ){
            int cs  = size(child);
            s = s + cs;
            
        }
        s = s + 1;
        
        return s;
    }
    
  public static void main(String[] args) {
      

    int[] arr = {10 , 20 ,50 , -1 , 60 , -1, -1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
    
    Stack<Node> st = new Stack<>();
    Node root = null;
    for(int i = 0; i < arr.length; i++){
        if(arr[i] == -1){
            st.pop();
        }else{
            Node t = new Node();
            t.data = arr[i];
            
            if(st.size() > 0){
                st.peek().children.add(t);
            }else{
                root = t;
            }
            
            st.push(t);
            
        }
    }
    // display(root);
    int tree  = size(root);
    System.out.print("Size of tree is" + " " + tree);
    
  }
}








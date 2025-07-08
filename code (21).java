import java.util.Stack;
import java.util.Queue;
import java.util.*;
public class BinaryTree{
    
    static class Node{
        int data;
        Node left;
        Node right;
        
        Node (int data,Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    
    public static class Pair{
        Node node ;
        int state;
        
        Pair(Node node ,int state){
            this.node  = node ;
            this.state = state;
        }
    }
    
    public static void Display(Node node){
        if(node == null){
            return;
        }
        
        String str = " ";
        str += node.left == null? "." : node.left.data + "";
        str += "<-"+ node.data + "->";
        str += node.right == null? "." : node.right.data + "";
        
        System.out.println(str);
        
        Display(node.left);
        Display(node.right);
    }
    
     public static int size(Node node){
        if(node == null){
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);
        int ts = rs + ls + 1;
        
        return ts;
        
    }
    
    public static void level(Node node){
        Queue<Node> st = new ArrayDeque<>();
        st.add(node);
        
        while(st.size() > 0){
            
            int count  = st.size();
            
            for(int i = 0; i < count; i++){
                
                node = st.remove();
                System.out.println(node.data);
            
                if(node.left != null){
                    st.add(node.left);
                    
                }
                if(node.right != null){
                    st.add(node.right);
                    
                }
            }    
            System.out.println();
                
        }
        
    }
    
    
    public static int sum(Node node){
        if(node == null){
            return 0;
        }
        int lss = sum(node.left);
        int rss = sum(node.right);
        int ts = rss + lss + node.data;
        
        return ts;
        
    }
    
    public static int max(Node node){
        if(node == null){
            return 0;
        }
        int lss = max(node.left);
        int rss = max(node.right);
        int ts = Math.max(lss,rss);
        
        if(node.data > ts){
            return node.data;
        }else{
            return ts;   
        }
        
    }
    
    public static int height(Node node){
        if(node == null){
            return -1 ; // for edges
            // return 0   for nodes
        }
        int lh = height(node.left);
        int rh = height(node.right);
        int th = Math.max(lh,rh);
        
        return th + 1;
        
    }
    
    
    
    
   
    public static void main(String args[]){
        
        int []arr = {1,2,4,-1,-1,5,-1,-1,3,-1,10,-1,-1};
        
        
        Node root = new Node(arr[0],null,null);
        Pair rp = new Pair(root,1);
        Stack<Pair> st = new Stack<>();
        st.push(rp);
        int i = 0;
        while(st.size() > 0){
            Pair top = st.peek();
            
            if(top.state == 1){
                i++;
                
                if(arr[i] != -1){
                    
                    Node ln = new Node(arr[i],null,null);
                    top.node.left = ln;
                    
                    Pair lp = new Pair(ln,1);
                    st.push(lp);
                }else{
                    top.node.left = null;
                    
                }
                
                top.state++;
            }else if(top.state == 2){
                i++;
                if(arr[i] != -1){
                    
                    Node rn = new Node(arr[i],null,null);
                    top.node.right = rn;
                    
                    Pair rrp = new Pair(rn,1);
                    st.push(rrp);
                }else{
                    top.node.right = null;
                    
                }
                top.state++;
            }else{
                st.pop();
            }
        }
        // System.out.println(size(root));
        // System.out.println(sum(root));
        // System.out.println(max(root));
        // System.out.println(height(root));
        level(root);
       
    }
}






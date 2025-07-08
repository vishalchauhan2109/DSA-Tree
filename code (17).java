import java.util.Stack;

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
    
   
    public static void main(String args[]){
        
        int []arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        
        
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
        System.out.print(size(root));
       
    }
}






import java.util.*;

public class Main {

    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static ArrayList<Integer> PathToRoot(Node node ,int val){
        if(node.data == val){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }
        
        for(Node child: node.children){
            ArrayList<Integer> list = PathToRoot(child,val);
            
            if(list.size() > 0){
                list.add(node.data);
                return list;
            }
        }
        return new ArrayList<>();
    }
    
    public static int DistanceBtw2Nodes(Node node , int d1, int d2){
        ArrayList<Integer> list1 = PathToRoot(node , d1);
        ArrayList<Integer> list2 = PathToRoot(node , d2);
        
        
        int i = list1.size() -1;
        int j = list2.size() -1;
        while( i >= 0 && j >= 0 && list1.get(i) == list2.get(j)){
            i--;
            j--;
        }
        
        i++;
        j++;
        
        
        return i+j;
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
        // display(root);
        System.out.println(DistanceBtw2Nodes(root,50,110));
        
        
        
    }
}
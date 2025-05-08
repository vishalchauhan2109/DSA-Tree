import java.util.*;

public class StockSpan {
    public static int[] calculateSpan(int[] prices) {
        
        int []arr = new int[prices.length];
        
        Stack<Integer> st = new Stack<>();
        
        st.push(0);
        arr[0] = 1;
        
        for(int i = 1; i < prices.length; i++){
            while(st.size() > 0 && prices[st.peek()] < prices[i]){
                st.pop();
                
            }
            
            if( st.size() == 0){
                arr[i] = i + 1;
                
            }else{
                arr[i] = i - st.peek();
          
            }
            
            st.push(i);
        }
        return arr;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int[] arr = calculateSpan(prices);

        for (int s : arr) {
            System.out.print(s + " ");
        }
    }
}

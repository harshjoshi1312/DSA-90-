////     5                                       random-flip-matrix///


/*  
 * There is an m x n binary grid matrix with all the values set 0 initially.
 *  Design an algorithm to randomly pick an index (i, j) where matrix[i][j] == 0 and flips it to 1. 
 * All the indices (i, j) where matrix[i][j] == 0 should be equally likely to be returned.
 */




 class Solution {
    int i=0,j=0;
     int m=0;int n=0;

    public Solution(int m, int n) {
        this.m=m;
        this.n=n;
    }
    
    public int[] flip() {
        j++;
        if(j==n){
            j=0;
            i++;
        }
        if(i==m){
            i=0;
            j=0;
        }

             
        return new int[]{i,j};
        
    }
    
    public void reset() {
      
        
        
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
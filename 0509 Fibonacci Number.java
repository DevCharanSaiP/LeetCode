class Solution {
    public int fib(int n) {
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        int fT = 0;
        int sT = 1;

        for(int i=1; i<=n; i++){
            int tT = fT + sT;
            fT = sT;
            sT = tT;
        }
        return fT;
    }
}

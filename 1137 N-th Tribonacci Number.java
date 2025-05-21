class Solution {
    public int tribonacci(int n) {
        if(n==0){
            return 0;
        }else if(n==1 || n==2){
            return 1;
        }else{
            int fT = 0;
            int sT = 1;
            int tT = 1;

            for(int i=1; i<=n; i++){
                int fourT = fT+sT+tT;
                fT = sT;
                sT = tT;
                tT = fourT;
            }
            return fT;
        }


    }
}

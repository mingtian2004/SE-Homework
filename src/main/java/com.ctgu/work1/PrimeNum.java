package src.main.java.com.ctgu.work1;

public class PrimeNum {
    public static boolean isPrimeNum(int num){
        if (num <= 1) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;
        }
        double sqrt=Math.sqrt(num);
        for(int i=2;i<sqrt;i++){
            if (num%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        int count=0;
        for(int i=1;i<20001;i++){
            if(isPrimeNum(i)){
                System.out.print(i+" ");
                count++;
            }
            if (count==5){
                System.out.println();
                count=0;
            }
        }


    }
}

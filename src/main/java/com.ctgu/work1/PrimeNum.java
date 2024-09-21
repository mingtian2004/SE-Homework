package src.main.java.com.ctgu.work1;

public class PrimeNum {
    //判断是否为素数
    public static boolean isPrimeNum(int num){
        //1不是素数
        if (num <= 1) {
            return false;
        }
        //2，3直接返回是素数
        if (num == 2 || num == 3) {
            return true;
        }
        //求平方根
        double sqrt=Math.sqrt(num);
        for(int i=2;i<=sqrt;i++){
            if (num%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        //计数
        int count=0;
        for(int i=1;i<20001;i++){
            if(isPrimeNum(i)){
                System.out.print(i+" ");
                count++;
            }
            //每5个换行
            if (count==5){
                System.out.println();
                count=0;
            }
        }


    }
}

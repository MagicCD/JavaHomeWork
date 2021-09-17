package program.Java_06;

public class Test01 {
    public static void main(String[] args) {
        //传入被除数给 isPrime 判断是否是质数
        for (int i = 2; i < 100; i++) {
            //判断 被除数n 以及 被除数n+2 是否是孪生质数，是则输出
            if (isPrime(i) && isPrime(i + 2)) {
                System.out.println(i + ", " + (i + 2));
            }
        }
    }

    //判断是否是质数
    public static boolean isPrime(int n) {
        //for循环，i代表除数，n代表被除数，i < n代表除数永远小于被除数，除数从2开始一直到被除数n-1为止
        for(int i = 2; i < n; i++) {
            //判断能否被数字整除
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

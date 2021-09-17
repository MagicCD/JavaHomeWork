package program.Java_06;

public class Test02 {
    public static void main(String[] args) {
        //使用for循环遍历年份
        for(int i = 2011; i <= 2020; i++) {
            //判断闰年
            if (i % 4 == 0 && i % 100 != 0|| i % 400 == 0) {
                System.out.println(i);
            }
        }
    }
}

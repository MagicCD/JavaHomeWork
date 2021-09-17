package program.Java_06;

//导包
import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        //创建对象
        Scanner input = new Scanner(System.in);

        System.out.println("请输入要进行比较的数字个数：");
        //接收数据
        int i = input.nextInt();
        int[] userInput = new int[i];

        System.out.println("请输入要比较的整数：");
        //定义 j 来访问用户输入的数组下标，数组下标j < 数组元素个数i
        for (int j = 0; j < i; j++) {
            userInput[j] = input.nextInt();     //为数组的每个位置赋值
        }

        //初始化
        int max = userInput[0];
        int min = userInput[0];

        //定义 k 来访问数组元素下标对应的值，数组下标k < 数组元素个数i
        for (int k = 1; k < i; k++) {
            //判断：从下标 1号位 开始到 i-1号位，比较大小，把大/小的赋值给Max/Min
            if (max < userInput[k]) {
                max = userInput[k];
            }
            if (min > userInput[k]) {
                min = userInput[k];
            }
        }
        System.out.println("max = " + max + " , " + "min = " + min);
    }
}

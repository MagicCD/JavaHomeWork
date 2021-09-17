# Java 编程题思路





## 1. 求孪生质数

素数（质数）指的是不能被分解的数，除了 1和它本身 之外没有其他数能够整除。

如果 ==两个素数之差为2==，则这两个素数就是 ==孪生素数==，例如 3和5为孪生素数，5和7为孪生素数



<h3>需求:</h3>

找出1-100之间的所有孪生素数





<h3>解题思路:</h3>



参考：[孪生素数的解题思路](https://zhidao.baidu.com/question/1052271698327070859.html)



从判断是否是 素数 开始：

+ 先回忆怎么判断这个数字是否是 质数

+ 质数的特性是 ==除了 1和它本身 之外没有其他数能够整除==，那么要判断这个数是否是 质数

  则需要 把 `要判断的数 / 小于要判断的数的所有数字（从2开始）` 看结果是否等于0

  + 如果 等于0，则不是质数
  + 如果 等于0，则是质数



例如：要判断 5 是否是质数

1. `要判断的数 / 小于要判断的数的所有数字（从2开始）`

+ 也就是	5 / 2	5 / 3	5 / 4



2. 看取余的结果是否等于0

+ 我们很容易发现，5在我们逐一相除下没有一个余数等于0的，那么5就是质数



代码示例：

~~~java
for(int Divisor = 2; Divisor < Dividend; Divisor++)		//Divisor为除数，Dividend为被除数
{
    if(Dividend % Divisor == 0)
    {
        retrun false;
    }
}
return true;
~~~



+ 解决了如何判断质数的问题，我们就要着重于解决新概念：孪生素数

+ 概念：如果 ==两个素数之差为2==，则这两个素数就是 ==孪生素数==



思路：

1. 孪生素数 本质上是素数的延申，我们只要判断 ==素数+2== 是否也是素数
2. 然后对输出条件限定，满足 这个数是素数 且 素数+2 也是素数，方可输出这对孪生素数



示例：

~~~java
for(int Divisor = 2; Divisor < Dividend; Divisor++)		//Divisor为除数，Dividend为被除数
{
    if(Dividend % Divisor == 0)
    {
        retrun false;
    }
}
return true;

if(return true)
{
    System.out.println(Dividend + " , " + (Dividend + 2))
}
~~~





现在我们对功能进行细化，既然题目可以明确的分为 找素数 和 区分孪生素数 两部分

那么我们只需要定义一个 能判断素数和区分孪生素数的函数



判断质数的函数：

~~~java
//判断是否是质数
public static boolean isPrime(int Dividend) {
    //for循环，Divisor代表除数，Dividend代表被除数，Divisor < Dividend代表除数永远小于被除数
    //除数从 2 开始一直到 Dividend-1 为止
    for(int Divisor = 2; Divisor < Dividend; Divisor++) {
        //判断能否被数字整除
        if (Dividend % Divisor == 0) {
            return false;
        }
    }
    return true;
}
~~~



判断是否是孪生质数的函数：

~~~java
public static void main(String[] args) {
    //传入 被除数Dividend 给 isPrime 判断是否是质数
    for (int Dividend = 2; Dividend < 100; Dividend++) {
        //判断 被除数Dividend 以及 被除数Dividend+2 是否是孪生质数，是则输出
        if (isPrime(Dividend) && isPrime(Dividend + 2)) {
            System.out.println(Dividend + ", " + (Dividend + 2));
        }
    }
}
~~~



完整代码：

~~~java
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
~~~











## 2. 找最大数和最小数





<h3>需求:</h3>

编写一个程序，用户输入若干整数，试找出其中的最大数和最小数





<h3>解题思路:</h3>

1. 用户输入若干整数我们应该怎么存储？    ---数组

2. 我们应该怎么规定用户输入的数组长度？    ---先让用户输入 需要输入的数字规模

3. 用户怎么给数组的元素赋值？          ---使用for循环遍历数组下标，并且做赋值操作

4. 怎么选出最大值和最小值？      ---遍历数组，把大的值赋值给max，小的赋值给min
//by kaian

import java.util.Scanner;

public class FindBiggest
{
    public double[] getDoubArr(Scanner in)
    {
        System.out.println("请以空格为间隔符,以回车符为终止符,输入待处理的数组:");
        String str= in.nextLine();
        if(str==null||"".equals(str)) /*注意这里不用使用"==",因为==是引用比较,两个空字符的字符串地址很可能不同*/
        {
            System.out.println("输入的数组为空数组，即将退出此历程!");
            System.exit(1);
        }
        //将输入转化处理为双精度浮点数数组,并返回
        String[] strArr = str.split(" ");
        double[] doubArr = new double[strArr.length];
        for(int i=0;i<strArr.length;i++)
        {
            doubArr[i]=Double.valueOf(strArr[i]);
        }
        return doubArr;
    }

    public void outIndexOfBiggest(double[] doubArr)
    {
        //遍历寻找最大值,并记录下标
        double biggest=-0x7fffffff;
        int indexOfBiggest=-1;
        for(int i=0;i<doubArr.length;i++)
        {
            if(doubArr[i]>biggest) {
                biggest = doubArr[i];
                indexOfBiggest = i;
            }
        }
        System.out.println("最大值的最小索引为:"+indexOfBiggest);
        //System.out.println("即Array[indexOfArray]="+doubArr[indexOfBiggest]+"为输入数组中的最大值。");
    }

    public static void main(String[] args)
    {
        FindBiggest find = new FindBiggest();
        //java.util.Scanner 是 Java5 的新特征，我们可以通过 Scanner 类来获取用户的输入
        Scanner in = new Scanner(System.in);
        double[] retDoubArr = find.getDoubArr(in);
        find.outIndexOfBiggest(retDoubArr);
        in.close();
    }
}
 
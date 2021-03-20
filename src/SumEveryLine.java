import java.util.Scanner;

public class SumEveryLine
{
    public static void main(String args[])
    {
        Scanner in =new Scanner(System.in);
        System.out.println("请输入你将输入的二维数组的行数：");
        int numOfLines = in.nextInt();
        in.nextLine();    //用于跳过换行符

        //对于用户指定输入行数为0时,退出
        if(numOfLines==0)
        {
            System.out.println("输入结束,即将退出...");
            System.exit(1);
        }

        //尽管设置intArr数组会增加大量空间复杂度,但是根据题意,这是必要的
        int BIGGEST_NUMBER_OF_COLUMNS=20;
        int[][] intArr= new int[numOfLines][BIGGEST_NUMBER_OF_COLUMNS]; /*假定二维数组的每行输入数都不会超过20个*/
        long sumOfEveryLine[]=new long[numOfLines];
        System.out.println("请在每行中输入二维数组中每行的数字:");
        for(int i=0;i<numOfLines;i++)
        {
            String strLine=in.nextLine();
            Scanner s=new Scanner(strLine);
            sumOfEveryLine[i]=0;
            String[] strArr=strLine.split(" ");
            for(int j=0;j<strArr.length;j++)
            {
                intArr[i][j]=Integer.valueOf(strArr[j]);
                sumOfEveryLine[i]+=Integer.valueOf(strArr[j]);
            }
        }

        //根据题意中"这一行号",当多行和同时最大时,我们输出最小行号
        long biggestSum = -0x7fffffff;
        int indexOfBiggestSum =-1;
        for(int i=0;i<numOfLines;i++)
        {
            if(sumOfEveryLine[i]>biggestSum)
            {
                indexOfBiggestSum=i;
                biggestSum=sumOfEveryLine[i];
            }
        }
        System.out.println("数字之和最大的最小行号为:"+indexOfBiggestSum);
        in.close();     /*记得关闭in*/
    }
}

import java.util.Scanner;

public class SortIO extends MergeSort
{
    public double[] getDoubArr(Scanner in)
    {
        //java.util.Scanner 是 Java5 的新特征，我们可以通过 Scanner 类来获取用户的输入
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

    public void outDoubArr(double[] inArr)
    {
        for(int i=0;i<inArr.length;i++)
            System.out.print(inArr[i]+" ");
        /*System.out.println(); 是最常用的输出语句，它会把括号里的内容转换成字符串输出到输出窗口（控制台），
        并且换行，当输出的是一个基本数据类型时，会自动转换成字符串，如果输出的是一个对象，会自动调用对象的toString()方法*/
    }

    public static void main(String[] args)
    {
        SortIO sort = new SortIO();
        Scanner in =new Scanner(System.in);
        double[] retDoubArr=sort.getDoubArr(in);

        System.out.println("输入输入'I'以进行插入排序,输入'E'以进行归并排序:");
        char choice = in.next().charAt(0);
        in.nextLine();
        in.close();

        if(choice=='I')
        {
            sort.insetSort(retDoubArr);
            sort.outDoubArr(retDoubArr);
        }
        else if(choice=='E')
        {
            sort.mergeSort(retDoubArr,0, retDoubArr.length-1);
            sort.outDoubArr(retDoubArr);
        }
        else
        {
            System.out.println("未检测到输入'I'或'M");
        }
    in.close();
    }
}

class InsertSort
{
    public void insetSort(double[] inArr)
    {
        for(int i=1;i<inArr.length;i++)
        {
            double temp = inArr[i];
            int j;
            for (j = i; j > 0 && inArr[j - 1] > temp; j--)
            {
                inArr[j] = inArr[j - 1];
            }
            inArr[j] = temp;
        }
    }

}

class MergeSort extends InsertSort
{
    public void mergeSort(double[] a,int start,int end)
    {
        //当子序列中仅有一个元素时结束递归
        if(start<end)
        {
            //划分子集,并对左右子序列分别进行递归排序
            int mid = (start+end)/2;
            mergeSort(a,start,mid);
            mergeSort(a,mid+1,end);
            merge(a,start,mid,end);
        }
    }

    public void merge(double[]a,int left,int mid,int right)
    {
        double[] tmp = new double[a.length];
        int p1=left,p2=mid+1,k=left;

        while(p1<=mid&&p2<=right)
        {
            if(a[p1]<=a[p2])
                tmp[k++]=a[p1++];
            else
                tmp[k++]=a[p2++];
        }
        //当其中仅有一个序列检测完后将另一序列直接加入
        while(p1<=mid)  tmp[k++]=a[p1++];
        while(p2<=right)    tmp[k++]=a[p2++];
        for(int i=left;i<=right;i++)
            a[i]=tmp[i];
    }
}
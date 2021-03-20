import javax.print.attribute.standard.NumberUp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VampireNumber
{
    //此方法的时间复杂度为O(n^3), 算法来自syml
    public static void main(String[] args)
    {
        System.out.println("4位下吸血鬼数字(无序)如下:");
        for(int p=10;p<100;p++)
            for(int q=p;q<100;q++)  /*q从p开始遍历,避免出现重复的数*/
                if(isVampireNumber(p,q))
                    System.out.println(p*q+" = "+p+" * "+q);
    }

    static boolean isVampireNumber(int p,int q)
    {
        int n=p*q;
        //先判断位数是否为4位
        if(!(1000<=n&&n<=9999))
            return false;
        //再判断4位数字中的各位数字是否满足吸血鬼数的要求
        List<Integer> NumList = new ArrayList<>();
        while(n>0)
        {
            NumList.add(n%10);
            n/=10;
        }
        List<Integer> FindList = new ArrayList<>();
        FindList.add(p%10);
        FindList.add(p/10);
        FindList.add(q%10);
        FindList.add(q/10);
        for(int i:FindList)
        {
            if(!NumList.contains(i))
                return false;
            else
                //为防止因重复数字而引起的错误,这里一定要移除此位数字
                NumList.remove(NumList.indexOf(i));
        }
        return true;
    }
}

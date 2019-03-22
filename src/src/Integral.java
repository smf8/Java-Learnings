import java.text.DecimalFormat;
import java.util.Scanner;

public class Integral {

    public static void main(String[] args)
    {
        Scanner inp = new Scanner(System.in);
        String input = inp.next(),res="";
        int maxFactor=0;
        boolean flag=true;
        String temp1="",temp2="";
        for (int i = 0; i < input.length()-1; i++)
        {
            if (input.charAt(i)=='x' || input.charAt(i+1)=='x')
                if (maxFactor==0)
                    maxFactor++;
            if (input.charAt(i)=='^')
            {
                int j=i+1;
                while (j < input.length() && (input.charAt(j) != '+' && input.charAt(j) != '-')) {
                    temp2 += input.charAt(j);
                    j++;
                }
                //System.out.println(temp2);
                if (maxFactor<Integer.valueOf(temp2))
                    maxFactor=Integer.valueOf(temp2);
                temp2="";
            }
        }
        //System.out.printf("%d",maxFactor);
        double[] factors=new double[maxFactor+1];
        for (int i = 0; i <= maxFactor; i++)
        {
            factors[i]=0;
        }
        for (int i = 0; i < input.length(); i++)
        {
            if(input.charAt(i)=='+' || input.charAt(i)=='-')
            {
                if (temp1!="")
                    factors[0]+=Float.valueOf(temp1);
                temp1="";
                if(input.charAt(i)=='-')
                    temp1 += input.charAt(i);
                flag=true;
            }
            else if(input.charAt(i)=='x')
            {
                if (temp1==""||temp1=="+"||temp1=="-")
                    temp1+="1";
                if (i==input.length()-1 || input.charAt(i+1)!='^')
                    temp2="1";
                else
                {
                    int j=i+2;
                    while(j<input.length() && input.charAt(j)!='+' && input.charAt(j)!='-')
                    {
                        temp2 += input.charAt(j);
                        j++;
                    }
                }
                //System.out.println(temp1);
                if (temp1.equals("-"))
                    temp1="-1";
                if (temp1.equals("+"))
                    temp1="+1";
                //System.out.println(temp1);
                //System.out.println(temp2);
                factors[Integer.valueOf(temp2)]+=Float.valueOf(temp1);
                temp1=temp2="";
                flag=false;
            }
            else if(flag)
                temp1+=input.charAt(i);
            //System.out.println(temp1);
        }
        //System.out.println(temp1);
        if(temp1!="")
            factors[0]+=Float.valueOf(temp1);
        flag=true;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        for (int i = maxFactor; i >=0; i--) {
            factors[i]/=(i+1);
            factors[i] = (double) Math.floor(factors[i] * 100) / 100;
            if (i==0)
            {
                if (factors[i]==1)
                    if (flag)
                        System.out.print("x");
                    else
                        System.out.print("+x");
                else if(factors[i]==-1)
                    System.out.print("-x");
                else if (factors[i]!=0)
                    if (flag)
                        System.out.print(""+decimalFormat.format(factors[i])+"x");
                        //System.out.printf("%.2fx",factors[i]);
                    else
                    if (factors[i]>0)
                        System.out.print("+"+decimalFormat.format(factors[i])+"x");
                        //System.out.printf("+%.2fx"+factors[i]);
                    else
                        System.out.print(""+decimalFormat.format(factors[i])+"x");
                    //System.out.printf("%.2fx",factors[i]);
                else
                    continue;
            }
            else
            {
                if (factors[i]==1)
                    if (flag)
                        System.out.printf("x^%d",(i+1));
                    else
                        System.out.printf("+x^%d",(i+1));
                else if(factors[i]==-1)
                    System.out.printf("-x^%d",(i+1));
                else if (factors[i]!=0)
                    if (flag)
                        System.out.print(""+decimalFormat.format(factors[i])+"x^"+(i+1));
                        //System.out.printf("%.2fx^%d",factors[i],(i+1));
                    else
                    if (factors[i]>0)
                        System.out.print("+"+decimalFormat.format(factors[i])+"x^"+(i+1));
                        //System.out.printf("+%.2fx^%d",factors[i],(i+1));
                    else
                        System.out.print(""+decimalFormat.format(factors[i])+"x^"+(i+1));
                    //System.out.printf("%.2fx^%d",factors[i],(i+1));
                else
                    continue;
            }
            flag=false;
        }
        //System.out.println(res);

    }
}


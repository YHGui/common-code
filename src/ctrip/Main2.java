package ctrip;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Katsura on 2017/4/11.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BigInteger big1=new BigInteger("1");
        int a[]=new int[3000];
        int n;
        int sum=2;
        a[0]=2;
        n=sc.nextInt();
        int i=1;
        int j=0;
        while(true){
            a[i]=a[i-1]+1;
            if(sum+a[i]>n){
                break;
            }else{
                sum+=a[i];
            }
            i++;
        }
        a[i]=n-sum;
        j=i-1;
        while(a[i]!=0&&j>=0){
            a[j]++;
            a[i]--;
            j--;
        }
        j=i-1;
        while(a[i]!=0&&j>=0){
            a[j]++;
            a[i]--;
            j--;
        }
        for(int k=0;k<i-1;k++){
            //System.out.print(a[k]+" ");
            big1=big1.multiply(BigInteger.valueOf(a[k]));
        }
        //System.out.println(a[i-1]);
        big1=big1.multiply(BigInteger.valueOf(a[i-1]));
        System.out.println(big1.toString());

    }
}

package Des2_detail;

import java.util.Scanner;

public class rsa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		Int y=new Int();
		Int x=new Int();
		int m=exgcd(a, b, x, y);
		System.out.println("m = "+m+" "+"x.v=="+x.v+" "+"y.v=="+y.v);

	}
	public static int exgcd(int a,int b,Int x,Int y) {
		if(b==0) {
			x.v=1;
			y.v=0;
			return a;
		}
//	下述由于将x，y的位置进行调换，所以式子有所不同，可以用下面的方法；	
//		int gcd=exgcd(b, a%b, y, x);
//		y.v-=(a/b)*x.v;

int gcd=exgcd(b, a%b, x, y);
		int c=y.v;
		y.v=x.v-(a/b)*y.v;
		x.v=c;

		return gcd;
	}

}
class Int{
	int v;
	public Int() {};
	public Int(int v) {
		this.v=v;
	}
}


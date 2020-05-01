import java.util.concurrent.ThreadLocalRandom;


public class Rsa1 {
	/**
	 * 随机生成一个可能是素数的数
	 * @param range 随机数产生范围
	 * @return 一个可能是素数的数
	 */
	public static long probablePrime(int range, int rounds) {
	    if (range > 0 && rounds > 0) {
	        ThreadLocalRandom random = ThreadLocalRandom.current();
	        while (true) {
	            int num = random.nextInt(range) + 2;
	            // 进行rounds轮素性测试
	            if (PrimalityTester.isProbablePrime(num, rounds))
	                return num;
	        }
	    }
	    return  -1;
	}

	/*实现模逆算法*/
	/* 利用辗转相除法求最大公约数*/
	/**/
	public static long gcd(long m, long n) {
	    while(true){
	        if ((m = m % n) == 0)
	            return n;
	        if ((n = n % m) == 0)
	            return m;
	    }
	}
	/*扩展欧几里得算法
	 * 使用实现非递归的扩展欧几里得算法求解ax + by = gcd(a,b)*/
	private static long extendedEuclid(long a, long b) {
	    long x = 0, y = 1, lastX = 1, lastY = 0, temp;

	    if (a < b) {
	        temp = a;
	        a = b;
	        b = temp;
	    }

	    while (b != 0) {
	        long q = a / b, r = a % b;
	        a = b;
	        b = r;

	        temp = x;
	        x = lastX - q * x;
	        lastX = temp;

	        temp = y;
	        y = lastY - q * y;
	        lastY = temp;
	    }
	    return lastY;
	}
	/*通过求解线性同余方程ax ≡ b(mod m)求解乘法逆元 */
	public static long linearCongruence(long a, long b, long m) {
	    if(b % gcd(a, m) != 0)
	        return - 1;
	    /*
	      通过扩展欧几里得算法求得x的逆元x'
	      x = kx', b = k(a, m)
	      所以要求地 x = (b / gcd(a, m)) * x'
	     */
	    long result = (b / gcd(a, m)) * extendedEuclid(a, m);
	    if(result < 0)
	        result += m;
	    return result;
	}
//	/* 实现快速模指运算*/
//	public static long exp(long x, long b, long n) {
//	    if (b == 1) {
//	    	
//	    }
//	    	return x % n;
//	    
//	}
//	/** Function to calculate (a ^ b) % c **/
//	public static long modExpNonRec(long a, long b, long c) {
//	    long res = 1;
//	    for (int i = 0; i < b; i++) {
//	        res *= a;
//	        res %= c;
//	    }
//	    return res % c;
//	}
}
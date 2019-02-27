package DES;

import java.util.ArrayList;

public class PublicKey {
	public static int e;
	public static int n;
	public static int d;
	public static int fn;
	public static int c;
	public static int m;
	
	public static int randome(int p,int q){             //随机生成一个e(e满足与fn互质)
		n=p*q;
		fn=(p-1)*(q-1);
		ArrayList<Integer> result=new ArrayList<Integer>();
		for(int i=3;i<fn;++i){
			if(relativelyPrime(fn,i)){
				result.add(i);
			}
		}
		int ran=(int)(Math.random()*(result.size()));
		e=result.get(ran);
		return e;
	}
	
	public static boolean relativelyPrime(int p,int q){     //判断两数互质
		if(p<q){
			int temp=p;
			p=q;
			q=temp;
		}
		int result=0;
		while((result=p%q)!=0){
			p=q;
			q=result;
		}
		return q==1;
	}
	
	public static boolean judge(int p){     //判断p,q是不是素数
		for(int i=2;i<(int)Math.sqrt(p)+1;++i){
			if(p%i==0){
				i=(int)Math.sqrt(p)+1;
				return true;
			}
		}
		return false;
	}
	
	public static void generation(int p,int q){     //生成公钥
		
		int i=1;
		for(i=1;(fn*i+1)%e!=0;i++){
		}
		d=(fn*i+1)/e;
	}
	
	public static int encryption(int mi,int ni,int ei){       //公钥加密(演示) 利用取余的结合律
		if(ei<=4){                //直到4次方以内
			return (int)(Math.pow(mi, ei)%ni);
		}
		else{                //每次将次方减半
			return (encryption(mi,ni,ei/2)*encryption(mi,ni,ei-ei/2))%ni;
		}
	}
	
	public static int decryption(int ci,int ni,int di){      //公钥解密(演示) 利用取余的结合律
		if(di<=4){                //直到4次方以内
			return (int)(Math.pow(ci, di)%ni);
		}
		else{                //每次将次方减半
			return (encryption(ci,ni,di/2)*encryption(ci,ni,di-di/2))%ni;
		}
	}
	
	public static String encrypt(String m,int n,int e){     //公钥加密，将输入的字符串分解成字符再进行加密 
		String result="";
		char[] temp=m.toCharArray();
		int sum;
		int res;
		for(int i=0;i<temp.length;++i){
			sum=(int)temp[i];
			res=encryption(sum,n,e);
			result+=String.valueOf(res)+" ";
		}
		return result;
	}
	
	public static String decrypt(String c,int n,int d){    //公钥加密，将输入的字符串分解成字符再进行加密 
		String result="";
		char[] temp=c.toCharArray();
		String s="";
		for(int i=0;i<temp.length;++i){
			if(temp[i]!=' '){                     //如果不是空格，九八字符串起来
				s+=temp[i];
			}
			else{                             //如果是空格，就把串成的字符串作为密文
				int sum=Integer.parseInt(s);
				result+=(char)decryption(sum,n,d);
				//result+=String.valueOf(decryption(sum,n,d))+" ";
				s="";
			}
		}
		return result;
	}
	
	public static void main(String argsp[]){
		//System.out.println(decrypt("292 292 255 255 337 337 219 219 249 249 289 289 ",437,101));
		//System.out.println(encryption(50,437,149));
	}
	
}

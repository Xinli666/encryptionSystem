package DES;

import java.util.ArrayList;

public class PublicKey {
	public static int e;
	public static int n;
	public static int d;
	public static int fn;
	public static int c;
	public static int m;
	
	public static int randome(int p,int q){             //�������һ��e(e������fn����)
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
	
	public static boolean relativelyPrime(int p,int q){     //�ж���������
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
	
	public static boolean judge(int p){     //�ж�p,q�ǲ�������
		for(int i=2;i<(int)Math.sqrt(p)+1;++i){
			if(p%i==0){
				i=(int)Math.sqrt(p)+1;
				return true;
			}
		}
		return false;
	}
	
	public static void generation(int p,int q){     //���ɹ�Կ
		
		int i=1;
		for(i=1;(fn*i+1)%e!=0;i++){
		}
		d=(fn*i+1)/e;
	}
	
	public static int encryption(int mi,int ni,int ei){       //��Կ����(��ʾ) ����ȡ��Ľ����
		if(ei<=4){                //ֱ��4�η�����
			return (int)(Math.pow(mi, ei)%ni);
		}
		else{                //ÿ�ν��η�����
			return (encryption(mi,ni,ei/2)*encryption(mi,ni,ei-ei/2))%ni;
		}
	}
	
	public static int decryption(int ci,int ni,int di){      //��Կ����(��ʾ) ����ȡ��Ľ����
		if(di<=4){                //ֱ��4�η�����
			return (int)(Math.pow(ci, di)%ni);
		}
		else{                //ÿ�ν��η�����
			return (encryption(ci,ni,di/2)*encryption(ci,ni,di-di/2))%ni;
		}
	}
	
	public static String encrypt(String m,int n,int e){     //��Կ���ܣ���������ַ����ֽ���ַ��ٽ��м��� 
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
	
	public static String decrypt(String c,int n,int d){    //��Կ���ܣ���������ַ����ֽ���ַ��ٽ��м��� 
		String result="";
		char[] temp=c.toCharArray();
		String s="";
		for(int i=0;i<temp.length;++i){
			if(temp[i]!=' '){                     //������ǿո񣬾Ű��ַ�������
				s+=temp[i];
			}
			else{                             //����ǿո񣬾ͰѴ��ɵ��ַ�����Ϊ����
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

package DES;

import java.util.Arrays;

import javax.swing.SwingUtilities;

public class Des {
	private static int[] replacement={58,50,42,34,26,18,10,2,60,52,44,36,28,20,12,4,62,54,46,38,30,22,14,6,64,56,48,40,32,24,16,8,57,49,41,33,25,17, 9,1,59,51,43,35,27,19,11,3,61,53,45,37,29,21,13,5,63,55,47,39,31,23,15,7};
	private static int[] inverse={40,8,48,16,56,24,64,32,39,7,47,15,55,23,63,31,38,6,46,14,54,22,62,30,37,5,45,13,53,21,61,29,36,4,44,12,52,20,60,28,35,3,43,11,51,19,59,27,34,2,42,10,50,18,58,26,33,1,41,9,49,17,57,25};
	private static int[] pc_1={57,49,41,33,25,17,9,1,58,50,42,34,26,18,10,2,59,51,43,35,27,19,11,3,60,52,44,36,63,55,47,39,31,23,15,7,62,54,46,38,30,22,14,6,61,53,45,37,29,21,13,5,28,20,12,4};
	private static int[] pc_2={14,17,11,24,1,5,3,28,15,6,21,10,23,19,12,4,26,8,16,7,27,20,13,2,41,52,31,37,47,55,30,40,51,45,33,48,44,49,39,56,34,53,46,42,50,36,29,32};
	private static int[] rule_e={32,1,2,3,4,5,4,5,6,7,8,9,8,9,10,11,12,13,12,13,14,15,16,17,16,17,18,19,20,21,20,21,22,23,24,25,24,25,26,27,28,29,28,29,30,31,32,1};
	private static int[][] S={
		{14,4,13,1,2,15,11,8,3,10,6,12,5,9,0,7,0,15,7,4,14,2,13,1,10,6,12,11,9,5,3,8,4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0,15,12,8,2,4,9,1,7,5,11,3,14,10,0,6,13},
		{15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10,3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5,0,14,7,11,10,4,13,1,5,8,12,6,9,3,2,15,13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9},
		{10,0,9,14,6,3,15,5,1,13,12,7,11,4,2,8,13,7,0,9,3,4,6,10,2,8,5,14,12,11,15,1,13,6,4,9,8,15,3,0,11,1,2,12,5,10,14,7,1,10,13,0,6,9,8,7,4,15,14,3,11,5,2,12},
		{7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15,13,8,11,5,6,15,0,3,4,7,2,12,1,10,14,9,10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4,3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,14},
		{2,12,4,1,7,10,11,6,8,5,3,15,13,0,14,9,14,11,2,12,4,7,13,1,5,0,15,10,3,9,8,6,4,2,1,11,10,13,7,8,15,9,12,5,6,3,0,14,11,8,12,7,1,14,2,13,6,15,0,9,10,4,5,3},
		{12,1,10,15,9,2,6,8,0,13,3,4,14,7,5,11,10,15,4,2,7,12,9,5,6,1,13,14,0,11,3,8,9,14,15,5,2,8,12,3,7,0,4,10,1,13,11,6,4,3,2,12,9,5,15,10,11,14,1,7,6,0,8,13},
		{4,11,2,14,15,0,8,13,3,12,9,7,5,10,6,1,13,0,11,7,4,9,1,10,14,3,5,12,2,15,8,6,1,4,11,13,12,3,7,14,10,15,6,8,0,5,9,2,6,11,13,8,1,4,10,7,9,5,0,15,14,2,3,12},
		{13,2,8,4,6,15,11,1,10,9,3,14,5,0,12,7,1,15,13,8,10,3,7,4,12,5,6,11,0,14,9,2,7,11,4,1,9,12,14,2,0,6,10,13,15,3,5,8,2,1,14,7,4,10,8,13,15,12,9,0,3,5,6,11},
	};
	private static int[] P={16,7,20,21,29,12,28,17,1,15,23,26,5,18,31,10,2,8,24,14,32,27,3,9,19,13,30,6,22,11,4,25};
	private static String hexStr =  "0123456789ABCDEF"; 
	private static int[][] subkey=new int[16][48];
	private static int[] left=new int[32];
	private static int[] right=new int[32];
	private static int[] C0=new int[28];
	private static int[] D0=new int[28];
	private static int[] R0=new int[48];
	private static int[] xorsresult=new int[48];
	private static int[] Sresult=new int[32];
	private static int[] Presult=new int[32];
	private static int[] ciphertext=new int[64];
	public static int s=0;
	
	public static int[] toBinary(String s){  //将输入的明文,密钥转换成二进制数组
		char[] temp=s.toCharArray();
		String result="";
		for(int i=0;i<temp.length;++i){
			String str=Integer.toBinaryString(temp[i]);
			int binaryint=Integer.parseInt(str);
			result+=String.format("%08d", binaryint);
		}
		char[] temp1=result.toCharArray();
		int[] result1=new int[64];
		for(int i=0;i<temp1.length;++i){
			result1[i]=temp1[i]-48;
		}
		if(result1.length<64){                //如果不足64位，后面补上0
			for(int i=result1.length;i<64;++i){
				result1[i]='0';
			}
		}
		//System.out.println(Arrays.toString(result1));
		return result1;
	}
	
	public static int[] replace(int[] arr){    //按照规则置换得到的二进制数组
		int result[] = new int[64];
		for(int i=0;i<64;++i){
			result[i]=arr[replacement[i]-1];
		}
		for(int i=0;i<32;++i){
			left[i]=result[i];
			right[i]=result[i+32];
		}
		/*for(int i=0;i<32;++i)
			System.out.print(left[i]+",");
		for(int i=0;i<32;++i)
			System.out.print(right[i]+",");*/
		return result;
	}
	
	public static void createkey(int[] arr,int round){    //生成子密钥
		if(round==0){
			for(int i=0;i<28;++i){
				C0[i]=arr[pc_1[i]-1];
			}
			for(int i=0;i<28;++i){
				D0[i]=arr[pc_1[i+28]-1];
			}
			/*for(int i=0;i<28;++i)
				System.out.print(C0[i]+",");
			for(int i=0;i<28;++i)
				System.out.print(D0[i]+",");*/
		}
		if(round==0||round==1||round==8||round==15){     //如果是第1，2，9，16轮就循环左移1位
			int temp1=C0[0],temp2=D0[0];
			for(int i=0;i<27;++i){
				C0[i]=C0[i+1];
				D0[i]=D0[i+1];
			}
			C0[27]=temp1;
			D0[27]=temp2;
		}
		else{                   //其余循环左移2位
			int temp1=C0[0],temp2=C0[1],temp3=D0[0],temp4=D0[1];
			for(int i=0;i<26;++i){
				C0[i]=C0[i+2];
				D0[i]=D0[i+2];
			}
			C0[26]=temp1;
			C0[27]=temp2;
			D0[26]=temp3;
			D0[27]=temp4;
		}
		int result[]=new int[56];
		for(int i=0;i<28;i++){
			result[i]=C0[i];
			result[i+28]=D0[i];
		}
		for(int i=0;i<48;++i){          
			subkey[round][i]=result[pc_2[i]-1];
		}
		//System.out.println(Arrays.toString(subkey));
	}
	
	public static void expand(int []r){   //将数据右半部分扩展为48位
		for(int i=0;i<48;++i){
			R0[i]=r[rule_e[i]-1];
		}
	}
	
	public static void xorS(int[] r,int[] k){    //将子密钥和对应数据异或
		for(int i=0;i<48;++i){
			xorsresult[i]=r[i]^k[i];
		}
	}
	
	public static void boxS(int[] xor){    //S盒计算
		int row=0,column=0,result=0;
		for(int i=0;i<8;++i){
			row=xor[i*6]*2+xor[i*6+5];
			column=xor[i*6+1]*8+xor[i*6+2]*4+xor[i*6+3]*2+xor[i*6+4];
			result=S[i][row*16+column];
			Sresult[i*4]=result/8;
			Sresult[i*4+1]=(result-Sresult[i*4]*8)/4;
			Sresult[i*4+2]=(result-Sresult[i*4]*8-Sresult[i*4+1]*4)/2;
			Sresult[i*4+3]=result-Sresult[i*4]*8-Sresult[i*4+1]*4-Sresult[i*4+2]*2;
		}
	}
	
	public static void boxP(int[] s){    //P盒置换
		for(int i=0;i<32;++i){
			Presult[i]=s[P[i]-1];
		}
	}
	
	public static void xorP(int[] l,int[] p){     //将P盒置换结果与左半部分异或作为新的左半部分
		for(int i=0;i<32;++i){
			l[i]=l[i]^p[i];
		}
	}
	
	public static void exchange(int[] l,int[] r){   //将左右互换
		int temp=0;
		for(int i=0;i<32;++i){
			temp=l[i];
			l[i]=r[i];
			r[i]=temp;
		}
	}
	
	public static void inversement(int[] l,int[] r){    //逆置换得到密文
		int[] temp=new int[64];
		for(int i=0;i<32;++i){
			temp[i]=l[i];
			temp[i+32]=r[i];
		}
		for(int i=0;i<64;++i){
			ciphertext[i]=temp[inverse[i]-1];
		}
	}
	
	public static void f(int round,int [] key){   //16轮的迭代
		if(round<16){                        
			createkey(key,round);
			expand(right);
			xorS(R0,subkey[round]);
			boxS(xorsresult);
			boxP(Sresult);
			xorP(left,Presult);
			exchange(left,right);
			round++;
			f(round,key);
		}
		else if(round==16){                     //16轮完成之后将左右互换之后做逆置换
			exchange(left,right);
			/*for(int i=0;i<32;i++)
				System.out.print(left[i]);
			for(int i=0;i<32;++i)
				System.out.print(right[i]);*/
			inversement(left,right);
		}
	}
	
	public static String binstrtostr(int[] t){    //得到的密文转换为16进制
		String result ="";
		int sum=0;
		for(int j=0;j<16;++j){
			for(int i=0;i<4;++i){  
				sum+=Math.pow(2,3-i)*t[i+j*4];
			}  
			result+=hexStr.charAt(sum);
			sum=0;
		}
        return result;  
	}
	
	public static String des(String k,String t){    //整合des算法
		String result="";
		String text="";
		int i=0;
		/*SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            }
		});*/
		for(i=0;i<t.length()/8;++i){
			text=t.substring(8*i,8*i+8);
			s=i*8+8;
			replace(toBinary(text));
			f(0,toBinary(k));
			result+=binstrtostr(ciphertext);
			//Demo.progress(s);
			
		}
		if(t.length()%8!=0){
			text=t.substring(8*i,t.length());
			s=t.length();
			replace(toBinary(text));
			f(0,toBinary(k));
			result+=binstrtostr(ciphertext);
			//Demo.progress(s);
		}
		return result;
	}
	
	public static int[] binary(String s){     //解密中将密文转换为二进制
		char[] temp=s.toCharArray();
		int[] result=new int[temp.length*4];
		int sum=0;
		for(int i=0;i<temp.length;++i){
			sum=hexStr.indexOf(temp[i]);
			result[i*4]=sum/8;
			result[i*4+1]=(sum-result[i*4]*8)/4;
			result[i*4+2]=(sum-result[i*4]*8-result[i*4+1]*4)/2;
			result[i*4+3]=sum-result[i*4]*8-result[i*4+1]*4-result[i*4+2]*2;
		}
		return result;
	}
	
	public static String binarytostr(int[] b){
		String result="";
		int sum=0;
		for(int j=0;j<8;++j){
			for(int i=0;i<8;++i){
				sum+=Math.pow(2, 7-i)*b[i+j*8];
			}
			result+=(char)sum;
			sum=0;
		}
		return result;
	}
	
	public static void def(int round){
		if(round<16){ 
			expand(right);
			xorS(R0,subkey[15-round]);
			boxS(xorsresult);
			boxP(Sresult);
			xorP(left,Presult);
			exchange(left,right);
			round++;
			def(round);
			
		}
		else if(round==16){                     //16轮完成之后将左右互换之后做逆置换
			exchange(left,right);
			
			
			inversement(left,right);
			//System.out.println(Arrays.toString(ciphertext));
		}
	}
	
	public static String undes(String k,String c){
		String result="";
		String text="";
		for(int i=0;i<c.length()/16;++i){
			text=c.substring(16*i,16*i+16);
			//System.out.println(Arrays.toString(binary(text)));
			replace(binary(text));
			for(int j=0;j<16;++j){
				createkey(toBinary(k),j);
			}
			def(0);
			result+=binarytostr(ciphertext);
		}
		return result;
	}
	
	public static void main(String[] args){
		//System.out.println(des("students","i am a student,you are a pig"));
		System.out.print(des("students","i am you"));
		/*for(int i=0;i<64;++i)
			System.out.print(ciphertext[i]);*/
		//System.out.println(undes("students","CF6FD7FE0EB89C0298D65A5EF3F113ABBF5586D73E50D86CF1856C5811E41305"));
		//System.out.println(undes("students","CF6FD7FE0EB89C02"));
		//System.out.println(des("students","i am a s"));
		/*replace(toBinary("aaaaaaaa"));
		createkey(toBinary("aaaaaaaa"),0);
		expand(right);
		xorS(R0,subkey);
		boxS(xorsresult);
		boxP(Sresult);
		xorP(left,Presult);
		exchange(left,right);
		System.out.println(Arrays.toString(left));*/
		//System.out.println(Arrays.toString(toBinary("i am a s")));
		//createkey(toBinary("stdaentf"),0);
		//f(0,toBinary("studentk"));
		//System.out.println(Arrays.toString(ciphertext));
		//System.out.println(binstrtostr(ciphertext));
	}
}
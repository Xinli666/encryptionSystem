package DES;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class PublicDemo extends JFrame implements ActionListener{
	JTextField nump;
	JTextField numq;
	JTextField nume;
	JButton retbtn;
	JButton random;
	JButton generate;
	JTextField num1;
	JTextField num2;
	JTextField num3;
	JTextField num4;
	JTextField num5;
	JTextField num6;
	JTextField num7;
	JTextField puk1;
	JTextField puk2;
	JTextField prk1;
	JTextField prk2;
	JTextField num8;
	JTextField num9;
	JTextField num10;
	JTextField num11;
	JTextField num12;
	JTextField num13;
	JTextField numc;
	JTextField num14;
	JTextField num15;
	JTextField num16;
	JTextField num17;
	JTextField num18;
	JTextField num19;
	JTextField numm;
	JButton encrypt;
	JButton decrypt;
	//JButton imp;
	//JButton exp;
	
	public PublicDemo(){
		super("公钥算法加密与解密(演示)");
		Container c=this.getContentPane();
		JPanel Panel=new JPanel(null);
		Font font=new Font("宋体",Font.BOLD,20);
		Font title=new Font("宋体",Font.BOLD,30);
		JLabel title1=new JLabel("公钥生成");
		title1.setFont(title);
		title1.setBounds(20,20,150,50);
		JLabel title2=new JLabel("公钥加密");
		title2.setFont(title);
		title2.setBounds(20,230,150,50);
		JLabel title3=new JLabel("公钥解密");
		title3.setFont(title);
		title3.setBounds(20,450,150,50);
		JLabel primenum1=new JLabel("素数p:");
		primenum1.setFont(font);
		primenum1.setBounds(20,80,100,50);
		nump=new JTextField();
		nump.setFont(font);
		nump.setBounds(105,85,70,40);
		JLabel primenum2=new JLabel("素数q:");
		primenum2.setFont(font);
		primenum2.setBounds(20,130,100,50);
		numq=new JTextField();
		numq.setFont(font);
		numq.setBounds(105,135,70,40);
		JLabel num=new JLabel("正整数e:");
		num.setFont(font);
		num.setBounds(20,180,100,50);
		nume=new JTextField();
		nume.setFont(font);
		nume.setBounds(105,185,70,40);
		retbtn=new JButton("返  回");
		retbtn.setFont(font);
		retbtn.setBounds(375,20,150,50);
		retbtn.addActionListener(this);
		random=new JButton("随机生成e");
		random.setFont(font);
		random.setBounds(575,20,150,50);
		random.addActionListener(this);
		generate=new JButton("生成公钥");
		generate.setFont(font);
		generate.setBounds(775,20,150,50);
		generate.addActionListener(this);
		JLabel text1=new JLabel("n=p*q=");
		text1.setFont(font);
		text1.setBounds(200,80,80,50);
		JLabel text2=new JLabel("ф(n)=(p-1)*(q-1)=");
		text2.setFont(font);
		text2.setBounds(200,130,210,50);
		JLabel text3=new JLabel("(e*d)mod(ф(n))=1  d=");
		text3.setFont(font);
		text3.setBounds(200,180,240,50);
		num1=new JTextField();
		num1.setFont(font);
		num1.setBounds(270,85,70,40);
		JLabel text4=new JLabel("*");
		text4.setFont(font);
		text4.setBounds(350,80,20,50);
		num2=new JTextField();
		num2.setFont(font);
		num2.setBounds(380,85,70,40);
		JLabel text5=new JLabel("=");
		text5.setFont(font);
		text5.setBounds(460,80,20,50);
		num3=new JTextField();
		num3.setFont(font);
		num3.setBounds(490,85,70,40);
		num4=new JTextField();
		num4.setFont(font);
		num4.setBounds(400,135,70,40);
		JLabel text6=new JLabel("*");
		text6.setFont(font);
		text6.setBounds(480,130,20,50);
		num5=new JTextField();
		num5.setFont(font);
		num5.setBounds(510,135,70,40);
		JLabel text7=new JLabel("=");
		text7.setFont(font);
		text7.setBounds(590,130,20,50);
		num6=new JTextField();
		num6.setFont(font);
		num6.setBounds(620,135,70,40);
		num7=new JTextField();
		num7.setFont(font);
		num7.setBounds(440,185,70,40);
		JLabel text8=new JLabel("公钥(");
		text8.setFont(font);
		text8.setBounds(720,80,60,50);
		puk1=new JTextField();
		puk1.setFont(font);
		puk1.setBounds(780,85,70,40);
		JLabel text9=new JLabel(",");
		text9.setFont(font);
		text9.setBounds(855,80,20,50);
		puk2=new JTextField();
		puk2.setFont(font);
		puk2.setBounds(875,85,70,40);
		JLabel text10=new JLabel(")");
		text10.setFont(font);
		text10.setBounds(950,80,20,50);
		JLabel text11=new JLabel("私钥(");
		text11.setFont(font);
		text11.setBounds(720,180,60,50);
		prk1=new JTextField();
		prk1.setFont(font);
		prk1.setBounds(780,185,70,40);
		JLabel text12=new JLabel(",");
		text12.setFont(font);
		text12.setBounds(855,180,20,50);
		prk2=new JTextField();
		prk2.setFont(font);
		prk2.setBounds(875,185,70,40);
		JLabel text13=new JLabel(")");
		text13.setFont(font);
		text13.setBounds(950,180,20,50);
		JLabel text14=new JLabel("e        n");
		text14.setFont(font);
		text14.setBounds(805,110,130,50);
		JLabel text15=new JLabel("d        n");
		text15.setFont(font);
		text15.setBounds(805,210,130,50);
		JLabel text16=new JLabel("明文m:");
		text16.setFont(font);
		text16.setBounds(20,280,70,50);
		JLabel text17=new JLabel("公钥n:");
		text17.setFont(font);
		text17.setBounds(20,330,70,50);
		JLabel text18=new JLabel("公钥e:");
		text18.setFont(font);
		text18.setBounds(20,380,70,50);
		num8=new JTextField();
		num8.setFont(font);
		num8.setBounds(90,285,70,40);
		num9=new JTextField();
		num9.setFont(font);
		num9.setBounds(90,335,70,40);
		num10=new JTextField();
		num10.setFont(font);
		num10.setBounds(90,385,70,40);
		JLabel text19=new JLabel("c=m^e mod n");
		text19.setFont(font);
		text19.setBounds(220,330,150,50);
		num11=new JTextField();
		num11.setFont(font);
		num11.setBounds(380,335,70,40);
		num12=new JTextField();
		num12.setFont(font);
		num12.setBounds(450,295,70,40);
		num13=new JTextField();
		num13.setFont(font);
		num13.setBounds(600,335,70,40);
		JLabel text20=new JLabel("( mod");
		text20.setFont(font);
		text20.setBounds(520,330,100,50);
		JLabel text21=new JLabel(")=密文c:");
		text21.setFont(font);
		text21.setBounds(680,330,100,50);
		numc=new JTextField();
		numc.setFont(font);
		numc.setBounds(780,335,70,40);
		JLabel text22=new JLabel("密文m:");
		text22.setFont(font);
		text22.setBounds(20,500,70,50);
		JLabel text23=new JLabel("私钥n:");
		text23.setFont(font);
		text23.setBounds(20,550,70,50);
		JLabel text24=new JLabel("私钥d:");
		text24.setFont(font);
		text24.setBounds(20,600,70,50);
		num14=new JTextField();
		num14.setFont(font);
		num14.setBounds(90,505,70,40);
		num15=new JTextField();
		num15.setFont(font);
		num15.setBounds(90,555,70,40);
		num16=new JTextField();
		num16.setFont(font);
		num16.setBounds(90,605,70,40);
		JLabel text25=new JLabel("m=c^d mod n");
		text25.setFont(font);
		text25.setBounds(220,550,150,50);
		num17=new JTextField();
		num17.setFont(font);
		num17.setBounds(380,555,70,40);
		num18=new JTextField();
		num18.setFont(font);
		num18.setBounds(450,515,70,40);
		num19=new JTextField();
		num19.setFont(font);
		num19.setBounds(600,555,70,40);
		JLabel text26=new JLabel("( mod");
		text26.setFont(font);
		text26.setBounds(520,550,100,50);
		JLabel text27=new JLabel(")=明文c:");
		text27.setFont(font);
		text27.setBounds(680,550,100,50);
		numm=new JTextField();
		numm.setFont(font);
		numm.setBounds(780,555,70,40);
		encrypt=new JButton("加  密");
		encrypt.setFont(font);
		encrypt.setBounds(775,250,150,50);
		encrypt.addActionListener(this);
		decrypt=new JButton("解  密");
		decrypt.setFont(font);
		decrypt.setBounds(775,450,150,50);
		decrypt.addActionListener(this);
		/*imp=new JButton("导  入");
		imp.setFont(font);
		imp.setBounds(575,650,150,50);
		imp.addActionListener(this);
		exp=new JButton("导  出");
		exp.setFont(font);
		exp.setBounds(775,650,150,50);
		exp.addActionListener(this);*/
		Panel.add(title1);
		Panel.add(title2);
		Panel.add(title3);
		Panel.add(nump);
		Panel.add(primenum1);
		Panel.add(numq);
		Panel.add(primenum2);
		Panel.add(nume);
		Panel.add(num);
		Panel.add(retbtn);
		Panel.add(random);
		Panel.add(generate);
		Panel.add(text1);
		Panel.add(text2);
		Panel.add(text3);
		Panel.add(num1);
		Panel.add(text4);
		Panel.add(num2);
		Panel.add(text5);
		Panel.add(num3);
		Panel.add(num4);
		Panel.add(num5);
		Panel.add(num6);
		Panel.add(text6);
		Panel.add(text7);
		Panel.add(text8);
		Panel.add(num7);
		Panel.add(puk1);
		Panel.add(text9);
		Panel.add(puk2);
		Panel.add(text10);
		Panel.add(text11);
		Panel.add(text12);
		Panel.add(text13);
		Panel.add(prk1);
		Panel.add(prk2);
		Panel.add(text14);
		Panel.add(text15);
		Panel.add(text16);
		Panel.add(text17);
		Panel.add(text18);
		Panel.add(num8);
		Panel.add(num9);
		Panel.add(num10);
		Panel.add(text19);
		Panel.add(num11);
		Panel.add(num12);
		Panel.add(num13);
		Panel.add(text20);
		Panel.add(text21);
		Panel.add(numc);
		Panel.add(text22);
		Panel.add(text23);
		Panel.add(text24);
		Panel.add(text25);
		Panel.add(text26);
		Panel.add(text27);
		Panel.add(num14);
		Panel.add(num15);
		Panel.add(num16);
		Panel.add(num17);
		Panel.add(num18);
		Panel.add(num19);
		Panel.add(numm);
		Panel.add(encrypt);
		Panel.add(decrypt);
		//Panel.add(imp);
		//Panel.add(exp);
		c.add(Panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,800);
		setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==retbtn){     
			this.dispose();
			new MainFrame();
		}
		if(e.getSource()==random){
			ran();
		}
		if(e.getSource()==generate){
			gen();
		}
		if(e.getSource()==encrypt){
			enc();
		}
		if(e.getSource()==decrypt){
			dec();
		}
		/*if(e.getSource()==imp){
			importion();
		}
		if(e.getSource()==exp){
			exportion();
		}*/
	}
	
	private void ran(){        //随机生成e
		if(nump.getText().length()==0||numq.getText().length()==0||PublicKey.judge(Integer.parseInt(nump.getText()))||PublicKey.judge(Integer.parseInt(numq.getText()))){
			JOptionPane.showMessageDialog(null,"请输入正确的素数p,q","错误",1);
		}
		else if(Integer.parseInt(nump.getText())*Integer.parseInt(numq.getText())<255){
			JOptionPane.showMessageDialog(null,"请输入乘积大于255的素数p,q","错误",1);
		}
		else{
			int np=Integer.parseInt(nump.getText());
			int nq=Integer.parseInt(numq.getText());
			PublicKey.randome(np,nq);
			nume.setText(String.valueOf(PublicKey.e));
		}
	}
	
	private void gen(){      //生成公钥
		if(nume.getText().length()==0){
			JOptionPane.showMessageDialog(null,"请先获得随机数e","错误",1);
		}
		else{
			int np=Integer.parseInt(nump.getText());
			int nq=Integer.parseInt(numq.getText());
			PublicKey.generation(np,nq);
			num1.setText(nump.getText());
			num2.setText(numq.getText());
			num3.setText(String.valueOf(PublicKey.n));
			num4.setText(String.valueOf(Integer.parseInt(nump.getText())-1));
			num5.setText(String.valueOf(Integer.parseInt(numq.getText())-1));
			num6.setText(String.valueOf(PublicKey.fn));
			num7.setText(String.valueOf(PublicKey.d));
			puk1.setText(String.valueOf(PublicKey.e));
			puk2.setText(String.valueOf(PublicKey.n));
			prk1.setText(String.valueOf(PublicKey.d));
			prk2.setText(String.valueOf(PublicKey.n));
		}
	}
	
	private void enc(){
		if(num8.getText().length()==0||num9.getText().length()==0||num10.getText().length()==0){
			JOptionPane.showMessageDialog(null,"请输入正确的明文，公钥","错误",1);
		}
		else{
			num11.setText(num8.getText());
			num12.setText(num10.getText());
			num13.setText(num9.getText());
			numc.setText(String.valueOf(PublicKey.encryption(Integer.parseInt(num8.getText()),Integer.parseInt(num9.getText()),Integer.parseInt(num10.getText()))));
		}
	}
	
	private void dec(){
		if(num14.getText().length()==0||num15.getText().length()==0||num16.getText().length()==0){
			JOptionPane.showMessageDialog(null,"请输入正确的密文，私钥","错误",1);
		}
		else{
			num17.setText(num14.getText());
			num18.setText(num16.getText());
			num19.setText(num15.getText());
			numm.setText(String.valueOf(PublicKey.decryption(Integer.parseInt(num14.getText()),Integer.parseInt(num15.getText()),Integer.parseInt(num16.getText()))));
		}
	}
	
	
	public static void main(String args[]){
		new PublicDemo();
	}
}

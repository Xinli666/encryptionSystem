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

public class Public1Demo extends JFrame implements ActionListener{
	JTextField numm1;
	JTextField numn1;
	JTextField nume;
	JTextField numc1;
	JTextField numm2;
	JTextField numn2;
	JTextField numd;
	JTextField numc2;
	JButton imp;
	JButton exp;
	JButton enc;
	JButton dec;
	JButton ret;
	
	public Public1Demo(){
		super("公钥算法加密与解密");
		Container c=this.getContentPane();
		JPanel panel=new JPanel(null);
		Font font=new Font("宋体",Font.BOLD,20);
		Font title=new Font("宋体",Font.BOLD,30);
		Font arrow=new Font("宋体",Font.BOLD,100);
		JLabel title1=new JLabel("公钥加密");
		title1.setFont(title);
		title1.setBounds(20,20,150,50);
		JLabel title2=new JLabel("公钥解密");
		title2.setFont(title);
		title2.setBounds(20,380,150,50);
		JLabel text1=new JLabel("明文m:");
		text1.setFont(font);
		text1.setBounds(20,100,80,50);
		JLabel text2=new JLabel("公钥n:");
		text2.setFont(font);
		text2.setBounds(20,200,80,50);
		JLabel text3=new JLabel("公钥e:");
		text3.setFont(font);
		text3.setBounds(20,300,80,50);
		numm1=new JTextField();
		numm1.setFont(font);
		numm1.setBounds(120,105,200,40);
		numn1=new JTextField();
		numn1.setFont(font);
		numn1.setBounds(120,205,200,40);
		nume=new JTextField();
		nume.setFont(font);
		nume.setBounds(120,305,200,40);
		JLabel text4=new JLabel("→");
		text4.setFont(arrow);
		text4.setBounds(400,195,150,50);
		JLabel text5=new JLabel("密文c:");
		text5.setFont(font);
		text5.setBounds(575,200,80,50);
		numc1=new JTextField();
		numc1.setFont(font);
		numc1.setBounds(655,205,200,40);
		JLabel text6=new JLabel("密文c:");
		text6.setFont(font);
		text6.setBounds(20,460,80,50);
		JLabel text7=new JLabel("私钥n:");
		text7.setFont(font);
		text7.setBounds(20,560,80,50);
		JLabel text8=new JLabel("私钥d:");
		text8.setFont(font);
		text8.setBounds(20,660,80,50);
		numc2=new JTextField();
		numc2.setFont(font);
		numc2.setBounds(120,465,200,40);
		numn2=new JTextField();
		numn2.setFont(font);
		numn2.setBounds(120,565,200,40);
		numd=new JTextField();
		numd.setFont(font);
		numd.setBounds(120,665,200,40);
		JLabel text9=new JLabel("→");
		text9.setFont(arrow);
		text9.setBounds(400,555,150,50);
		JLabel text10=new JLabel("明文c:");
		text10.setFont(font);
		text10.setBounds(575,560,80,50);
		numm2=new JTextField();
		numm2.setFont(font);
		numm2.setBounds(655,565,200,40);
		imp=new JButton("导  入");
		imp.setFont(font);
		imp.setBounds(575,390,150,50);
		imp.addActionListener(this);
		exp=new JButton("导  出");
		exp.setFont(font);
		exp.setBounds(575,30,150,50);
		exp.addActionListener(this);
		dec=new JButton("解  密");
		dec.setFont(font);
		dec.setBounds(775,390,150,50);
		dec.addActionListener(this);
		enc=new JButton("加  密");
		enc.setFont(font);
		enc.setBounds(775,30,150,50);
		enc.addActionListener(this);
		ret=new JButton("返  回");
		ret.setFont(font);
		ret.setBounds(375,30,150,50);
		ret.addActionListener(this);
		panel.add(title1);
		panel.add(title2);
		panel.add(text1);
		panel.add(text2);
		panel.add(text3);
		panel.add(numm1);
		panel.add(numn1);
		panel.add(nume);
		panel.add(text4);
		panel.add(text5);
		panel.add(numc1);
		panel.add(text6);
		panel.add(text7);
		panel.add(text8);
		panel.add(text9);
		panel.add(text10);
		panel.add(numm2);
		panel.add(numn2);
		panel.add(numd);
		panel.add(numc2);
		panel.add(imp);
		panel.add(exp);
		panel.add(enc);
		panel.add(dec);
		panel.add(ret);
		c.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,800);
		setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==imp){
			importion();
		}
		if(e.getSource()==exp){
			exportion();
		}
		if(e.getSource()==ret){
			this.dispose();
			new MainFrame();
		}
		if(e.getSource()==enc){
			encryption();
		}
		if(e.getSource()==dec){
			decryption();
		}
	}
	
	private void importion(){
		try{
			FileReader fr=new FileReader("publiccipher.txt");  
	        BufferedReader br=new BufferedReader(fr);
	        String k=br.readLine();
	        numc2.setText(k);
	        JOptionPane.showMessageDialog(null,"导入密文成功","成功",1);
	        br.close();
		}
		catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
	}
	
	private void exportion(){
		String keypath="publiccipher.txt";
		try{
	           File file = new File(keypath);
	           PrintStream ps = new PrintStream(new FileOutputStream(file));
	           ps.println(numc1.getText());
	           JOptionPane.showMessageDialog(null,"导出密文成功","成功",1);
	       }catch (FileNotFoundException e){
	           e.printStackTrace();
	       }
	}
	
	private void encryption(){
		if(numm1.getText().length()==0||numn1.getText().length()==0||nume.getText().length()==0){
			 JOptionPane.showMessageDialog(null,"请输入需要加密的公钥和明文","错误",1);
		}
		else{
			 numc1.setText(PublicKey.encrypt(numm1.getText(),Integer.parseInt(numn1.getText()), Integer.parseInt(nume.getText())));
			 JOptionPane.showMessageDialog(null,"加密成功","成功",1);
		}
	}
	
	private void decryption(){
		if(numc2.getText().length()==0||numn2.getText().length()==0||numd.getText().length()==0){
			 JOptionPane.showMessageDialog(null,"请输入需要解密的私钥和密文","错误",1);
		}
		else{
			 numm2.setText(PublicKey.decrypt(numc2.getText(),Integer.parseInt(numn2.getText()), Integer.parseInt(numd.getText())));
			 JOptionPane.showMessageDialog(null,"解密成功","成功",1);
		}
	}
	
	public static void main(String args[]){
		new Public1Demo();
	}
}

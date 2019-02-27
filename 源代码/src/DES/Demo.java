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

public class Demo extends JFrame implements ActionListener{
	JButton encrypt;
	JButton decrypt;
	JButton imp;
	JButton exp;
	JButton fileen;
	JButton filede;
	JTextField key;
	JTextArea plain;
	JTextArea cipher;
	JButton retbtn;
	static JPanel Panel=new JPanel(null);
	static JProgressBar pb;
	static int s;
	static int total;
	
	public Demo(){
		super("Des�㷨���������");
		Font font=new Font("����",Font.BOLD,20);
		Font text=new Font(Font.DIALOG,Font.BOLD,18);
		Container c=this.getContentPane();		
		key=new JTextField(8);
		key.setBounds(125,40,150,40);
		key.setFont(text);
		JLabel inputkey=new JLabel("64λ��Կ:");
		inputkey.setBounds(25,35,150,50);
		inputkey.setFont(font);
		encrypt=new JButton("��  ��");
		encrypt.setBounds(575,35,125,40);
		encrypt.setFont(font);
		encrypt.addActionListener(this);
		decrypt=new JButton("��  ��");
		decrypt.setFont(font);
		decrypt.setBounds(775,35,125,40);
		decrypt.addActionListener(this);
		JLabel plaintext=new JLabel("����");
		plaintext.setBounds(25,120,150,50);
		plaintext.setFont(font);
		plain=new JTextArea();	
		plain.setLineWrap(true);
		plain.setWrapStyleWord(true);
		JLabel ciphertext=new JLabel("����");
		ciphertext.setBounds(25,390,150,50);
		ciphertext.setFont(font);
		cipher=new JTextArea();
		cipher.setLineWrap(true);
		cipher.setWrapStyleWord(true);
		JScrollPane js1=new JScrollPane(plain);
		js1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		js1.setBounds(25,175,940,185);
		plain.setFont(text);
		JScrollPane js2=new JScrollPane(cipher);
		js2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		js2.setBounds(25,445,940,185);
		cipher.setFont(text);
		imp=new JButton("��  ��");
		imp.setFont(font);
		imp.addActionListener(this);
		imp.setBounds(575,650,125,40);
		exp=new JButton("��  ��");
		exp.setFont(font);
		exp.setBounds(775,650,125,40);
		exp.addActionListener(this);
		fileen=new JButton("�ļ�����");
		fileen.setFont(font);
		fileen.addActionListener(this);
		fileen.setBounds(50,650,125,40);
		filede=new JButton("�ļ�����");
		filede.setFont(font);
		filede.addActionListener(this);
		filede.setBounds(250,650,125,40);
		retbtn=new JButton("��  ��");
		retbtn.setFont(font);
		retbtn.setBounds(375,35,125,40);
		retbtn.addActionListener(this);
		pb=new JProgressBar();
		pb.setStringPainted(true);  
		pb.setBorderPainted(false);  
		pb.setForeground(new Color(0, 210, 40));  
		pb.setBackground(new Color(188, 190, 194));  
		pb.setBounds(0,700,1000,50);
		Panel.add(inputkey);
		Panel.add(key);
		Panel.add(encrypt);
		Panel.add(decrypt);
		Panel.add(plaintext);
		//Panel.add(plain);
		Panel.add(ciphertext);
	   // Panel.add(cipher);
	    Panel.add(imp);
	    Panel.add(exp);
	    Panel.add(fileen);
	    Panel.add(filede);
	    Panel.add(js1);
	    Panel.add(js2);
	    Panel.add(retbtn);
	    Panel.add(pb);
		c.add(Panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,800);
		setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==encrypt){
			encryption();
		}
		if(e.getSource()==decrypt){
			decryption();
		}
		if(e.getSource()==imp){
			importion();
		}
		if(e.getSource()==exp){
			exportion();
		}
		if(e.getSource()==fileen){
			fileencrypt();
		}
		if(e.getSource()==filede){
			filedecrypt();
		}
		if(e.getSource()==retbtn){
			ret();
		}
	}
	
	private void encryption(){           //�����ַ���
		String keytext=key.getText();
		String plaintext=plain.getText();
		if(keytext.length()!=8||plaintext.length()==0){
			JOptionPane.showMessageDialog(null,"������8���ַ�����Կ������","����",1);
		}
		else{
			//new ProgressBar(plaintext.length());
			total=plaintext.length();
			try {
                Thread.sleep(1000);
               // System.out.println("dd");
            } catch (InterruptedException e1) {}
			String ciphertext="";
			ciphertext=Des.des(keytext,plaintext);
			cipher.setText(ciphertext);
			//JOptionPane.showMessageDialog(null,"���ܳɹ�","�ɹ�",1);
		}
	}
	
	public static void progress(int s1) {
		s=s1;
		/*new Thread(new Runnable(){
			public void run(){		
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		            	pb.setValue((int)(s*100/total));
		            	//pb.paintImmediately(0, 700, 1000, 50);
		            }
				});
			}
		}).start();*/
		
		/*new Thread(new Runnable(){
		    @Override
		    public void run() {
		        System.out.println(s);
		        pb.setValue((int)(s*100/total));
		            //Thread.sleep(1000);   
		    }
		}).start();*/
		//Panel.repaint();
		pb.setValue((int)(s*100/total));
		Dimension d = pb.getSize();
		Rectangle rect = new Rectangle(0, 0, d.width, d.height);
		pb.paintImmediately(rect);
		try {
			Thread.currentThread().sleep(500); //����
			} catch (Exception e) {
			 e.printStackTrace();
			}
		//pb.setValue((int)(s*100/total));
		//pb.setValue(10);
		//pb.setValue(20);
	}
	
	/*public static void progress(int s1){
		s=s1;
		pb.setValue((int)(s*100/total));
	}*/
	
	private void decryption(){          //�����ַ���
		String keytext=key.getText();
		String ciphertext=cipher.getText();
		if(keytext.length()!=8||ciphertext.length()==0){
			JOptionPane.showMessageDialog(null,"������8���ַ�����Կ��������","����",1);
		}
		else{
			String plaintext="";
			plaintext=Des.undes(keytext, ciphertext);
			plain.setText(plaintext);
			JOptionPane.showMessageDialog(null,"���ܳɹ�","�ɹ�",1);
		}
	}
	
	private void importion(){     //���ļ��е���Կ�����ĵ��뵽������
		try{
			FileReader fr=new FileReader("key.txt");  
	        BufferedReader br=new BufferedReader(fr);
	        String k=br.readLine();
	        key.setText(k);
	        FileReader fr1=new FileReader("ciphertext.txt");  
	        BufferedReader br1=new BufferedReader(fr1);
	        String c=br1.readLine();
	        cipher.setText(c);
	        JOptionPane.showMessageDialog(null,"������Կ�����ĳɹ�","�ɹ�",1);
	        br1.close();
	        br.close();
		}
		catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
	}
	
	private void exportion(){     //����Կ�����ķֱ�����ļ���
		String keypath="key.txt";
		String cipherpath="ciphertext.txt";
		try{
	           File file = new File(keypath);
	           PrintStream ps = new PrintStream(new FileOutputStream(file));
	           ps.println(key.getText());
	           File file1=new File(cipherpath);
	           PrintStream ps1 = new PrintStream(new FileOutputStream(file1));
	           ps1.println(cipher.getText());
	           JOptionPane.showMessageDialog(null,"������Կ�����ĳɹ�","�ɹ�",1);
	       }catch (FileNotFoundException e){
	           e.printStackTrace();
	       }
	}
	
	private void fileencrypt(){         //ѡȡ�ļ�����
		JFileChooser jfc=new JFileChooser();  
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
		jfc.showDialog(new JLabel(), "ѡ����Ҫ���ܵ��ļ�");
		File file=jfc.getSelectedFile();  
		try{
			FileReader fr=new FileReader(file);  
	        BufferedReader br=new BufferedReader(fr);
	        String line="";
	        String result="";
	        while((line=br.readLine())!=null){
	        	result+=line+"\n\r";
	        }
	        plain.setText(result);
	        br.close();
		}catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
	}
	
	private void filedecrypt(){      //ѡȡ�ļ�����
		JFileChooser jfc=new JFileChooser();  
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
		jfc.showDialog(new JLabel(), "ѡ����Ҫ���ܵ��ļ�");
		File file=jfc.getSelectedFile();  
		try{
			FileReader fr=new FileReader(file);  
	        BufferedReader br=new BufferedReader(fr);
	        String line="";
	        String result="";
	        while((line=br.readLine())!=null){
	        	result+=line+"\n\r";
	        }
	        cipher.setText(result);
	        br.close();
		}catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
	}
	
	private void ret(){    //����������
		this.dispose();
		new MainFrame();
	}
	
	public static void main(String args[]){
		new Demo();
		total=10;
		/*for(int i=0;i<10;++i){
			try {
                Thread.sleep(1000);
               // System.out.println("dd");
            } catch (InterruptedException e1) {}
			progress(i);
		}*/
	}
}

package DES;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements ActionListener{
	JButton desbtn;
	JButton publicbtn;
	JButton public1btn;
	
	public MainFrame(){
		super("des加密与公钥加密");
		Font font=new Font("宋体",Font.BOLD,20);
		Font tit=new Font("宋体",Font.BOLD,30);
		Container c=this.getContentPane();
		JPanel Panel=new JPanel(null);
		JLabel title=new JLabel("实验一：des加密与公钥加密");
		title.setFont(tit);
		title.setBounds(300,100,500,100);
		desbtn=new JButton("DES算法加密与解密");
		desbtn.setBounds(150,300,300,100);
		desbtn.setFont(font);
		desbtn.addActionListener(this);
		publicbtn=new JButton("公钥加密与解密过程演示");
		publicbtn.setBounds(550,300,300,100);
		publicbtn.setFont(font);
		publicbtn.addActionListener(this);
		public1btn=new JButton("公钥加密与解密");
		public1btn.setBounds(350,500,300,100);
		public1btn.setFont(font);
		public1btn.addActionListener(this);
		Panel.add(title);
		Panel.add(desbtn);
		Panel.add(publicbtn);
		Panel.add(public1btn);
		c.add(Panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,800);
		setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==desbtn){
			opendes();
		}
		if(e.getSource()==publicbtn){
			openpublic();
		}
		if(e.getSource()==public1btn){
			openpublic1();
		}
	}
	
	private void opendes(){
		this.dispose();
		new Demo();
	}
	
	private void openpublic(){
		this.dispose();
		new PublicDemo();
	}
	
	private void openpublic1(){
		this.dispose();
		new Public1Demo();
	}
	
	public static void main(String args[]){
		new MainFrame();
	}
}

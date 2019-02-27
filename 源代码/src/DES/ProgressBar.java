package DES;

import java.awt.*;

import javax.swing.*;

public class ProgressBar extends JFrame{
	public static int total;
	static JPanel panel;	
	static JProgressBar pb;
	static JLabel text1;
	static int s;
	
	public ProgressBar(int l){
		super("加密进度条");
		Container c1 = this.getContentPane();
		panel=new JPanel(null);
		total=l;		
		pb=new JProgressBar();
		pb.setStringPainted(true);  
		pb.setBorderPainted(false);  
		pb.setForeground(new Color(0, 210, 40));  
		pb.setBackground(new Color(188, 190, 194));  
		pb.setBounds(80,100,300,50);
		text1=new JLabel();
		text1.setBounds(80,20,340,50);
		Font font=new Font("宋体",Font.BOLD,20);
		text1.setFont(font);
		panel.add(text1);
		panel.add(pb);
		c1.add(panel);
	    this.setSize(500,300);
		setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void progress(int s1) {
		s=s1;
		new Thread(new Runnable(){
			public void run(){		
				/*try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}*/
				
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		            	text1.setText("已加密："+s+"/"+total);
		            	pb.setValue((int)(s*100/total));
		            }
				});
			}
		}).start();
	}
		//panel.add(text1);
	
	
	public static void main(String args[]){
		//new ProgressBar(10);
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            }
		});
		for(int i=0;i<11;++i){
			try {
                Thread.sleep(1000);
               // System.out.println("dd");
            } catch (InterruptedException e1) {}
			progress(i);
		}
	}
}

package DES;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class test extends JFrame implements ActionListener{
	JButton b;
	static JLabel label2;
	static int x=0;
	public test(){
		Container c=this.getContentPane();
		JPanel panel=new JPanel(null);
		label2=new JLabel("label");
		label2.setBounds(300,300,100,100);
		b=new JButton("click");
		b.setBounds(100,100,100,100);
		b.addActionListener(this);
		panel.add(b);
		panel.add(label2);
		c.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,800);
		setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b){
			/*new Thread(new Runnable(){
	            public void run() {
	                for(int i = 0 ; i < 10 ; i ++){
	                    try {
	                        Thread.sleep(1000);
	                    } catch (InterruptedException e1) {}
	                    SwingUtilities.invokeLater(new Runnable(){
	                        @Override
	                        public void run() {
	                        	x++;
	                            label2.setText(x + "");
	                        }
	                    });
	                }
	            }
	        }).start();*/
			x++;
			f(x);
	    }
		}
	
	public static void f(int c){
		x=c;
	new Thread(new Runnable(){
        public void run() {
        	/*try {
                Thread.sleep(1000);
               // System.out.println("dd");
            } catch (InterruptedException e1) {}*/
                SwingUtilities.invokeLater(new Runnable(){
                    @Override
                    public void run() {
                    	//x++;
                        label2.setText(x + "");
                       // System.out.println("dd");
                    }
                });
                   }
    }).start();
	
	}
	
	
	public static void setx(int g){
		x=g;
		f(x);
	}
	
	public static void main(String args[]){
		new Demo();
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            }
		});
		Demo.total=10;
		for(int i=0;i<10;++i){
			try {
                Thread.sleep(1000);
               // System.out.println("dd");
            } catch (InterruptedException e1) {}
			Demo.progress(i);
		}
	}
}

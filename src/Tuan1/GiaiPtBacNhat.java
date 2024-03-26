package Tuan1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GiaiPtBacNhat extends JFrame {
	private JLabel label1, label2, label3;
	private JTextField tSoA, tSoB, tKQ;
	private JButton btTinh, btClear;
	private Font myFont = new Font("Arial", Font.PLAIN, 16);
	
	/**
	 * Launch the application
	 */
	public GiaiPtBacNhat() {
		init();
	}
	
	/**
	 * Create the Frame 
	 */
	private void init() {
		setTitle("Giải phương trình ax + b = 0");
		setBounds(500, 200, 490, 410);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		label1 = new JLabel("Nhập số a: ");
		label1.setBounds(20, 20, 90, 35);
		label1.setFont(myFont);
		getContentPane().add(label1);
		
		label2 = new JLabel("Nhập số b: ");
		label2.setBounds(20, 80, 90, 35);
		label2.setFont(myFont);
		getContentPane().add(label2);
		
		label3 = new JLabel("Kết quả: ");
		label3.setBounds(20, 140, 90, 35);
		label3.setFont(myFont);
		getContentPane().add(label3);
		
		tSoA = new JTextField();
		tSoA.setBounds(115, 20, 310, 35);
		tSoA.setFont(myFont);
		getContentPane().add(tSoA);
		
		tSoB = new JTextField();
		tSoB.setBounds(115, 80, 310, 35);
		tSoB.setFont(myFont);
		getContentPane().add(tSoB);
		
		tKQ = new JTextField("x = ");
		tKQ.setBounds(115, 140, 310, 30);
		tKQ.setFont(myFont);
		tKQ.setEnabled(false);
		getContentPane().add(tKQ);
		
		btTinh = new JButton("Tính");
		btTinh.setFont(myFont);
		btTinh.setSize(70, 45);
		btTinh.setLocation(115, 185);
		btTinh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Double soa = Double.parseDouble(tSoA.getText());
					if(soa == 0) throw new ArithmeticException();
					Double sob = Double.parseDouble(tSoB.getText());
					
					Double kq = -sob / soa;
					kq = (double) Math.round(kq * 1000) / 1000;
					
					tKQ.setText("x = " +kq+ "");
				} catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Số nhập vào không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}catch (ArithmeticException Arex) {
					JOptionPane.showMessageDialog(null, "Số a phải khác 0", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
	
			}
		});
		getContentPane().add(btTinh);
		
		btClear = new JButton("Clear");
		btClear.setSize(75, 45);
		btClear.setFont(myFont);
		btClear.setLocation(215, 185);
		btClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tSoA.setText("");
				tSoB.setText("");
				tKQ.setText("x = ");
			}
		});
		getContentPane().add(btClear);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GiaiPtBacNhat();
	}
}

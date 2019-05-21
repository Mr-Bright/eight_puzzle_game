package something_strange;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Game extends JFrame implements ActionListener {
	JFrame jf;
	JButton start;
	JLabel yuan;
	static JButton[] pos = new JButton[9];
	static ImageIcon[] icon = new ImageIcon[9];
	static int count;
	static int best;
	static DoubleCount y;
	public Game() {
		jf = new JFrame("8 puzzle");
		yuan = new JLabel(new ImageIcon("./image/yuan.jpg"));
		for(int i = 0;i<9;i++){
			icon[i] = new ImageIcon("./image/"+i+".jpg");
		}
		Dimension preferredSize = new Dimension(300, 100);
		Dimension preferredSize1 = new Dimension(100, 100);
		start = new JButton("重新开始");
		start.addActionListener(this);
		start.setPreferredSize(preferredSize);
		jf.add(start);
		for (int i = 0; i < 9; i++) {
			pos[i] = new JButton("X");
			pos[i].setPreferredSize(preferredSize1);
			pos[i].addActionListener(this);
			jf.add(pos[i]);
		}
		setnumber();
		jf.add(yuan);
		jf.setLayout(new FlowLayout());
		jf.setBounds(200, 200, 400, 800);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

	public static void setnumber() {
		count = 0;
		int[] a = new int[9];
		while (true) {
			int[] rand = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			for (int i = 0; i < 9; i++) {
				int m = (int) (Math.random() * rand.length);
				while (rand[m] == 0) {
					m = (int) (Math.random() * rand.length);
				}
				a[i] = rand[m];
				rand[m] = 0;
			}
			int max = 0;
			for (int i = 0; i < 9; i++) {
				if (a[i] != 9) {
					for (int j = i + 1; j < 9; j++) {
						if (a[i] > a[j] && a[j] != 9) {
							max++;
						}
					}
				}
			}
			if (max % 2 == 0) {
				break;
			}
		}
		//a[0] = 1;a[1] = 2;a[2] = 3;a[3] = 4;a[4] = 5;a[5] = 9;a[6] = 7;a[7] = 8;a[8] = 6;
		String str = "";
		for(int i = 0;i<9;i++){
			str = str+String.valueOf(a[i]);
		}
		y = new DoubleCount(str);
		best = y.getBest();
		for (int i = 0; i < 9; i++) {
			if (a[i] != 9) {
				pos[i].setText(String.valueOf(a[i]));
				pos[i].setIcon(icon[a[i]-1]);
			} else {
				pos[i].setText("X");
				pos[i].setIcon(icon[8]);
			}
		}
	}

	public static void main(String[] args) {
		new Game();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			setnumber();
		} else if (e.getSource() == pos[0]) {
			if (pos[1].getText().equals("X")) {
				pos[1].setText(pos[0].getText());
				pos[0].setText("X");
				pos[1].setIcon(pos[0].getIcon());
				pos[0].setIcon(icon[8]);
			} else if (pos[3].getText().equals("X")) {
				pos[3].setText(pos[0].getText());
				pos[0].setText("X");
				pos[3].setIcon(pos[0].getIcon());
				pos[0].setIcon(icon[8]);
			}
			count++;
			check();
		} else if (e.getSource() == pos[1]) {
			if (pos[0].getText().equals("X")) {
				pos[0].setText(pos[1].getText());
				pos[1].setText("X");
				pos[0].setIcon(pos[1].getIcon());
				pos[1].setIcon(icon[8]);
			} else if (pos[2].getText().equals("X")) {
				pos[2].setText(pos[1].getText());
				pos[1].setText("X");
				pos[2].setIcon(pos[1].getIcon());
				pos[1].setIcon(icon[8]);
			} else if (pos[4].getText().equals("X")) {
				pos[4].setText(pos[1].getText());
				pos[1].setText("X");
				pos[4].setIcon(pos[1].getIcon());
				pos[1].setIcon(icon[8]);
			}
			count++;
			check();
		} else if (e.getSource() == pos[2]) {
			if (pos[1].getText().equals("X")) {
				pos[1].setText(pos[2].getText());
				pos[2].setText("X");
				pos[1].setIcon(pos[2].getIcon());
				pos[2].setIcon(icon[8]);
			} else if (pos[5].getText().equals("X")) {
				pos[5].setText(pos[2].getText());
				pos[2].setText("X");
				pos[5].setIcon(pos[2].getIcon());
				pos[2].setIcon(icon[8]);
			}
			count++;
			check();
		} else if (e.getSource() == pos[3]) {
			if (pos[0].getText().equals("X")) {
				pos[0].setText(pos[3].getText());
				pos[3].setText("X");
				pos[0].setIcon(pos[3].getIcon());
				pos[3].setIcon(icon[8]);
			} else if (pos[4].getText().equals("X")) {
				pos[4].setText(pos[3].getText());
				pos[3].setText("X");
				pos[4].setIcon(pos[3].getIcon());
				pos[3].setIcon(icon[8]);
			} else if (pos[6].getText().equals("X")) {
				pos[6].setText(pos[3].getText());
				pos[3].setText("X");
				pos[6].setIcon(pos[3].getIcon());
				pos[3].setIcon(icon[8]);
			}
			count++;
			check();
		} else if (e.getSource() == pos[4]) {
			if (pos[1].getText().equals("X")) {
				pos[1].setText(pos[4].getText());
				pos[4].setText("X");
				pos[1].setIcon(pos[4].getIcon());
				pos[4].setIcon(icon[8]);
			} else if (pos[3].getText().equals("X")) {
				pos[3].setText(pos[4].getText());
				pos[4].setText("X");
				pos[3].setIcon(pos[4].getIcon());
				pos[4].setIcon(icon[8]);
			} else if (pos[5].getText().equals("X")) {
				pos[5].setText(pos[4].getText());
				pos[4].setText("X");
				pos[5].setIcon(pos[4].getIcon());
				pos[4].setIcon(icon[8]);
			} else if (pos[7].getText().equals("X")) {
				pos[7].setText(pos[4].getText());
				pos[4].setText("X");
				pos[7].setIcon(pos[4].getIcon());
				pos[4].setIcon(icon[8]);
			}
			count++;
			check();
		} else if (e.getSource() == pos[5]) {
			if (pos[2].getText().equals("X")) {
				pos[2].setText(pos[5].getText());
				pos[5].setText("X");
				pos[2].setIcon(pos[5].getIcon());
				pos[5].setIcon(icon[8]);
			} else if (pos[4].getText().equals("X")) {
				pos[4].setText(pos[5].getText());
				pos[5].setText("X");
				pos[4].setIcon(pos[5].getIcon());
				pos[5].setIcon(icon[8]);
			} else if (pos[8].getText().equals("X")) {
				pos[8].setText(pos[5].getText());
				pos[5].setText("X");
				pos[8].setIcon(pos[5].getIcon());
				pos[5].setIcon(icon[8]);
			}
			count++;
			check();
		} else if (e.getSource() == pos[6]) {
			if (pos[3].getText().equals("X")) {
				pos[3].setText(pos[6].getText());
				pos[6].setText("X");
				pos[3].setIcon(pos[6].getIcon());
				pos[6].setIcon(icon[8]);
			} else if (pos[7].getText().equals("X")) {
				pos[7].setText(pos[6].getText());
				pos[6].setText("X");
				pos[7].setIcon(pos[6].getIcon());
				pos[6].setIcon(icon[8]);
			}
			count++;
			check();
		} else if (e.getSource() == pos[7]) {
			if (pos[6].getText().equals("X")) {
				pos[6].setText(pos[7].getText());
				pos[7].setText("X");
				pos[6].setIcon(pos[7].getIcon());
				pos[7].setIcon(icon[8]);
			} else if (pos[4].getText().equals("X")) {
				pos[4].setText(pos[7].getText());
				pos[7].setText("X");
				pos[4].setIcon(pos[7].getIcon());
				pos[7].setIcon(icon[8]);
			} else if (pos[8].getText().equals("X")) {
				pos[8].setText(pos[7].getText());
				pos[7].setText("X");
				pos[8].setIcon(pos[7].getIcon());
				pos[7].setIcon(icon[8]);
			}
			count++;
			check();
		} else if (e.getSource() == pos[8]) {
			if (pos[5].getText().equals("X")) {
				pos[5].setText(pos[8].getText());
				pos[8].setText("X");
				pos[5].setIcon(pos[8].getIcon());
				pos[8].setIcon(icon[8]);
			} else if (pos[7].getText().equals("X")) {
				pos[7].setText(pos[8].getText());
				pos[8].setText("X");
				pos[7].setIcon(pos[8].getIcon());
				pos[8].setIcon(icon[8]);
			}
			count++;
			check();
		}
	}

	static void check() {
		String str = "";
		for (int i = 0; i < 9; i++) {
			str = str + pos[i].getText();
		}
		if (str.equals("12345678X")) {
			if (count == best) {
				JOptionPane.showMessageDialog( null,"那真的牛批！");
				setnumber();
			} else {
				JOptionPane.showMessageDialog( null,"小老弟你也不行啊！最少步数为："+best+"步，你用了"+count+"步");
				setnumber();
			}
		}
	}

}

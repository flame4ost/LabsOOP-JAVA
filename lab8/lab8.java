import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class main
{
	public static void main(String[] args)
	{
		WorkWithClassHuman Work = new WorkWithClassHuman();
		Work.DrawWindow();
	}
}

class Telephone extends JPanel
{
	Color col;
	String maker;
	int prise;
	Color clr;

	Telephone() {
		
	}
	
	//Конструктори
	Telephone(String a)
	{
		maker = a;
	}
	Telephone(int a)
	{
		prise = a;
	}
	//Методи
	public void paint (Graphics g) 
	{
		g.setColor(col);
		g.drawRect(10,15,prise,50);
		g.drawString(maker, 50, 10);
	}

	void DrawWindow()
	{
		JFrame SetWin = new JFrame("Setting telephone");
		GridLayout gbl = new GridLayout(4,1);
		SetWin.setLayout(gbl);
		SetWin.setLocation(0,350);

		
		clr = Color.white;
		JButton changeCol = new JButton("");
		changeCol.setBackground(clr);
		
		String[] listMaterials = {
			"Alcatel",
			"Panasonic",
			"Philips",
			"Texet"
		};
		JComboBox mak = new JComboBox(listMaterials);
		
		JTextField  prs = new JTextField();
		JLabel L_SetCol = new JLabel("Color:");
		JLabel L_mat = new JLabel("Maker:");
		JLabel L_prs = new JLabel("Prise:");
		JButton apply = new JButton("Input data");

		SetWin.getContentPane().add(L_SetCol);
		SetWin.getContentPane().add(changeCol);
		SetWin.getContentPane().add(L_mat);
		SetWin.getContentPane().add(mak);
		SetWin.getContentPane().add(L_prs);
		SetWin.getContentPane().add(prs);
		SetWin.getContentPane().add(apply);
		
		SetWin.setVisible(true);
		SetWin.setSize(500,300);
		
		changeCol.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
						clr = JColorChooser.showDialog(null, "Choose a background",clr);
						changeCol.setBackground(clr);
				}
			}
		);
		apply.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					inputData(clr,mak,prs);
					
				}
			}
		);
	}
	void inputData(Color a, JComboBox b, JTextField c)
	{
		col = a;
		maker = (String)b.getSelectedItem();
		prise = Integer.parseInt(c.getText());
	}

	String outputData()
	{
		String a = "col:"+col+"\n"+"maker:"+maker+"\n"+"prise:"+prise;
		return a;
	}
		
		
	
}

class Human extends JPanel
{
	Telephone tel;
	int x = 10;
	int y = 10;
	int height = 50;
	int width = 50;

	public void paint (Graphics g) 
	{
		g.drawOval(x, y, height, width);


	}
	
	void DrawWindow()
	{
		JFrame SetWin = new JFrame("Setting Human");
		GridLayout gbl = new GridLayout(5,2);
		SetWin.setLayout(gbl);
		SetWin.setLocation(0,350);

		JTextField  _x = new JTextField();
		JTextField  _y = new JTextField();
		JTextField  _h = new JTextField();
		JTextField  _w = new JTextField();
		JLabel L_x = new JLabel("X:");
		JLabel L_y = new JLabel("Y:");
		JLabel L_height = new JLabel("Height:");
		JLabel L_width = new JLabel("Width:");
		JButton apply = new JButton("Input data");
		JButton setTel = new JButton("Setting object Telephone");

		SetWin.getContentPane().add(L_x);
		SetWin.getContentPane().add(_x);
		SetWin.getContentPane().add(L_y);
		SetWin.getContentPane().add(_y);
		SetWin.getContentPane().add(L_height);
		SetWin.getContentPane().add(_h);
		SetWin.getContentPane().add(L_width);
		SetWin.getContentPane().add(_w);
		SetWin.getContentPane().add(apply);
		if (tel != null)
		{
			SetWin.getContentPane().add(setTel);
		}
		
		SetWin.setVisible(true);
		SetWin.setSize(600,300);
		

		apply.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					inputData(_x, _y, _h, _w);
					
				}
			}
		);
		setTel.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					tel.DrawWindow();
				}
			}
		);
	}
	void inputData(JTextField a, JTextField b, JTextField c, JTextField d)
	{
		x = Integer.parseInt(a.getText());
		y = Integer.parseInt(b.getText());
		height = Integer.parseInt(c.getText());
		width = Integer.parseInt(d.getText());
	}

	String outputData()
	{
		String a = "x:"+x+"\n"+"y:"+y+"\n"+"height:"+height+"\n"+"width:"+width;
		return a;
	}

	void addObject()
	{
		tel = new Telephone("Alcatel");
	}
}

class WorkWithClassHuman
{
	public void DrawWindow()
	{
		JFrame window = new JFrame("Lab8");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout gbl = new GridLayout(3,1);
		window.setLayout(gbl);
		

		JTextArea result = new JTextArea();
		JButton showRes = new JButton("Output data");
		JButton set = new JButton("Setting");
		Human human = new Human();
		JButton addTel = new JButton("add object");
		
		window.getContentPane().add(set);
		window.getContentPane().add(showRes);
		window.getContentPane().add(addTel);
		window.getContentPane().add(result);
		window.getContentPane().add(human);

		window.setVisible(true);
		window.setSize(500,300);

		
		set.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					human.DrawWindow();
				}
			}
						
		);
		showRes.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					window.getContentPane().remove(human);
					if (human.tel != null)
						window.getContentPane().remove(human.tel);
					
					window.getContentPane().repaint();
					window.getContentPane().add(human);

					if (human.tel != null)
						window.getContentPane().add(human.tel);
					result.setText(human.outputData());
				}
			}
						
		);
		addTel.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					human.addObject();
					human.tel.DrawWindow();
					result.setText("added the facility is first class");
				}
			}
						
		);

	}
}	


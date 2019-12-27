
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class main
{
	static JustJpanel BaseСlass;
	static int index = 3;
	public static void main(String[] args)
	{

		JFrame window = new JFrame("Lab7");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout gbl = new GridLayout(3,0);
		window.setLayout(gbl);
		//Колекция 
		List Obj = new ArrayList();

		Random random = new Random();
		int order[] = new int[3];
		do 
		{
			for (int i = 0; i < 3; i++)
			{
				order[i] = random.nextInt(3)+1;
				//System.out.println(order[i]);
			}
		} while(order[0] == order[1] || order[1] == order[2] || order[2] == order[0] );

		//Заповнення колекції
		for (int i : order) 
		{
			if(i == 1)
				Obj.add(new JustJpanel());
			if(i == 2)
				Obj.add(new Telephone("Alcatel"));	
			if(i == 3)
				Obj.add(new Phone(12,12));
		}


		String[] listObj= {
			String.valueOf(Obj.get(0).getClass()),
			String.valueOf(Obj.get(1).getClass()),
			String.valueOf(Obj.get(2).getClass())
		};
		JComboBox comboBoxObj = new JComboBox(listObj);
		JButton sel = new JButton("Select");
		JButton set = new JButton("Setting");

		JTextArea result = new JTextArea();
		JButton showRes = new JButton("Output data");
		//Виведення елементів в вікно
		
		window.getContentPane().add(comboBoxObj);
		window.getContentPane().add(sel);
		window.getContentPane().add(showRes);
		window.getContentPane().add(result);
		window.getContentPane().add(set);
		
		window.setVisible(true);
		window.setSize(500,300);
		

		sel.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (index < 3)
						window.getContentPane().remove((JustJpanel)Obj.get(index));
					for (int i = 0; i < 3; i++)
						if((String)comboBoxObj.getSelectedItem() == listObj[i])
								index = i;
				}
			}
						
		);
		set.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					((JustJpanel)Obj.get(index)).DrawWindow();
				}
			}
						
		);
		showRes.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					window.getContentPane().remove((JustJpanel)Obj.get(index));
					window.getContentPane().repaint();
					window.getContentPane().add((JustJpanel)Obj.get(index));
					result.setText(((JustJpanel)Obj.get(index)).outputData());
				}
			}
						
		);

	}
}

class JustJpanel extends JPanel
{
	int x = 10;
	int y = 10;
	int height = 50;
	int width = 50;
	public void paint (Graphics g) 
	{
		g.drawRect(x,y,height,width);
	}
	void DrawWindow()
	{
		JFrame SetWin = new JFrame("Setting class Jpanel");
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

		SetWin.getContentPane().add(L_x);
		SetWin.getContentPane().add(_x);
		SetWin.getContentPane().add(L_y);
		SetWin.getContentPane().add(_y);
		SetWin.getContentPane().add(L_height);
		SetWin.getContentPane().add(_h);
		SetWin.getContentPane().add(L_width);
		SetWin.getContentPane().add(_w);
		SetWin.getContentPane().add(apply);
		
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
}

class Telephone extends JustJpanel
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

class Phone extends Telephone
{
	int width;
	int height;
	int thickness;
	
	//Конструктори
	Phone(int a, int b, int c)
	{
		width = a;
		height = b;
		thickness = c;
	}
	Phone(int a, int b)
	{
		width = a;
		height = b;
		thickness = 10;
	}
	@Override
	public void paint (Graphics g) 
		{
			g.drawOval(20, width, height, thickness);
		}
	void DrawWindow()
	{
		JFrame SetWin = new JFrame("Setting mobile phone");
		GridLayout gbl = new GridLayout(4,1);
		SetWin.setLayout(gbl);
		SetWin.setLocation(0,350);

		JTextField  wid = new JTextField();
		JTextField  heig = new JTextField();
		JTextField  thick = new JTextField();
		JLabel L_wid = new JLabel("width:");
		JLabel L_heig = new JLabel("height:");
		JLabel L_thick = new JLabel("thickness:");
		JButton apply = new JButton("Input data");
		
		SetWin.getContentPane().add(L_wid);
		SetWin.getContentPane().add(wid);
		SetWin.getContentPane().add(L_heig);
		SetWin.getContentPane().add(heig);
		SetWin.getContentPane().add(L_thick);
		SetWin.getContentPane().add(thick);
		SetWin.getContentPane().add(apply);
		SetWin.setVisible(true);
		SetWin.setSize(500,300);
		
		apply.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					inputData(wid,heig,thick);
				}
			}
		);
	}
	void inputData(JTextField a,JTextField b,JTextField c)
	{
		width = Integer.parseInt(a.getText());
		height = Integer.parseInt(b.getText());
		thickness = Integer.parseInt(c.getText());
	}

	String outputData()
	{
		String a = "width:"+width+"\n" +"height:"+height+"\n"+"thickness:"+thickness;
		return a;
	}
	
}

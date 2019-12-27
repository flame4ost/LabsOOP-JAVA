
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

class main
{
	public static void main(String[] args)
	{
		JFrame window = new JFrame("Lab6");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Елементи інтерфейсу:
		GridLayout gbl = new GridLayout(3,1);
		window.setLayout(gbl);
		
		JLabel st = new JLabel("Select the option you start program:");
		JButton var1 = new JButton("Variant 1");
		JButton var2 = new JButton("Variant 2");
		
		window.getContentPane().add(st);
		window.getContentPane().add(var1);
		window.getContentPane().add(var2);
		//window.getContentPane().add(pnl);
		
		window.setVisible(true);
		window.setSize(270,100);
		
		StartV1 startV1 = new StartV1();
		StartV2 startV2 = new StartV2();
		var1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					startV1.StartProg();
				}
			}						
		);
		var2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					startV2.StartProg();
				}
			}						
		);

	}
}


class StartV1
{
	Telephone telephone;
	Phone phone;
	public  void StartProg()
	{
		JFrame window = new JFrame("Variant 1");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Елементи інтерфейсу:
		GridLayout gbl = new GridLayout(3,2);
		window.setLayout(gbl);
		
		String[] listConstr = {
			"Telephone(String a)",
			"Telephone(String a,int b)",
			"Phone(int a, int b, int c)",
			"Phone(int a, int b)"
		};
		JPanel pnl = new JPanel();
		JButton set = new JButton("Setting");
		JComboBox constr = new JComboBox(listConstr);
		JButton create = new JButton("Create");
		JTextArea result = new JTextArea();
		JButton showRes = new JButton("Output data");
		//Виведення елементів в вікно
		window.getContentPane().add(constr);
		window.getContentPane().add(create);
		window.getContentPane().add(showRes);
		window.getContentPane().add(result);
		window.getContentPane().add(set);
		//window.getContentPane().add(pnl);
		
		window.setVisible(true);
		window.setSize(500,300);
		
		create.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(telephone != null)
					{
						window.getContentPane().remove(telephone);
						telephone = null;
					}
					if(phone != null)
					{
						window.getContentPane().remove(phone);
						phone = null;

					}

					if ((String)constr.getSelectedItem() == "Telephone(String a)")
					{
						telephone = new Telephone("Alcatel");
						window.getContentPane().repaint();
						window.getContentPane().add(telephone);
					}
					if ((String)constr.getSelectedItem() == "Telephone(String a,int b)")
					{
						telephone =  new Telephone("Alcatel",143);
						window.getContentPane().repaint();
						window.getContentPane().add(telephone);
					}
					if ((String)constr.getSelectedItem() == "Phone(int a, int b, int c)")
					{
						phone =  new Phone(23,12,43);
						window.getContentPane().repaint();
						window.getContentPane().add(phone);
					}
					if ((String)constr.getSelectedItem() == "Phone(int a, int b)")
					{
						phone =  new Phone(12,23);
						window.getContentPane().repaint();
						window.getContentPane().add(phone);
					}
					result.setText("Create object");
				}
			}						
		);
		set.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(telephone != null)
					{
						telephone.DrawWindow();
					}
					if(phone != null)
					{
						phone.DrawWindow();
					}
				}
			}						
		);
		showRes.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					
					if(telephone != null)
					{
						window.getContentPane().repaint();
						window.getContentPane().add(telephone);
						result.setText(telephone.outputData());
					}
					if(phone != null)
					{
						window.getContentPane().repaint();
						window.getContentPane().add(phone);
						result.setText(phone.outputData());
					}
				}
			}						
		);

	}
}

class StartV2
{
	Telephone BaseСlass;
	
	public  void StartProg()
	{
		JFrame window = new JFrame("Variant 2");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Елементи інтерфейсу:
		GridLayout gbl = new GridLayout(3,2);
		window.setLayout(gbl);
		
		String[] listConstr = {
			"Telephone(String a)",
			"Telephone(String a,int b)",
			"Phone(int a, int b, int c)",
			"Phone(int a, int b)"
		};
		JPanel pnl = new JPanel();
		JButton set = new JButton("Setting");
		JComboBox constr = new JComboBox(listConstr);
		JButton create = new JButton("Create");
		JTextArea result = new JTextArea();
		JButton showRes = new JButton("Output data");
		//Виведення елементів в вікно
		window.getContentPane().add(constr);
		window.getContentPane().add(create);
		window.getContentPane().add(showRes);
		window.getContentPane().add(result);
		window.getContentPane().add(set);
		//window.getContentPane().add(pnl);
		
		window.setVisible(true);
		window.setSize(500,300);
		
		create.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(BaseСlass != null)
					{
						window.getContentPane().remove(BaseСlass);
						BaseСlass = null;
					}

					if ((String)constr.getSelectedItem() == "Telephone(String a)")
					{
						BaseСlass = new Telephone("Alcatel");
						window.getContentPane().repaint();
						window.getContentPane().add(BaseСlass);
					}
					if ((String)constr.getSelectedItem() == "Telephone(String a,int b)")
					{
						BaseСlass =  new Telephone("Alcatel",143);
						window.getContentPane().repaint();
						window.getContentPane().add(BaseСlass);
					}
					if ((String)constr.getSelectedItem() == "Phone(int a, int b, int c)")
					{
						BaseСlass =  new Phone(23,12,43);
						window.getContentPane().repaint();
						window.getContentPane().add(BaseСlass);
					}
					if ((String)constr.getSelectedItem() == "Phone(int a, int b)")
					{
						BaseСlass =  new Phone(12,23);
						window.getContentPane().repaint();
						window.getContentPane().add(BaseСlass);
					}
					result.setText("Create object");
				}
			}						
		);
		set.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(BaseСlass != null)
					{
						BaseСlass.DrawWindow();
					}
				}
			}						
		);
		showRes.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					
					if(BaseСlass != null)
					{
						window.getContentPane().repaint();
						window.getContentPane().add(BaseСlass);
						result.setText(BaseСlass.outputData());
					}
				}
			}						
		);
		

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
	Telephone(String a,int b)
	{
		maker = a;
		prise = b;
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




















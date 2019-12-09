import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Main {
    static Ticket ticket;
    static AirTicket airTicket;

    public static void main(String[] args) {
        JFrame window = new JFrame("Lab5");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Елементи інтерфейсу:
        GridLayout gbl = new GridLayout(3, 2);
        window.setLayout(gbl);

        String[] listConstr = {
                "ticket(String a)",
                "ticket(String a, int b)",
                "AirTicket(int a, int b, int i)",
                "AirTicket(int a, int b)"
        };
        JPanel pnl = new JPanel();
        JButton set = new JButton("Setting");
        JComboBox constr = new JComboBox(listConstr);
        JButton create = new JButton("Create");
        JTextArea result = new JTextArea();
        JButton showRes = new JButton("Result");
        //Виведення елементів в вікно
        window.getContentPane().add(constr);
        window.getContentPane().add(create);
        window.getContentPane().add(showRes);
        window.getContentPane().add(result);
        window.getContentPane().add(set);
        //window.getContentPane().add(pnl);

        window.setVisible(true);
        window.setSize(500, 300);

        create.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 if (ticket != null) {
                     window.getContentPane().remove(ticket);
                     ticket = null;
                 }
                 if (airTicket != null) {
                     window.getContentPane().remove(airTicket);
                     airTicket = null;
                 }

                 if (((String) constr.getSelectedItem()).equals ("ticket(String a)")) {
                     ticket = new Ticket("Spain");
                     window.getContentPane().repaint();
                     window.getContentPane().add(ticket);
                 }
                 if (((String) constr.getSelectedItem()).equals("ticket(String a, int b)")) {
                     ticket = new Ticket("Plastic paper", 150);
                     window.getContentPane().repaint();
                     window.getContentPane().add(ticket);
                 }
                 if (((String) constr.getSelectedItem()).equals("AirTicket(String a, Date c)")) {
                     airTicket = new AirTicket();
                     window.getContentPane().repaint();
                     window.getContentPane().add(airTicket);
                 }
                 if (((String) constr.getSelectedItem()).equals("AirTicket(Date a, Date b)")) {
                     airTicket = new AirTicket();
                     window.getContentPane().repaint();
                     window.getContentPane().add(airTicket);
                 }
                 result.setText("Create object");
             }
         }
        );
        set.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  if (ticket != null) {
                      ticket.DrawWindowTicket();
                  }
                  if (airTicket != null) {
                      airTicket.DrawWindowAirTicket();
                  }
              }
          }
        );
        showRes.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {

                  if (ticket != null) {
                      window.getContentPane().repaint();
                      window.getContentPane().add(ticket);
                      result.setText("color:" + ticket.color + "\n"
                              + "material:" + ticket.material + "\n"
                              + "price:" + ticket.price);
                  }
                  if (airTicket != null) {
                      window.getContentPane().repaint();
                      window.getContentPane().add(airTicket);
                      result.setText("color:" + airTicket.price + "\n"
                              + "material:" + airTicket.arrivalTime + "\n"
                              + "price:" + airTicket.departureTime);
                  }
              }
        });

    }

    void DrawWindowTicket() {
        JFrame SetWin = new JFrame("Setting ticket");
        GridLayout gbl = new GridLayout(4,1);
        SetWin.setLayout(gbl);
        SetWin.setLocation(0,350);


        JButton changeCol = new JButton("");
        changeCol.setBackground(ticket.color);
        ticket.color = Color.white;

        String[] listMaterials = {
                "Paper",
                "Plastic paper"
        };
        JComboBox mat = new JComboBox(listMaterials);

        JTextField  prc = new JTextField();
        JLabel lSetCol = new JLabel("Color:");
        JLabel lmat = new JLabel("Material:");
        JLabel lprc = new JLabel("Price:");
        JButton apply = new JButton("Apply");

        SetWin.getContentPane().add(lSetCol);
        SetWin.getContentPane().add(changeCol);
        SetWin.getContentPane().add(lmat);
        SetWin.getContentPane().add(mat);
        SetWin.getContentPane().add(lprc);
        SetWin.getContentPane().add(prc);
        SetWin.getContentPane().add(apply);

        SetWin.setVisible(true);
        SetWin.setSize(500,300);

        changeCol.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                            ticket.color = JColorChooser.showDialog(null, "Choose a background",col);
                                            changeCol.setBackground(ticket.color);
                                        }
                                    }
        );
        apply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ticket.material = (String) mat.getSelectedItem();
                ticket.price = Integer.parseInt(prc.getText());
                void DrawWindowAirTicket() {
                    JFrame SetWin = new JFrame("Setting air_ticket");
                    GridLayout gbl = new GridLayout(4, 1);
                    SetWin.setLayout(gbl);
                    SetWin.setLocation(0, 350);

                    JTextField pric = new JTextField();
                    JTextField leng = new JTextField();
                    JTextField tim = new JTextField();
                    JLabel lprice = new JLabel("Price:");
                    JLabel lleng = new JLabel("Time:");
                    JLabel ltim = new JLabel("Length:");
                    JButton apply = new JButton("Apply");

                    SetWin.getContentPane().add(lprice);
                    SetWin.getContentPane().add(pric);
                    SetWin.getContentPane().add(lleng);
                    SetWin.getContentPane().add(leng);
                    SetWin.getContentPane().add(ltim);
                    SetWin.getContentPane().add(tim);
                    SetWin.getContentPane().add(apply);
                    SetWin.setVisible(true);
                    SetWin.setSize(500, 300);

                    apply.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            price = Integer.parseInt(pric.getText());
                            length = Integer.parseInt(leng.getText());
                            time = Integer.parseInt(tim.getText());
                        }
                    });
                }


            }
        });
}}
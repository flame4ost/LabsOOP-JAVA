import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

class MainWindow2 {
    private Ticket ticket;
    private AirTicket airTicket;

    private JFrame frame;

    private JPanel panel;
    private JPanel mainPanel;
    private JPanel menu;

    private JButton create;
    private JButton createTicket;
    private JButton deleteTicket;
    private JButton showTicket;
    private JButton infoButton;

    private JButton getInfo;
    private JButton writeInfo;

    private JTextField departurePlaceField;
    private JTextField departureTimeField;
    private JTextField priceField;
    private JTextField planeNumberField;
    private JTextField airplaneSeatNumberField;

    private JLabel description;
    private JLabel ticketDescription;

    private JComboBox chooseBox;

    private JCheckBox hasRestaurant;

    private int choose;
    public static boolean hasRestaurantBoolean;

    MainWindow2() {
        this.frame = new JFrame("Lab5");
        this.buildNewPanel();
    }

    private void buildNewPanel() {
        this.panel = new JPanel();
        this.panel.setLayout(new FlowLayout());

        chooseBox = new JComboBox();
        chooseBox.setEditable(true);
        chooseBox.addItem("Ticket 1");
        chooseBox.addItem("Ticket 2");
        chooseBox.addItem("Air Ticket 1");
        chooseBox.addItem("Air Ticket 2");
        this.panel.add(this.chooseBox);

        this.create = new JButton("Choose");
        this.panel.add(this.create);

        this.frame.setLayout(new FlowLayout());
        this.frame.setContentPane(this.panel);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(200, 100);
        this.frame.setVisible(true);

        this.create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choose = chooseBox.getSelectedIndex();
                buildSecondPanel();
            }
        });
    }

    private void buildSecondPanel() {
        this.mainPanel = new JPanel();

        this.mainPanel.add(new JLabel("Departure Place,"));
        this.mainPanel.add(new JLabel("Price,"));
        this.mainPanel.add(new JLabel("Departure time,"));

        this.createTicket = new JButton("Create ticket");

        this.getInfo = new JButton(" Get info");
        this.writeInfo = new JButton("Show info");

        if (this.choose >= 2) {
            this.mainPanel.add(new JLabel("Plane Number,"));
            this.mainPanel.add(new JLabel("Airplane seat number:"));
        }

        this.departurePlaceField = new JTextField();
        this.departurePlaceField.setPreferredSize(new Dimension(200, 30));
        this.mainPanel.add(this.departurePlaceField);

        this.departureTimeField = new JTextField();
        this.departureTimeField.setPreferredSize(new Dimension(200, 30));
        this.mainPanel.add(this.departureTimeField);

        this.priceField = new JTextField();
        this.priceField.setPreferredSize(new Dimension(200, 30));
        this.mainPanel.add(this.priceField);


        if (this.choose >= 2) {

            this.planeNumberField = new JTextField();
            this.planeNumberField.setPreferredSize(new Dimension(200, 30));
            this.mainPanel.add(this.planeNumberField);

            this.airplaneSeatNumberField = new JTextField();
            this.airplaneSeatNumberField.setPreferredSize(new Dimension(200, 30));
            this.mainPanel.add(this.airplaneSeatNumberField);
        }

        if (this.choose >= 2) {

            this.hasRestaurant = new JCheckBox("Does it has a restaurant");
            this.mainPanel.add(this.hasRestaurant);

            this.hasRestaurant.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        MainWindow2.hasRestaurantBoolean = true;
                    } else {
                        MainWindow2.hasRestaurantBoolean = false;
                    }
                }
            });
        }
        this.createTicket.setPreferredSize(new Dimension(200, 30));
        this.mainPanel.add(this.createTicket);

        this.getInfo.setPreferredSize(new Dimension(200, 30));
        this.mainPanel.add(this.getInfo);

        this.writeInfo.setPreferredSize(new Dimension(200, 30));
        this.mainPanel.add(this.writeInfo);

        this.frame.setSize(350, 400);
        this.frame.setContentPane(this.mainPanel);
        frame.setVisible(true);

        this.createTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTicket();
                buildMenuPanel();
            }
        });

        this.getInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getTicketInfo();
            }
        });

        this.writeInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeTicketInfo();
            }
        });

        this.mainPanel.setVisible(true);
    }

    private void writeTicketInfo() {
        String transportInfo;
            transportInfo = airTicket.getTicketData();
            this.frame.setSize(350, 450);
            this.ticketDescription = new JLabel();
            this.ticketDescription.setText(transportInfo);
            this.mainPanel.add(ticketDescription);
        }


    private void getTicketInfo() {
        ArrayList param = new ArrayList();
        if (this.choose <= 1) {
            param.add(this.departurePlaceField.getText());
            param.add(Integer.valueOf(this.priceField.getText()));
            param.add(Integer.valueOf(this.departureTimeField.getText()));
        } else{
            param.add(this.departurePlaceField.getText());
            param.add(Integer.valueOf(this.priceField.getText()));
            param.add(Integer.valueOf(this.departureTimeField.getText()));
            param.add(Integer.valueOf(this.planeNumberField.getText()));
            param.add(Integer.valueOf(this.airplaneSeatNumberField.getText()));
        }

        if (this.choose <= 1) {
            this.ticket = new Ticket(this.departurePlaceField.getText(),Integer.valueOf(this.priceField.getText()), Integer.valueOf(this.departureTimeField.getText()));
            this.ticket.setTicketData(param);
        } else {
            this.airTicket = new AirTicket(this.departurePlaceField.getText(), Integer.valueOf(this.priceField.getText()), Integer.valueOf(this.departureTimeField.getText()), Integer.valueOf(this.planeNumberField.getText()), Integer.valueOf(this.airplaneSeatNumberField.getText()));
            this.airTicket.setTicketData(param);
        }
    }
    private void createTicket (){
        ArrayList param2 = new ArrayList();
        if (this.choose <= 1) {
            param2.add(this.departurePlaceField.getText());
            param2.add(Integer.valueOf(this.priceField.getText()));
            param2.add(Integer.valueOf(this.departureTimeField.getText()));
        }else {
            param2.add(this.departurePlaceField.getText());
            param2.add(Integer.valueOf(this.priceField.getText()));
            param2.add(Integer.valueOf(this.departureTimeField.getText()));
            param2.add(Integer.valueOf(this.planeNumberField.getText()));
            param2.add(Integer.valueOf(this.airplaneSeatNumberField.getText()));
        }
        if (this.choose == 0){
            this.ticket = new Ticket(this.departurePlaceField.getText(),Integer.valueOf(this.priceField.getText()), Integer.valueOf(this.departureTimeField.getText()));
            this.ticket.setTicketData(param2);
        }
        if (this.choose == 1){
            this.ticket = new Ticket(this.departurePlaceField.getText(),Integer.valueOf(this.priceField.getText()), Integer.valueOf(this.departureTimeField.getText()));
            this.ticket.setTicketData(param2);
        }
        if (this.choose == 2){
            this.airTicket = new AirTicket(this.departurePlaceField.getText(), Integer.valueOf(this.priceField.getText()),Integer.valueOf(this.departureTimeField.getText()),Integer.valueOf(this.planeNumberField.getText()), Integer.valueOf(this.airplaneSeatNumberField.getText()));
            this.airTicket.setTicketData(param2);
        }
        if (this.choose == 3){
            this.airTicket = new AirTicket(this.departurePlaceField.getText(), Integer.valueOf(this.priceField.getText()),Integer.valueOf(this.departureTimeField.getText()),Integer.valueOf(this.planeNumberField.getText()), Integer.valueOf(this.airplaneSeatNumberField.getText()));
            this.airTicket.setTicketData(param2);
        }
    }

    private void buildMenuPanel(){
        this.menu = new JPanel();

        this.showTicket = new JButton("Show");
        this.menu.add(this.showTicket);

        this.infoButton = new JButton("Information");
        this.menu.add(this.infoButton);

        this.deleteTicket = new JButton("Delete ticket");
        this.menu.add(this.deleteTicket);

        this.frame.setContentPane(this.menu);
        this.frame.setSize(300,150);
        this.frame.setVisible(true);

        this.showTicket.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                showButton();
            }
        });

        this.deleteTicket.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                deleteTicket();
            }
        });

        this.infoButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                showInfo();
            }
        });
    }

    private void showButton(){
        JFrame newFrame = new JFrame("Ticket");
        if(this.choose <=1 ){
            newFrame.setContentPane(this.ticket);
        }else {
            newFrame.setContentPane(this.airTicket);
        }
        newFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        newFrame.setSize(300,300);
        newFrame.setVisible(true);
    }

    private void showInfo(){

        String info;
        if (this.choose <= 1) {
            info = ticket.getTicketData();
        }else {
            info = airTicket.getTicketData();
        }
        this.frame.setSize(720,150);
        this.description = new JLabel();
        this.description.setText(info);
        this.menu.add(description);
    }

    private void deleteTicket(){
        this.ticket = null;
        this.airTicket = null;

        this.hasRestaurantBoolean = false;

        this.frame.setContentPane(this.panel);
        this.frame.setSize(200,150);
    }
}










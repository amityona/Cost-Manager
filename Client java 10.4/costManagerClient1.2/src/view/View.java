package view;
import models.Cost;
import models.FilterDateByUserName;
import models.User;
import viewModel.ViewModel;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class View implements IView {
    private ViewModel vm;
    //private UsersViewModel vm;
    private JFrame frame;
    private JTextField Costs;
    private JTextField categoryText, currencyText, textText, sumText, tfMessageText, costsStatusText, dateText, fromDateText, untilDateText;
    private JButton addCost, getMyCosts, getBySpecialDate;
    private JTextArea ta,ta3;
    private JPanel panelSouth;
    private JPanel panelNorth;
    private JLabel userName, category, sum, text, currency, tfMessage, costsStatus, myCostsLabel, userNameLabel, dateLabel, fromDate, untilDate;
    public String userName2;
    private JTextField tfItem;
    private JTextField userNameTextRegister;
    private JTextField passwordTextRegister;
    private JTextField userNameTextLogin;
    private JTextField passwordTextLogin;
    private JButton btLogin;
    private JButton btRegister;
    private JTextArea ta2;
    //private JPanel panelSouth;
    //private JPanel panelNorth;
    private JLabel registerLabel, loginLabelStatus;
    private JLabel loginLabel;
    //private JLabel userNameLabel;
    private JLabel passwordLabel;
    private static String userNameNow;

    /**
     * Instantiates a new Users view.
     */
    public View() {
    }
    public View(String answer) {
            userName2=answer;
    }

    /**
     * Init the user UI.
     */
    //@Override
    public void init() {
        this.frame = new JFrame();
        this.userNameTextLogin = new JTextField(10);
        this.passwordTextLogin = new JTextField(10);
        this.btRegister = new JButton("Register");
        this.passwordTextRegister = new JTextField(10);
        this.userNameLabel = new JLabel("User Name :");
        this.passwordLabel = new JLabel("Password :");
        this.registerLabel = new JLabel("Register:");
        this.loginLabel = new JLabel("login:");
        this.tfItem = new JTextField(10);
        this.userNameTextRegister = new JTextField(10);
        this.btLogin = new JButton("Login");
        this.ta = new JTextArea();
        this.panelSouth = new JPanel();
        this.panelNorth = new JPanel();
        tfMessage = new JLabel("Status");
        loginLabelStatus = new JLabel("Status");
    }

    /**
     * start the UI
     * first display - login and register UI
     */
    //@Override
    public void start() {
        this.panelNorth.setBackground(Color.GREEN);
        this.panelNorth.setLayout(new FlowLayout());
        this.panelNorth.add(this.registerLabel);
        this.panelNorth.add(this.userNameLabel);
        this.panelNorth.add(this.userNameTextRegister);
        this.panelNorth.add(this.passwordLabel);
        this.panelNorth.add(this.passwordTextRegister);
        this.panelNorth.add(this.btRegister);
        this.panelNorth.add(tfMessage);
        this.panelSouth.setBackground(Color.BLUE);
        this.panelSouth.add(this.loginLabel);
        this.panelSouth.add(this.userNameLabel);
        this.panelSouth.add(this.userNameTextLogin);
        this.panelSouth.add(this.passwordLabel);
        this.panelSouth.add(this.passwordTextLogin);
        this.panelSouth.setLayout(new FlowLayout());
        this.panelSouth.add(this.btLogin);
        this.panelSouth.add(this.loginLabelStatus);
        this.frame.setLayout(new BorderLayout());
        this.frame.add(this.panelSouth, "South");
        this.frame.add(this.ta, "Center");
        this.frame.add(this.panelNorth, "North");
        this.frame.setSize(800, 400);
        this.frame.setVisible(true);
        //add user
        btRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User(userNameTextRegister.getText().toString(), passwordTextRegister.getText().toString());
                vm.addItem(user);
            }
        });
        // check login
        /**
         * Check if user is exists on the Data Base
         * if exists display the cost ui
         */
        btLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User(userNameTextLogin.getText().toString(), passwordTextLogin.getText().toString());
                vm.checkLogin(user);
            }
        });

    }

    /**
     * Display the message that recive from the server on the label.
     * @param message the message
     */
    //@Override
    public void showMessage(String message) {
        tfMessage.setText(message);
        new java.util.Timer().schedule(new TimerTask() {

            @Override
            public void run() {

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        tfMessage.setText("");
                    }
                });
            }
        }, 5000);
    }

    /**
     * show messagee that recive from the server in the label cost ui
     * @param message the message
     */
    //@Override
    public void showMessage2(String message) {
        loginLabelStatus.setText(message);
        new java.util.Timer().schedule(new TimerTask() {

            @Override
            public void run() {

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        loginLabelStatus.setText("Status");
                    }
                });
            }
        }, 5000);
    }

    /**
     * Set ViewModel Instance.
     * @param vm the vm
     */
    //@Override
    public void setIViewModel(ViewModel vm) {

        this.vm = vm;
    }


    /**
     * Init the cost UI.
     */
    public void initCost() {
        this.frame = new JFrame();
        this.untilDateText = new JTextField(10);
        this.fromDateText = new JTextField(10);
        this.fromDate = new JLabel("From Date : yyyy-mm-dd ");
        this.untilDate = new JLabel(" Until Date : yyyy-mm-dd ");
        this.dateLabel = new JLabel("Date : yyyy-mm-dd ");
        this.userNameLabel = new JLabel("User Name :");
        this.getMyCosts = new JButton("Get My Costs");
        this.myCostsLabel = new JLabel("My Costs ");
        this.category = new JLabel("Category :");
        this.categoryText = new JTextField(10);
        this.dateText = new JTextField(10);
        this.addCost = new JButton("Add Cost");
        this.currencyText = new JTextField(10);
        this.userName = new JLabel(userName2);
        this.sum = new JLabel("sum : ");
        this.text = new JLabel("text : ");
        this.textText = new JTextField(10);
        this.currency = new JLabel(" currency : ");
        this.sumText = new JTextField(10);
        // this.btLogin = new JButton("Login");
        this.ta3 = new JTextArea();
        this.panelSouth = new JPanel();
        this.panelNorth = new JPanel();
        this.getBySpecialDate = new JButton("Get Special Date");
        tfMessage = new JLabel("Status");
    }

    /**
     * Start the cost UI.
     */
    //@Override
    public void startCost() {
        this.panelNorth.setBackground(Color.GREEN);
        this.panelNorth.setLayout(new FlowLayout());
        this.panelNorth.add(userNameLabel);
        this.panelNorth.add(this.userName);
        this.panelNorth.add(dateLabel);
        this.panelNorth.add(dateText);
        this.panelNorth.add(this.category);
        this.panelNorth.add(this.categoryText);
        this.panelNorth.add(this.sum);
        this.panelNorth.add(this.sumText);
        this.panelNorth.add(this.currency);
        this.panelNorth.add(this.currencyText);
        this.panelNorth.add(this.text);
        this.panelNorth.add(this.textText);
        this.panelNorth.add(tfMessage);
        this.panelNorth.add(addCost);
        this.panelNorth.add(getMyCosts);
        this.panelNorth.add(fromDate);
        this.panelNorth.add(fromDateText);
        this.panelNorth.add(untilDate);
        this.panelNorth.add(untilDateText);
        this.panelNorth.add(getBySpecialDate);
        this.frame.setLayout(new BorderLayout());
        this.frame.add(myCostsLabel);
        this.frame.add(this.ta3, "Center");
        this.frame.add(this.panelNorth, "North");
        this.frame.setSize(2000, 1200);
        this.frame.setVisible(true);
        // add cost by user name
        /**
         * Add cost Button Click.
         */
        addCost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cost cost = new Cost(userName.getText(), categoryText.getText(), textText.getText(), currencyText.getText(), Double.parseDouble(sumText.getText()), dateText.getText());
                vm.addItem(cost);
            }
        });
        /**
         * Button Click - Get all costs for specific user Name.
         */
        // get all costs by id
        getMyCosts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vm.getMyCosts(userName.getText());
            }
        });
        /**
         * Button click - get all filter by date costs.
         */
        // get filter costs by date
        getBySpecialDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FilterDateByUserName filterDate = new FilterDateByUserName(userName.getText(), fromDateText.getText(), untilDateText.getText());
                vm.getSpecialCostsByDate(filterDate);
            }
        });


    }

    /**
     * Display the cost On the UI.
     * @param message
     */
   // @Override
    public void showMessageCost(String message) {
        ta3.setText(message);
        new java.util.Timer().schedule(new TimerTask() {

            @Override
            public void run() {

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ta3.setText("");
                    }
                });
            }
        }, 100000);
    }


}

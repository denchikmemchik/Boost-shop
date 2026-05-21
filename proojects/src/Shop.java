import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Shop {
    private JPanel bustShop;
    private JLabel startLabel;
    private JButton baseButton;
    private JLabel levelLabel;
    private JButton silverButton;
    private JButton goldButton;
    private JLabel follower;
    private JLabel price;
    private JLabel followerCount;
    private JLabel priceCount;
    private JTextField countField;
    private JLabel count;
    private JLabel country;
    private JComboBox<String> countryBox;
    private JLabel ageLabel;
    private JComboBox<String> ageBox;
    private JButton buyButton;
    private JLabel followerTotal;
    private JLabel priceTotal;
    private JLabel totalFollower;
    private JLabel totalPrice;

    public Shop() {
        follower.setVisible(false);
        price.setVisible(false);
        country.setVisible(false);
        ageLabel.setVisible(false);
        countryBox.setVisible(false);
        ageBox.setVisible(false);
        baseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                follower.setVisible(true);
                price.setVisible(true);
                country.setVisible(false);
                ageLabel.setVisible(false);
                countryBox.setVisible(false);
                ageBox.setVisible(false);
                countryBox.setSelectedItem(" ");
                ageBox.setSelectedItem(" ");
                Base base = new Base();

                followerCount.setText(String.valueOf(base.followers()));
                priceCount.setText(String.valueOf(base.price()) + " " + "€");
            }
        });
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tot = countField.getText();
                int total = Integer.parseInt(tot);
                String priceText = priceCount.getText();
                priceText = priceText.replace("€", "").trim();

                if (total>0){
                int ftot = Integer.parseInt(followerCount.getText())  * total;
                int ptot = Integer.parseInt(priceText) * total;
                totalFollower.setText(String.valueOf(ftot));
                totalPrice.setText((String.valueOf(ptot)) + " " + "€");
                try {

                    FileWriter writer = new FileWriter("data.txt", true);

                    if ((countryBox.getSelectedItem() == " ") && (ageBox.getSelectedItem() == " ")){
                        Base bs = new Base(ftot,ptot);

                        writer.write(bs.print());
                    } else{
                        if ((countryBox.getSelectedItem() != " ") && (ageBox.getSelectedItem() == " ")){
                            Silver sc = new Silver(ftot,ptot, (String) countryBox.getSelectedItem());

                            writer.write(sc.print());

                        }else {
                            if ((countryBox.getSelectedItem() != " ") && (ageBox.getSelectedItem() != " ")){
                                Gold gd = new Gold(ftot,ptot, (String) countryBox.getSelectedItem(), (String) ageBox.getSelectedItem());
                                writer.write(gd.print());
                            }
                        }

                    }



                    writer.close();

                    JOptionPane.showMessageDialog(bustShop,
                            "Текст сохранён!");

                } catch (IOException ex) {
                    ex.printStackTrace();
                }}

                follower.setVisible(false);
                price.setVisible(false);
                country.setVisible(false);
                countryBox.setVisible(false);
                ageLabel.setVisible(false);
                ageBox.setVisible(false);
                followerCount.setText("");
                priceCount.setText("");
                countField.setText("");
                countryBox.setSelectedItem(" ");
                ageBox.setSelectedItem(" ");
            }
        });
        silverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                follower.setVisible(true);
                price.setVisible(true);
                country.setVisible(true);
                countryBox.setVisible(true);
                ageLabel.setVisible(false);
                ageBox.setVisible(false);
                ageBox.setSelectedItem(" ");

                Silver silver = new Silver();
                followerCount.setText(String.valueOf(silver.followers()));
                priceCount.setText(String.valueOf(silver.price()) + " " + "€");

            }
        });
        goldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                follower.setVisible(true);
                price.setVisible(true);
                country.setVisible(true);
                countryBox.setVisible(true);
                ageLabel.setVisible(true);
                ageBox.setVisible(true);
                Gold gold = new Gold();
                followerCount.setText(String.valueOf(gold.followers()));
                priceCount.setText(String.valueOf(gold.price()) + " " + "€");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Shop");
        frame.setContentPane(new Shop().bustShop);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(1000,800);
        frame.setVisible(true);

    }

    private void createUIComponents() {
        countryBox = new JComboBox<>();
        countryBox.addItem(" ");
        countryBox.addItem("Argentina");
        countryBox.addItem("Australia");
        countryBox.addItem("Brazil");
        countryBox.addItem("Canada");
        countryBox.addItem("China");
        countryBox.addItem("Egypt");
        countryBox.addItem("France");
        countryBox.addItem("Germany");
        countryBox.addItem("India");
        countryBox.addItem("Italy");
        countryBox.addItem("Japan");
        countryBox.addItem("Mexico");
        countryBox.addItem("Norway");
        countryBox.addItem("South Africa");
        countryBox.addItem("United Kingdom");
        ageBox = new  JComboBox<>();
        ageBox.addItem(" ");
        ageBox.addItem("0 - 17");
        ageBox.addItem("18 - 44");
        ageBox.addItem("45 - 59");
        ageBox.addItem("60 - 74");
        ageBox.addItem("75 - 90");


        // TODO: place custom component creation code here
    }
}

package lntfinalproject;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class InsertDataPanel extends JPanel {
	JTextField nameField;
	JTextField hargaField;
	JTextField qtyField;
	Database db = new Database();
	
    public InsertDataPanel() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JPanel left = new JPanel(new GridLayout(3, 1));
        JLabel nameLabel = new JLabel("Menu name   : ");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        nameLabel.setHorizontalAlignment(JLabel.LEFT);
        JLabel hargaLabel = new JLabel("Menu price    : ");
        hargaLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        hargaLabel.setHorizontalAlignment(JLabel.LEFT);
        JLabel qtyLabel = new JLabel("Menu stock    : ");
        qtyLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        qtyLabel.setHorizontalAlignment(JLabel.LEFT);
        left.add(nameLabel);
        left.add(hargaLabel);
        left.add(qtyLabel);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.anchor = GridBagConstraints.LINE_END;
        this.add(left, gbc);

        JPanel right = new JPanel(new GridLayout(3, 1));
        nameField = new JTextField(10);
        nameField.setFont(new Font("Arial", Font.PLAIN, 22));
        hargaField = new JTextField(10);
        hargaField.setFont(new Font("Arial", Font.PLAIN, 22));
        qtyField = new JTextField(10);
        qtyField.setFont(new Font("Arial", Font.PLAIN, 22));
        right.add(nameField);
        right.add(hargaField);
        right.add(qtyField);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.ipadx = 50;
        this.add(right, gbc);

        JPanel low = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton sendButton = new JButton("SUBMIT");
        JButton cancelButton = new JButton("CANCEL");
        low.add(sendButton);
        low.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(InsertDataPanel.this);
                frame.dispose();
            }
        });
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nameField.getText().isEmpty() || hargaField.getText().isEmpty() || qtyField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Data is empty!");
                } else {
                	add();
                    JOptionPane.showMessageDialog(null, "Data successfully inserted!");
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(InsertDataPanel.this);
                    frame.dispose();
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(low, gbc);
    }
    
    public void add() {
        String name = nameField.getText();
        int price = Integer.parseInt(hargaField.getText());
        int stock = Integer.parseInt(qtyField.getText());
        String code = "PD-" + (int)(Math.random() * 1000);
        Menu newMenu = new Menu(code, name, price, stock);
        db.insert(newMenu);
    }
}

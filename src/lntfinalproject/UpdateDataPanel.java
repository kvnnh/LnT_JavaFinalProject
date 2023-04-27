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

public class UpdateDataPanel extends JPanel {
	JTextField kodeField;
	JTextField hargaField;
	JTextField qtyField;
	Database db = new Database();
    public UpdateDataPanel() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JPanel left = new JPanel(new GridLayout(3, 1));
        JLabel kodeLabel = new JLabel("Enter the menu code   : ");
        kodeLabel.setFont(new Font("Arial", Font.PLAIN,18));
        kodeLabel.setHorizontalAlignment(JLabel.LEFT);
        JLabel hargaLabel = new JLabel("Price after change      : ");
        hargaLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        hargaLabel.setHorizontalAlignment(JLabel.LEFT);
        JLabel qtyLabel = new JLabel("Stock after change      : ");
        qtyLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        qtyLabel.setHorizontalAlignment(JLabel.LEFT);
        left.add(kodeLabel);
        left.add(hargaLabel);
        left.add(qtyLabel);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.anchor = GridBagConstraints.LINE_END;
        this.add(left, gbc);

        JPanel right = new JPanel(new GridLayout(3, 1));
        kodeField = new JTextField(10);
        kodeField.setFont(new Font("Arial", Font.PLAIN, 22));
        hargaField = new JTextField(10);
        hargaField.setFont(new Font("Arial", Font.PLAIN, 22));
        qtyField = new JTextField(10);
        qtyField.setFont(new Font("Arial", Font.PLAIN, 22));
        right.add(kodeField);
        right.add(hargaField);
        right.add(qtyField);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.ipadx = 50;
        this.add(right, gbc);

        JPanel low = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton sendButton = new JButton("UPDATE");
        JButton cancelButton = new JButton("CANCEL");
        low.add(sendButton);
        low.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(UpdateDataPanel.this);
                frame.dispose();
            }
        });
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (kodeField.getText().isEmpty() || hargaField.getText().isEmpty() || qtyField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Data has not been filled in!");
                } else {
                	update();
					if(db.isChange) {
                		JOptionPane.showMessageDialog(null, "Data successfully updated!");
                		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(UpdateDataPanel.this);
                        frame.dispose();
                	}
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(low, gbc);
    }
    
    public void update() {
    	String code = kodeField.getText();
        int price = Integer.parseInt(hargaField.getText());
        int stock = Integer.parseInt(qtyField.getText());
        Menu newMenu = new Menu(code, price, stock);
        db.update(newMenu);
    }
}
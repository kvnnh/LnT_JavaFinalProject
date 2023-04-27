package lntfinalproject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DeleteDataPanel extends JPanel {
	JTextField kodeField;
	Database db = new Database();
	
    public DeleteDataPanel() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        JPanel up = new JPanel(new GridLayout(1, 2));
        up.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
        JLabel kodeLabel = new JLabel("Menu Code:");
        kodeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        kodeLabel.setHorizontalAlignment(JLabel.LEFT);
        kodeField = new JTextField(10);
        kodeField.setFont(new Font("Arial", Font.PLAIN, 18));
        kodeField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        up.add(kodeLabel);
        up.add(kodeField);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(up, gbc);

        JPanel low = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton deleteButton = new JButton("DELETE");
        JButton cancelButton = new JButton("CANCEL");
        low.add(deleteButton);
        low.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(DeleteDataPanel.this);
                frame.dispose();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (kodeField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the code!");
                } else {
                	delete();
					if(db.isChange) {
                		JOptionPane.showMessageDialog(null, "Data successfully deleted!");
                		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(DeleteDataPanel.this);
                        frame.dispose();
                	}
                }
            }
        });
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(low, gbc);
    }
    
    public void delete() {
    	String kode = kodeField.getText();
        Menu newMenu = new Menu(kode);
        db.delete(newMenu);
    }
}
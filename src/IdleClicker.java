import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IdleClicker extends JFrame{
	public IdleClicker() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Click for Greatness!");
		lblNewLabel_1.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(141, 5, 190, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Level:");
		lblNewLabel.setBounds(341, 49, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblHealth = new JLabel("Health:");
		lblHealth.setBounds(341, 90, 46, 14);
		panel.add(lblHealth);
		
		JLabel lblAttack = new JLabel("Attack:");
		lblAttack.setBounds(341, 130, 46, 14);
		panel.add(lblAttack);
		
		JLabel lblDefense = new JLabel("Defense:");
		lblDefense.setBounds(341, 170, 46, 14);
		panel.add(lblDefense);
		
		JLabel lblExp = new JLabel("EXP:");
		lblExp.setBounds(341, 213, 46, 14);
		panel.add(lblExp);
		
		JLabel lblLvlCnt = new JLabel("1");
		lblLvlCnt.setBounds(397, 49, 46, 14);
		panel.add(lblLvlCnt);
		
		JLabel lblHltCnt = new JLabel("5/5");
		lblHltCnt.setBounds(397, 90, 46, 14);
		panel.add(lblHltCnt);
		
		JLabel lblAttCnt = new JLabel("1");
		lblAttCnt.setBounds(397, 130, 46, 14);
		panel.add(lblAttCnt);
		
		JLabel lblDefCnt = new JLabel("0");
		lblDefCnt.setBounds(397, 170, 46, 14);
		panel.add(lblDefCnt);
		
		JLabel lblExpCnt = new JLabel("0/5");
		lblExpCnt.setBounds(397, 213, 46, 14);
		panel.add(lblExpCnt);
		
		JButton btnAttack = new JButton("Attack!");
		btnAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAttack.setBounds(183, 263, 89, 23);
		panel.add(btnAttack);
	}

	public static void main(String[] args) {
		
	}
}

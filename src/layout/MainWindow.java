package layout;

import java.awt.Color;
import java.awt.Font;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JTextField textField;
	private JRadioButton rdbtnFile;
	private JPanel panel_4;
	private JPanel panel_5;
	private JButton btnEncrypt;
	private JButton btnDecrypt;
	private JTextField key1;
	private JTextField key2;
	private JTextField key3;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JRadioButton rdbtnYes;

	public MainWindow() {
		setAll();
	}

	public void setAll() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("Cryptography");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), "Input", TitledBorder.CENTER, TitledBorder.TOP,
				null, new Color(255, 0, 0)));
		panel.setBounds(10, 0, 422, 168);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 24, 402, 127);
		panel.add(scrollPane);

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(textArea);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Output",
				TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		panel_1.setBounds(10, 179, 422, 168);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(10, 28, 402, 127);
		panel_1.add(scrollPane_1);

		textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane_1.setViewportView(textArea_1);

		btnEncrypt = new JButton("Encrypt");
		btnEncrypt.setActionCommand("EN");
		btnEncrypt.setBounds(341, 358, 91, 42);
		contentPane.add(btnEncrypt);

		btnDecrypt = new JButton("Decrypt");
		btnDecrypt.setActionCommand("DE");
		btnDecrypt.setBounds(341, 411, 91, 42);
		contentPane.add(btnDecrypt);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Method",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 359, 121, 125);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JRadioButton rdbtnDesx = new JRadioButton("DESX", true);
		rdbtnDesx.setActionCommand("A");
		rdbtnDesx.setBounds(6, 16, 109, 23);
		panel_3.add(rdbtnDesx);
		buttonGroup.add(rdbtnDesx);

		JRadioButton rdbtnKnapsack = new JRadioButton("Knapsack");
		rdbtnKnapsack.setActionCommand("B");
		rdbtnKnapsack.setBounds(6, 56, 109, 23);
		panel_3.add(rdbtnKnapsack);
		buttonGroup.add(rdbtnKnapsack);

		JRadioButton rdbtnThird = new JRadioButton("RSA");

		rdbtnThird.setActionCommand("C");
		rdbtnThird.setBounds(6, 95, 109, 23);
		panel_3.add(rdbtnThird);
		buttonGroup.add(rdbtnThird);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Input/Output",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(141, 358, 121, 68);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		rdbtnFile = new JRadioButton("File");
		rdbtnFile.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (rdbtnFile.isSelected())
					panel_4.setVisible(true);
				else
					panel_4.setVisible(false);

			}
		});
		rdbtnFile.setBounds(6, 16, 109, 23);
		rdbtnFile.setActionCommand("D");
		panel_2.add(rdbtnFile);
		buttonGroup_1.add(rdbtnFile);

		JRadioButton rdbtnWindow = new JRadioButton("Window", true);
		rdbtnWindow.setActionCommand("E");
		rdbtnWindow.setBounds(6, 39, 109, 23);
		panel_2.add(rdbtnWindow);
		buttonGroup_1.add(rdbtnWindow);

		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "File Name",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(141, 436, 182, 48);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setVisible(false);

		textField = new JTextField();
		textField.setBounds(10, 17, 162, 20);
		panel_4.add(textField);
		textField.setColumns(10);

		panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Public keys",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 487, 422, 85);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setVisible(false);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "key 1", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_6.setBounds(10, 24, 132, 52);
		panel_5.add(panel_6);
		panel_6.setLayout(null);

		key1 = new JTextField();
		key1.setBounds(10, 21, 114, 20);
		panel_6.add(key1);
		key1.setColumns(10);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "key 2", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_7.setBounds(150, 24, 134, 53);
		panel_5.add(panel_7);
		panel_7.setLayout(null);

		key2 = new JTextField();
		key2.setBounds(10, 21, 114, 20);
		panel_7.add(key2);
		key2.setColumns(10);

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "key 3", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_8.setBounds(294, 24, 118, 53);
		panel_5.add(panel_8);
		panel_8.setLayout(null);

		key3 = new JTextField();
		key3.setBounds(10, 22, 98, 20);
		panel_8.add(key3);
		key3.setColumns(10);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(null, "Key", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_9.setBounds(272, 358, 59, 78);
		contentPane.add(panel_9);
		panel_9.setLayout(null);

		JRadioButton rdbtnNo = new JRadioButton("no");
		rdbtnNo.setSelected(true);
		buttonGroup_2.add(rdbtnNo);
		rdbtnNo.setBounds(8, 23, 37, 23);
		panel_9.add(rdbtnNo);

		rdbtnYes = new JRadioButton("yes");
		rdbtnYes.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (rdbtnYes.isSelected())
					panel_5.setVisible(true);
				else
					panel_5.setVisible(false);

			}
		});
		buttonGroup_2.add(rdbtnYes);
		rdbtnYes.setBounds(8, 49, 43, 23);
		panel_9.add(rdbtnYes);

	}

	public String getInput() {
		return textArea.getText();
	}

	public void setInput(String in) {
		textArea.setText(in);
	}

	public String getOutput() {
		return textArea_1.getText();
	}

	public void setOutput(String in) {
		textArea_1.setText(in);
	}

	public int getMethod() {
		if (buttonGroup.getSelection().getActionCommand().equals("A"))
			return 1;// DESX
		if (buttonGroup.getSelection().getActionCommand().equals("B"))
			return 2;// Knapsack
		else
			return 3;// AA
	}

	public int getFileOrWindow() {
		if (buttonGroup_1.getSelection().getActionCommand().equals("D"))
			return 1;// Plik
		else
			return 2;// Okno
	}

	public String getFileName() {
		if (getFileOrWindow() == 1)
			return textField.getText();
		else
			return null;
	}

	public void setController(AbstractAction a) {
		btnDecrypt.addActionListener(a);
		btnEncrypt.addActionListener(a);
	}
	public String getKey1() {
		return key1.getText();
	}

	public void setKey1(String key1) {
		this.key1.setText(key1);
	}

	public String getKey2() {
		return key2.getText();
	}

	public void setKey2(String key2) {
		this.key2.setText(key2);
	}
	public String getKey3() {
		return key3.getText();
	}

	public void setKey3(String key3) {
		this.key3.setText(key3);
	}

}

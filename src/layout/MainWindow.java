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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JLabel;

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
	private JRadioButton rdbtnFileIn;
	private JPanel panel_5;
	private JButton btnEncrypt;
	private JButton btnDecrypt;
	private JButton btnGenerateKeys;
	private JTextField key1;
	private JTextField key2;
	private JTextField key3;
	private File fileIn;
	private File fileOut;
	private JRadioButton rdbtFileOut;
	private JRadioButton rdbtWindowsOut;
	private JRadioButton rdbtnWindowIn;
	private JLabel labelFrom;
	private JLabel labelTo;
	
	
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
		setTitle("Cryptography, blind signature with RSA");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 622);
		contentPane = new JPanel();
		contentPane.setToolTipText("Generate keys");
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
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEncrypt.setActionCommand("EN");
		btnEncrypt.setBounds(341, 358, 83, 33);
		contentPane.add(btnEncrypt);

		btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		btnDecrypt.setActionCommand("DE");
		btnDecrypt.setBounds(341, 402, 83, 33);
		contentPane.add(btnDecrypt);
		
		btnGenerateKeys = new JButton("Keys");
		btnGenerateKeys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGenerateKeys.setActionCommand("GENERATE_KEYS");
		btnGenerateKeys.setBounds(341, 446, 83, 33);
		contentPane.add(btnGenerateKeys);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Input",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 358, 150, 68);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		rdbtnFileIn = new JRadioButton("File");

		rdbtnFileIn.setBounds(6, 16, 109, 23);
		rdbtnFileIn.setActionCommand("FileIn");
		panel_2.add(rdbtnFileIn);
		buttonGroup_1.add(rdbtnFileIn);

		rdbtnWindowIn = new JRadioButton("Window", true);
		rdbtnWindowIn.setBounds(6, 39, 109, 23);
		rdbtnWindowIn.setActionCommand("WindowIn");
		panel_2.add(rdbtnWindowIn);
		buttonGroup_1.add(rdbtnWindowIn);

		panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Keys",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 487, 422, 85);
		contentPane.add(panel_5);
		panel_5.setLayout(null);


		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "key N", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_6.setBounds(10, 24, 132, 52);
		panel_5.add(panel_6);
		panel_6.setLayout(null);

		key1 = new JTextField();
		key1.setBounds(10, 21, 114, 20);
		panel_6.add(key1);
		key1.setColumns(10);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "key E", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_7.setBounds(150, 24, 134, 53);
		panel_5.add(panel_7);
		panel_7.setLayout(null);

		key2 = new JTextField();
		key2.setBounds(10, 21, 114, 20);
		panel_7.add(key2);
		key2.setColumns(10);

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "key D", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_8.setBounds(294, 24, 118, 53);
		panel_5.add(panel_8);
		panel_8.setLayout(null);

		key3 = new JTextField();
		key3.setBounds(10, 22, 98, 20);
		panel_8.add(key3);
		key3.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Output",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setLayout(null);
		panel_3.setBounds(170, 358, 150, 68);
		contentPane.add(panel_3);
		
		rdbtFileOut = new JRadioButton("File");
		rdbtFileOut.setActionCommand("FileOut");
		rdbtFileOut.setBounds(6, 16, 109, 23);
		panel_3.add(rdbtFileOut);
		buttonGroup.add(rdbtFileOut);
		
		rdbtWindowsOut = new JRadioButton("Window", true);
		rdbtWindowsOut.setBounds(6, 39, 109, 23);
		rdbtWindowsOut.setActionCommand("WindowOut");
		panel_3.add(rdbtWindowsOut);
		buttonGroup.add(rdbtWindowsOut);


		labelFrom = new JLabel("");
		labelFrom.setBounds(10, 437, 310, 14);
		contentPane.add(labelFrom);
		
		labelTo = new JLabel("");
		labelTo.setBounds(10, 462, 310, 14);
		contentPane.add(labelTo);

	}

	public String getInput() {
		return textArea.getText();
	}

	public void setInput(String in) {
		textArea.setText(in);
	}
	public void setInput2(String in) {
		if(textArea.getText().isEmpty())textArea.setText(in);
		textArea.setText(textArea.getText()+"\n"+in);
	}

	public String getOutput() {
		return textArea_1.getText();
	}

	public void setOutput(String in) {
		textArea_1.setText(in);
	}

//	public int getFileOrWindowIn() {
//		if (buttonGroup_1.getSelection().getActionCommand().equals("D"))
//			return 1;// Plik
//		else
//			return 2;// Okno
//	}
//	public int getFileOrWindowOut() {
//		if (buttonGroup.getSelection().getActionCommand().equals("D"))
//			return 1;// Plik
//		else
//			return 2;// Okno
//	}

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
	public void setController(AbstractAction a) {
		btnDecrypt.addActionListener(a);
		btnEncrypt.addActionListener(a);
		btnGenerateKeys.addActionListener(a);
		rdbtFileOut.addActionListener(a);
		rdbtnFileIn.addActionListener(a);
		rdbtWindowsOut.addActionListener(a);
		rdbtnWindowIn.addActionListener(a);
		//cos
	}

	public JRadioButton getRdbtFileOut() {
		return rdbtFileOut;
	}
	public JRadioButton getRdbtnWindowIn() {
		return rdbtnWindowIn;
	}
	public JRadioButton getRdbtnFileIn() {
		return rdbtnFileIn;
	}
	public JRadioButton getRdbtWindowsOut() {
		return rdbtWindowsOut;
	}

	public File getFileIn() {
		return fileIn;
	}

	public void setFileIn(File fileIn) {
		this.fileIn = fileIn;
	}

	public File getFileOut() {
		return fileOut;
	}

	public void setFileOut(File fileOut) {
		this.fileOut = fileOut;
	}
	public JLabel getLabelFrom() {
		return labelFrom;
	}
	public JLabel getLabelTo() {
		return labelTo;
	}

	public void setLabelFrom(String labelFrom) {
		this.labelFrom.setText(labelFrom);
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JTextArea getTextArea_1() {
		return textArea_1;
	}

	public void setLabelTo(String labelTo) {
		this.labelTo.setText(labelTo);
	}
}

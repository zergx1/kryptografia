package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import layout.MainWindow;
import model.Rsa;

public class Controller extends AbstractAction implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainWindow window;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("EN")) {
			// encrypt
			if (window.getMethod() == 1) {
				// DESX
				if (window.getFileOrWindow() == 1) {
					// File
					String fileName = window.getFileName();
				} else {
					// Window
				}
			}
			if (window.getMethod() == 2) {
				// Knapsack
				if (window.getFileOrWindow() == 1) {
					// File
					String fileName = window.getFileName();
				} else {
					// Window
				}
			}
			if (window.getMethod() == 3) {
				// RSA
				Rsa blind=new Rsa();
				
				if(window.getKey1().isEmpty() && window.getKey2().isEmpty() && window.getKey3().isEmpty())
				{
					blind.generate_rsa();
					window.setKey1(blind.getN().toString());
					window.setKey2(blind.getE().toString());
					window.setKey3(blind.getD().toString());					
				}
				else
					{
					if(window.getKey1().isEmpty() || window.getKey2().isEmpty() || window.getKey3().isEmpty())
						JOptionPane.showMessageDialog(window,
							    "Brakuje klucza",
							    "Blad",
							    JOptionPane.ERROR_MESSAGE);
					else
					{
						blind.setN(new BigInteger(window.getKey1()));
						blind.setE(new BigInteger(window.getKey2()));
						blind.setD(new BigInteger(window.getKey3()));
					}

				
				if (window.getFileOrWindow() == 1) {
					// File
					String fileName = window.getFileName();
				} else {
					// Window
				}

			}
		} else {
			// decrypt
			if (window.getMethod() == 1) {
				// DESX
				if (window.getFileOrWindow() == 1) {
					// File
					String fileName = window.getFileName();
				} else {
					// Window
				}
			}
			if (window.getMethod() == 2) {
				// Knapsack
				if (window.getFileOrWindow() == 1) {
					// File
					String fileName = window.getFileName();
				} else {
					// Window
				}
			}
			if (window.getMethod() == 3) {
				// Third
				if (window.getFileOrWindow() == 1) {
					// File
					String fileName = window.getFileName();
				} else {
					// Window
				}

			}
		}
			}
	}

	public Controller() {
		window = new MainWindow();
		window.setAll();
		window.repaint();
		window.setController(this);
	}

}

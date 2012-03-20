package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;

import layout.MainWindow;
import model.RSA;

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
				RSA blind=new RSA();
				
				if(window.getKey1().isEmpty())
				{
					window.setKey1(blind.generateN().toString());
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

	public Controller() {
		window = new MainWindow();
		window.setAll();
		window.repaint();
		window.setController(this);
	}

}

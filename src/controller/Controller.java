package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	private Rsa blind=new Rsa();

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("GENERATE_KEYS"))
		{
			blind.generateRsaKeys();
			window.setKey1(blind.getN().toString());
			window.setKey2(blind.getE().toString());
			window.setKey3(blind.getD().toString());
		}
		if (e.getActionCommand().equals("EN")) {

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

				
//				if (window.getFileOrWindow() == 1) {
//					// File
//					String fileName = window.getFileName();
//					// czytanie pliku
//					FileReader fr;
//					try {
//						fr = new FileReader(fileName);
//						BufferedReader br = new BufferedReader(fr);
//						String s;
//					
//						while((s = br.readLine()) != null)
//						{
//						window.setInput2(s);
//						}
//						fr.close();
//						
//						//Kodowanie
//						
//						
//					} catch (FileNotFoundException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//			
//				} 
					
					if(blind.getD()!=null)
					window.setOutput( blind.return_encrypted_msg( window.getInput() ));

			
		} 
		
		if(e.getActionCommand().equals("DE"))
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
					
		
				window.setOutput( blind.return_decrypted_msg( window.getInput() ));

		}

		
			
	}

	public Controller() {
		window = new MainWindow();
		window.setAll();
		window.repaint();

		//window.setController(this);
	}

}

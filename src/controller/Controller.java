package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
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
	private JFileChooser fc=new JFileChooser();
	private File file;
	private boolean winIn=true;
	private boolean winOut=true;

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
		if(e.getActionCommand().equals("FileIn"))
		{
			int returnVal = fc.showOpenDialog(window);

		      if (returnVal == JFileChooser.APPROVE_OPTION) {
		    	  file=fc.getSelectedFile();
		    	  window.setFileIn(file);
		    	  window.setLabelFrom("From: "+file.toPath().toString());
		    	  window.getTextArea().setEditable(false);
		    	  window.getTextArea().setText("");
		    	  window.getTextArea().setBackground(Color.LIGHT_GRAY);
		    	  winIn=false;
		      } 
		      else
		    	  if(winIn==true)
		    	  window.getRdbtnWindowIn().setSelected(true);
			
		}
		if(e.getActionCommand().equals("FileOut"))
		{
			int returnVal = fc.showSaveDialog(window);

		      if (returnVal == JFileChooser.APPROVE_OPTION) {
		    	  file=fc.getSelectedFile();
		    	  window.setFileOut(file);
		    	  window.setLabelTo("To: "+file.toPath().toString());
		    	  window.getTextArea_1().setEditable(false);
		    	  window.getTextArea_1().setText("");
		    	  window.getTextArea_1().setBackground(Color.LIGHT_GRAY);
		    	  winOut=false;
		      } 
		      else
		      {
		    	  if(winOut==true)
		    	  {
		    	  window.getRdbtWindowsOut().setSelected(true);
		    	  window.getRdbtFileOut().setSelected(false);
		    	  }
		      }
		}
		if(e.getActionCommand().equals("WindowIn"))
		{
			window.setLabelFrom("");
	    	  window.getTextArea().setEditable(true);
	    	  window.getTextArea().setBackground(Color.white);
	    	  winIn=true;
		}
		if(e.getActionCommand().equals("WindowOut"))
		{
			window.setLabelTo("");
	    	  window.getTextArea_1().setEditable(true);
	    	  window.getTextArea_1().setBackground(Color.white);
	    	  winOut=true;
		}
		
		
		
		if (e.getActionCommand().equals("EN")) {
			System.out.println("ENCRYPTED");
					if(window.getKey1().isEmpty() || window.getKey2().isEmpty() || window.getKey3().isEmpty())
					{
						JOptionPane.showMessageDialog(window,
							    "Brakuje klucza",
							    "Blad",
							    JOptionPane.ERROR_MESSAGE);
						return;
					}
					else
					{				
							blind.setN(new BigInteger(window.getKey1()));
							blind.setE(new BigInteger(window.getKey2()));
							blind.setD(new BigInteger(window.getKey3()));						
					}

					if(winIn==true)
					{
						//z pola tekstowego
						if(winOut==true)
						{
							//do pola tekstowego
							window.setOutput( blind.return_encrypted_msg( window.getInput() ));
						}
						else
						{
							//do pliku
							FileOutputStream fos;
							try {
								fos = new FileOutputStream(window.getFileOut());	
					        try {
					        	String en = blind.return_encrypted_msg( window.getInput() );
					            //en = blind.return_decrypted_msg(en);
								fos.write(en.getBytes());
						        fos.flush();
						        fos.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					        } catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
						}
					}
					else
					{
						//z pliku
						try {
							byte[] by = blind.fileToBytes(window.getFileIn());
							System.out.println(window.getFileIn());
							try
							{
								System.out.println("Z pliku encrypt");
								BigInteger bigby = new BigInteger( by );
								by = bigby.toByteArray();
							    String en = blind.return_encrypted_msg( by );
								if(winOut==true)
								{
								//do pola tekstowego
								window.setOutput(en);
								}
								else
								{
									//do pliku

							        FileOutputStream fos = new FileOutputStream(window.getFileOut());
							        try {
										fos.write(en.getBytes());
								        fos.flush();
								        fos.close();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}
							catch(java.lang.NumberFormatException e1)
							{
								JOptionPane.showMessageDialog(window,
									    "Plik jest pusty",
									    "Blad",
									    JOptionPane.ERROR_MESSAGE);
							}
							
							
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					        
						
						
					}
		
		} 
		
		if(e.getActionCommand().equals("DE"))
		{
			System.out.println("DECRYPTED");
			if(window.getKey1().isEmpty() || window.getKey2().isEmpty() || window.getKey3().isEmpty())
			{
						JOptionPane.showMessageDialog(window,
							    "Brakuje klucza",
							    "Blad",
							    JOptionPane.ERROR_MESSAGE);
						return;
			}
			else
			{
				blind.setN(new BigInteger(window.getKey1()));
				blind.setE(new BigInteger(window.getKey2()));
				blind.setD(new BigInteger(window.getKey3()));
			}
					
		
				if(winIn==true)
				{
					//z pola tekstowego
					if(winOut==true)
					{
						//do pola tekstowego
						window.setOutput( blind.return_decrypted_msg( window.getInput() ));
					}
					else
					{
						//do pliku
						FileOutputStream fos;
						try {
							fos = new FileOutputStream(window.getFileOut());	
				        try {
				        	String en =window.getInput();
				            en = blind.return_decrypted_msg(en);
							fos.write(en.getBytes());
					        fos.flush();
					        fos.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				        } catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
				}
				else
				{
					//z pliku
					try {
						//byte[] by = blind.fileToBytes(window.getFileIn());
						System.out.println(window.getFileIn());
						FileReader fr = new FileReader(window.getFileIn());
						BufferedReader br = new BufferedReader(fr);
						String s,en="";
						
						try {
							while((s = br.readLine()) != null)
							{
							en+=s;
							}
							
							//fr.close();
							try
							{
								System.out.println("ENCRYPTED z pliku");
								//BigInteger bigby = new BigInteger( by );
								//by = bigby.toByteArray();
							    en=blind.return_decrypted_msg(en);
								if(winOut==true)
								{
								//do pola tekstowego
									System.out.println("Z pliku na konsole");
								window.setOutput(en);
								}
								else
								{
									//do pliku
									System.out.println("Z pliku do pliku");
							        FileOutputStream fos = new FileOutputStream(window.getFileOut());
							        try {
										fos.write(en.getBytes());
								        fos.flush();
								        fos.close();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
						
					}
						catch(java.lang.NumberFormatException e1)
						{
							//z pliku
							try {
								byte[] by = blind.fileToBytes(window.getFileIn());
								System.out.println(window.getFileIn());
								try
								{
									System.out.println("Z pliku encrypt");
									BigInteger bigby = new BigInteger( by );

								    en = blind.return_decrypted_msg( bigby.toString() );
									if(winOut==true)
									{
									//do pola tekstowego
									window.setOutput(en);
									}
									else
									{
										//do pliku

								        FileOutputStream fos = new FileOutputStream(window.getFileOut());
								        try {
											fos.write(en.getBytes());
									        fos.flush();
									        fos.close();
										} catch (IOException e11) {
											// TODO Auto-generated catch block
											e11.printStackTrace();
										}
									}
								}
								catch(java.lang.NumberFormatException e11)
								{
									JOptionPane.showMessageDialog(window,
										    "Plik jest pusty",
										    "Blad",
										    JOptionPane.ERROR_MESSAGE);
								}
								
								
							} catch (FileNotFoundException e11) {
								// TODO Auto-generated catch block
								e11.printStackTrace();
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				        
					
					
				
	

		}

		
			
	}
		}
	public Controller() {
		window = new MainWindow();
		
		window.setAll();
		window.repaint();
		window.setVisible(true);
		window.setController(this);
		window.getRdbtnWindowIn().setSelected(true);
		window.getRdbtWindowsOut().setSelected(true);
		
	}

}

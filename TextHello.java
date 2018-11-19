import javax.swing.*;
import java.io.*;

public class TextHello {

	public static void main(String[] args) {
		
		int userOption;
		String[] options = {"Create File", "Read File", "Delete File"};
		File f = new File("c:/users/user/desktop/textHello.txt");
		String fileContent = "";
		boolean exit = false;
		
		do {
		
		userOption = JOptionPane.showOptionDialog(null, "Please choose one of the following options: ", "TextHello", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
		
			if(userOption == 0) {
				System.out.println("first option chosen");
				
				try {
					f.createNewFile();
					JOptionPane.showMessageDialog(null, "A new file has been created!");
					int addText = JOptionPane.showOptionDialog(null, "Would you like to add text to the file?", "TextHello", 0, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					
					if(addText == 0) {
						String text = JOptionPane.showInputDialog(null, "Please type in the box: ");
						
						try {
							PrintWriter pw = new PrintWriter(f, "UTF-8");
							pw.println(text);
							pw.close();
						}
						catch(Exception e) {
							
						}
					}
				}
				catch(Exception e) {
					//catch all
				}
			}
			else if(userOption == 1) {
				System.out.println("second option chosen");
				
				try {
					BufferedReader br = new BufferedReader(new FileReader(f));
					
					String line;
					
					if((line = br.readLine()) == null) {
						System.out.println("file is empty");
						JOptionPane.showMessageDialog(null, "The file is empty...");
					}
					else {
						System.out.println(line);
						fileContent += line + "\n";
						
						while ((line = br.readLine()) != null) {
						    System.out.println(line);
						    fileContent += line + "\n";
						}
						
						JOptionPane.showMessageDialog(null, "The contents of the file are:\n" + fileContent);
					}
					br.close();
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "File does not exist!");
					//catch all
				}
			}
			else if(userOption == 2) {
				System.out.println("third option chosen");
				
				try {
					f.delete();
					JOptionPane.showMessageDialog(null, "File deleted!");
				}
				catch(Exception e) {
					//catch all
				}
			}
		} while(exit != true);
	}
}

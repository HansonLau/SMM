import java.awt.Component;
import java.util.*;
import javax.swing.JOptionPane;

//https://github.com/HansonLau/SMM.git

public class practice {
	
	private String temptype;
	private int tempamt;
	private double correct = 0; 
	
	public practice() {

		int ans = 1;
		JOptionPane.showMessageDialog(null, "Types of math: \n add\n subtract\n multiply\n divide");
		while(ans == 1) {
			ans = JOptionPane.showConfirmDialog(typ(), "Are you sure you want to " + temptype + "?");
			if (ans == -1)
				System.exit(0);
			if (ans == 2)
				System.exit(0);
			
		}
		ans = 1;
		
		while(ans == 1) {
			ans = JOptionPane.showConfirmDialog(num(), "Are you sure you want " + tempamt + " question(s)?");
			if (ans == -1)
				System.exit(0);
			if (ans == 2)
				System.exit(0);
		}
		
		//generate questions
		questions q = new questions(temptype, tempamt);
		
		//shows questions
		for(problem temp: q.getQuestion()) {
			
			int input = Integer.parseInt(JOptionPane.showInputDialog(temp.getProblem()));
			if(input == temp.getAnswer())
				correct++;
		}
		
		
		int percent = (int) ((((correct/(q.getQuestion().length))*1000) + 5)/10);
		
		JOptionPane.showMessageDialog(null, "You got " + percent + "% correct.");
		
	}
	
	private Component typ() {
		temptype = JOptionPane.showInputDialog("What type?");
		return null;
	}
	private Component num() {
		tempamt  = Integer.parseInt(JOptionPane.showInputDialog("How many questions?"));
		return null;
	}
	
	
	public static void main(String[] args) {
		new practice();
		
	}

}

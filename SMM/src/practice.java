import java.awt.Component;
import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.Date;

//https://github.com/HansonLau/SMM.git

public class practice {
	
	private String type;
	private int amt;
	private double correct = 0; 
	private double[] user;
	
	public practice() {

		int ans = 1;
		JOptionPane.showMessageDialog(null, "Types of math: \n add\n subtract\n multiply\n divide");
		while(ans == 1) {
			ans = JOptionPane.showConfirmDialog(typ(), "Are you sure you want to " + type + "?");
			if (ans == -1)
				System.exit(0);
			if (ans == 2)
				System.exit(0);
			
		}
		ans = 1;
		
		while(ans == 1) {
			ans = JOptionPane.showConfirmDialog(num(), "Are you sure you want " + amt + " question(s)?");
			if (ans == -1)
				System.exit(0);
			if (ans == 2)
				System.exit(0);
		}
		
		//generate questions
		questions q = new questions(type, amt);
		user = new double[amt];
		//shows questions
		long startTime = System.currentTimeMillis();  // timer
		double elapsedTime = 0;
		while (elapsedTime < 2*60*1000) {
			int i = 0;
			for(problem temp: q.getQuestion()) {
				
				if(type.equals("divide")) {
					double input2 = Double.parseDouble(JOptionPane.showInputDialog(temp.getProblem()));
					if(input2 == temp.getAnswer())
						correct++;
					user[i] = input2;
				}
					
				else {
					int input = Integer.parseInt(JOptionPane.showInputDialog(temp.getProblem()));
					if(input == temp.getAnswer())
						correct++;
					user[i] = input;
				}
				i++;
				elapsedTime = (new Date()).getTime() - startTime;
			}
			break;
		}
		
		
		int percent = (int) ((((correct/(q.getQuestion().length))*1000) + 5)/10);
		elapsedTime = (int)elapsedTime/10; 
		elapsedTime = elapsedTime/100; // rounding to one decimal
		
		JOptionPane.showMessageDialog(null, "You got " + percent + "% correct.\n"
				+ "Your answers: " + Arrays.toString(user)
				+ "\nAnswers: " + Arrays.toString(q.getKey())
				+ "\nFinished in " + elapsedTime + " seconds!"); // add time

	}
	
	private Component typ() {
		type = JOptionPane.showInputDialog("What type?");
		return null;
	}
	private Component num() {
		amt  = Integer.parseInt(JOptionPane.showInputDialog("How many questions?"));
		return null;
	}
	
	
	public static void main(String[] args) {
		new practice();
		
	}

}

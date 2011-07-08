import java.util.LinkedList;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		String ans = new String();

		Animal zebra = new Animal("zebra");
		zebra.setQuestion("Is it like a striped horse?");
		Animal root = zebra;
		Animal reference = new Animal("reference");
		Animal current;
		
		int replay = 1;
		while (replay > 0){
			
			String win = "";
			String lose = "";
			current = root;
			
			while(win.equals("") && lose.equals("")){
				
				if (!current.equals(zebra)){
					reference = current;
				}
				System.out.println(current.getQuestion());
				ans = in.nextLine().toLowerCase();
				if (ans.equals("yes")){
					System.out.println("Is your animal a/an "+current.getAnimal()+"?");
					ans = in.nextLine().toLowerCase();
					if(current.getCheckYes()==0){
						if (ans.equals("yes")){
							win = "win";
						}
						else{
							lose = "yesloss";
						}
					}
					else{
						current = current.getYes();
					}
				}
				else{
					if(current.getCheckNo()==0){
						lose = "loss";
					}
					else{
						current = current.getNo();
					}
				}			
			}
			
			if (win.equals("win")){
				System.out.println("I win!!! Thank you for playing.");
			}
			
			else{
				System.out.println("You win!");
				System.out.println("What is your animal? ");
				String new_animal = in.nextLine();
				System.out.println("new_animal: "+new_animal);
				System.out.println("Can you give me a question that would be answered yes for this animal, but no for what I guessed?");
				String new_question = in.nextLine();
				System.out.println("new_question: "+new_question);
				Animal temp = new Animal(new_animal);
				temp.setNo(zebra);
				temp.setQuestion(new_question);
				if (lose.equals("loss")){
						reference.setNo(temp);
				}
				else{
						reference.setYes(temp);
				}				
				if(root.getAnimal().equals("zebra")){
					root = temp;
				}
			}
			
			System.out.println("Would you like to play again?");
			ans = in.nextLine().toLowerCase();
			
			if (ans.equals("no")){
				replay = 0;
			}
		}
	}
}

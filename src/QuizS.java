import java.util.Scanner;

public class QuizS {
	public static void main (String[] Sources) {
		
		QuizSStart();
		
	}
	private static void QuizSStart() {
		
		Scanner consolScan = new Scanner(System.in);
		String whatToDo = "";
		QuizSLetsPlay quiz = new QuizSLetsPlay();
		QuizSAddQuestions addQuestions = new QuizSAddQuestions();
				
		System.out.println("Witaj! Czy chcesz zagrać w Quiz?\n");

		while (true) {
			
			System.out.println("Wpisz słowo \"zagrajmy\", aby zagrać, \"pytania\", aby dodać nowe pytania do quizu, "
					+ "lub \"koniec\", by zakończyć grę!\n");
			
			whatToDo = consolScan.nextLine(); //<--
			
			if (whatToDo.equals("zagrajmy")) {
				quiz.letsPlay();
				
			}else if (whatToDo.equals("pytania")){
				addQuestions.addQuestions();
								
			}else if (whatToDo.equals("koniec")){
				System.out.println("\nDzięki za grę! Do zobaczenia wkrótce!");
				break;
				
			}
		}
		
		consolScan.close();
	}
}

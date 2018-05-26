import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuizSAddQuestions {
	
	public void addQuestions() {
				
		Scanner consolScanQ = new Scanner(System.in);
		String whatToDoQ;
		String correctAnswer;
		StringBuffer questionMaker = new StringBuffer();
		String[] questionsForQuestions = {"\nPodaj kategorię pytania.\n", "\nPodaj treść pytania.\n", "\nPodaj odpowiedź a.\n", "\nPodaj odpowiedź b.\n", "\nPodaj odpowiedź c.\n"};
				
		try { 
			FileWriter outNoDel = new FileWriter ("pytania.txt", true);

			//USTALANIE - NADPISAĆ CZY NIE
			while (true) {				
				System.out.println("\nWpisz \"nadpisz\", by nadpisać Twoje nowe pytania na już istniejących lub \"dodaj\", by poszerzyć istniejący już zestaw.\n"
						+ "Jeśli chcesz wyjść z trybu dodawania pytań - wpisz \"cofnij\".\n");
				
				whatToDoQ = consolScanQ.nextLine();
				
				if (whatToDoQ.equals("nadpisz")) {			
					try {
						FileWriter outDel = new FileWriter ("pytania.txt", false);
						outDel.append("");
						outDel.close();
						
					} catch (IOException e) {
						System.out.println("\nWystapił błąd. Nie można dodać pytań.\n");
						whatToDoQ = "cofnij";	
					}
					break;
					
				}else if (whatToDoQ.equals("dodaj")) {
					break;
					
				}else if (whatToDoQ.equals("cofnij")) {
					break;
				}	
			}

			//DOPISYWANIE PYTAŃ
			while (true) {
				if (whatToDoQ.equals("cofnij")) {
					break;					
				}
				
				for (int i = 0; i < questionsForQuestions.length; i++) {
					System.out.println(questionsForQuestions[i]);
					questionMaker.append(consolScanQ.nextLine().trim().replaceAll(" ", "_") + " ");	
				}
				
				while (true) {
					System.out.println("\nKtóra z wpisanych odpowiedzi jest poprawna? Podaj: \"a\", \"b\", lub \"c\".\n");
					correctAnswer = consolScanQ.nextLine();
					if (correctAnswer.toLowerCase().equals("a") || correctAnswer.toLowerCase().equals("b") || correctAnswer.toLowerCase().equals("c")) {
						break;
					}	
				}
				
				questionMaker.append(correctAnswer);
				outNoDel.append(questionMaker + "\n");
				questionMaker.delete(0, questionMaker.length());
				
				System.out.println("\nWpisz dowolny ciąg znaków, aby dodać następne pytanie, albo \"koniec\", aby zakończyć dodawanie pytań.\n");
				whatToDoQ = consolScanQ.nextLine();				
				if (whatToDoQ.equals("koniec")) {
					break;					
				}
			}

			outNoDel.close();
			
		} catch (IOException e) {
			System.out.println("\nWystapił błąd. Nie można dodać pytań.\n");
			
		}
	
//		consolScanQ.close(); // <--to powoduje błąd (dla czego???)
		
	}
	
}

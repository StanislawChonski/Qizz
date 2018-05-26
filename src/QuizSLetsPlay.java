import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuizSLetsPlay {
	
	public void letsPlay() {
		
		Scanner consolScanP = new Scanner(System.in);
		File questionsFile = new File("pytania.txt");
		List<String> questions = new ArrayList<>();
		String answere;
//		String whatToDoP = "";
		int numberOfQuestions = 0;
		int points = 0;
		double result;

		try {
			//ZCZYTYWANIE PYTAŃ Z PLIKU, LOSOWANIE KOLEJNOŚCI
			Scanner fileScan = new Scanner(questionsFile);
			while (fileScan.hasNextLine()) {
				questions.add(fileScan.nextLine());
			}
			Collections.shuffle(questions);
			
			System.out.println("\nCzas na grę!");
			
			//NA ILE PYTAŃ ODPOWIADAMY
			while (true) {
				System.out.println("\nWpisz, na ile pytań chcesz odpowiedzieć (podaj liczbę).\n");
				if (consolScanP.hasNextInt()) {
					numberOfQuestions = consolScanP.nextInt();
					if (numberOfQuestions <= 0) {
						System.out.println("\nDodatnią liczbę cwaniaku ;)");
					}else {
						break;
					}
				}			
			}
			
			if (numberOfQuestions > questions.size()) {
				numberOfQuestions = questions.size();
				System.out.println("\nNiestety - aktualnie nie mam aż tylu pytań w bazie.");
			}
			System.out.println("\nZadam Ci " + numberOfQuestions + " pytań.");
			
			//ZADAWANIE PYTAŃ		
			for (int i = 0; i < numberOfQuestions; i++) {
				System.out.println("\nPytanie numer " + (i + 1) + ":");
				
				String[] questionParts = questions.get(i).split(" ");
				System.out.println("Kategoria: " + questionParts[0].replaceAll("_", " ") + "." + "\n\n" + questionParts[1].replaceAll("_", " ") + "\n" +
				"  a. " + questionParts[2].replaceAll("_", " ") + "\n  b. " + questionParts[3].replaceAll("_", " ") + "\n  c. " + questionParts[4].replaceAll("_", " ") + "\n");
				
				while (true) {
					answere = consolScanP.nextLine();
					if (answere.toLowerCase().equals("a") || answere.toLowerCase().equals("b") || answere.toLowerCase().equals("c")) {
						break;
					}else if(answere != null){
						System.out.println("Wpisz \"a\", \"b\", lub \"c\"!");
					}

				}
				if (answere.equals(questionParts[5])) {
					points++;
				}
			}
			
			//PODAWANIE WYNIKU
			System.out.println("\nTo już wszystkie pytania!\n");
			result = points / numberOfQuestions * 100;
			
			if (result <= 100 && result >= 90) {
				System.out.println("Szacun!!!");
			}else if (result < 90 && result >= 80) {
				System.out.println("Gratulacje!!");
			}else if (result < 80 && result >= 70) {
				System.out.println("Całkiem nieźle!");
			}else if (result < 70 && result >= 60) {
				System.out.println("Nie jest źle!");
			}else if (result < 60 && result >= 50) {
				System.out.println("Nie ma biedy!");
			}else if (result < 50 && result >= 40) {
				System.out.println("Tak sobie!");
			}else if (result < 40 && result >= 30) {
				System.out.println("Popraw się!");
			}else if (result < 30 && result >= 20) {
				System.out.println("Kiepsko!!");
			}else if (result < 20 && result >= 10) {
				System.out.println("Wstydź się!!!");
			}else if (result < 10 && result >= 0) {
				System.out.println("Aż brak mi słów... ŻENADA!!!!");
			}else {
				System.out.println("Coś poszło nie tak i nie mogę podać Twojego wyniku :(");
			}
			
			System.out.println("Udało Ci się udzielić... " + result + "%" + " poprawnych odpowiedzi!\n\n\n");

			fileScan.close();
//			consolScanP.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("\nPlik z pytaniami nie istnieje. Musisz najpierw dodać jakieś pytania.\n");
		}
	}
}
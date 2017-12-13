import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Lottery {

	public static void main(String[] args) {
		Lottery l = new Lottery();
		l.compareWinnings();
	}

	public HashSet<Integer> createUserNumbers() {
		System.out.print("Enter six numbers seperated by spaces: ");
		Scanner scan = new Scanner(System.in);
		String numbersRaw = scan.nextLine();
		
		String[] numbersSplit = numbersRaw.split(" ");
		HashSet<Integer> userNumbers = new HashSet<Integer>();
		
		for(int i = 0; i < numbersSplit.length; i++) {
			userNumbers.add(Integer.parseInt(numbersSplit[i]));
		}
		
		return userNumbers;
	}
	
	public HashSet<Integer> createLotteryNumbers() {
		HashSet<Integer> lotteryNumbers = new HashSet<Integer>();
		for(int i = 0; i < 6; i++) {
			Random gen = new Random(); 
			lotteryNumbers.add(gen.nextInt(50));
		}
		return lotteryNumbers;
	}
	
	public void compareWinnings() {
		HashSet<Integer> userNumbers = createUserNumbers();
		HashSet<Integer> lotteryNumbers = createLotteryNumbers();
		
		userNumbers.retainAll(lotteryNumbers);
		System.out.println("The winning numbers are: ");
		System.out.println(lotteryNumbers.toString());
		
		if(userNumbers.size() == 0) {
			System.out.println("No money won! :(");
		} else if(userNumbers.size() == 1) {
			System.out.println("Won $10");
		} else if(userNumbers.size() == 2) {
			System.out.println("Won $100");
		} else if(userNumbers.size() == 3) {
			System.out.println("Won $1000");
		} else if(userNumbers.size() == 4) {
			System.out.println("Won $10000");
		} else if(userNumbers.size() == 5) {
			System.out.println("Won $100000");
		} else if(userNumbers.size() == 6) {
			System.out.println("Won $1000000");
		}
	}
}

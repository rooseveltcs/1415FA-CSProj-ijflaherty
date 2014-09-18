package factor;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;


public class read {
	public static final boolean ONE_OR_TWO = true;
	public static void main(String[]args){
		boolean test = true;
		while(test){
			int firstNumber = 0;
			int secondNumber = 0;
			Scanner s = new Scanner(System.in);
			System.out.println("please enter a number, or if you wish to quit type quit");
			String quit = "quit";
			String Quit = "Quit";
			String hold = s.nextLine();
			if(quit.equals(hold) || Quit.equals(hold)){
				test = false;
			}else{
				int secX = 0;
				boolean ONE_OR_TWO = true;
				for(int x = 0; x <= hold.length()-1; x++){
					if((hold.charAt(hold.length() -1 - x)) == ' '){
						x++;
						ONE_OR_TWO = false;
					}
					if(ONE_OR_TWO){
						firstNumber = firstNumber + (((int)hold.charAt(hold.length() -1 - x) - 48) * (int)Math.pow(10, x));
					}else{

						secondNumber = secondNumber + (((int)hold.charAt(hold.length() -1 - x) - 48) * (int)Math.pow(10, secX));
						secX++;
					}
				}
				if(!ONE_OR_TWO){
					greatestComonFactor(firstNumber, secondNumber);
				}else{
					System.out.println(calculations(firstNumber));
				}
			}
			System.out.println();
		}
	}

	public static void greatestComonFactor(int firstNumber, int secondNumber){
		String print = null;
		ArrayList<Integer> firstList = factorIt(firstNumber);
		ArrayList<Integer> secondList = factorIt(secondNumber);
		for(int f = firstList.size()-1 ; f >= 0; f-- ){
			for(int s = secondList.size()-1; s >= 0 ; s-- ){
				if(firstList.get(f) == secondList.get(s)){
					print = "Your greatest common factor is: " + firstList.get(f);
				}
			}
		}
		System.out.println(print);
	}


	public static String calculations(int number){
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> revList = new ArrayList<Integer>();
		for(int p = 1; p <= Math.sqrt((int)number); p++){
			if(number % p == 0){
				list.add(number / p); 
				revList.add(p);

			}
		}
		for(int q = revList.size() -1; q >= 0; q--){
			list.add(revList.get(q));
		}
		String ret = "the factors of " + number + " are: " + list;
		return ret;
	}
	
	
	
	public static ArrayList<Integer> factorIt(int number){
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> revList = new ArrayList<Integer>();
		for(int p = 1; p <= Math.sqrt((int)number); p++){
			if(number % p == 0){
				list.add(number / p); 
				revList.add(p);
				
			}
		}
		for(int q = revList.size() -1; q >= 0; q--){
			list.add(revList.get(q));
		}
		return list;
	}
}

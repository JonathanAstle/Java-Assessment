package com.qa.javaAssessment;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		return word;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	
	
	public String getBert(String input) {
		
		int bOfBert1=-1;
		int bOfBert2=-1;
		
		String word = "";
		String reverseWord = "";
		
		for (int i = 0; i<input.length()-3; i++) {
			if (input.substring(i,i+4).toLowerCase().equals("bert")) {
				bOfBert1 = i;
				break;
			}
		}
			
		for (int j = bOfBert1+4; j<input.length()-3; j++) {
			if (input.substring(j,j+4).toLowerCase().equals("bert")) {
				bOfBert2 = j;
			}
		}
		
		if (bOfBert1 == -1 || bOfBert2 == -1) {
			return "";
		} else {
			for (int k = bOfBert1 + 4; k<bOfBert2; k++) {
				word += input.substring(k, k+1);
			}
			
			for (int m = word.length(); m>=1; m--) {
				reverseWord += word.substring(m-1, m);
			}
			
			
			
			return reverseWord;
		}
	
	}
	

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {
		int large;
		int middle;
		int small;
		if (a>b && a>c) {
			large=a;
			if (b>c) {
				middle = b;
				small = c;
			} else {
				middle = c;
				small = b;
			}
		} else if (b>a && b>c) {
			large=b;
			if (a>c) {
				middle = a;
				small = c;
			} else {
				middle = c;
				small = a;
			}
		} else {
			large=c;
			if (a>b) {
				middle = a;
				small = b;
			} else {
				middle = b;
				small = a;
			}
		}
		
		int space1 = large-middle;
		int space2 = middle-small;
		
		if (space1 == space2) {
			return true;
		} else {
			return false;
		}

	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
		String output = "";
		for (int i = 0; i<input.length() - (input.length()/2) - (a/2) - 1; i++) {
			output += input.substring(i, i+1);
		}
		for (int i = input.length() - (input.length()/2) + (a/2); i<input.length(); i++) {
			output += input.substring(i, i+1);
		}
			
		return output;
	}


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public static int superBlock(String input) {
		int currentMax=1;
		
		for (int i = 0; i<input.length(); i++) {
			
			int counter = 1;
			
			for (int j=i; j<input.length()-1; j++) {
				if (input.substring(j, j+1).equals(input.substring(j+1,j+2))) {
					counter += 1;
					System.out.println(counter);
					if (counter > currentMax) {
						currentMax = counter;
					}
				}
			}
			
		}
			
		return currentMax;
	}
	
	
	public static void main(String[] args) {
		System.out.println(superBlock("hoopplla"));
	}
	
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0

	public static int amISearch(String arg1) {
		int number = 0;
		if (arg1.substring(0, 3).toLowerCase().equals("am ")) {
			number += 1;
		}
		if (arg1.substring(arg1.length()-3, arg1.length()).toLowerCase().equals(" am")) {
			number += 1;
		}
		for (int i = 0; i<arg1.length()-4; i++) {
			if (arg1.substring(i, i+4).toLowerCase().equals(" am ")) {
				number += 1;
			}
		}
		
		return number;
		
	}
	
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		if (arg1%3==0 && arg1%5==0) {
			return "fizzbuzz";
		} else if (arg1%3==0) {
			return "fizz";
		} else if (arg1%5==0) {
			return "buzz";
		} else {
			return "not divisible by 3 or 5";
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	public int largest(String arg1) {
		for (int i = 0; i<arg1.length(); i++) {
			
		}
		
		
		
		
		
		
		return -1;
	}
}

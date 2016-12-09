/*																The Pangrams:


Roy wanted to increase his typing speed for programming contests. So, his friend advised him to type the sentence "The quick brown fox jumps over the lazy dog" repeatedly, because it is a pangram. (Pangrams are sentences constructed by using every letter of the alphabet at least once.)

After typing the sentence several times, Roy became bored with it. So he started to look for other pangrams.

Given a sentence , tell Roy if it is a pangram or not.

Input Format

Input consists of a string .

Constraints 
Length of  can be at most   and it may contain spaces, lower case and upper case letters. Lower-case and upper-case instances of a letter are considered the same.

Output Format

Output a line containing pangram if  is a pangram, otherwise output not pangram.

Sample Input

Input #1

We promptly judged antique ivory buckles for the next prize    
Input #2

We promptly judged antique ivory buckles for the prize    
Sample Output

Output #1

pangram
Output #2

not pangram
Explanation

In the first test case, the answer is pangram because the sentence contains all the letters of the English alphabet.*/



import java.io.*;
import java.util.*;


public class Pangrams {

    public static void main(String[] args) 
	{
        String s;
        char c='#';
        Scanner sc=new Scanner(System.in);
        boolean visited[]=new boolean[26];
        s=sc.nextLine().toLowerCase();
		for(int i=0;i<s.length();i++)
        {
			c=s.charAt(i);
			if(c!=' ')
			{
				visited['z'-c]=true;
			}
        }
        for(int i=0;i<26;i++)
        {
        	if(visited[i]==false)
        	{
        		System.out.println("not pangram");
        		return;
        	}
        }
		System.out.println("pangram");
    }
}
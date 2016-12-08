/*Problem Statement :-

As we all know caterpillars love to eat leaves. Usually, a caterpillar sits on leaf, eats as much of it as it can (or wants), then stretches out to its full length to reach a new leaf with its front end, and finally "hops" to it by contracting its back end to that leaf.

We have with us a very long, straight branch of a tree with leaves distributed uniformly along its length, and a set of caterpillars sitting on the first leaf. (Well, our leaves are big enough to accommodate upto 20 caterpillars!). As time progresses our caterpillars eat and hop repeatedly, thereby damaging many leaves. Not all caterpillars are of the same length, so different caterpillars may eat different sets of leaves. We would like to find out the number of leaves that will be undamaged at the end of this eating spree. We assume that adjacent leaves are a unit distance apart and the length of the caterpillars is also given in the same unit.

For example suppose our branch had 20 leaves (placed 1 unit apart) and 3 caterpillars of length 3, 2 and 5 units respectively. Then, first caterpillar would first eat leaf 1, then hop to leaf 4 and eat it and then hop to leaf 7 and eat it and so on. So the first caterpillar would end up eating the leaves at positions 1,4,7,10,13,16 and 19. The second caterpillar would eat the leaves at positions 1,3,5,7,9,11,13,15,17 and 19. The third caterpillar would eat the leaves at positions 1,6,11 and 16. Thus we would have undamaged leaves at positions 2,8,12,14,18 and 20. So the answer to this example is 6.

Input format
The first line of the input contains two integers N and K, where N is the number of leaves and K is the number of caterpillars.
Lines 2,3,...,K+1 describe the lengths of the K caterpillars. 
Line i+1 (1 ≤ i ≤ K) contains a single integer representing the length of the ith caterpillar.

You may assume that 1 ≤ N ≤ 1000000000 and 1 ≤ K≤ 20. The length of the caterpillars lies between 1 and N.

Output format
A line containing a single integer, which is the number of leaves left on the branch after all the caterpillars have finished their eating spree.

Test Data:
The range of input values over which your program is to be tested is described above. In addition, 50% of the test-cases will also satisfy 1 ≤ N≤ 10000000 and K ≤ 16.

Example:
We now illustrate the input and output formats using the example described above.

Sample Input:
20 3
3
2
5

Sample Output:
6

Hint:
You may use 64-bit integers (long long int in C/C++) to avoid errors while multiplying large integers. The maximum value you can store in a 32-bit integer is 2^31-1, which is approximately 2 * 10^9. 64-bit integers can store values greater than 10^18.*/





//Solution:
import java.util.*;


public class CaterpillarByDivision{
	
public static void main(String args[])
{
	ArrayList<Integer> lcm =new ArrayList<Integer>();//the array containing LCM of the sizes of caterpillar;
	ArrayList<Integer> cat =new ArrayList<Integer>();//array containing sizes of caterpillar;
	int n,k,i,j,l;
	int cnt=0,lcm_cnt=0;
	n=Integer.parseInt(args[0]);					//Reading input through command line argument ;
	k=Integer.parseInt(args[1]);					//(You can also get input from using scanners);
	
	int catr[]=new int[k];
	
	for(i=0;i<k;i++)
		catr[i]=Integer.parseInt(args[2+i]);
	
	
	for(i=k-1;i>-1;i--)						//Finding the LCMs and storing them in list;
	{
		for(j=i-1;j>-1;j--)
		{
			int min=(catr[i]<catr[j])?catr[i]:catr[j];
			int max=(catr[i]>catr[j])?catr[i]:catr[j];
			for(l=min;l<n;l+=min)
			{
				if(l%max==0)
				{
					lcm.add(l);
					break;
				}
			}
		}
	}
	
	
	for(i=0;i<k;i++)						//Finding no. of leaves ate by each caterpillar;
	{
		cnt=cnt+(n/catr[i]);						
	}
	
	for(i=0;i<lcm.size();i++)					//Finding the no. of leaves commonly ate by caterpillars;
	{
		lcm_cnt=lcm_cnt+(n/lcm.get(i));				
	}
	
	
	System.out.println(n-(cnt-lcm_cnt+1));				//Printing the no. of uneaten leaves.
}
}

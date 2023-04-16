/*

6350. Find the Maximum Divisibility Score
User Accepted:8192
User Tried:9074
Total Accepted:8295
Total Submissions:16704
Difficulty:Easy
You are given two 0-indexed integer arrays nums and divisors.

The divisibility score of divisors[i] is the number of indices j such that nums[j] is divisible by divisors[i].

Return the integer divisors[i] with the maximum divisibility score. If there is more than one integer with the maximum score, return the minimum of them.

 

Example 1:

Input: nums = [4,7,9,3,9], divisors = [5,2,3]
Output: 3
Explanation: The divisibility score for every element in divisors is:
The divisibility score of divisors[0] is 0 since no number in nums is divisible by 5.
The divisibility score of divisors[1] is 1 since nums[0] is divisible by 2.
The divisibility score of divisors[2] is 3 since nums[2], nums[3], and nums[4] are divisible by 3.
Since divisors[2] has the maximum divisibility score, we return it.
Example 2:

Input: nums = [20,14,21,10], divisors = [5,7,5]
Output: 5
Explanation: The divisibility score for every element in divisors is:
The divisibility score of divisors[0] is 2 since nums[0] and nums[3] are divisible by 5.
The divisibility score of divisors[1] is 2 since nums[1] and nums[2] are divisible by 7.
The divisibility score of divisors[2] is 2 since nums[0] and nums[3] are divisible by 5.
Since divisors[0], divisors[1], and divisors[2] all have the maximum divisibility score, we return the minimum of them (i.e., divisors[2]).
Example 3:

Input: nums = [12], divisors = [10,16]
Output: 10
Explanation: The divisibility score for every element in divisors is:
The divisibility score of divisors[0] is 0 since no number in nums is divisible by 10.
The divisibility score of divisors[1] is 0 since no number in nums is divisible by 16.
Since divisors[0] and divisors[1] both have the maximum divisibility score, we return the minimum of them (i.e., divisors[0]).
 

Constraints:

1 <= nums.length, divisors.length <= 1000
1 <= nums[i], divisors[i] <= 109
Java	
*/
1
class Solution {

    public int maxDivScore(int[] nums, int[] di) {

        int[] a = new int[di.length];

        

        for(int j:nums){

            for(int k = 0;k < di.length;k++){

                if(j % di[k] == 0)

                    a[k] += 1;
            }

        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        HashSet<Integer> set = new HashSet();

        HashSet<Integer> set1 = new HashSet();

        boolean flag = false;
        for(int i = 0;i < a.length;i ++){

            if(set1.contains(a[i])) flag = true;

            if(a[i] >= max){

                set.add(a[i]);

                max = i;

            }

            if(a[i] <= min){

                min = i;

                set1.add(a[i]);

            }
 
        }
         return flag == true?di[min]:di[max];
    }
}

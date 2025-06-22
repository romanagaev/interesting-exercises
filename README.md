**Kotlin/ JS/ SQL Function/ Code Examples:**

1. Reduce Function
The reduce function takes an accumulator and applies an operation to each element in the collection.
<pre>val numbers = listOf(1, 2, 3, 4, 5)
val sum = numbers.reduce { acc, num -> acc + num }
println(sum)  // Output: 15</pre>

2. Filter Function
The filter function returns a list containing only the elements that satisfy a given condition.
<pre>val numbers = listOf(1, 2, 3, 4, 5)
val evens = numbers.filter { it % 2 == 0 }
println(evens)  // Output: [2, 4]</pre>

3. Difference Between Reduce and Filter
•	reduce accumulates a result from all elements.
•	filter selects elements based on a condition.
Example:
<pre>val numbers = listOf(1, 2, 3, 4, 5)
val sumOfEvens = numbers.filter { it % 2 == 0 }.reduce { acc, num -> acc + num }
println(sumOfEvens)  // Output: 6 (2 + 4)</pre>

4. Apply vs Also
•	apply: Modifies the object and returns it.
•	also: Executes a block and returns the same object.
Example:
<pre>class Person(var name: String, var age: Int)

val person = Person("Alice", 25).apply {
    age = 30
}
println(person.age)  // Output: 30

val person2 = Person("Bob", 25).also {
    println("Created: ${it.name}, Age: ${it.age}")
}
person2.name = "Charlie"  // `also` does not run again automatically</pre>


**Example Coding Questions:**

Find the most common transaction type in a dataset
<pre>fun mostCommonTransactionType(transactions: List<String>): String? {
    return transactions.groupingBy { it }
        .eachCount()
        .maxByOrNull { it.value }?.key
}

fun main() {
    val transactions = listOf("Deposit", "Withdrawal", "Deposit", "Transfer", "Deposit", "Withdrawal")
    val mostCommon = mostCommonTransactionType(transactions)
    println("Most common transaction type: $mostCommon")
}</pre>

**Problems:**

1. Two Sum (HashMap Approach)
HackerRank problem: Two Sum
2. Longest Substring Without Repeating Characters (Sliding Window)
HackerRank problem: Longest Substring Without Repeating Characters
3. Merge Intervals (Sorting + Greedy Approach)
HackerRank problem: Merge Intervals
4. Kth Largest Element in an Array (Heap/Binary Search)
HackerRank problem: Kth Largest Element
5. Find Duplicate in Array (Floyd’s Tortoise and Hare Algorithm)
HackerRank problem: Find Duplicate
6. Word Ladder (BFS)
HackerRank problem: Word Ladder
7. Climbing Stairs (Dynamic Programming – Fibonacci Variant)
HackerRank problem: Climbing Stairs
8. Subset Sum Problem (Backtracking/DP)
HackerRank problem: Subset Sum (Knapsack-style DP problems)
9. Lowest Common Ancestor in a Binary Tree (DFS) Depth First Search
HackerRank problem: Lowest Common Ancestor
10. Binary Search in Rotated Sorted Array
HackerRank problem: Binary Search in Rotated Sorted Array
11. Finding shortest path in directed graph with not same weights using Dijkstra algorithm.
12. Finding minimum wight path via spanning tree. MSP with Kuskal's algorithm.
13. Finding the smallest amount of needed resources on the bideractional graph using DFS
14. Forming magic square. Finding the best solution that requires the smallest cost
15. Picking numbers. Given an array of integers, find the longest subarray where the absolute difference between any two elements is less than or equal to 1.
16. Given a set of distinct integers, print the size of a maximal subset of  where the sum of any  numbers in  is not evenly divisible by .
17. An English text needs to be encrypted using the following encryption scheme.
    First, the spaces are removed from the text. Let L be the length of this text.Then, characters are written into a grid, whose rows and columns have the following constraints:

    Example

    After removing spaces, the string is  characters long.  is between  and , so it is written in the form of a grid with 7 rows and 8 columns.

    ifmanwas  
    meanttos          
    tayonthe  
    groundgo  
    dwouldha  
    vegivenu  
    sroots
    
    Ensure that 
    If multiple grids satisfy the above conditions, choose the one with the minimum area, i.e. .
    The encoded message is obtained by displaying the characters of each column, with a space between column texts. The encoded message for the grid above is:

    imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau
18. Lexicographical order is often known as alphabetical order when dealing with strings. A string is greater than another string if it comes later in a lexicographically sorted list.

Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:
    1.It must be greater than the original word
    2.It must be the smallest word that meets the first condition
19. Given two positive integers p and q where p is lower than q, write a program to print the modified Kaprekar numbers in the range between p and q, inclusive. If no modified Kaprekar numbers exist in the given range, print INVALID RANGE.


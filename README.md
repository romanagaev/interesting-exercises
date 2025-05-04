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


**Resources:**

•	LeetCode (Focus on Medium/Hard problems)
•	HackerRank
•	Fast.ai Machine Learning Course


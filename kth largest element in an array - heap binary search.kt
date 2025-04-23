import java.util.PriorityQueue

fun kthLargestElement(nums: IntArray, k: Int): Int {
    val pq = PriorityQueue<Int>();
    
    for(i in nums.indices){
        pq.add(nums[i]);
        if(pq.size > k){
            pq.poll();}
    }
    
    return pq.peek(); 
}

fun main() {
    val nums = intArrayOf(3, 2, 1, 5, 6, 4)
    val k = 2
    val result = kthLargestElement(nums, k)

    println("The $k-th largest element is: $result")
}
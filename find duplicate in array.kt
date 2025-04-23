fun findDuplicate(nums: IntArray): Int {
    // Floyd's Tortoise and Hare Algorithm to detect the duplicate
    var tortoise = nums[0]
    var hare = nums[0]
    
	while(true){
        tortoise = nums[tortoise];
        hare = nums[nums[hare]];
        if(tortoise == hare) break;
    }
    
    tortoise = nums[0];
    while (tortoise != hare){
        tortoise = nums[tortoise];
        hare = nums[hare];
    }
    
    return hare // duplicate found at hare (or tortoise)
}

fun main() {
    val nums = intArrayOf(7, 1, 4, 3, 2, 6, 2, 1);
    val result = findDuplicate(nums);
    println("The duplicate number is: $result");
}

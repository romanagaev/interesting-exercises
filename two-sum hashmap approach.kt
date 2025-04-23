fun twoSum(nums: IntArray, target: Int): IntArray {
	
    val hm = mutableMapOf<Int, Int>();
    
    for(i in nums.indices){
        println(i);
        if(hm.containsKey(target - nums[i])){
            hm[target-nums[i]]?.let{return intArrayOf(i, it)};
        }
        else{
            hm[nums[i]] = i;
        }
    }
    
    return intArrayOf()
}

fun main() {
    val nums = intArrayOf(2, 3, 4, 6, 7, 11, 15)
    val target = 9
    val result = twoSum(nums, target)

    if (result.isNotEmpty()) {
        println("Indices of the two numbers are: ${result.joinToString(", ")}")
    } else {
        println("No solution found")
    }
}

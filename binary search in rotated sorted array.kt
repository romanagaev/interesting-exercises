fun search(nums: IntArray, target: Int): Int {
	var left = 0;
    var right = nums.size -1;
    
    while(left <= right){
        val mid = left + (right-left)/2;
        
        if(nums[mid] == target) return mid;
        
        if(nums[left] <= nums[mid]){
            if(target in nums[left]..nums[mid]){
                right = mid - 1
            }else{
                left = mid + 1
            }
        }else{
            if(target in nums[mid]..nums[right]){
                right = mid + 1;
            }else{
                left = mid - 1;
            }
        }
    }
    
    
    return -1;
}

fun main() {
    val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)  // Rotated sorted array
    val target = 5 // Target to search for

    val result = search(nums, target);

    println("Index of target: $result")  
}
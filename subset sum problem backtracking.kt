fun subsetSum(nums: IntArray, target: Int): Boolean {
    val dp = Array(nums.size + 1) { BooleanArray(target + 1) }

    for (i in 0..nums.size) {
        dp[i][0] = true
    }

    for (i in 1..nums.size) {
        for (j in 1..target) {
            dp[i][j] = dp[i - 1][j]
            if (j >= nums[i - 1]) {
                dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]]
            }
        }
    }

    return dp[nums.size][target]
}

fun main() {
    val nums = intArrayOf(3, 34, 4, 12, 5, 2)
    val target = 35
    val result = subsetSum(nums, target)

    println("Is there a subset with sum $target? $result")
}

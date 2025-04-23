fun climbStairs(n: Int): Int {
    if (n <= 2) return n

    var fn1 = 1;
    var fn2 = 2;
    
    for(i in 3..n){
        val tmp = fn1 + fn2;
        fn1 = fn2;
        fn2 = tmp;
    }

    return fn2
}

fun climbStairs_rec(n: Int): Int {
    if (n <= 1){
        return n;}
    return climbStairs_rec(n-1) + climbStairs_rec(n-2)
}

fun main() {
    val n = 7
    val result = climbStairs(n)
    val result1 = climbStairs_rec(n+1)
    println("Total ways to climb $n steps: $result and using recursion $result1")
}
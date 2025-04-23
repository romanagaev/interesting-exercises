fun mergeIntervals(intervals: Array<IntArray>): Array<IntArray> {
 
	val si = intervals.sortedBy{ it[0] };
    
    println(si.map{it.toList()});
    
    val result = mutableListOf<IntArray>();
    
    for(i in si){
        if(result.isEmpty() || result.last()[1] < i[0]){
            result.add(i);
        }
        else{
            result.last()[1] = maxOf(result.last()[1], i[1]);
        }
    }
    
    println(result.map{it.toList()})
    
    return result.toTypedArray()
}

fun main() {
    val input = arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))
    val merged = mergeIntervals(input)
    
    println("Merged Intervals: ${merged.map { it.toList() }}")
}

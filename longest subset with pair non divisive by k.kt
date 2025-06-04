import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

fun nonDivisibleSubset(k: Int, s: Array<Int>): Int {
    
    val freq = IntArray(k)
    
    for (num in s) {
        freq[num % k]++
    }

    //println(freq.size)
    //println(freq.joinToString())

    var count = 0 //minOf(freq[0], 1)
    if(freq[0] > 0) { count+=1}

    for (i in 1 until (k + 1) / 2) {
        count += maxOf(freq[i], freq[k - i])
    }

    if (k % 2 == 0) {
        count += 1
    }

    return count
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val k = first_multiple_input[1].toInt()

    val s = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = nonDivisibleSubset(k, s)

    println(result)
}

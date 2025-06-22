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

fun isKaprekar(n: Int): Boolean {
    /*if (n < 1) return false
    val squareStr = (n.toLong() * n).toString()

    for (i in 1..squareStr.lastIndex) {
        //val left = squareStr.substring(0, i).toLong()
        //val right = squareStr.substring(i).toLong()
        val left = squareStr.substring(0, i).toLongOrNull() ?: 0
        val right = squareStr.substring(i).toLongOrNull() ?: continue

        if (right > 0 && left + right == n.toLong()) {
            return true
        }
    }

    return n == 1  // Special case*/
    if (n < 1) return false

    val d = n.toString().length
    val squareStr = (n.toLong() * n).toString()

    val splitPoint = squareStr.length - d
    if (splitPoint < 0) return false

    val left = if (splitPoint == 0) 0 else squareStr.substring(0, splitPoint).toLong()
    val right = squareStr.substring(splitPoint).toLong()

    return left + right == n.toLong()
}



fun kaprekarNumbers(p: Int, q: Int): Unit {
    var ln = mutableSetOf<Int>()
    
    for(n in p until q+1){
        //println(n)
        if(isKaprekar(n)) ln.add(n)
    }
    
    if(ln.isEmpty()){println("INVALID RANGE")}
    else {println(ln.joinToString(" "))}
}

fun main(args: Array<String>) {
    val p = readLine()!!.trim().toInt()

    val q = readLine()!!.trim().toInt()

    kaprekarNumbers(p, q)
}

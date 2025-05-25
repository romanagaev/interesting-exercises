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
import kotlin.math.pow
import kotlin.math.abs


fun formingMagicSquare(s: Array<Array<Int>>): Int {
    
       val magicSquares = listOf(
        arrayOf(arrayOf(8, 1, 6), arrayOf(3, 5, 7), arrayOf(4, 9, 2)),
        arrayOf(arrayOf(6, 1, 8), arrayOf(7, 5, 3), arrayOf(2, 9, 4)),
        arrayOf(arrayOf(4, 9, 2), arrayOf(3, 5, 7), arrayOf(8, 1, 6)),
        arrayOf(arrayOf(2, 9, 4), arrayOf(7, 5, 3), arrayOf(6, 1, 8)),
        arrayOf(arrayOf(8, 3, 4), arrayOf(1, 5, 9), arrayOf(6, 7, 2)),
        arrayOf(arrayOf(4, 3, 8), arrayOf(9, 5, 1), arrayOf(2, 7, 6)),
        arrayOf(arrayOf(6, 7, 2), arrayOf(1, 5, 9), arrayOf(8, 3, 4)),
        arrayOf(arrayOf(2, 7, 6), arrayOf(9, 5, 1), arrayOf(4, 3, 8))
    )

    return magicSquares.minOf { magic ->
        var cost = 0
        for (i in 0..2) {
            for (j in 0..2) {
                cost += kotlin.math.abs(s[i][j] - magic[i][j])
            }
        }
        cost
    }
    
    
    /*val mss = (s.size*((s.size).toDouble().pow(2) + 1)/2).toInt()
    var nl = mutableListOf<Int>();
    
    for(i in 0..s.size-1){
        val rl = s[i].toMutableList()
        if(mss != rl.sum()){
            val nd = mss - rl.filter { it != s[i][i] }.sum()
            nl.add(abs(s[i][i] - nd))
            s[i][i] = nd 
        }    
    }
    
    return nl.sum()*/
}

fun main(args: Array<String>) {

    val s = Array<Array<Int>>(3, { Array<Int>(3, { 0 }) })

    for (i in 0 until 3) {
        s[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = formingMagicSquare(s)

    println(result)
}

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
import kotlin.math.abs

fun pickingNumbers(a: Array<Int>): Int {
    var lsl = mutableListOf<MutableList<Int>>()
    var td = 0
    var al = a.toMutableList().sorted();
    var ll = mutableListOf<Int>(al[0]);
    
   
    for(i in 1..al.size-1){
        td += abs(al[i]-al[i-1])
        if(td <= 1){
            ll.add(al[i])
        }else{
            lsl.add(ll.toMutableList())
            td = 0
            ll.clear()
            ll.add(al[i])
        }
    }

    if (ll.isNotEmpty()) {
        lsl.add(ll)
    }
    
    
    return lsl.filter{it.size > 1}.maxByOrNull { it.size }?.size ?: 0
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = pickingNumbers(a)

    println(result)
}

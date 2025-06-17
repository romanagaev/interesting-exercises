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

fun encryption(s: String): String {
    var es = s.replace(" ", "")
    var sr = Math.sqrt(es.length.toDouble())
    var rows = kotlin.math.floor(sr).toInt()
    var cols = kotlin.math.ceil(sr).toInt()
    
    if(rows*cols < es.length){
        rows++
    }
    
    var res = StringBuilder()
    
    for(c in 0..cols-1){
        for(r in 0..rows-1){
            val index = r*cols + c
            if(index < es.length){
                res.append(es[index])
            }
        }
        if(c != cols-1){
            res.append(' ')
        }
    }
    
    return res.toString()
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val result = encryption(s)

    println(result)
}

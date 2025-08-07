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

fun workbook(n: Int, k: Int, arr: Array<Int>): Int {
    var s = 0
    var page_nnumber = 1
    var chapter_pages = 0

    for(c in arr){
        chapter_pages = c/k + if(c%k != 0) 1 else 0
        for(pic in 1..chapter_pages){
            var start_ex_in_page = (pic-1)*k + 1
            val end_ex_in_page = minOf(start_ex_in_page + k - 1, c)

            if(page_nnumber in (start_ex_in_page..end_ex_in_page)){
                s++
            }
            
            page_nnumber++;
        }
    }

    return s;
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val k = first_multiple_input[1].toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = workbook(n, k, arr)

    println(result)
}

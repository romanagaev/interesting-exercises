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

fun cavityMap(grid: Array<String>): Array<String> {
    //var resMtrx: MutableList<String> = grid.toMutableList() //mutableListOf() 
    var resMtrx: MutableList<StringBuilder> = grid.map { StringBuilder(it) }.toMutableList() //grid.toMutableList() //mutableListOf() 
       
    var mtrxDim = grid.size
    
    //println(mtrxDim)
    
    if(mtrxDim == 2) return grid.copyOf()
    
    for(i in 1 until mtrxDim-1){
       //println(grid[i])        
       for(j in 1 until mtrxDim-1){
           //println(grid[i][j])
           if(grid[i][j] > grid[i][j+1] &&
              grid[i][j] > grid[i][j-1] &&
              //grid[i][j] >= grid[i-1][j+1] &&
              //grid[i][j] >= grid[i-1][j-1] &&
              grid[i][j] > grid[i-1][j] &&
              //grid[i][j] >= grid[i+1][j+1] &&
              //grid[i][j] >= grid[i+1][j-1] &&
              grid[i][j] > grid[i+1][j]){
                resMtrx[i][j] = 'X'
              }
       }
    }
    
    return resMtrx.map { it.toString() }.toTypedArray()

}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val grid = Array<String>(n, { "" })
    for (i in 0 until n) {
        val gridItem = readLine()!!
        grid[i] = gridItem
    }

    val result = cavityMap(grid)

    println(result.joinToString("\n"))
}

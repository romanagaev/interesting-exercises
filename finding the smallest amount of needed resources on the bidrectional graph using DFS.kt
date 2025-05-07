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


fun roadsAndLibraries(n: Int, c_lib: Int, c_road: Int, cities: Array<Array<Int>>): Long {
    if (c_road >= c_lib) {
        // Cheaper to build library in each city
        return n.toLong() * c_lib
    }

    val graph = Array(n + 1) { mutableListOf<Int>() }
    for (road in cities) {
        val u = road[0]
        val v = road[1]
        graph[u].add(v)
        graph[v].add(u)
    }

    val visited = BooleanArray(n + 1)
    var totalCost = 0L

    fun dfs(city: Int): Int {
        visited[city] = true
        var size = 1
        for (neighbor in graph[city]) {
            if (!visited[neighbor]) {
                size += dfs(neighbor)
            }
        }
        return size
    }

    for (i in 1..n) {
        if (!visited[i]) {
            val componentSize = dfs(i)
            totalCost += c_lib + (componentSize - 1).toLong() * c_road
        }
    }

    return totalCost
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val n = first_multiple_input[0].toInt()

        val m = first_multiple_input[1].toInt()

        val c_lib = first_multiple_input[2].toInt()

        val c_road = first_multiple_input[3].toInt()

        val cities = Array<Array<Int>>(m, { Array<Int>(2, { 0 }) })

        for (i in 0 until m) {
            cities[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
        }

        val result = roadsAndLibraries(n, c_lib, c_road, cities)

        println(result)
    }
}

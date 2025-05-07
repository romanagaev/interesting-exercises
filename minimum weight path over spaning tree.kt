fun roadsInHackerland(n: Int, roads: Array<Array<Int>>): String {
    data class Edge(val u: Int, val v: Int, val weight: Long)

    // Convert each road to Edge and shift the weight as power of 2
    val edgeList = roads.map {
        Edge(it[0] - 1, it[1] - 1, 1L shl it[2])
    }.sortedBy { it.weight }

    val parent = IntArray(n) { it }
    val size = IntArray(n) { 1 }

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x]) // path compression
        }
        return parent[x]
    }

    var result = 0L

    for (edge in edgeList) {
        val rootU = find(edge.u)
        val rootV = find(edge.v)
        if (rootU != rootV) {
            val pairCount = size[rootU].toLong() * size[rootV]
            result += pairCount * edge.weight

            // Union by size
            if (size[rootU] < size[rootV]) {
                parent[rootU] = rootV
                size[rootV] += size[rootU]
            } else {
                parent[rootV] = rootU
                size[rootU] += size[rootV]
            }
        }
    }

    return result.toString(2)
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()
    val m = first_multiple_input[1].toInt()

    val roads = Array(m) { Array(3) { 0 } }

    for (i in 0 until m) {
        roads[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val result = roadsInHackerland(n, roads)

    println(result)
}
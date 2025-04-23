import kotlin.math.abs

fun detectAnomalies(transactions: List<Double>, threshold: Double = 2.0): List<Double> {
    if (transactions.isEmpty()) return emptyList()
    
    val mean = transactions.average()
    val stdDev = kotlin.math.sqrt(transactions.map { (it - mean) * (it - mean) }.average())
    
    return transactions.filter { abs(it - mean) > threshold * stdDev }
}

fun main() {
    val transactions = listOf(100.0, 105.0, 98.0, 102.0, 500.0, 99.0, 101.0)
    val anomalies = detectAnomalies(transactions)
    println("Anomalies detected: $anomalies")
}

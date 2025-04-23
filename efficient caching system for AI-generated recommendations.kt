class LRUCache<K, V>(private val capacity: Int) {
    private val map = LinkedHashMap<K, V>(capacity, 0.75f, true)
    
    fun get(key: K): V? {
        return map[key] // Moves accessed key to the end (if exists)
    }

    fun put(key: K, value: V) {
        if (map.size >= capacity) {
            val eldestKey = map.keys.first() // Remove the least recently used item
            map.remove(eldestKey)
        }
        map[key] = value
    }
}

fun main() {
    val cache = LRUCache<String, String>(3)
    cache.put("A", "Data1")
    cache.put("B", "Data2")
    cache.put("C", "Data3")
    println(cache.get("A")) // Moves "A" to the end
    cache.put("D", "Data4") // Removes "B" (LRU item)
    println(cache.get("B")) // Output: null (B was evicted)
}
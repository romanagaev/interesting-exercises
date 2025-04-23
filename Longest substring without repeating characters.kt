fun lengthOfLongestSubstring(s: String): Int {
    val windowMap = mutableMapOf<String,Int>();
    val windowSet = mutableSetOf<Char>();
    var subs = 0;
    var submax = 0;
    
	for (end in s.indices){
        if(!windowSet.contains(s[end])){
            windowSet.add(s[end]);
            subs++;
        }else{
           windowMap.put(windowSet.joinToString(""), subs);
           if(submax < subs){ submax = subs;}
           windowSet.clear();
           subs = 0;
        }
    }
    return submax;
}

fun main() {
    val s = "abcdabcbb"
    val result = lengthOfLongestSubstring(s)
    println("Length of longest substring without repeating characters: $result");
}

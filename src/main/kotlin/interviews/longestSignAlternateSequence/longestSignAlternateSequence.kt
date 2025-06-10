package interviews.longestSignAlternateSequence

fun longestSignAlternateSequenceFunctional(nums: IntArray): Int {
    if(nums.size == 1) return 1
    if(nums.size == 2 && nums[0] shr 31 != nums[1] shr 31) return 2
    var result = 1 // contains the value of longest sequence found. Start at 1 because it is lowes sequence possible
    var count = 1 // stores the length of current sequence. Start at 1 because it is lowes sequence possible
    // value of value in the current position. Possible values:
    //  1 -> positive
    //  -1 -> negative
    var currentSignal: Int? = getSignal(nums[0])
    // Since the zero acts like a wildcard, the method needs to store the position of the zero sequence start to be able
    // returning to the beginning of sequence and restart the counting from there. The value will be null until a zero be found
    var lastZeroSequenceStartIdx: Int? = null
    var idx = 1
    while(idx < nums.size) {
        if (isAlternateSequence(currentSignal ?: getSignal(nums[idx - 1]), nums[idx])) {
            count++
            // update the result if it is lower than the current sequence counting
            result = maxOf(result, count)
            // If the previous values of the current sequence are zero (currentSignal == null) calculates the current
            // signal, otherwise forces the signal alternation
            currentSignal = if(currentSignal == null) getSignal(nums[idx]) else currentSignal * -1
            // Stores the index of the zero sequence beginning
            lastZeroSequenceStartIdx = if(nums[idx-1] == 0) lastZeroSequenceStartIdx ?: (idx - 1) else null
            // moving for the next position
            idx++
        } else {
            // When a zero was found the algorithm must restart the searching from it position
            if(lastZeroSequenceStartIdx != null) {
                currentSignal = null
                // Since zero acts as a wildcard, it is safe to skip the zero position and thus avoid a loop in the algorithm.
                idx = lastZeroSequenceStartIdx + 2
                count = 2
                // Forget the zero position
                lastZeroSequenceStartIdx = null
            } else {
                // Otherwise starts a new searching sequence in the next position
                count = 1
                idx++
            }
        }
    }
    return result
}

// Possible return values:
// 1 -> positive values
// -1 -> negative values
// null -> for zero because in this exercise the zero acts as a wildcard
fun getSignal(value: Int) = if (value == 0) null else if (value shr 31 == 0) 1 else -1

fun isAlternateSequence(currentSignal: Int?, values: Int) = (currentSignal == null || values == 0 || currentSignal != getSignal(values))
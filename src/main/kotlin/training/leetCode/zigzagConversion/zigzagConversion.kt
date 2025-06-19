package training.leetCode.zigzagConversion

class Solution {
    fun convert(s: String, numRows: Int): String {
        if(numRows == 1 || s.length <= numRows) return s

        val rows = arrayOfNulls<ArrayList<Char>>(numRows).also {
            for (i in 0..numRows - 1) {
                it[i] = ArrayList()
            }
        }
        var idx = 0
        var direction = 1;

        for (c in s) {
            rows[idx]!!.add(c)
            if (idx == 0) {
                direction = 1
            } else if (idx == numRows - 1) {
                direction = -1
            }
            idx += direction
        }

        val result = StringBuilder()
        for (row in rows) {
            for (c in row!!) {
                result.append(c)
            }
        }

        return result.toString()
    }
}
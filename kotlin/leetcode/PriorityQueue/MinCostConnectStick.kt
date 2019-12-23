/*
You have some sticks with positive integer lengths.

You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y. You perform this action until there is one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.

Example 1:

Input: sticks = [2,4,3]
Output: 14
Example 2:

Input: sticks = [1,8,3,5]
Output: 30

Constraints:
    1 <= sticks.length <= 10^4
    1 <= sticks[i] <= 10^4

Link: https://leetcode.com/problems/minimum-cost-to-connect-sticks/
 */

fun connectSticks(sticks: IntArray): Int {
    var cost = 0

    val minHeap = java.util.PriorityQueue<Int>()
    for (stick in sticks) {
        minHeap.add(stick)
    }

    while (minHeap.size > 1) {
        val sum = minHeap.remove() + minHeap.remove()
        cost += sum
        minHeap.add(sum)
    }

    return cost
}

fun main(args: Array<String>) {
    val sticks = intArrayOf(2, 4, 3)
    println("Input: [2,4,3]\nOutput: ${connectSticks(sticks)}")
}
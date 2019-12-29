/*
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".

Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).

Leetcode: https://leetcode.com/problems/minimum-index-sum-of-two-lists/
*/

fun findResturant(list1: Array<String>, list2: Array<String>): ArrayList<String> {
	if (list1.size > list2.size) {
		return findResturant(list2, list1)
	}

	// put second list indexes into the map
	val map = HashMap<String, Int>()
	for (i in 0 until list2.size) {
		map[list2[i]] = i
	}

	// traverse the first list resturant and check its index with equivalent index in the map,
	// and find the minimum
	var result = ArrayList<String>()
	var min = Int.MAX_VALUE
	for (i in 0 until list1.size) {
		var resturant = list1[i]
		val otherIndex = map[resturant]
		if (otherIndex != null) {
			val sum = i + otherIndex

			if (sum < min) {
				min = otherIndex + i
				result.clear()
				result.add(resturant)
			}
			else if (sum == min) {
				result.add(resturant)
			}
		}
	}

	return result
}

fun main(args: Array<String>) {
	val list1 = arrayOf("Shogun", "Tapioca Express", "Burger King", "KFC")
	val list2 = arrayOf("Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun")

	val result = findResturant(list1, list2)
	for (resturant in result) {
		println("$resturant,")
	}
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
*/

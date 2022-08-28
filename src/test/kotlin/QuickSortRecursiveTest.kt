import org.junit.jupiter.api.Test

internal class QuickSortRecursiveTest {

    @Test
    fun sortSingleValue() {
        val list = mutableListOf(123)
        quicksortRecursive(list)
        assert(list[0] == 123)
    }

    @Test
    fun sortTwoValues() {
        val list = mutableListOf(456, 123)
        quicksortRecursive(list)
        assert(list[0] == 123)
        assert(list[1] == 456)
    }

    @Test
    fun sortMultipleValues() {
        val lists = listOf(
            listOf(8, 1, 8, 7, 2, 9, 3, 6, 4, 8),
            listOf(5, 2, 3, 1, 4),
            listOf(3, 3, 4, 1, 7, 9, 7),
            listOf(4, 9, 1),
            listOf(2, 9, 7, 7, 7, 1, 8, 6, 7, 9),
            listOf(5, 2, 4, 1, 1, 8, 9, 5),
            listOf(6, 7, 5, 9, 2, 5, 5, 0, 5, 9),
            listOf(2, 0, 8, 0, -3),
            listOf(3, 7, 2, 0, 9, 6, 2, 2, 2),
        )

        val sortedLists = listOf(
            listOf(1, 2, 3, 4, 6, 7, 8, 8, 8, 9),
            listOf(1, 2, 3, 4, 5),
            listOf(1, 3, 3, 4, 7, 7, 9),
            listOf(1, 4, 9),
            listOf(1, 2, 6, 7, 7, 7, 7, 8, 9, 9),
            listOf(1, 1, 2, 4, 5, 5, 8, 9),
            listOf(0, 2, 5, 5, 5, 5, 6, 7, 9, 9),
            listOf(-3, 0, 0, 2, 8),
            listOf(0, 2, 2, 2, 2, 3, 6, 7, 9),
        )

        for ((listToSort, sortedList) in lists.zip(sortedLists)) {
            val mutableListToSort = listToSort.toMutableList()
            quicksortRecursive(mutableListToSort)
            assert(mutableListToSort == sortedList)
        }
    }

    @Test
    fun sortAscending() {
        val list = mutableListOf(1, 3, 1, 8, 5, -7, 10, 2)
        quicksortRecursive(list)
        assert(list.zipWithNext { a, b -> a <= b }.all { it })
    }

    @Test
    fun sortDescending() {
        val list = mutableListOf(1, 3, 1, 8, 5, -7, 10, 2)
        quicksortRecursive(list) { a, b -> b - a }
        assert(list.zipWithNext { a, b -> a >= b }.all { it })
    }

    @Test
    fun sortDoubles() {
        val lists = listOf(
            listOf(4.9, 2.775, 4.24, 3.45, 1.68, 0.12, 4.625, 2.535, 4.515, 2.625),
            listOf(1.69, 4.635),
            listOf(1.18, 1.51, 2.92, 0.725),
            listOf(3.515, 3.385, 4.46, 0.475, 2.565),
        )

        val sortedLists = listOf(
            listOf(0.12, 1.68, 2.535, 2.625, 2.775, 3.45, 4.24, 4.515, 4.625, 4.9),
            listOf(1.69, 4.635),
            listOf(0.725, 1.18, 1.51, 2.92),
            listOf(0.475, 2.565, 3.385, 3.515, 4.46),
        )

        for ((listToSort, sortedList) in lists.zip(sortedLists)) {
            val mutableListToSort = listToSort.toMutableList()
            quicksortRecursive(mutableListToSort)
            assert(mutableListToSort == sortedList)
        }
    }

    @Test
    fun sortStrings() {
        val lists = listOf(
            listOf("xyz", "abc", "d"),
            listOf("z", "a"),
            listOf("acd", "abd", "aba"),
        )

        val sortedLists = listOf(
            listOf("abc", "d", "xyz"),
            listOf("a", "z"),
            listOf("aba", "abd", "acd"),
        )

        for ((listToSort, sortedList) in lists.zip(sortedLists)) {
            val mutableListToSort = listToSort.toMutableList()
            quicksortRecursive(mutableListToSort)
            assert(mutableListToSort == sortedList)
        }
    }
}
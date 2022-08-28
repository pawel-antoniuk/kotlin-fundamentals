class QuickSortRecursive<T>(
    private val comparator: Comparator<T>
) where T : Comparable<T> {

    constructor() : this({ a: T, b: T -> a.compareTo(b) })

    fun sort(list: MutableList<T>) {
        if (list.size <= 1) return
        val pivotIndex = partition(list)
        sort(list.subList(0, pivotIndex))
        sort(list.subList(pivotIndex, list.size))
    }

    private fun partition(list: MutableList<T>): Int {
        var i = -1
        var j = list.size
        val pivot = list[list.size / 2]

        while (true) {
            do ++i while (comparator.compare(list[i], pivot) < 0)
            do --j while (comparator.compare(list[j], pivot) > 0)
            if (i >= j) return i
            list[i] = list[j].also { list[j] = list[i] }
        }
    }
}

fun <T> quicksortRecursive(list: MutableList<T>, comparator: Comparator<T>? = null) where T : Comparable<T> {
    val quicksortInstance = if (comparator == null) {
        QuickSortRecursive()
    } else {
        QuickSortRecursive(comparator)
    }
    quicksortInstance.sort(list)
}
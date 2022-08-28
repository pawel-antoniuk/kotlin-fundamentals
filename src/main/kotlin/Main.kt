import kotlin.math.roundToInt
import kotlin.random.Random

fun main() {
    for (i in 1..20)
        println(List(10) { (Random.nextDouble(10.0) * 100).roundToInt() / 200.0 })
}
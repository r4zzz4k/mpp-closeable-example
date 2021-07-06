import kotlin.use as kotlinUse

import com.example.closeable.sample.Hello
import com.example.closeable.use

fun main() {
    try {
        println("Starting")
        Hello().use {
            println("Inside use")
            error("test")
        }
        println("Ending")
    } catch (e: RuntimeException) {
        println("Caught")
    }

    println()

    try {
        println("Starting kotlinUse")
        Hello().kotlinUse {
            println("Inside kotlinUse")
            error("test")
        }
        println("Ending kotlinUse")
    } catch (e: RuntimeException) {
        println("Caught kotlinUse")
    }
}

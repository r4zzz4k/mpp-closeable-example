import kotlinx.browser.document

import com.example.closeable.sample.Hello
import com.example.closeable.use

fun append(message: String) {
    val div = document.createElement("div")
    div.textContent = message
    document.getElementById("root")!!.appendChild(div)
}
fun main() {
    try {
        append("Starting")
        Hello(append = ::append).use {
            append("Inside use")
            error("test")
        }
        append("Ending")
    } catch (e: RuntimeException) {
        append("Caught")
    }
}

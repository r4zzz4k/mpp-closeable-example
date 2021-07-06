package com.example.closeable.sample

import com.example.closeable.*

public class Hello(private val append: (String) -> Unit = ::println): Closeable {
    override fun close() {
        append("Closed")
    }
}

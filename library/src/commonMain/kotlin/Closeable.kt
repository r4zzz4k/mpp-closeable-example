package com.example.closeable

import kotlin.contracts.*

public expect interface Closeable {
    public fun close()
}

@OptIn(ExperimentalContracts::class)
public inline fun <T : Closeable?, R> T.use(block: (T) -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    var exception: Throwable? = null
    try {
        return block(this)
    } catch (e: Throwable) {
        exception = e
        throw e
    } finally {
        this.closeFinally(exception)
    }
}

@PublishedApi
internal fun Closeable?.closeFinally(cause: Throwable?): Unit = when {
    this == null -> {}
    cause == null -> close()
    else ->
        try {
            close()
        } catch (closeException: Throwable) {
            cause.addSuppressed(closeException)
        }
}

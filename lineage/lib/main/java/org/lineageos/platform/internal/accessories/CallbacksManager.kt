/*
 * SPDX-FileCopyrightText: 2024 The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package org.lineageos.platform.internal.accessories

import android.util.Log
import java.lang.ref.WeakHashMap
import java.util.concurrent.ConcurrentHashMap

/**
 * A manager for callbacks that are stored as weak references.
 *
 * @param T The type of the callback
 */
class CallbacksManager<T : Any> {
    private val callbacks = ConcurrentHashMap<T, Nothing>(WeakHashMap<T, Nothing>())

    /**
     * Adds a callback to the manager.
     *
     * @param callback The callback to add
     */
    fun registerCallback(callback: T) {
        callbacks[callback] = Nothing
    }

    /**
     * Removes a callback from the manager.
     *
     * @param callback The callback to remove
     */
    fun unregisterCallback(callback: T) {
        callbacks.remove(callback)
    }

    /**
     * Calls a block for each callback in the manager.
     *
     * @param block The block to call for each callback
     */
    fun forEachCallback(block: (T) -> Unit) {
        callbacks.keys.forEach {
            block(it)
        }
    }
}

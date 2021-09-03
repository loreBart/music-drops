package com.crazy.musicdrops.model.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Log {
    private val logger: Logger = LoggerFactory.getLogger(Log::class.java)

    fun debug(msg: String, throwable: Throwable? = null) = logger.debug(msg, throwable)

    fun warn(msg: String) = logger.warn(msg)

    fun error(msg: String) = logger.error(msg)

}
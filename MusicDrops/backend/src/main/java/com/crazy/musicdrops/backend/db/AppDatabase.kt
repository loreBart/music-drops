package com.crazy.musicdrops.backend.db

import com.crazy.musicdrops.backend.db.table.MusicDropsTable
import com.crazy.musicdrops.backend.db.table.UserTable
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

object AppDatabase {

    fun init() {
        Database.connect(hikari())

        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(UserTable)
            SchemaUtils.create(MusicDropsTable)
        }
    }

    private fun hikari(): HikariDataSource {
        val config = HikariConfig()
        config.driverClassName = "org.h2.Driver"
        config.jdbcUrl = "jdbc:h2:mem:test"
        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.validate()
        return HikariDataSource(config)
    }

}

package com.github.joaolucasl.wallet_service.infrastructure

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import java.util.Properties

object DatabaseConfig {
    fun setup() {
        val dataSource = buildDataSource()
        Database.connect(dataSource)
    }

    private fun buildDataSource() = HikariDataSource(HikariConfig(dbProperties()))

    private fun dbProperties() : Properties{
        return Properties().also {
            it["dataSourceClassName"] = "org.postgresql.ds.PGSimpleDataSource"
            it["dataSource.serverName"] = Environment.DATABASE_HOST
            it["dataSource.user"] = Environment.DATABASE_USER
            it["dataSource.password"] = Environment.DATABASE_PASSWORD
            it["dataSource.databaseName"] = Environment.DATABASE_NAME
        }
    }
}


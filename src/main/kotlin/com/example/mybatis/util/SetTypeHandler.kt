package com.example.mybatis.util

import org.apache.ibatis.type.JdbcType
import org.apache.ibatis.type.MappedJdbcTypes
import org.apache.ibatis.type.MappedTypes
import org.apache.ibatis.type.TypeHandler
import java.sql.CallableStatement
import java.sql.JDBCType
import java.sql.PreparedStatement
import java.sql.ResultSet

class SetTypeHandler : TypeHandler<Set<String>> {
    override fun setParameter(ps: PreparedStatement, i: Int, parameter: Set<String>, jdbcType: JdbcType) {
        ps.setString(i, parameter.joinToString(","))
    }

    override fun getResult(rs: ResultSet, columnName: String): Set<String> {
        return rs.getString(columnName).split(",").toSet()
    }

    override fun getResult(rs: ResultSet, columnIndex: Int): Set<String> {
        return rs.getString(columnIndex).split(",").toSet()
    }

    override fun getResult(cs: CallableStatement, columnIndex: Int): Set<String> {
        return cs.getString(columnIndex).split(",").toSet()
    }
}

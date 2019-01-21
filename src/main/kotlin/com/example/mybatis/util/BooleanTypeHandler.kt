package com.example.mybatis.util

import org.apache.ibatis.type.BaseTypeHandler
import org.apache.ibatis.type.BooleanTypeHandler
import org.apache.ibatis.type.JdbcType
import org.apache.ibatis.type.TypeHandler
import java.sql.CallableStatement
import java.sql.PreparedStatement
import java.sql.ResultSet

class BooleanTypeHandler : BaseTypeHandler<Boolean>() {

    override fun setNonNullParameter(ps: PreparedStatement, i: Int, parameter: Boolean, jdbcType: JdbcType) {
        ps.setBoolean(i, parameter)
    }

    override fun getNullableResult(rs: ResultSet, columnName: String): Boolean {
        return rs.getBoolean(columnName)
    }

    override fun getNullableResult(rs: ResultSet, columnIndex: Int): Boolean {
        return rs.getBoolean(columnIndex)
    }

    override fun getNullableResult(cs: CallableStatement, columnIndex: Int): Boolean {
        return cs.getBoolean(columnIndex)
    }

}

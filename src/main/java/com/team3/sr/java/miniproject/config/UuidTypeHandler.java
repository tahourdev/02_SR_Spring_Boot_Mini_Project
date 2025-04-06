package com.team3.sr.java.miniproject.config;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

//public class UuidTypeHandler implements TypeHandler<UUID> {
//
//    @Override
//    public void setParameter(PreparedStatement ps, int i, UUID parameter, JdbcType jdbcType) throws SQLException {
//        if (parameter == null) {
//            ps.setObject(i, null);
//        } else {
//            ps.setObject(i, parameter, java.sql.Types.OTHER);
//        }
//    }
//
//    @Override
//    public UUID getResult(ResultSet rs, String columnName) throws SQLException {
//        String uuid = rs.getString(columnName);
//        return uuid == null ? null : UUID.fromString(uuid);
//    }
//
//    @Override
//    public UUID getResult(ResultSet rs, int columnIndex) throws SQLException {
//        String uuid = rs.getString(columnIndex);
//        return uuid == null ? null : UUID.fromString(uuid);
//    }
//
//    @Override
//    public UUID getResult(CallableStatement cs, int columnIndex) throws SQLException {
//        String uuid = cs.getString(columnIndex);
//        return uuid == null ? null : UUID.fromString(uuid);
//    }
//}


import org.apache.ibatis.type.BaseTypeHandler;
import org.springframework.stereotype.Component;

@Component
public class UuidTypeHandler extends BaseTypeHandler<UUID> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, UUID parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter, java.sql.Types.OTHER);
    }

    @Override
    public UUID getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return value == null ? null : UUID.fromString(value);
    }

    @Override
    public UUID getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return value == null ? null : UUID.fromString(value);
    }

    @Override
    public UUID getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return value == null ? null : UUID.fromString(value);
    }
}
package com.base.mapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.*;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * This mapper to help transforming resultset to Dto automatically through reflecting and accessing properties of Bean.
 *
 */
@Slf4j
public class BaseRowAutoMapper<ENTITY> implements RowMapper<ENTITY> {

    private Class<ENTITY> mappedClass;

    public BaseRowAutoMapper(Class<ENTITY> mappedClass) {
        this.mappedClass = mappedClass;
    }

    @Override
    public ENTITY mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        ENTITY mappedObject = BeanUtils.instantiateClass(this.mappedClass);
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(mappedObject);

        beanWrapper.setAutoGrowNestedPaths(true);

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int index = 1; index <= columnCount; index++) {
            try {
                String column = JdbcUtils.lookupColumnName(metaData, index);
                Object value = JdbcUtils.getResultSetValue(resultSet, index,
                        Class.forName(metaData.getColumnClassName(index)));

                beanWrapper.setPropertyValue(column, value);
            } catch (TypeMismatchException | NotWritablePropertyException | ClassNotFoundException e) {
                log.error("Cannot mapper entity to Dto. ", e);
            }
        }
        return mappedObject;
    }
}
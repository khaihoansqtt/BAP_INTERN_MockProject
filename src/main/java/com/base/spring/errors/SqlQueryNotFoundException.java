package com.base.spring.errors;

import com.base.repository.sqltemplate.SqlQuery;

public class SqlQueryNotFoundException extends RuntimeException {
    public SqlQueryNotFoundException(Class<? extends SqlQuery> sqlTemplate) {
        super("Could not find SQL template: " + sqlTemplate.getName());
    }
}

package com.base.spring.errors;

import com.base.repository.sqltemplate.SqlQuery;

public class SqlTemplateIOException extends RuntimeException {
    public SqlTemplateIOException(Class<? extends SqlQuery> sqlTemplate) {
        super("Could not find SQL template: " + sqlTemplate.getName());
    }

    public SqlTemplateIOException(Class<? extends SqlQuery> sqlTemplate, Throwable e) {
        super("Could not read SQL template: " + sqlTemplate.getName(), e);
    }
}

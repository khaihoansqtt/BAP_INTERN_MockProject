//package com.base.repository.sqltemplate;
//
//import com.base.spring.errors.SqlQueryNotFoundException;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class SqlTemplater {
//
//    /**
//     * Gets sql query locator.
//     *
//     * @return the sql query locator
//     */
//    public SqlQueryLocator getSqlQueryLocator() {
//        return new SqlQueryLocator();
//    }
//
//    /**
//     * Gets query.
//     *
//     * @param sqlQueryClazz the sql query clazz
//     * @return the query
//     */
//    public String getQuery(Class<? extends SqlQuery> sqlQueryClazz) {
//        log.debug("getQuery: {}", sqlQueryClazz.getSimpleName());
//        String queryString = this.getSqlQueryLocator().getQuery(sqlQueryClazz);
//        if (queryString == null) {
//            throw new SqlQueryNotFoundException(sqlQueryClazz);
//        } else {
//            return queryString;
//        }
//    }
//}

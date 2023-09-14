//package com.base.repository.sqltemplate;
//
//import com.base.spring.errors.SqlTemplateIOException;
//import lombok.extern.slf4j.Slf4j;
//import org.reflections.Reflections;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.*;
//import java.lang.reflect.Modifier;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//@Slf4j
//@Component
//public class SqlQueryLocator {
//    private static final String SQL_FILE_EXTENSION = ".sql";
//    private static final String SQL_DIRECTORY = "sql/";
//    private static final String SQL_PACKAGE = "com.base.repository.query";
//    private static final String LINE_FEED = "\n";
//
//    private final Map<Class<? extends SqlQuery>, String> classesToQueriesMap = new HashMap();
//
//
//    /**
//     * Instantiates a new Sql query locator.
//     */
//    @Autowired
//    public SqlQueryLocator() {
//        findAllQueryClasses(SQL_PACKAGE);
//    }
//
//    /**
//     * Get Query String by Class
//     *
//     * @param queryClass Class which defined Sql query
//     * @return Query String
//     */
//    public String getQuery(Class<? extends SqlQuery> queryClass) {
//        return this.classesToQueriesMap.get(queryClass);
//    }
//
//    /**
//     * Release Map contains query if needed
//     */
//    public void clear() {
//        this.classesToQueriesMap.clear();
//    }
//
//    private void findAllQueryClasses(String prefixes) {
//        log.info("findAllQueryClasses called.");
//        Reflections reflections = new Reflections(prefixes);
//        Set<Class<? extends SqlQuery>> queryClasses = reflections.getSubTypesOf(SqlQuery.class);
//        this.classesToQueriesMap.clear();
//        queryClasses.stream()
//                .filter(queryClass -> !Modifier.isAbstract(queryClass.getModifiers()))
//                .forEach(queryClass -> this.classesToQueriesMap.put(queryClass, this.loadQuery(queryClass)));
//    }
//
//    private String loadQuery(Class<? extends SqlQuery> sqlTemplate) {
//        log.debug("Adding into QueryMap : {} .....", sqlTemplate.getSimpleName());
//        InputStream inputStream = this.getClass()
//                .getClassLoader()
//                .getResourceAsStream(SQL_DIRECTORY + sqlTemplate.getSimpleName() + SQL_FILE_EXTENSION);
//
//        if (inputStream == null) {
//            throw new SqlTemplateIOException(sqlTemplate);
//        }
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//        StringBuilder stringBuilder = new StringBuilder();
//
//        try {
//            appendLine(reader, stringBuilder);
//        } catch (IOException e) {
//            throw new SqlTemplateIOException(sqlTemplate, e);
//        } finally {
//            this.closeQuietly(reader);
//        }
//        return stringBuilder.toString();
//    }
//
//    private void closeQuietly(Reader input) {
//        try {
//            input.close();
//        } catch (IOException e) {
//            log.error("Could not close resources", e);
//        }
//    }
//
//    private void appendLine(BufferedReader reader, StringBuilder stringBuilder) throws IOException {
//        String line;
//        while ((line = reader.readLine()) != null) {
//            stringBuilder.append(line).append(LINE_FEED);
//        }
//    }
//}

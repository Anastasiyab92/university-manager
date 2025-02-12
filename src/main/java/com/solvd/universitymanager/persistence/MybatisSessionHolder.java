package com.solvd.universitymanager.persistence;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisSessionHolder {

    private static final String FILE_PROPERTY = "mybatis-config.xml";
    private static final SqlSessionFactory SQL_SESSION_FACTORY;

    static {
        SQL_SESSION_FACTORY = buildSqlSession();
    }

    private static SqlSessionFactory buildSqlSession() {
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(FILE_PROPERTY);
        } catch (IOException e) {
            throw new RuntimeException("Unable to prepare mybatis config xml.", e);
        }
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        return builder.build(inputStream);
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return SQL_SESSION_FACTORY;
    }
}

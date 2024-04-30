package org.zerock.jdbcex.dao;

import lombok.Cleanup;
import org.checkerframework.checker.units.qual.C;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TodoDAO {

    public String getTime() {
        String now = null;

        /*
        try-with-resources 구문을 사용하면, 괄호 안에 선언된 모든 자원(AutoCloseable 인터페이스를 구현하는 객체)은 try 블록을 벗어날 때 자동으로 닫힘.
        이는 Connection, PreparedStatement, ResultSet과 같은 JDBC 자원을 포함하며, 이들은 모두 AutoCloseable 인터페이스를 구현하고 있어 해당 방식으로 자동 관리됨.*/

        try (Connection connection = ConnectionUtil.Instance.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select now()");
             ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            resultSet.next();
            now = resultSet.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    public String getTime2() throws Exception {
        @Cleanup Connection connection = ConnectionUtil.Instance.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement("select now()");
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        String now = resultSet.getString(1);

        return now;
    }
}

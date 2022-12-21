package com.ddoooe.study_servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class PollWithDB {
    public void getQuestion(String questionsUid) throws SQLException{
        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String query = "SELECT * FROM QUESTIONS_LIST " +
                        " WHERE QUESTIONS_UID = '"+questionsUid+"'";
        
        ResultSet resultSet = statement.executeQuery(query);
        // 로우 하나를 받아내는 데이터를 결정해야 한다.
        // 넘겨줄 수 있는 건 3가지 중 하나다(지금은 row하나라 hashMap). (bean, hashMap, arrayList)
        HashMap<String, Object> result;
        while(resultSet.next()){
            resultSet.getString("QUESTIONS_UID");
            resultSet.getString("QUESTIONS");
            resultSet.getInt("ORDERS");
        }
    }
}

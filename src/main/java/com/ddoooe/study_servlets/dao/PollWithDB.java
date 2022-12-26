package com.ddoooe.study_servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class PollWithDB {
    public ArrayList<HashMap> getAnswer(String questionsUid) throws SQLException{

        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        // 습관적으로 query 이어지는 뒷 부분에 스페이스바 하나 넣어주기
        String query = "SELECT ANSWERS.QUESTIONS_UID, EXAMPLE_LIST.ORDERS, EXAMPLE_LIST.EXAMPLE " +
                        "FROM ANSWERS " +
                        "INNER JOIN EXAMPLE_LIST " +
                        "ON ANSWERS.EXAMPLE_UID = EXAMPLE_LIST.EXAMPLE_UID " +
                        "WHERE QUESTIONS_UID = '"+questionsUid+"' " +
                        "ORDER BY QUESTIONS_UID";
        // DB에 던지기
        // resultSet으로 던졌다 --> 여러개가 루핑을 돈다
        ResultSet resultSet = statement.executeQuery(query);

        ArrayList<HashMap> answer_list = new ArrayList<>(); 
        while(resultSet.next()){
            // HashMap은 마지막에 넣은 answer만 담긴다. 그래서 마지막으로 ArrayList에 담아주기
            HashMap<String, Object> answer = new HashMap<>();
            answer.put("QUESTIONS_UID", resultSet.getString("QUESTIONS_UID"));
            answer.put("ORDERS", resultSet.getInt("ORDERS"));
            answer.put("EXAMPLE", resultSet.getString("EXAMPLE"));

            // 각각의 HashMap ArrayList에 담아주기
            answer_list.add(answer);
        }
        // 묶어둔 answer_list return
        return answer_list;
    }

    public HashMap<String, Object> getQuestion(String questionsUid) throws SQLException{
        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String query = "SELECT * FROM QUESTIONS_LIST " +
                        " WHERE QUESTIONS_UID = '"+questionsUid+"'";
        
        ResultSet resultSet = statement.executeQuery(query);
        // 로우 하나를 받아내는 데이터를 결정해야 한다.
        // 넘겨줄 수 있는 건 3가지 중 하나다(지금은 row하나라 hashMap). (bean, hashMap, arrayList)
        HashMap<String, Object> result = null;
        while(resultSet.next()){
            result = new HashMap<>();
            result.put("QUESTIONS_UID", resultSet.getString("QUESTIONS_UID"));
            result.put("QUESTIONS",resultSet.getString("QUESTIONS"));
            result.put("ORDERS",resultSet.getInt("ORDERS"));
        }

        return result;
    }
}

package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("INSERT INTO ConstructionProgress(schedule,\n" +
                "                                 project_id,\n" +
                "                                 additional_comments)\n" +
                "VALUES (#{value},\n" +
                "        #{projectId},\n" +
                "        (SELECT TOP 1 additional_comments\n" +
                "         FROM ConstructionProgress\n" +
                "         WHERE project_id = #{projectId}\n" +
                "         ORDER BY created_at DESC))");
    }
}
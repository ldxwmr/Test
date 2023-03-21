package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s = "SELECT d.id, filename, path, created_at AS createdAt\n" +
                "FROM Document d\n" +
                "WHERE CONVERT(VARCHAR(7), d.created_at, 126) = #{date}\n" +
                "  AND d.project_id = #{projectId}\n" +
                "  AND d.document_category_id = (SELECT id\n" +
                "                                FROM DocumentCategoryMaster dcm\n" +
                "                                WHERE dcm.item = 'Site Photographs')\n" +
                "ORDER BY d.created_at DESC";
        System.out.println(s);


    }
}
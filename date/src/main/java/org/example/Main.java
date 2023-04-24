package org.example;


public class Main {
    public static void main(String[] args) {
        System.out.println("select ST.tower, SCU.unit_no, SUBSTRING(SCU.unit_no, 1, 3) as unitGroup, SCUS.stage, SCUS.id as stageId\n" +
                "from StageCompletionTower ST\n" +
                "         join StageCompletionUnit SCU on ST.id = SCU.tower_id\n" +
                "         join StageCompletionUnitStage SCUS on SCU.id = SCUS.unit_id\n" +
                "where ST.project_id = #{projectId} and LEFT(CONVERT(varchar(100), SCUS.upload_year_month, 23), 7) = #{uploadYearMonth}\n" +
                "order by ST.tower, SCU.unit_no desc");
    }
}
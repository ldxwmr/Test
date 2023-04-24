package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("select count(*) counts, stage, DATENAME(month, upload_year_month) month\n" +
                "from StageCompletionTower ST\n" +
                "         join StageCompletionUnit SCU on ST.id = SCU.tower_id\n" +
                "         join StageCompletionUnitStage SCUS on SCU.id = SCUS.unit_id\n" +
                "where ST.project_id = #{projectId}\n" +
                "  and DATENAME(year, SCUS.upload_year_month) = #{year}\n" +
                "group by stage, upload_year_month order by month");
    }
}
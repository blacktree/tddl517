package com.taobao.tddl.sample;

import com.taobao.tddl.client.jdbc.TDataSource;
import com.taobao.tddl.common.exception.TddlException;
import com.taobao.tddl.common.properties.ConnectionProperties;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ZaisiSample {

    public static void main(String[] args) throws TddlException, SQLException {

        TDataSource ds = new TDataSource();

        ds.setAppName("DEV_SUBWAY_MYSQL");
        ds.setRuleFile("rule.xml");

        Map cp = new HashMap();
        cp.put("ALLOW_TEMPORARY_TABLE", "True");
        cp.put(ConnectionProperties.TEMP_TABLE_DIR, ".\\temp\\");
        cp.put(ConnectionProperties.TEMP_TABLE_CUT_ROWS, false);
        cp.put(ConnectionProperties.TEMP_TABLE_MAX_ROWS, 100);
        ds.setConnectionProperties(cp);

        ds.init();

        System.out.println("init done");
        long start = System.currentTimeMillis();

        Connection conn = ds.getConnection();
        // PreparedStatement ps =
        // conn.prepareStatement("SELECT a.custId, a.id,b.adgroupid, SUM(c.cost) / SUM(c.click) AS ppc,c.thedate, c.memberid, c.campaignid, c.productlineid, c.adgroupid, SUM(c.impression), SUM(c.cost), SUM(c.click), SUM(c.click) / SUM(c.impression) AS ctr, b.title, a.onlinestate, a.reason FROM Lunaadgroup a join lunaadgroupinfo b on a.id=b.adgroupid  LEFT JOIN rpt_solar_adgroup_ob c ON a.id = c.adgroupid where a.custid='1102000884' and b.custid='1102000884'   GROUP BY c.thedate, c.memberid, c.campaignid, c.productlineid, c.adgroupid HAVING ppc > 1 ORDER BY ppc DESC");
        PreparedStatement ps = conn.prepareStatement("SELECT "
                + "sum(d.impression), sum(d.cost), sum(d.click),(sum(d.click)/sum(d.impression)) as ctr, (sum(d.cost) / sum(d.click)) as ppc "
                + "FROM (SELECT "
                + "               sum(b.impression) as impression , sum(b.cost) as cost, sum(b.click) as click "
                + "FROM "
                + "               Lunaadgroup a left join rpt_solar_adgroup_ob b on a.id=b.adgroupid "
                + "              LEFT join lunacampaign c on c.id=a.campaignid "
                + " "
                + "WHERE "
                + "      a.onlinestate in (1,2,3) "
                + "               AND b.thedate between '2013-12-12' AND '2013-12-31' "
                + "      AND a.custid=1102272275 "

                + "GROUP BY "
                + "             b.memberid, b.campaignid, b.productlineid, b.adgroupid "
                + ") as d" + " HAVING " + "               ppc>1 ");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            StringBuilder sb = new StringBuilder();
            int count = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= count; i++) {

                String key = rs.getMetaData().getColumnLabel(i);
                Object val = rs.getObject(i);
                sb.append("[" + rs.getMetaData().getTableName(i) + "." + key + "->" + val + "]");
            }
            System.out.println(sb.toString());
        }

        rs.close();
        ps.close();
        conn.close();

        System.out.println("done " + (System.currentTimeMillis() - start));
    }
}

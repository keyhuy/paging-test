package com.keyhuy.paging.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 工具类-操作数据库
 *
 * @author Key
 * @date 2022/01/22/10:55
 **/
public class DbUtils {

    private static DataSource ds;

    static {
        try {
            // 创建属性文件类
            Properties pro = new Properties();
            // 将外部属性文件加载到内存
            pro.load(DbUtils.class.getClassLoader().getResourceAsStream("druid.properties"));

            // 通过属性类对象获取数据库连接池对象，并将属性文件中各个属性注入连接池
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象
     */
    public static Connection getConn() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 关闭资源
     */
    public static void closeResource(ResultSet rs, PreparedStatement ps, Connection conn) {

        try {
            // 判断是否是null，不是就关闭
            if (null != rs) {
                rs.close();
            }

            if (null != ps) {
                ps.close();
            }

            if (null != conn) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package assignment.springboot.projectmanagement.utils;

import com.baomidou.mybatisplus.generator.config.*;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class BaseGenerator {
    protected static void initDataSource(DataSourceConfig dataSourceConfig) throws SQLException {
        Connection conn = dataSourceConfig.getConn();
        InputStream inputStream = BaseGenerator.class.getResourceAsStream("/sql/init.sql");
        ScriptRunner scriptRunner = new ScriptRunner(conn);
        scriptRunner.setAutoCommit(true);
        scriptRunner.runScript(new InputStreamReader(inputStream));
        conn.close();
    }

    protected static StrategyConfig.Builder strategyConfig() {
        return new StrategyConfig.Builder();
    }

    protected static GlobalConfig.Builder globalConfig() {
        return new GlobalConfig.Builder();
    }

    protected static PackageConfig.Builder packageConfig() {
        return new PackageConfig.Builder();
    }

    protected static TemplateConfig.Builder templateConfig() {
        return new TemplateConfig.Builder();
    }

    protected static InjectionConfig.Builder injectionConfig() {
        return new InjectionConfig.Builder().beforeOutputFile((tableInfo, objectMap) -> {
            System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
        });
    }
}
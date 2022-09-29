package assignment.springboot.projectmanagement.utils;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;

public class MySQLGeneratorTest extends BaseGenerator {
    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig.Builder("jdbc:mysql://xxxx:3306/baomidou?serverTimezone=Asia/Shanghai", "root", "123456").schema("baomidou").build();

    public void testSimple() {
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        generator.strategy(strategyConfig().build());
        generator.global(globalConfig().build());
        generator.execute();
    }
}
package com.example.demo.utils;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGeneratorPlus {

    /*服务的文件夹名称*/
    private static final String projectName = "";
    /*模块名称*/
    private static final String moduleName = "";
    /*服务包名*/
    private static final String parentName = "com.example.demo";
    /*控制层所在地方*/
    private static final String controllerName = "controller" + moduleName;
    /*实体层所在*/
    private static final String entityName = "entity" + moduleName;
    /*mapper层所在*/
    private static final String mapperName = "mapper" + moduleName;
    /*服务接口层*/
    private static final String serviceName = "service" + moduleName;
    /*服务实现层*/
    private static final String serviceImplName = "service.impl" + moduleName;

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StrUtil.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/" + projectName + "/src/main/java");
        gc.setAuthor("zqy");
        gc.setOpen(false);
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://lijifeng.mysql.rds.aliyuncs.com:3306/science?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai");
        dsc.setDbType(DbType.MYSQL);
        dsc.setUsername("root");
        dsc.setPassword("@LJF_li0104");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        dsc.setUrl("jdbc:kingbase8://10.249.137.149:54321/YXKJ_DWDB");
//        dsc.setDbType(DbType.KINGBASE_ES);
//        dsc.setUsername("YXKJ_DWDB");
//        dsc.setPassword("Password@1");
//        dsc.setDriverName("com.kingbase8.Driver");
//        dsc.setSchemaName("YXKJ_DWDB");
        mpg.setDataSource(dsc);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(parentName);
        pc.setController(controllerName);// 这里是控制器包名，默认 web
        pc.setEntity(entityName);
        pc.setMapper(mapperName);
        pc.setService(serviceName);
        pc.setServiceImpl(serviceImplName);
        mpg.setPackageInfo(pc);
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/" + projectName + "/src/main/resources/mapper/" +
                        "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
//        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    /**
     * 模块名称枚举
     */
    enum ModuleName {
        SMS("sms", "短信"),
        ORG("org", "org"),
        SYS("sys", "sys"),
        LOG("log", "日志"),
        PARA("para", "系统参数");

        private String name;
        private String desc;

        ModuleName(String name, String desc) {
            this.name = name;
            this.desc = desc;
        }

        public String getName() {
            return name;
        }
    }
}

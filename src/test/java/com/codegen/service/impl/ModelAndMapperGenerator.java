package com.codegen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.GeneratedKey;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.codegen.service.CodeGenerator;
import com.codegen.service.CodeGeneratorManager;
import com.codegen.util.StringUtils;

/**
 * Model & Mapper 代码生成器
 * Created by GaoLiWei on 2017/09/20.
 */
public class ModelAndMapperGenerator extends CodeGeneratorManager implements CodeGenerator {


	public void genCode(String tableName) {
		Context initConfig = initConfig(tableName);
		List<String> warnings = null;
		MyBatisGenerator generator = null;
		try {
			Configuration cfg = new Configuration();
			cfg.addContext(initConfig);
			cfg.validate();
			
			DefaultShellCallback callback = new DefaultShellCallback(true);
			warnings = new ArrayList<String>();
			generator = new MyBatisGenerator(cfg, callback, warnings);
			generator.generate(null);
		} catch (Exception e) {
			throw new RuntimeException("Model 和  Mapper 生成失败!", e);
		}
		
		if (generator == null || generator.getGeneratedJavaFiles().isEmpty() || generator.getGeneratedXmlFiles().isEmpty()) {
			throw new RuntimeException("Model 和  Mapper 生成失败, warnings: " + warnings);
		}
		
		if (StringUtils.isNullOrEmpty(tableName)) {
			tableName = tableNameConvertUpperCamel(tableName);
		}
		
		logger.info(tableName, "{}.java 生成成功!");
		logger.info(tableName, "{}Mapper.java 生成成功!");
//		logger.info(tableName, "{}Mapper.xml 生成成功!");
	}
	
	/**
	 * 完善初始化环境
	 * @param tableName 表名
	 */
	private Context initConfig(String tableName) {
		Context context = null;
		try {
			context = initMybatisGeneratorContext();

			//配饰生成实体类地址
			JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
	        javaModelGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
	        javaModelGeneratorConfiguration.setTargetPackage(MODEL_PACKAGE);
	        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

	        //配置生成dao接口
	        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
	        javaClientGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
	        javaClientGeneratorConfiguration.setTargetPackage(MAPPER_PACKAGE);
	        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
	        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);
	        
	        TableConfiguration tableConfiguration = new TableConfiguration(context);
	        tableConfiguration.setTableName(tableName);
	        //设置生成的domain类的名字，不设置则使用表名
//	        tableConfiguration.setDomainObjectName(modelName);
	        tableConfiguration.setGeneratedKey(new GeneratedKey("id", "Mysql", true, null));
	        context.addTableConfiguration(tableConfiguration);
		} catch (Exception e) {
			throw new RuntimeException("ModelAndMapperGenerator 初始化环境异常!", e);
		}
		return context;
	}
}

package com.codegen.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import com.codegen.service.CodeGenerator;
import com.codegen.service.CodeGeneratorManager;
import com.codegen.util.StringUtils;

import freemarker.template.Configuration;
/**
 * Service层 代码生成器
 * Created by GaoLiWei on 2017/09/20.
 */
public class ServiceGenerator extends CodeGeneratorManager implements CodeGenerator {


	public void genCode(String tableName) {
		Configuration cfg = getFreemarkerConfiguration();
		String tableNameUpperCamel = tableNameConvertUpperCamel(tableName);
		
		Map<String, Object> data = getDataMapInit(tableNameUpperCamel);
		try {
			// 创建 Service 接口
			File serviceFile = new File(TO_PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE
					+ tableNameUpperCamel + "Service.java");
			// 查看父级目录是否存在, 不存在则创建
			if (!serviceFile.getParentFile().exists()) {
				serviceFile.getParentFile().mkdirs();
			}
			cfg.getTemplate("service.ftl").process(data, new FileWriter(serviceFile));
			logger.info(tableNameUpperCamel + "Service.java 生成成功!");
			
			// 创建 Service 接口的实现类
			File serviceImplFile = new File(TO_PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE_IMPL
					+ tableNameUpperCamel + "ServiceImpl.java");
			// 查看父级目录是否存在, 不存在则创建
			if (!serviceImplFile.getParentFile().exists()) {
				serviceImplFile.getParentFile().mkdirs();
			}
			cfg.getTemplate("service-impl.ftl").process(data, new FileWriter(serviceImplFile));
			logger.info(tableNameUpperCamel + "ServiceImpl.java 生成成功!");
		} catch (Exception e) {
			throw new RuntimeException("Service 生成失败!", e);
		}
	}
	
	/**
	 * 预置页面所需数据
	 * @param tableNameUpperCamel 首字为大写的实体类名
	 * @return
	 */
	private Map<String, Object> getDataMapInit(String tableNameUpperCamel) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("date", DATE);
		data.put("author", AUTHOR);
		data.put("tableNameUpperCamel", tableNameUpperCamel);
		data.put("tableNameLowerCamel", StringUtils.toLowerCaseFirstOne(tableNameUpperCamel));
		data.put("commonPackage", COMMON_BUSINESS_PACKAGE);
		data.put("basePackage", BASE_PACKAGE);
		
		return data;
	}
}

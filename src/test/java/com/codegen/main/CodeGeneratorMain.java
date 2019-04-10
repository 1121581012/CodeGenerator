package com.codegen.main;

import com.codegen.service.CodeGeneratorManager;

/**
 * 代码生成器启动项
 * Created by GaoLiWei on 2017/09/20.
 */
public class CodeGeneratorMain {
	

	
	private static final String[] TABLES = {
			"bus_param_second"
	};

	/**
	 *  根据表名生成代码
	 * @param args
	 */
	public static void main(String[] args) {
		CodeGeneratorManager cgm = new CodeGeneratorManager();
		
		cgm.genCodeWithSimpleName(TABLES);

	}
}

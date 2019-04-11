# Java代码生成器
## 介绍
这是一个基于数据库表<br/>用来自动生成 Model & Mapper & Service & ServiceImpl & Controller 等代码的代码生成器<br/>
使用者可以通过修改ftl模板来生成自己所需的基本代码块<br/>
主要是为了解决日常工作、练习中代码的重复工作量<br/>
目前仅支持 Mybatis 底层代码的生成

## 目录结构
```

	|——test
|		|——java					// 存放生成器的代码
	|
|		|	|——com
	|
|		|	|	|——codegen
	|
|		|	|	|	|——main
	|
|						|——CodeGeneratorMain.java // 代码生成器启动项
	|
|		|	|	|	|——service
	|
|						|——CodeGeneratorManager.java // 代码生成器基础项 (通用方法)
	|
|						|——CodeGeneratorConfig.java // 所有的配置信息变量
	|
|						|——CodeGenerator.java // 主要逻辑接口
	|
|		|	|	|	|	|——impl
	|
|							|——ControllerGenerator.java // Controller层 代码生成器
	|
|							|——ServiceGenerator.java // Service层 代码生成器
	|
|							|——ModelAndMapperGenerator.java // Model&Mapper 代码生成器
	|
	|
|		|	|	|	|——util
	|
|						|——StringUtils.java // 字符串操作常用方法集
	|
|		|——resource
	|
|		|	|——generatorConfig.properties // 配置文件
	|
|		|	|——generator
	|
|		|	|	|——template				// 存放ftl模板代码
	|		
```

## 使用说明
#### 运行
进入到 `src/test/java` 目录下<br />
找到`CodeGeneratorMain`类 为生成器的启动项<br />
直接 `Run As Java Application` 运行即可<br />
而且考虑到项目开发过程中，数据库表可能会有变动，所以将Dao文件与实体类分开生成<br />
需注意命名规则与存放的包路径要统一

#### 修改配置
进入到 `src/test/resources` 目录下<br />
找到 `generatorConfig.properties` 文件<br />
修改对应的参数即可<br />
具体的注释信息可参考 `/src/test/java/com/codegen/service/CodeGeneratorConfig.java` 类<br />

#### Mybatis 通用插件
新增 Mapper 通用插件<br />
已经固定放置 `com.bigsea.sns.need` 下 <br />
使用者可以根据自已定义的路径存放<br/>
但是需要注意的是 `MyMapper` 接口存放的路径最好不要被 `Mybatis` 扫描到, 会出现异常<br />
插件路径变换后, 需要修改对应配置文件的值<br />


#### 模板样式修改
如果需要生成自己所需的 Controller & Service & ServiceImpl 样式<br/>
进入到 `src/test/resources/generator/template` 目录下<br />
修改对应的ftl文件即可






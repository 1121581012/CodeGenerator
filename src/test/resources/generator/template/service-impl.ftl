package ${basePackage}.${commonPackage}.service.impl;

import ${basePackage}.${commonPackage}.dao.${tableNameUpperCamel}Mapper;
import ${basePackage}.${commonPackage}.model.${tableNameUpperCamel};
import ${basePackage}.${commonPackage}.service.${tableNameUpperCamel}Service;
import ${basePackage}.${commonPackage}.need.AbstractMyService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
* @author ${author}
* @date ${date}
*/
@Service
public class ${tableNameUpperCamel}ServiceImpl extends AbstractMyService<${tableNameUpperCamel}> implements ${tableNameUpperCamel}Service {

    @Autowired
    private ${tableNameUpperCamel}Mapper ${tableNameLowerCamel}Mapper;

}

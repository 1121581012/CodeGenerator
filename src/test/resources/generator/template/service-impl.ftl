package ${basePackage}.service.impl;

import ${basePackage}.dao.${tableNameUpperCamel}Mapper;
import ${basePackage}.model.${tableNameUpperCamel};
import ${basePackage}.service.${tableNameUpperCamel}Service;
import ${basePackage}.service.AbstractMyService;
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

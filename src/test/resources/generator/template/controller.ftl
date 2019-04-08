package ${basePackage}.controller;
import ${basePackage}.model.${tableNameUpperCamel};
import ${basePackage}.service.${tableNameUpperCamel}Service;
import ${resultPackage}.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
* @author ${author}
* @date ${date}
*/
@Controller
@RequestMapping("/${baseRequestMapping}/")
public class ${tableNameUpperCamel}Controller {

    @Autowired
    ${tableNameUpperCamel}Service ${tableNameLowerCamel}Service;


    @PostMapping("insert")
    public Result insert(@RequestBody ${tableNameUpperCamel} ${tableNameLowerCamel}) {
    return Result.result(${tableNameLowerCamel}Service.insert(${tableNameLowerCamel}),"新增成功","新增失败");
    }

    @DeleteMapping("delete")
    public Result delete(@RequestBody ${tableNameUpperCamel} ${tableNameLowerCamel}) {
    return Result.result(${tableNameLowerCamel}Service.delete(${tableNameLowerCamel}),"删除成功","删除失败");
    }

    @DeleteMapping("deleteById/{id}")
    public Result deleteById(@PathVariable String id) {
    return Result.result(${tableNameLowerCamel}Service.deleteById(id),"删除成功","删除失败");
    }

    @PutMapping("update")
    public Result update(@RequestBody ${tableNameUpperCamel} ${tableNameLowerCamel}) {
    return Result.result(${tableNameLowerCamel}Service.update(${tableNameLowerCamel}),"更新成功","更新失败");
    }

    @GetMapping("selectById/{id}")
    public Result selectById(@PathVariable String id) {
    return Result.result(${tableNameLowerCamel}Service.selectById(id));
    }

    @GetMapping("selectAll")
    public Result selectAll() {
    return Result.result(${tableNameLowerCamel}Service.selectAll());
    }
}

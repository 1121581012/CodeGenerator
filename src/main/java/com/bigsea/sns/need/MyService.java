package com.bigsea.sns.need;

import java.util.List;

/**
 * MyService 层 基础接口，其他Service 接口 请继承该接口
 *
 * @author GaoLiWei
 * @date 2017/09/18
 */
public interface MyService<T> {

	/**
	 * 插入数据
	 * @param model
     * @return Integer
	 */
    Integer insert(T model);

    /**
     * 通过属性删除刪除
     * @param model
     * @return Integer
     */
    Integer delete(T model);

    /**
     * 通过主鍵刪除
     * @param id
     * @return Integer
     */
    Integer deleteById(Object id);

    /**
     * 更新
     * @param model
     * @return Integer
     */
    Integer update(T model);



    /**
     * 通过ID查找
     * @param id
     * @return Integer
     */
    T selectById(Object id);
    

    
    /**
     * 获取所有
     * @return Integer
     */
    List<T> selectAll();
}

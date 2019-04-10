package com.bigsea.sns.dao;


import tk.mybatis.mapper.common.Mapper;

/**
 * 通用 Mapper, 如果被扫描到会报异常
 *
 * @author GaoLiWei
 * @date 2017/09/18
 */
public interface MyMapper<T> extends Mapper<T> {
}

package com.itheima.service;//操作部门信息

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> findAll();  //查询所有部门数据

    //根据部门ID删除
    void deleteById(Integer id);

    //新增部门
    void add(Dept dept);

    //根据ID查询部门
    Dept getById(Integer deptId);

    //修改部门
    void update(Dept dept);
}

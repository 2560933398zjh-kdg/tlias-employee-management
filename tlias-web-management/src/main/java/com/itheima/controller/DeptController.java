package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;


    //查询部门
    @GetMapping("/depts")
    public Result list(){
        System.out.println("查询全部部门数据");
        List<Dept> deptList= deptService.findAll();
        return Result.success(deptList);
    }

    //删除部门
    @DeleteMapping("/depts")
    public Result delete(Integer id){
        System.out.println("根据ID删除部门："+ id);
        deptService.deleteById(id);
        return Result.success();
    }

    //新增部门
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        System.out.println("新增部门"+dept);
        deptService.add(dept);
        return Result.success();
    }

    //根据ID查询部门
    @GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable("id") Integer deptId){
        System.out.println("查询部门"+deptId);
        Dept dept=deptService.getById(deptId);
        return Result.success(deptId);
    }

    //修改部门数据
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        System.out.println("修改部门："+dept);
        deptService.update(dept);
        return Result.success();
    }
}

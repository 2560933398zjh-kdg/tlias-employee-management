# web-ai-project02 — Maven 项目容器

包含两个独立子项目：HelloWorld 入门示例与 tlias 员工管理系统。

## 子项目

| 子目录 | 项目 | 说明 |
| --- | --- | --- |
| `Helloworld/` | Maven 入门 | Java 8 纯 Maven，HelloWorld 控制台输出示例 |
| `tlias-web-management/` | 员工管理系统 | Spring Boot 3.5.13 + MyBatis + MySQL 的部门管理后端 |

### Helloworld

与 `web-ai-project01/mevan-project01` 相同的入门示例：

```bash
cd Helloworld && mvn compile
```

### tlias-web-management — 员工（部门）管理系统

基于 Spring Boot 的部门管理后端（黑马程序员 tlias 课程项目雏形），提供部门列表查询、新增、修改、删除接口。

- **技术**：Java 21 + Spring Boot 3.5.13 + MyBatis + MySQL（tlias 数据库）+ Lombok
- **目录结构**：

```
tlias-web-management/
└── src/main/
    ├── java/com/itheima/
    │   ├── TliasWebManagementApplication.java   # 启动类
    │   ├── controller/DeptController.java       # 部门接口（/depts）
    │   ├── mapper/DeptMapper.java               # MyBatis Mapper
    │   ├── pojo/Dept.java                       # 部门实体
    │   ├── pojo/Result.java                     # 统一响应结果（code/msg/data）
    │   └── service/DeptService.java + impl/     # 业务层
    └── resources/application.yml               # 数据源与 MyBatis 配置
```

- **核心接口**：

| 方法 | 路径 | 说明 |
| --- | --- | --- |
| GET | `/depts` | 查询全部部门 |
| DELETE | `/depts?id=` | 按 ID 删除部门 |
| POST | `/depts` | 新增部门 |
| PUT | `/depts` | 修改部门 |

- **运行**：

```bash
# 1. 创建 MySQL 数据库 tlias 并初始化 dept 表
# 2. 确认 application.yml 数据库账号密码（默认 root / 123456）
mvn spring-boot:run
```

- **备注**：统一响应 `Result`（code=1 成功），MyBatis 开启驼峰映射与 SQL 日志输出；当前仅实现部门模块，员工模块待扩展。

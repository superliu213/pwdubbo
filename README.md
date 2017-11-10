# pwdubbo

## 项目介绍
本项目是一个通过maven工具管理，基于dubbo框架搭建的微服务实现，特点如下：
- 基于dubbo框架实现微服务，并进行了项目和服务划分
- 实现了基本的权限管理、日志管理和smartbi报表结合
- 基于 spring mvc 搭建整个平台，通过json传输前后台数据
- 通过独立的接口设计，实现前后端完全分离
- 通过nodejs，提供前端server，结合mock工具实现ajax拦截和数据模拟，得以实现前端完全脱离后台，实现完整展示功能，以适应快速迭代的敏捷开发和频繁的前端需求变化
- 通过maven工具管理项目，实现开发自测发布一体化管理
- ORM使用mybatis实现，灵活的实现持久化处理
- 自动生成代码功能，便于快速实现功能
- 使用Druid连接池，进行运行监控
- 统一的异常处理管理，实现异常处理代码解耦
- 完备的文档说明和问题帮助说明

## 目录结构说明

```
pw-api-user : 用户管理服务接口模块
pw-common : 公共项目模块
pw-common-config : 公共配置模块
pw-common-core : 公共核心代码模块
pw-common-web : 公共web模块
pw-service-user : 用户管理服务模块
pw-web-system : 用户管理系统
```

## 使用说明
> 本项目通过maven管理项目，提供必备的maven命令如下：
- 下载依赖
```
$ mvn install
```
- 打包
```
$ mvn package
```
- 清理target目录
```
$ mvn clean
```
> 本项目提供mysql版本数据库脚本，详见doc目录，运行项目前请配置数据库

> 配置请在公共配置模块进行配置，主要需要配置数据库和duboo注册地址（注册中心建议使用zookeeper）

> 通过应用服务器启动pw-service-user用户管理模块，完成提供者注册
![服务提供者](https://github.com/superliu213/resources/blob/master/images/pwdubbo/%E6%9C%8D%E5%8A%A1%E6%8F%90%E4%BE%9B%E8%80%85.png)

> 通过应用服务器启动用户管理系统，完成消费者注册
![服务消费者](https://github.com/superliu213/resources/blob/master/images/pwdubbo/%E6%9C%8D%E5%8A%A1%E6%B6%88%E8%B4%B9%E8%80%85.png)
如果使用eclipse开发，通过tomcat部署应用后，
手动打开url地址 http://localhost:8080/view/login.html
用户名admin 密码admin
（这里需要去除server部署的项目名）

## 界面（图片同pwssm）
![登录](https://github.com/superliu213/resources/blob/master/images/pwssm/%E7%99%BB%E5%BD%95.png)

![主页](https://github.com/superliu213/resources/blob/master/images/pwssm/%E4%B8%BB%E9%A1%B5.png)

![用户管理](https://github.com/superliu213/resources/blob/master/images/pwssm/%E7%94%A8%E6%88%B7%E7%AE%A1%E7%90%86.png)

![生成代码](https://github.com/superliu213/resources/blob/master/images/pwssm/%E7%94%9F%E6%88%90%E4%BB%A3%E7%A0%81.png)

## 调整思路（pwssm to pwdubbo）
### 统一规范
- 模块分为4类，公共(common)、接口(api)、服务(service)、应用，模块名规则：pw-模块类型/属性-命名
  eg:pw-api-user，模块类型是接口，使用api，因为是用户接口，所以使用user
- 模块下java包命名，以com开头，参照项目名定义包层级，随后根据业务功能进行划分，eg：pw-api-user，会定义包com.pw.api.user
- 资源统一放在resources模块下，公共配置提取到pw-common-config统一管理
- 需要通过应用服务器启动的模块，构建webapp目录，统一放置web资源

## 问答
> 模块之间的相互引用需要注意什么？
  - 模块是分三级：第一级，公共模块；第二级接口；第三级，服务和应用
  - 低级模块是为高级模块服务的，尽量不要低级模块引用高级模块
  - 服务和应用不建议相互引用，通过dubbo管理服务，应用可以调用服务，服务也可以调用服务
> 包扫描
  spring容器，springmvc容器，dubbo都可以进行包扫描，spring容器是父容器，扫描结果可以被子容器识别，反之子容器扫描信息父容器无法识别，
  先进行父容器扫描
> 为什么不单独分离出来日志服务，感觉耦合度高
  因为是demo，通过demo展示dubbo框架的整体设计与实现，部分业务解耦不彻底，独立事务，独立业务建议独立成单独服务
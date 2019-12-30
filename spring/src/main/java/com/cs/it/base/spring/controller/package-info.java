package com.cs.it.base.spring.controller;

/**
 *
 * Spring 基础
 *
 *  1.mvc设计模式  视图层、控制、模型
 *
 *  2.mvc 是一种软件架构思想
 *
 *  3.设计模式 重构代码  提高代码复用
 *
 *  4.什么是spring：是一个容器  把每个bean（实体类）与bean得关系 全部交给spring管理。这个容器就是spring  整个对象的生命周期交给spring管理
 *                spring的核心 是 ioc（控制反转）
 *                               di(依赖)
 *                               aop（面向切面编程）
 *                               di 与 ioc得区别   di 做注入的  ioc是创建对象
 *
 *  5.spring 可以整合很多框架
 *
 *  6.spring ioc 原理
 *    1） 解析xml配置 获取bean  class 地址
 *    2）使用java的反射机制 进行实例化对象
 *    3）返回对象
 *
 *  7.怎么证明 spring 是单例的还是多例的 ：通过无参构造函数  如果无参构造函数 只执行一遍 那么就是单例的  默认是单例的
 *
 *  8.因为是单例的 所以回发生线程安全问题
 *
 *  9.单例在哪里使用：spring 默认是单例的（线程不安全）（节约内存）
 *
 *  10.spring中beanId 重复了 会怎么样 ： 会报错
 *     分两种情况： 如果在xml文件中 beanId 是不允许重复的
 *                如果注解和xml 混合  beanId 一样 是不会报错的
 *
 *  11.spring生命周期：
 *     1).singleton 作用域 单例
 *     2).Prototype 多例 当调用  getbean方法 才会初始化
 *     3).request http请求request作用里面使用
 *     4).session http请求session作用里面使用
 *
 *  12.xml中bean中scope 设置成 prototype ===== 多例 当调用  getbean方法 才会初始化
 *
 *  13.springIoc：ioc 和 di 区别在哪里：ioc负责创建对象  /
 *                springIoc创建对象有哪些方式：
 *                1） 构造函数 ： 调用无参构造函数 、 带参函数构造器
 *                2） 工厂 ：  静态方法创建对象 、 非静态方法创建对象
 *                3） 注解
 *                di 是依赖注入  方式：
 *                1）构造函数
 *                2）set
 *                3）p 标签
 *
 * 14.springAop : cglib动态代理
 *
 *
 *
 * 代理设计模式 ： 静态代理
 *                动态代理 jdk动态代理    ：jdk使用反射
 *                        cglib 动态代理 ：asm
 *
 * 15.@Resource 和 @Autiwer  的区别是：
 *                               Resource 是spring框架自带 / 默认以名称查找
 *                               Autiwer 是jdk1.6之后才有的 /默认以类型查找
 *
 * 16.aop编程其实就是 让关注代码与业务代码分离   重复代码 就叫做关注点  关注点形成的类就叫做切面
 *
 **/


//~ Formatted by Jindent --- http://www.jindent.com

package com.itmayiedu;

/**
 *  spring  事务 与传播行为
 *
 *  什么是事务：就是一个执行单元。保证数据的一致性
 *  1.事务概述：1）原子性：不可分割的 不能拆分
 *             2）一致性：数据一致性
 *             3）隔离性：互不影响 在并发编程  有两个线程同时操作事务
 *             4）持久性：永久保存
 * 2.事务用法分类：1）编程事务
 *                2）声明事务：xml方式
 *                            注解方式
 *                   声明式事务  只有抛出异常的时候  才会回滚
 *                   事务是程序运行 如果没有错误  会自动提交事务  如果程序运行发生异常  则会自动回滚。如果使用了  try catch捕获异常时 一定要在catch里面手动回滚
 *                   事务手动回滚代码  TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
 *
 *
 *  4.注解事务：首先要先在xml文件里面添加开启事务注解xml    其次 ：  @Transactional(propagation = Propagation.REQUIRED)
 *
 *
 *  5.事务传播行为：七种传播行为
 *       1.REQUIRED   : 如果当前有事务，其他就用当前事务  如果没有事务 新增事务
 *       2.SUPPORTS   ：支持当前事务，如果当前没有事务，就以非事务方式执行
 *       3.MANDATORY  ：支持当前事务，如果当前没有事务，就抛出异常
 *       4.REQUIRES_NEW ： 如果当前有事务，不会加入当前事务，会增加新的事务
 *       5.NOT_SUPPORTED ： 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起
 *       6.NEVER ： 以非事务方式运行，如果当前存在事务，则抛出异常
 *       7.
 *
 *
 *
 *       @Transactional
 *       class LogService{
 *           public void addLog();----调用数据库 插入日志
 *       }
 *
 *       @Transactional
 *       class userService{
 *       private LogService logService;
 *           public void addServiceUser(){
 *               logService.addLog();
 *               addUser(); --- 插入用户信息
 *               int i = 1 / 0;
 *           }
 *       }
 *
 **/



package com.itmayiedu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.itmayiedu.dao.UserDao;
import com.itmayiedu.transaction.TransactionManager;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	// @Autowired
	// private TransactionManager transactionManager;
	@Autowired
	private LogService logService;

	// public void add() {
	// TransactionStatus transactionStatus = null;
	// try {
	// transactionStatus = transactionManager.begin();
	// userDao.addUser("zhangsan-" + System.currentTimeMillis(), 18);
	// System.out.println("UserService####张三插入成功!");
	//// int i = 1 / 0;// 是会发生运行异常.
	// userDao.addUser("lisi-" + System.currentTimeMillis(), 18);
	// System.out.println("UserService####李四插入成功!");
	// System.out.println("UserService####add方法执行完毕!");
	// transactionManager.commit(transactionStatus);
	// } catch (Exception e) {
	// // 可能会发生异常,进行回滚.
	// e.printStackTrace();
	// if(transactionManager!=null)
	// transactionManager.rollback(transactionStatus);
	// }
	// }
	// public void add() {
	// try {
	// userDao.addUser("lisi-" + System.currentTimeMillis(), 18);
	// System.out.println("UserService####李四插入成功!");
	// System.out.println("UserService####add方法执行完毕!");
	// int i = 1 / 0;// 是会发生运行异常.
	// userDao.addUser("zhangsan-" + System.currentTimeMillis(), 18);
	// System.out.println("UserService####张三插入成功!");
	// } catch (Exception e) {
	// System.out.println("数据已经被回滚");
	// // 手动回滚
	// TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	// }
	//
	// }
	// @Transactional(propagation = Propagation.REQUIRED)
	// public void add() {
	// try {
	// userDao.addUser("lisi-" + System.currentTimeMillis(), 18);
	// System.out.println("UserService####李四插入成功!");
	// System.out.println("UserService####add方法执行完毕!");
	// int i = 1 / 0;// 是会发生运行异常.
	// userDao.addUser("zhangsan-" + System.currentTimeMillis(), 18);
	// System.out.println("UserService####张三插入成功!");
	// } catch (Exception e) {
	// System.out.println("数据已经被回滚");
	// // 手动回滚
	// TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	// }
	//
	// }
	@Transactional(propagation = Propagation.REQUIRED)
	public void add() {
		logService.addLog();
		userDao.addUser("lisi-" + System.currentTimeMillis(), 18);
		int i = 1 / 0;
	}
}


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
	// System.out.println("UserService####��������ɹ�!");
	//// int i = 1 / 0;// �ǻᷢ�������쳣.
	// userDao.addUser("lisi-" + System.currentTimeMillis(), 18);
	// System.out.println("UserService####���Ĳ���ɹ�!");
	// System.out.println("UserService####add����ִ�����!");
	// transactionManager.commit(transactionStatus);
	// } catch (Exception e) {
	// // ���ܻᷢ���쳣,���лع�.
	// e.printStackTrace();
	// if(transactionManager!=null)
	// transactionManager.rollback(transactionStatus);
	// }
	// }
	// public void add() {
	// try {
	// userDao.addUser("lisi-" + System.currentTimeMillis(), 18);
	// System.out.println("UserService####���Ĳ���ɹ�!");
	// System.out.println("UserService####add����ִ�����!");
	// int i = 1 / 0;// �ǻᷢ�������쳣.
	// userDao.addUser("zhangsan-" + System.currentTimeMillis(), 18);
	// System.out.println("UserService####��������ɹ�!");
	// } catch (Exception e) {
	// System.out.println("�����Ѿ����ع�");
	// // �ֶ��ع�
	// TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	// }
	//
	// }
	// @Transactional(propagation = Propagation.REQUIRED)
	// public void add() {
	// try {
	// userDao.addUser("lisi-" + System.currentTimeMillis(), 18);
	// System.out.println("UserService####���Ĳ���ɹ�!");
	// System.out.println("UserService####add����ִ�����!");
	// int i = 1 / 0;// �ǻᷢ�������쳣.
	// userDao.addUser("zhangsan-" + System.currentTimeMillis(), 18);
	// System.out.println("UserService####��������ɹ�!");
	// } catch (Exception e) {
	// System.out.println("�����Ѿ����ع�");
	// // �ֶ��ع�
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

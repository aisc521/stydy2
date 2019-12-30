
package com.itmayiedu.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

@Component
public class TransactionManager {

	@Autowired
	private DataSourceTransactionManager dataSourceTransactionManager;

	/**
	 * 
	 * @methodDesc: ��������:(��������)
	 * @author: ��ʤ��
	 * @param:
	 * @createTime:2017��9��12�� ����9:46:48
	 * @returnType: void
	 * @copyright:�Ϻ�ÿ�ؽ����Ƽ����޹�˾
	 * @QQ:644064779
	 */
	public TransactionStatus begin() {
		// ��ȡ������״̬
		return dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
	}

	/**
	 * 
	 * @methodDesc: ��������:(�ύ����)
	 * @author: ��ʤ��
	 * @param:
	 * @createTime:2017��9��12�� ����9:48:24
	 * @returnType: void
	 * @copyright:�Ϻ�ÿ�ؽ����Ƽ����޹�˾
	 * @QQ:644064779
	 */
	public void commit(TransactionStatus transactionStatus) {
		dataSourceTransactionManager.commit(transactionStatus); // ���ݻ��ύ�����ݿ���...

	}

	/**
	 * 
	 * @methodDesc: ��������:(�����쳣,���ݿ�Ҫ�ع�)
	 * @author: ��ʤ��
	 * @param: @param
	 *             transactionStatus
	 * @createTime:2017��9��12�� ����9:49:32
	 * @returnType:@param transactionStatus void
	 * @copyright:�Ϻ�ÿ�ؽ����Ƽ����޹�˾
	 * @QQ:644064779
	 */
	public void rollback(TransactionStatus transactionStatus) {
		dataSourceTransactionManager.rollback(transactionStatus);
	}

}

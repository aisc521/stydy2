
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
	 * @methodDesc: 功能描述:(开启事物)
	 * @author: 余胜军
	 * @param:
	 * @createTime:2017年9月12日 下午9:46:48
	 * @returnType: void
	 * @copyright:上海每特教育科技有限公司
	 * @QQ:644064779
	 */
	public TransactionStatus begin() {
		// 获取到事物状态
		return dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
	}

	/**
	 * 
	 * @methodDesc: 功能描述:(提交事物)
	 * @author: 余胜军
	 * @param:
	 * @createTime:2017年9月12日 下午9:48:24
	 * @returnType: void
	 * @copyright:上海每特教育科技有限公司
	 * @QQ:644064779
	 */
	public void commit(TransactionStatus transactionStatus) {
		dataSourceTransactionManager.commit(transactionStatus); // 数据会提交到数据库中...

	}

	/**
	 * 
	 * @methodDesc: 功能描述:(发生异常,数据库要回滚)
	 * @author: 余胜军
	 * @param: @param
	 *             transactionStatus
	 * @createTime:2017年9月12日 下午9:49:32
	 * @returnType:@param transactionStatus void
	 * @copyright:上海每特教育科技有限公司
	 * @QQ:644064779
	 */
	public void rollback(TransactionStatus transactionStatus) {
		dataSourceTransactionManager.rollback(transactionStatus);
	}

}

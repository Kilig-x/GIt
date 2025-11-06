/**
 * Copyright (c) 2004-2011 Wang Jinbao(Julian Wong), http://www.ralasafe.com
 * Licensed under the MIT license: http://www.opensource.org/licenses/mit-license.php
 */
package org.ralasafe.demo;

public class Privilege {
	//------------ business privilege constants -------------
	 
    
	public static final int ROLE_ADMIN=-6;
	 
	     
	public static final int ASSIGN_ROLE_TO_USER=-5;
	 
	     
	/**
	  * Define policy, user category, business data and query.
	  */   
	public static final int POLICY_ADMIN=-4;
	 
	     
	public static final int LOAN=4;
	 
	     
	public static final int QUERY_LOAN=5;
	 
	 
	//------------ non role privilege constants -------------
	 
	     
	

	
	/**
	  * 运营数据
	  */   
	public static final int YUNYING_DATA=5;
	 
	     
	/**
	  * 客服功能
	  */   
	public static final int CUSTOMER=6;
	 
	     
	/**
	  * 渠道功能
	  */   
	public static final int PUBLISHER=7;

	/**
	  * 员工查询
	  */   
	public static final int QUERY_EMPLOYEE=2;
	/**
	  * 公司查询
	  */   
	public static final int QUERY_COMPANY=11;
	/**
	  * 部门查询
	  */   
	public static final int QUERY_DEPARTMENT=12; 
	/**
	  * 开放运营数据
	  */   
	public static final int OPEN_YUNYING_DATA=13;
	/**
	 * 测试
	 */
	public static final int TEST=14;
	
	public static final int OPEN_LINK_DATA=15;

	public static final int SERVER_MANAGER=16;
	/**
	 * 运营配置
	 */
	public static final int YUNYING_CONFIG=17;
}

package org.springcloud.service.governing.entity.request;

/**
* @Description:    java类作用描述
* @Author:         刘涛
* @CreateDate:     2019/4/22 18:17
*/
public class BaseParamEntity {
	protected String token;

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "token:" + token;
	}

}

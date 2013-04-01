/**    
* @Title: PasswordEncrypt.java  
* @Description: TODO 
* @author Strong 
* @date 2013-3-11 下午5:40:01  
* @version V1.0    
*/
package cn.tbj.test.utils;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

import cn.tbj.security.utils.Digests;
import cn.tbj.utils.Encodes;


/**  
 * @Description: TODO 
 * @author Strong
 * @date 2013-3-11 下午5:40:01    
 */
public class PasswordEncrypt {

	private static final int INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;
	private static final String ALGORITHM = "SHA-1";
	
	
	/**  
	 * @Title: 测试盐值加密  
	 * @Description: TODO 
	 * @param @param args     
	 * @return void   
	 * @throws  
	 */
	public static void main(String[] args) {
		
		PasswordEncrypt passwordEncrypt = new PasswordEncrypt();
		passwordEncrypt.encrypt("cbe5c339a2beb940bddd43f30486473fac2e0658");
		

	}
	
	
	public static class HashPassword {
		public String salt;
		public String password;
	}
	
	public HashPassword encrypt(String plainText) {
		HashPassword result = new HashPassword();
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		result.salt = Encodes.encodeHex(salt);

		byte[] hashPassword = Digests.sha1(plainText.getBytes(), salt, INTERATIONS);
		result.password = Encodes.encodeHex(hashPassword);
		
		
		byte[] salt_ = Encodes.decodeHex(result.salt);
		
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(ALGORITHM);
		matcher.setHashIterations(INTERATIONS);
		
		
		return result;

	}

}

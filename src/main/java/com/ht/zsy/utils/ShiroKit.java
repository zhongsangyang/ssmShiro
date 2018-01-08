package com.ht.zsy.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class ShiroKit {
	 public static String md5Pwd(String password, String salt) {  
		    // TODO Auto-generated method stub  
		    String md5Pwd = new Md5Hash(password, salt).toHex();  
		    return md5Pwd;  
		}  

}

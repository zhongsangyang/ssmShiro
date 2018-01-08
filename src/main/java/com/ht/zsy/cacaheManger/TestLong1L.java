package com.ht.zsy.cacaheManger;

public class TestLong1L {
	public static void main(String[] args) {
		int i=1;
		Long j=1l;
		if(i==j){
			System.out.println("你们是相等的");
		}else if(j>i){
			System.out.println("长整型更大");
		}else {
			System.out.println("长整型更小");
		}
	}
}

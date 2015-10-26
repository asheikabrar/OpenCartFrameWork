package com.opencart;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

import com.opencart.data.GlobalParametersFile;
import com.opencart.data.HomePageProperties;
import com.opencart.database.SqlConnect;
import com.opencart.testcases.BaseTest;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			SqlConnect sqc = new SqlConnect();
		
			sqc.connect("select * from registration");
		
/*			GlobalParametersFile gp = new GlobalParametersFile();
			
			gp.createGlobalProperties();
			HomePageProperties hp = new HomePageProperties();
			
		
			BaseTest bt = new BaseTest();
			
			bt.Initialise();*/
	}

}

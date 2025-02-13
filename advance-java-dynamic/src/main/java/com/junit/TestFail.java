package com.junit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestFail {

	@Test
	public void testAdd() throws Exception {

		UserBean bean = new UserBean();
		bean.setId(17);
		bean.setName("ajay");
		bean.setSalary(6000);

		UserModel.add(bean);
		bean = UserModel.findByPk(19);

		if (bean == null) {
			//assertTrue("ok", bean!=null);
			fail("Record is not added...!!!");
			
		} else {
			System.out.println("record is added..!!!");
		}

	}

}
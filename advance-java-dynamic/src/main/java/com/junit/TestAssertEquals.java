package com.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestAssertEquals {

	@Test
	public void update() throws Exception {

		UserBean bean = UserModel.findByPk(1);

		bean.setName("kapil");

		UserModel.update(bean);

		bean = UserModel.findByPk(1);

		assertEquals("kapil", bean.getName());

	}

}
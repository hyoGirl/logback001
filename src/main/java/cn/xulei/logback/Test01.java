package cn.xulei.logback;

import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test01 {

	final static Logger logger = LoggerFactory.getLogger(Test01.class);

	public static void main(String[] args) throws InterruptedException {

		logger.debug("现在的时间是 {}", new Date().toString());

		logger.info(" This time is {}", new Date().toString());

		logger.warn(" This time is {}", new Date().toString());

		logger.error(" This time is {}", new Date().toString());

		Thread.sleep(10000);
	}

	@Test
	public void test() throws InterruptedException {
		Test01 obj = new Test01();
		try {
			obj.divide();
		} catch (ArithmeticException ex) {
			logger.error("大家好111!", ex);
		}
		Thread.sleep(10000);
		System.out.println("=========================");
		System.out.println("+++++++++++++++++++++++++++++++");
	}

	private void divide() {
		int i = 10 / 0;
		// Thread.sleep(10000);
	}

}

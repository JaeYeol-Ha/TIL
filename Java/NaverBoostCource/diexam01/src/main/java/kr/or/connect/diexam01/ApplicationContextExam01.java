package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("초기화완료!");
		
		UserBean userBean = (UserBean) ac.getBean("userBean");
		userBean.setName("kang");
		System.out.println(userBean.getName());
		
		UserBean userBean2 = (UserBean)ac.getBean("userBean");
		userBean2.setName("kim");
		System.out.println(userBean.getName());
		System.out.println(userBean2.getName());  // 싱글톤패턴

		if(userBean == userBean2)
			System.out.println("같은 인스턴스입니다.");
	}
}

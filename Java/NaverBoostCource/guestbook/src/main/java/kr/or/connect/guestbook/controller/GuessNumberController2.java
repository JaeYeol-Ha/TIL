//package kr.or.connect.guestbook.controller;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//public class GuessNumberController2 {
//	@GetMapping("/guess2")
//	public String guess(@RequestParam(name="number", required=false) Integer number,
//			HttpSession session,
//			ModelMap model) {
//		
//		String message = null;
//		
//		if(number ==null ) {
//			session.setAttribute("count", 0);
//			session.setAttribute("randomNumber", (int)(Math.random() * 100) + 1 );
//			message = "내가 생각한 숫자를 맞춰보세요";
//		}else {
//			int count = (Integer)session.getAttribute("count");
//			int random
//		}
//		
//	}
//}

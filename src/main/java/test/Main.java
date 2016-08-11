//package test;
//import java.util.HashMap;
//import java.util.Map;
//
//import com.nc.emailintegration.EmailSender;
//
//public class Main {
//	public static void main(String[] args) {
//		EmailSender emailSender = new EmailSender("http://nodetest:8000/testemail", "123456");
//		Map<String, Object> params = new HashMap<>();
//		params.put("templateName", "bulkOrderCustomerEmail");
//		params.put("toEmail", "bulkOrderCustomerEmail@email.com");
//		for (int i = 0; i < 100; i++) {
//			emailSender.send(1, params);
//		}
//	}
//}

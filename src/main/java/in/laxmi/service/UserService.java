package in.laxmi.service;

import in.laxmi.dao.UserDao;

public class UserService {
private UserDao dao;
public UserService() {
	
}
public UserService(UserDao dao) {
	this.dao=dao;
}

public String getNameByUserId(Integer id) {
	String name=dao.findNameById(id);
	return name;
}
public String getEmailByUserId(Integer id) {
	String email=dao.findEmailById(id);
	return email;
}
public void doProcess() {
	System.out.println("doProcess() method started");
    pushMsgToKafkaTopic();
    System.out.println("doProcess() ENDED");
}
public void pushMsgToKafkaTopic() {
	System.out.println("msg pushing to kafka..");
}
public String doWork(String msg) {
	String formattedMsg=formatMsg(msg);
	return formattedMsg;
}
private String formatMsg(String msg) {
	return msg.toUpperCase();
}

}

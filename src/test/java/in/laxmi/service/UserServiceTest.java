package in.laxmi.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import in.laxmi.dao.UserDao;

public class UserServiceTest {
	@Test
	public void testGetNameByUserId() {
		UserDao mockDao = PowerMockito.mock(UserDao.class);
		PowerMockito.when(mockDao.findNameById(101)).thenReturn("nick");
		UserService service = new UserService(mockDao);
		String name = service.getNameByUserId(101);
		assertEquals("nick", name);

	}
	@Test
	public void testGetEmailByUserId() {
		UserDao mockDao = PowerMockito.mock(UserDao.class);
		PowerMockito.when(mockDao.findEmailById(101)).thenReturn("jhon@gmail.com");
		UserService service = new UserService(mockDao);
		String email = service.getEmailByUserId(101);
		assertEquals("jhon@gmail.com", email);

	}
	@Test
	public void testDoProcess() {
		UserService service = new UserService();
		try {
			PowerMockito.doNothing().when(service, "pushMsgToKafkaTopic",anyString());
		service.doProcess();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void testDoWorkWithPrivateMethodMock() throws Exception{
		UserService service = new UserService();
		UserService spy = PowerMockito.spy(service);
		PowerMockito.doReturn("TEST MSG").when(spy, "formatMsg","test msg");
		String formattedMsg = service.doWork("test msg");
		assertEquals("TEST MSG", formattedMsg);
	}
}

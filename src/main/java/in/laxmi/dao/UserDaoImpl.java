package in.laxmi.dao;

public class UserDaoImpl implements UserDao {

	public String findNameById(Integer id) {
		System.out.println("findNameById() called");
		return "JHON";
	}

	public String findEmailById(Integer id) {
		System.out.println("findEmailById() called");
		return "Jhon@gmail.com";
	}

}

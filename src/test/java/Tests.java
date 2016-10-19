import org.junit.Test;

import dao.NetworkingDeviceDao;

public class Tests {

	@Test
	public void testUniqueIds() {
		assert NetworkingDeviceDao.getInstance().getNextId() == NetworkingDeviceDao.getInstance().getNextId()-1;
	}

}

package kr.or.ddit.widu.dao.profile;

import java.rmi.RemoteException;
import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.widu.util.SqlMapClientFactory;

public class ProfileDaoImpl implements IProfileDao{

	private static IProfileDao dao;
	private SqlMapClient smc;
	
	private  ProfileDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IProfileDao getInstance() {
		if(dao == null) {
			dao = new ProfileDaoImpl();
		}
		return dao;
	}
	
	
	@Override
	public int countMyLike(String mem_id) throws RemoteException {
		int cnt = 0;
		
		try {
			cnt = (int) smc.queryForObject("profile.countMyLike",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int countMyHate(String mem_id) throws RemoteException {
		int cnt = 0;
		
		try {
			cnt = (int) smc.queryForObject("profile.countMyHate",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

}

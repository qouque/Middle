package kr.or.ddit.widu.service.profile;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import kr.or.ddit.widu.dao.profile.IProfileDao;
import kr.or.ddit.widu.dao.profile.ProfileDaoImpl;

public class ProfileServiceImpl extends UnicastRemoteObject implements IProfileService{

	private IProfileDao dao;
	private static IProfileService service;
	
	protected ProfileServiceImpl() throws RemoteException {
		super();
		dao = ProfileDaoImpl.getInstance();
	}
	
	public static IProfileService getInstance() throws RemoteException {
		if(service == null) {
			service = new ProfileServiceImpl();
		}
		return service;
	}
	
	@Override
	public int countMyLike(String mem_id) throws RemoteException {
		return dao.countMyLike(mem_id);
	}

	@Override
	public int countMyHate(String mem_id) throws RemoteException {
		return dao.countMyHate(mem_id);
	}

}

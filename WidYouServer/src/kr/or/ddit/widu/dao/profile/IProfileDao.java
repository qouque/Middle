package kr.or.ddit.widu.dao.profile;

import java.rmi.RemoteException;

public interface IProfileDao {

	/**
	 * 내가 받은 좋아요수를 리턴 해주는 메소드
	 * @param mem_id
	 * @return 내가 받은 좋아요수
	 * @throws RemoteException
	 */
	public int countMyLike(String mem_id) throws RemoteException;
	
	/**
	 * 내가받은 싫어요수를 리턴 해주는 메소드
	 * @param mem_id
	 * @return 내가받은 싫어요 수
	 * @throws RemoteException
	 */
	public int countMyHate(String mem_id) throws RemoteException;
}

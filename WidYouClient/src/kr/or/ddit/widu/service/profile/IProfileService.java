package kr.or.ddit.widu.service.profile;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 프로필 관련 된 소스들이 모여있는 인터페이스
 * @author lhu
 *
 */
public interface IProfileService extends Remote{
	
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

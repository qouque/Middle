package kr.or.ddit.widu.dao.shop;

import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.widu.vo.shop.Shop_ItemVO;

public interface IShopDao {
	
	
	/**
	 * DB에 있는 아이템 데이터를 불러오는 메소드
	 * @return Shop_ItemVO에 있는 모든 데이터
	 */
	public List<Shop_ItemVO> selectAllItems();
	
	public int insertItem(Shop_ItemVO itemInfo);

}

package kr.or.ddit.widu.service.shop;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.widu.dao.shop.IShopDao;
import kr.or.ddit.widu.dao.shop.ShopDao;
import kr.or.ddit.widu.vo.shop.Shop_ItemVO;

public class ShopService extends UnicastRemoteObject implements IShopService {
	
	private static ShopService instance;
	private IShopDao dao;
	
	private ShopService() throws RemoteException {
		dao = ShopDao.getInstance();
	}
	
	public static IShopService getInstance() throws RemoteException {
		return (instance == null) ? instance = new ShopService() : instance;
	}

	@Override
	public List<Shop_ItemVO> selectAllItems() throws RemoteException {
		return dao.selectAllItems();
	}

	@Override
	public int insertItem(Shop_ItemVO itemInfo) throws RemoteException {
		return dao.insertItem(itemInfo);
	}

}

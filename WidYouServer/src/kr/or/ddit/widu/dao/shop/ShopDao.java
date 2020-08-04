package kr.or.ddit.widu.dao.shop;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import kr.or.ddit.widu.vo.shop.Shop_ItemVO;

public class ShopDao implements IShopDao{

	private SqlMapClient smc;
	private static IShopDao shop;
	
	public static IShopDao getInstance() {
		if(shop == null) {
			shop = new ShopDao();
		}
		
		return shop;
	}
	
	private ShopDao() {
		Reader rd;
		try {
			Charset charset = Charset.forName("UTF-8"); // 설정파일의 인코딩 설정
			
			Resources.setCharset(charset);
			rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			// 1-2. 위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 객체 생성
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close(); // Reader객체 닫기
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<Shop_ItemVO> selectAllItems() {
		List<Shop_ItemVO> list = null;
		
		try {
			list = smc.queryForList("shop.selectAllItems");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insertItem(Shop_ItemVO itemInfo) {
		int chk = 0;
		try {
			Object obj = smc.insert("shop.insertItem", itemInfo);
			if (obj == null) {
				chk = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chk;
	}

}

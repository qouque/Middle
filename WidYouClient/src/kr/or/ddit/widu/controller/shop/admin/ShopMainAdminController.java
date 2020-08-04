package kr.or.ddit.widu.controller.shop.admin;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import kr.or.ddit.widu.main.LoginSession;
import kr.or.ddit.widu.service.shop.IShopService;
import kr.or.ddit.widu.store.Store;
import kr.or.ddit.widu.vo.board.BoardVO;
import kr.or.ddit.widu.vo.shop.Shop_ItemVO;
import kr.or.ddit.widu.vo.shop.Shop_RubbyVO;

public class ShopMainAdminController implements Initializable{
	
	public TabPane tab_pane;
	public Tab shop_item;
	public TableView<Shop_ItemVO> item_tableview;
	public TableColumn<Shop_ItemVO, Integer> item_num;
	public TableColumn<Shop_ItemVO, String> item_productname;
	public TableColumn<Shop_ItemVO,String> item_productcontent;
	public TableColumn<Shop_ItemVO,Integer> item_rubyprice;
	public Tab shop_ruby;
	public TableView<Shop_RubbyVO> ruby_tableview;
	public TableColumn<Shop_RubbyVO, Integer> ruby_num;
	public TableColumn<Shop_RubbyVO, String> ruby_productname;
	public TableColumn<Shop_RubbyVO, Integer> ruby_rubycount;
	public TableColumn<Shop_RubbyVO, Integer> ruby_rubyprice;	
	public ComboBox<String> shop_combobox;
	public JFXTextField shop_content_input;
	public JFXButton shop_select;
	public JFXButton shop_add;
	public JFXButton shop_modify;
	public JFXButton shop_delete;
	
	
	
	private IShopService service;
	private Registry reg;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			reg = LocateRegistry.getRegistry("localhost",8413);
			
			service = (IShopService) reg.lookup("shopService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		
		
		item_num.setCellValueFactory(new PropertyValueFactory<>("shop_id"));
		item_productname.setCellValueFactory(new PropertyValueFactory<>("shop_name"));
		item_productcontent.setCellValueFactory(new PropertyValueFactory<>("shop_detail"));
		item_rubyprice.setCellValueFactory(new PropertyValueFactory<>("shop_price"));
		List<Shop_ItemVO> list = null;
		try {
			list = service.selectAllItems();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ObservableList<Shop_ItemVO> obblist = FXCollections.observableArrayList(list);
		
		item_tableview.setItems(obblist);
		
		
		
		// 추가 버튼 이벤트
		shop_add.setOnAction(event -> {
			Store.newWindow_Modal(getClass().getResource("/kr/or/ddit/widu/view/shop/admin/itemadd.fxml"), "추가", null);
		});
	}
	
	

}

package servlets;

import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.service.ServiceInfo;



import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class CloudConnection {
	private DataSource ds;
	Cloud cloud;
	public CloudConnection() {
		try {
		CloudFactory cloudFactory = new CloudFactory();
		this.cloud = cloudFactory.getCloud();
		String serviceID = "pg1";
		
		this.ds = cloud.getServiceConnector(serviceID, DataSource.class,
		                                            null /* default config */);
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public List<ServiceInfo> getinfo(){
		List<ServiceInfo>info= cloud.getServiceInfos();
//		for(int i=0; i<info.size();i++) {
//			out.println(info.get(i).toString());
//		}
		return info;
	}
	
	public List<ServiceInfo> getdatabaseinfo(){
		List<ServiceInfo>info= cloud.getServiceInfos(DataSource.class);
//		for(int i=0; i<info.size();i++) {
//			System.out.println(info.get(i).toString());
//		}
		return info;
	}
	
	public  Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
//	public static void main(String[] args) {
//		CloudConnection con= new CloudConnection();
//		con.getinfo();
//		con.getdatabaseinfo();
//	}
}

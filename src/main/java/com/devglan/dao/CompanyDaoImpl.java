package com.devglan.dao;
/*package com.example.stockspring.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.stockspring.model.Company;

@Repository
public class CompanyDaoImpl implements CompanyDao{

	public static Connection connect() throws Exception {
		Connection conn = null;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stockproject", "root", "root");

		return conn;

	}
	public int insert(Company c) throws Exception {

		Connection conn = connect();
		System.out.println(c);
		String insertQuery = "insert into company(company_code,company_Name,turnover,ceo,boardofdirectors,breifwriteup,stock_code) values (?,?,?,?,?,?,?)";
       
		PreparedStatement pstmt = conn.prepareStatement(insertQuery);
		pstmt.setInt(1, c.getCompanyCode());

		pstmt.setString(2, c.getCompanyName());
		pstmt.setDouble(3, c.getTurnOver());
		pstmt.setString(4, c.getCeoName() );
		pstmt.setString(5, c.getDirectorsName());
		pstmt.setString(6, c.getBriefWriteUp());
		pstmt.setInt(7, c.getStockCode());
		
		int insertstatus = 0;
		insertstatus = pstmt.executeUpdate();
		System.out.println(insertstatus);
		return insertstatus;

	}
	public List<Company> getCompanyList() throws Exception {
		Connection conn = connect();
		List<Company> companyList = new ArrayList<Company>();
		String read = "select company_code,company_Name,ceo,turnover from company";
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(read);

		while (rs.next()) {
			Company company = new Company();

			company.setCompanyCode(rs.getInt(1));
			company.setCompanyName(rs.getString(2));
			company.setCeoName(rs.getString(3));
			company.setTurnOver(rs.getDouble(4));
			companyList.add(company);
		}

		return companyList;
	}
	public int updateCompanyList(Company company) throws Exception{
		Connection conn=connect();
		String updateQuery="update company set coe=? where company_Name=?";
		PreparedStatement preparedStatement=conn.prepareStatement(updateQuery);
	
		preparedStatement.setString(2, company.getCompanyName());
		preparedStatement.setString(1,company.getCeoName());
		int updatestatus=0;
		updatestatus =preparedStatement.executeUpdate();
		
		return updatestatus;
		
		
	}
	

}
*/
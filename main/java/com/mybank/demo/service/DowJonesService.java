package com.mybank.demo.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mybank.demo.config.DowJonesDbConfig;
import com.mybank.demo.dto.DowJonesData;

@Service
public class DowJonesService {
	
	public DowJonesService(){
		
	}
	
	public List<DowJonesData> getDataByTicker(String client, String ticker) {
		String sql = "select * from DOW_JONES_IDX where client = ? and stock = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection dbConn = null;
		List<DowJonesData> list = new ArrayList<DowJonesData>();
		try {
			dbConn = DowJonesDbConfig.getConnection();
			System.out.println("dbConn "+dbConn);
			pstmt = dbConn.prepareStatement(sql);
			pstmt.setString(1, client);
			pstmt.setString(2, ticker);
			System.out.println("statment "+pstmt);
			rs = pstmt.executeQuery();
			System.out.println("rs "+rs);
			while(rs.next()){
				DowJonesData data = new DowJonesData();
				data.setClient(rs.getString("client"));
				data.setQtr(rs.getInt("qtr"));
				data.setStock(rs.getString("stock"));
				data.setIdate(rs.getString("idate"));
				data.setOpen(rs.getBigDecimal("open"));
				data.setHigh(rs.getBigDecimal("high"));
				data.setLow(rs.getBigDecimal("low"));
				data.setClose(rs.getBigDecimal("close"));
				data.setVolume(rs.getInt("volume"));
				data.setPct_chg_price(rs.getBigDecimal("pct_chg_price"));
				data.setPct_chg_vol_over_lst_wk(rs.getBigDecimal("pct_chg_vol_over_lst_wk"));
				data.setPrv_wks_vol(rs.getInt("prv_wks_vol"));
				data.setNxt_wks_open(rs.getBigDecimal("nxt_wks_open"));
				data.setNxt_wks_close(rs.getBigDecimal("nxt_wks_close"));
				data.setPct_chg_nxt_wk_price(rs.getBigDecimal("pct_chg_nxt_wk_price"));
				data.setDays_to_nxt_div(rs.getInt("days_to_nxt_div"));
				data.setPct_rtn_nxt_div(rs.getBigDecimal("pct_rtn_nxt_div"));
				list.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (dbConn != null) {
				try {
					dbConn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	
	public void saveBulk(List<DowJonesData> dataList){
		//implement logic to save data to db
		String sql = "insert into DOW_JONES_IDX values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		Connection dbConn = null;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		try {
			dbConn = DowJonesDbConfig.getConnection();
			System.out.println("dbConn "+dbConn);
			pstmt = dbConn.prepareStatement(sql);
			System.out.println("statment "+pstmt);
			
			
			for(DowJonesData data : dataList){
				pstmt.setString(1, data.getClient());
				pstmt.setInt(2, data.getQtr());
				pstmt.setString(3, data.getStock());
				pstmt.setDate(4, new java.sql.Date(sdf.parse(data.getIdate()).getTime()));
				pstmt.setBigDecimal(5, data.getOpen());
				pstmt.setBigDecimal(6, data.getHigh());
				pstmt.setBigDecimal(7, data.getLow());
				pstmt.setBigDecimal(8, data.getClose());
				pstmt.setInt(9, data.getVolume());
				pstmt.setBigDecimal(10, data.getPct_chg_price());
				pstmt.setBigDecimal(11, data.getPct_chg_vol_over_lst_wk());
				pstmt.setInt(12, data.getPrv_wks_vol());
				pstmt.setBigDecimal(13, data.getNxt_wks_open());
				pstmt.setBigDecimal(14, data.getNxt_wks_close());
				pstmt.setBigDecimal(15, data.getPct_chg_nxt_wk_price());
				pstmt.setInt(16, data.getDays_to_nxt_div());
				pstmt.setBigDecimal(17, data.getPct_rtn_nxt_div());
				pstmt.addBatch();
			}
			int [] res = pstmt.executeBatch();
			System.out.println(res);
		}
		catch(Exception e){
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (dbConn != null) {
				try {
					dbConn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	
}

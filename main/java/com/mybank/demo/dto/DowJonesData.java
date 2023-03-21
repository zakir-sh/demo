package com.mybank.demo.dto;

import java.math.BigDecimal;


//import lombok.Data;
//import lombok.ToString;

//@Data
public class DowJonesData{

	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public int getQtr() {
		return qtr;
	}
	public void setQtr(int qtr) {
		this.qtr = qtr;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getIdate() {
		return idate;
	}
	public void setIdate(String idate) {
		this.idate = idate;
	}
	public BigDecimal getOpen() {
		return open;
	}
	public void setOpen(BigDecimal open) {
		this.open = open;
	}
	public BigDecimal getHigh() {
		return high;
	}
	public void setHigh(BigDecimal high) {
		this.high = high;
	}
	public BigDecimal getLow() {
		return low;
	}
	public void setLow(BigDecimal low) {
		this.low = low;
	}
	public BigDecimal getClose() {
		return close;
	}
	public void setClose(BigDecimal close) {
		this.close = close;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public BigDecimal getPct_chg_price() {
		return pct_chg_price;
	}
	public void setPct_chg_price(BigDecimal pct_chg_price) {
		this.pct_chg_price = pct_chg_price;
	}
	public BigDecimal getPct_chg_vol_over_lst_wk() {
		return pct_chg_vol_over_lst_wk;
	}
	public void setPct_chg_vol_over_lst_wk(BigDecimal pct_chg_vol_over_lst_wk) {
		this.pct_chg_vol_over_lst_wk = pct_chg_vol_over_lst_wk;
	}
	public int getPrv_wks_vol() {
		return prv_wks_vol;
	}
	public void setPrv_wks_vol(int prv_wks_vol) {
		this.prv_wks_vol = prv_wks_vol;
	}
	public BigDecimal getNxt_wks_open() {
		return nxt_wks_open;
	}
	public void setNxt_wks_open(BigDecimal nxt_wks_open) {
		this.nxt_wks_open = nxt_wks_open;
	}
	public BigDecimal getNxt_wks_close() {
		return nxt_wks_close;
	}
	public void setNxt_wks_close(BigDecimal nxt_wks_close) {
		this.nxt_wks_close = nxt_wks_close;
	}
	public BigDecimal getPct_chg_nxt_wk_price() {
		return pct_chg_nxt_wk_price;
	}
	public void setPct_chg_nxt_wk_price(BigDecimal pct_chg_nxt_wk_price) {
		this.pct_chg_nxt_wk_price = pct_chg_nxt_wk_price;
	}
	public int getDays_to_nxt_div() {
		return days_to_nxt_div;
	}
	public void setDays_to_nxt_div(int days_to_nxt_div) {
		this.days_to_nxt_div = days_to_nxt_div;
	}
	public BigDecimal getPct_rtn_nxt_div() {
		return pct_rtn_nxt_div;
	}
	public void setPct_rtn_nxt_div(BigDecimal pct_rtn_nxt_div) {
		this.pct_rtn_nxt_div = pct_rtn_nxt_div;
	}
	private String client;
    private int qtr;
    private String stock;
    private String idate;
    private BigDecimal open;
    private BigDecimal high; 
    private BigDecimal low;  
    private BigDecimal close;
    private int volume;
    private BigDecimal pct_chg_price; 
    private BigDecimal pct_chg_vol_over_lst_wk;
    private int prv_wks_vol;
    private BigDecimal nxt_wks_open; 
    private BigDecimal nxt_wks_close;
    private BigDecimal pct_chg_nxt_wk_price;
    private int days_to_nxt_div;
    private BigDecimal pct_rtn_nxt_div;
    
    public DowJonesData(){
    	
    }
	public DowJonesData(String client, int qtr, String stock, String idate,
			BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close,
			int volume, BigDecimal pct_chg_price,
			BigDecimal pct_chg_vol_over_lst_wk, int prv_wks_vol,
			BigDecimal nxt_wks_open, BigDecimal nxt_wks_close,
			BigDecimal pct_chg_nxt_wk_price, int days_to_nxt_div,
			BigDecimal pct_rtn_nxt_div) {

		this.client = client;
		this.qtr = qtr;
		this.stock = stock;
		this.idate = idate;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.pct_chg_price = pct_chg_price;
		this.pct_chg_vol_over_lst_wk = pct_chg_vol_over_lst_wk;
		this.prv_wks_vol = prv_wks_vol;
		this.nxt_wks_open = nxt_wks_open;
		this.nxt_wks_close = nxt_wks_close;
		this.pct_chg_nxt_wk_price = pct_chg_nxt_wk_price;
		this.days_to_nxt_div = days_to_nxt_div;
		this.pct_rtn_nxt_div = pct_rtn_nxt_div;
	}    

	@Override
	public String toString(){

		return client + ":" + qtr + ":" + stock + ":" + idate + ":" + open
				+ ":" + high + ":" + low + ":" + close + ":" + volume + ":"
				+ pct_chg_price + ":" + pct_chg_vol_over_lst_wk + ":"
				+ prv_wks_vol + ":" + nxt_wks_open + ":" + nxt_wks_close + ":"
				+ pct_chg_nxt_wk_price + ":" + days_to_nxt_div + ":"
				+ pct_rtn_nxt_div;
	
	}
	
}

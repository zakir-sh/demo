create table DOW_JONES_IDX (
    client varchar(32),
    qtr int,
    stock varchar (16),
    idate date,
    open numeric (10,2),
    high numeric (10,2),
    low  numeric (10,2),
    close numeric (10,2),
    volume int,
    pct_chg_price numeric (10,8),
    pct_chg_vol_over_lst_wk numeric (12,8),
    prv_wks_vol int,
    nxt_wks_open numeric (10,2), 
    nxt_wks_close numeric (10,2),
    pct_chg_nxt_wk_price numeric (12,8),
    days_to_nxt_div int,
    pct_rtn_nxt_div numeric (10,2)
);
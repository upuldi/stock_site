package com.site.action.ajax;

import com.dao.ChartDataDaoHibernate;
import com.dao.MarketSummeryDao;
import com.domain.ChartData;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: udoluweera
 * Date: 11/11/12
 * Time: 12:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class AJAXHtml5ChartData extends ActionSupport implements ModelDriven<ChartData> {

    private List<ChartData> dateList = null;

    private List<ChartData> ASIdateList = null;
    private List<ChartData> MPIdateList = null;
    private List<ChartData> SNP20dateList = null;

    private List<ChartData> BFIdateList = null;
    private List<ChartData> BFTdateList = null;
    private List<ChartData> CNPdateList = null;
    private List<ChartData> CNEdateList = null;
    private List<ChartData> DIVdateList = null;

    private List<ChartData> FNTdateList = null;
    private List<ChartData> HLTdateList = null;
    private List<ChartData> HNTdateList = null;
    private List<ChartData> INVdateList = null;
    private List<ChartData> ITdateList = null;

    private List<ChartData> LNPdateList = null;
    private List<ChartData> MFGdateList = null;
    private List<ChartData> MTRdateList = null;
    private List<ChartData> PLTdateList = null;
    private List<ChartData> PNEdateList = null;

    private List<ChartData> SRVdateList = null;
    private List<ChartData> SNSdateList = null;
    private List<ChartData> TLEdateList = null;
    private List<ChartData> TRDdateList = null;


    private ChartData chartData;
    private MarketSummeryDao marketSummeryDao;
    private ChartDataDaoHibernate chartDataDaoHibernate;

    public void setChartDataDaoHibernate(ChartDataDaoHibernate chartDataDaoHibernate) {
        this.chartDataDaoHibernate = chartDataDaoHibernate;
    }

    public void setChartData(ChartData chartData) {
        this.chartData = chartData;
    }

    public void setMarketSummeryDao(MarketSummeryDao marketSummeryDao) {
        this.marketSummeryDao = marketSummeryDao;
    }

    @Override
    public ChartData getModel() {
        return chartData;
    }

    public List<ChartData> getASIdateList() {
        return ASIdateList;
    }

    public List<ChartData> getMPIdateList() {
        return MPIdateList;
    }

    public List<ChartData> getSNP20dateList() {
        return SNP20dateList;
    }

    public List<ChartData> getBFIdateList() {
        return BFIdateList;
    }

    public List<ChartData> getBFTdateList() {
        return BFTdateList;
    }

    public List<ChartData> getCNEdateList() {
        return CNEdateList;
    }

    public List<ChartData> getCNPdateList() {
        return CNPdateList;
    }

    public List<ChartData> getDIVdateList() {
        return DIVdateList;
    }

    public List<ChartData> getFNTdateList() {
        return FNTdateList;
    }

    public List<ChartData> getHLTdateList() {
        return HLTdateList;
    }

    public List<ChartData> getHNTdateList() {
        return HNTdateList;
    }

    public List<ChartData> getINVdateList() {
        return INVdateList;
    }

    public List<ChartData> getITdateList() {
        return ITdateList;
    }

    public List<ChartData> getLNPdateList() {
        return LNPdateList;
    }

    public List<ChartData> getMFGdateList() {
        return MFGdateList;
    }

    public List<ChartData> getMTRdateList() {
        return MTRdateList;
    }

    public List<ChartData> getPLTdateList() {
        return PLTdateList;
    }

    public List<ChartData> getPNEdateList() {
        return PNEdateList;
    }

    public List<ChartData> getSNSdateList() {
        return SNSdateList;
    }

    public List<ChartData> getSRVdateList() {
        return SRVdateList;
    }

    public List<ChartData> getTLEdateList() {
        return TLEdateList;
    }

    public List<ChartData> getTRDdateList() {
        return TRDdateList;
    }

    public String  fetchChartData() throws ParseException, SQLException {

        ASIdateList = new ArrayList<ChartData>();
        ResultSet rsetASI = marketSummeryDao.getMarketSummeryValuesForAMCharts("H5ALL");
        extractListFromRS(rsetASI,ASIdateList);

        MPIdateList = new ArrayList<ChartData>();
        ResultSet rsetMPI = marketSummeryDao.getMarketSummeryValuesForAMCharts("MIL");
        extractListFromRS(rsetMPI,MPIdateList);

        BFIdateList = new ArrayList<ChartData>();
        ResultSet rsetBFI = marketSummeryDao.getMarketSummeryValuesForAMCharts("BFI");
        extractListFromRS(rsetBFI,BFIdateList);

        BFTdateList = new ArrayList<ChartData>();
        ResultSet rsetBFT = marketSummeryDao.getMarketSummeryValuesForAMCharts("BFT");
        extractListFromRS(rsetBFT,BFTdateList);

        CNPdateList = new ArrayList<ChartData>();
        ResultSet rsetCNP = marketSummeryDao.getMarketSummeryValuesForAMCharts("CNP");
        extractListFromRS(rsetCNP,CNPdateList);

        CNEdateList = new ArrayList<ChartData>();
        ResultSet rsetCNE = marketSummeryDao.getMarketSummeryValuesForAMCharts("CNE");
        extractListFromRS(rsetCNE,CNEdateList);

        SNP20dateList = new ArrayList<ChartData>();
        ResultSet rsetSNP20 = marketSummeryDao.getMarketSummeryValuesForAMCharts("SNP");
        extractListFromRS(rsetSNP20,SNP20dateList);

        DIVdateList = new ArrayList<ChartData>();
        ResultSet rsetDIV = marketSummeryDao.getMarketSummeryValuesForAMCharts("DIV");
        extractListFromRS(rsetDIV,DIVdateList);

        FNTdateList = new ArrayList<ChartData>();
        ResultSet rsetFNT = marketSummeryDao.getMarketSummeryValuesForAMCharts("FNT");
        extractListFromRS(rsetFNT,FNTdateList);

        HLTdateList = new ArrayList<ChartData>();
        ResultSet rsetHLT = marketSummeryDao.getMarketSummeryValuesForAMCharts("HLT");
        extractListFromRS(rsetHLT,HLTdateList);

        HNTdateList = new ArrayList<ChartData>();
        ResultSet rset_HNT = marketSummeryDao.getMarketSummeryValuesForAMCharts("HNT");
        extractListFromRS(rset_HNT,HNTdateList);

        INVdateList = new ArrayList<ChartData>();
        ResultSet rset_INV = marketSummeryDao.getMarketSummeryValuesForAMCharts("INV");
        extractListFromRS(rset_INV,INVdateList);

        ITdateList = new ArrayList<ChartData>();
        ResultSet rset_IT = marketSummeryDao.getMarketSummeryValuesForAMCharts("IT");
        extractListFromRS(rset_IT,ITdateList);

        LNPdateList = new ArrayList<ChartData>();
        ResultSet rset_LNP = marketSummeryDao.getMarketSummeryValuesForAMCharts("LNP");
        extractListFromRS(rset_LNP,LNPdateList);

        MFGdateList = new ArrayList<ChartData>();
        ResultSet rset_MFG = marketSummeryDao.getMarketSummeryValuesForAMCharts("MFG");
        extractListFromRS(rset_MFG,MFGdateList);

        MTRdateList = new ArrayList<ChartData>();
        ResultSet rset_MTR = marketSummeryDao.getMarketSummeryValuesForAMCharts("MTR");
        extractListFromRS(rset_MTR,MTRdateList);

        PLTdateList = new ArrayList<ChartData>();
        ResultSet rset_PLT = marketSummeryDao.getMarketSummeryValuesForAMCharts("PLT");
        extractListFromRS(rset_PLT,PLTdateList);

        PNEdateList = new ArrayList<ChartData>();
        ResultSet rset_PNE = marketSummeryDao.getMarketSummeryValuesForAMCharts("PNE");
        extractListFromRS(rset_PNE,PNEdateList);

        SRVdateList = new ArrayList<ChartData>();
        ResultSet rset_SRV = marketSummeryDao.getMarketSummeryValuesForAMCharts("SRV");
        extractListFromRS(rset_SRV,SRVdateList);

        SNSdateList = new ArrayList<ChartData>();
        ResultSet rset_SNS = marketSummeryDao.getMarketSummeryValuesForAMCharts("SNS");
        extractListFromRS(rset_SNS,SNSdateList);

        TLEdateList = new ArrayList<ChartData>();
        ResultSet rset_TLE = marketSummeryDao.getMarketSummeryValuesForAMCharts("TLE");
        extractListFromRS(rset_TLE,TLEdateList);

        TRDdateList = new ArrayList<ChartData>();
        ResultSet rset_TRD = marketSummeryDao.getMarketSummeryValuesForAMCharts("TRD");
        extractListFromRS(rset_TRD,TRDdateList);

        return SUCCESS;
    }

    private void extractListFromRS(ResultSet rsetASI,List collection) throws SQLException {
        while(rsetASI.next()){
            String dateStr = rsetASI.getString(1);
            String value = rsetASI.getString(2);
            ChartData chartDataInstance = new ChartData();
            chartDataInstance.setDate(dateStr);
            chartDataInstance.setValue(value);
            collection.add(chartDataInstance);
        }
    }

    private void extractListFromRSHQ(ResultSet rsetASI,List collection) throws SQLException {
        while(rsetASI.next()){
            String dateStr = rsetASI.getString(1);
            String value = rsetASI.getString(2);
            ChartData chartDataInstance = new ChartData();
            chartDataInstance.setDate(dateStr);
            chartDataInstance.setValue(value);
            collection.add(chartDataInstance);
        }
    }

    public String fetchDataHibernate() throws ParseException {
        dateList =  chartDataDaoHibernate.getChartData("getAllASI");
        return SUCCESS;

    }

    public String fetchHQDataChart() throws SQLException {

        ASIdateList = new ArrayList<ChartData>();
        ResultSet rsetASI = marketSummeryDao.getMarketSummeryValuesForAMCharts("H5ALL");
        extractListFromRS(rsetASI,ASIdateList);





        return SUCCESS;
    }
}

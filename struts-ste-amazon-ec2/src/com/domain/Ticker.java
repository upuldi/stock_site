package com.domain;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 2/11/12
 * Time: 7:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Ticker {

    private long id;
    private long companyid;
    private String symbol;
    private String lastTradedPrice;
    private String cseId;
    private String marketCap;
    private String marketCapPresent;
    private String betaAsi;
    private String betaMpi;
    private String allTimeHigh;
    private String allTimeLow;
    private String toWtd;
    private String toYtd;
    private String volWtd;
    private String toMtd;
    private String volMtd;
    private String volYtd;
    private String recordTIme;
    private String change;
    private String changePresentage;
    private String turnover;
    private String volume;
    private String trade;
    private String lastTradedPriceRange;
    private String closingPrice;
    private String prevClose;

    private String changeClass;
    private String changeImage;
    private String changeClassPresentage;


    public String getChangePresentage() {
        return changePresentage;
    }

    public void setChangePresentage(String changePresentage) {
        this.changePresentage = changePresentage;
    }

    public String getChangeClassPresentage() {
        return changeClassPresentage;
    }

    public void setChangeClassPresentage(String changeClassPresentage) {
        this.changeClassPresentage = changeClassPresentage;
    }

    public String getChangeImage() {
        return changeImage;
    }

    public void setChangeImage(String changeImage) {
        this.changeImage = changeImage;
    }

    public String getChangeClass() {
        return changeClass;
    }

    public void setChangeClass(String changeClass) {
        this.changeClass = changeClass;
    }

    public String getLastTradedPriceRange() {
        return lastTradedPriceRange;
    }

    public void setLastTradedPriceRange(String lastTradedPriceRange) {
        this.lastTradedPriceRange = lastTradedPriceRange;
    }

    public String getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(String closingPrice) {
        this.closingPrice = closingPrice;
    }

    public String getPrevClose() {
        return prevClose;
    }

    public void setPrevClose(String prevClose) {
        this.prevClose = prevClose;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getChange() {
        return change;
    }

    public String getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(String lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }

    public String getRecordTIme() {
        return recordTIme;
    }

    public void setRecordTIme(String recordTIme) {
        this.recordTIme = recordTIme;
    }

    public String getVolYtd() {
        return volYtd;
    }

    public void setVolYtd(String volYtd) {
        this.volYtd = volYtd;
    }

    public String getVolMtd() {
        return volMtd;
    }

    public void setVolMtd(String volMtd) {
        this.volMtd = volMtd;
    }

    public String getToMtd() {
        return toMtd;
    }

    public void setToMtd(String toMtd) {
        this.toMtd = toMtd;
    }

    public String getVolWtd() {
        return volWtd;
    }

    public void setVolWtd(String volWtd) {
        this.volWtd = volWtd;
    }

    public String getToYtd() {
        return toYtd;
    }

    public void setToYtd(String toYtd) {
        this.toYtd = toYtd;
    }

    public String getToWtd() {
        return toWtd;
    }

    public void setToWtd(String toWtd) {
        this.toWtd = toWtd;
    }

    public String getAllTimeLow() {
        return allTimeLow;
    }

    public void setAllTimeLow(String allTimeLow) {
        this.allTimeLow = allTimeLow;
    }

    public String getAllTimeHigh() {
        return allTimeHigh;
    }

    public void setAllTimeHigh(String allTimeHigh) {
        this.allTimeHigh = allTimeHigh;
    }

    public String getBetaMpi() {
        return betaMpi;
    }

    public void setBetaMpi(String betaMpi) {
        this.betaMpi = betaMpi;
    }

    public String getBetaAsi() {
        return betaAsi;
    }

    public void setBetaAsi(String betaAsi) {
        this.betaAsi = betaAsi;
    }

    public String getMarketCapPresent() {
        return marketCapPresent;
    }

    public void setMarketCapPresent(String marketCapPresent) {
        this.marketCapPresent = marketCapPresent;
    }

    public String getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    }

    public String getCseId() {
        return cseId;
    }

    public void setCseId(String cseId) {
        this.cseId = cseId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCompanyid() {
        return companyid;
    }

    public void setCompanyid(long companyid) {
        this.companyid = companyid;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setChange(String change) {
        this.change = change;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "id=" + id +
                ", companyid=" + companyid +
                ", symbol='" + symbol + '\'' +
                ", lastTradedPrice='" + lastTradedPrice + '\'' +
                ", cseId='" + cseId + '\'' +
                ", marketCap='" + marketCap + '\'' +
                ", marketCapPresent='" + marketCapPresent + '\'' +
                ", betaAsi='" + betaAsi + '\'' +
                ", betaMpi='" + betaMpi + '\'' +
                ", allTimeHigh='" + allTimeHigh + '\'' +
                ", allTimeLow='" + allTimeLow + '\'' +
                ", toWtd='" + toWtd + '\'' +
                ", toYtd='" + toYtd + '\'' +
                ", volWtd='" + volWtd + '\'' +
                ", toMtd='" + toMtd + '\'' +
                ", volMtd='" + volMtd + '\'' +
                ", volYtd='" + volYtd + '\'' +
                ", recordTIme='" + recordTIme + '\'' +
                ", change='" + change + '\'' +
                ", turnover='" + turnover + '\'' +
                ", volume='" + volume + '\'' +
                ", trade='" + trade + '\'' +
                ", lastTradedPriceRange='" + lastTradedPriceRange + '\'' +
                ", closingPrice='" + closingPrice + '\'' +
                ", prevClose='" + prevClose + '\'' +
                '}';
    }
}

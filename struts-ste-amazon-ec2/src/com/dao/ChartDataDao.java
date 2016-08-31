package com.dao;

import com.domain.ChartData;
import com.domain.RubberPrice;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: udoluweera
 * Date: 11/19/12
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ChartDataDao {

    public List<ChartData> getChartData(String type);

}

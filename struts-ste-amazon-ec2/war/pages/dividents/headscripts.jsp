<!-- Page Specific JS to make -->
<script type="text/javascript" src="pages/jquery/jquery-1.7.js"></script>
<script type="text/javascript" src="pages/jquery/jquery-ui.min.js"></script>

<script src="pages/hc/js/highstock.js"></script>
<script src="pages/hc/js/modules/exporting.js"></script>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>


<script type="text/javascript">
    $(document).ready(function () {
        $("input#autoText").autocomplete({
            width: 300,
            max: 10,
            delay: 100,
            minLength: 1,
            autoFocus: true,
            cacheLength: 1,
            scroll: true,
            highlight: false,
            source: function (request, response) {
                $.ajax({
                    url: "fetchStockCodesAutoFillDataSupport.action",
                    dataType: "json",
                    data: request,
                    success: function (data, textStatus, jqXHR) {
                        console.log(data);
                        var items = data;
                        response(items);
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        console.log(textStatus);
                    }
                });
            }
        });
    });
</script>


<script type="text/javascript">
$(function () {

    $.getJSON('http://localhost:8080/struts-site/ss.hcStockOtherDataServlet?category=dividents&type=<s:property value="tickerOnly"/>&callback=?', function (data) {

            // split the data set into ohlc and volume
            var ohlc = [],
                    volume = [], flagData = [] ,
                    dataLength = data.length;

            for (i = 0; i < dataLength; i++) {

                ohlc.push([
                    data[i][0], // the date
                    data[i][1] // open
                ]);


                volume.push([
                    data[i][0], // the date
                    data[i][2] // the volume
                ]);

                if ("" != data[i][3]) {
                    flagData.push({
                        x: data[i][0],
                        title: 'D',
                        text: data[i][3]
                    });
                }

            }
            console.log('flagData : ' + flagData.length);


            // set the allowed units for data grouping
            var groupingUnits = [
                [
                    'week', // unit name
                    [1]                             // allowed multiples
                ],
                [
                    'month',
                    [1, 2, 3, 4, 6]
                ]
            ];


            /**
             * Gray theme for Highcharts JS
             * @author Torstein Hønsi
             */

            Highcharts.theme = {
                colors: ["#F87B27", "#7798BF", "#55BF3B", "#DF5353", "#aaeeee", "#ff0066", "#eeaaee",
                    "#55BF3B", "#DF5353", "#7798BF", "#aaeeee"],
                chart: {
                    backgroundColor: {
                        linearGradient: [0, 0, 0, 400],
                        stops: [
                            [0, 'rgb(96, 96, 96)'],
                            [1, 'rgb(16, 16, 16)']
                        ]
                    },
                    borderWidth: 0,
                    borderRadius: 15,
                    plotBackgroundColor: null,
                    plotShadow: false,
                    plotBorderWidth: 0
                },
                title: {
                    style: {
                        color: '#FFF',
                        font: '16px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
                    }
                },
                subtitle: {
                    style: {
                        color: '#DDD',
                        font: '12px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
                    }
                },
                xAxis: {
                    gridLineWidth: 0,
                    lineColor: '#999',
                    tickColor: '#999',
                    labels: {
                        style: {
                            color: '#999',
                            fontWeight: 'bold'
                        }
                    },
                    title: {
                        style: {
                            color: '#AAA',
                            font: 'bold 12px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
                        }
                    }
                },
                yAxis: {
                    alternateGridColor: null,
                    minorTickInterval: null,
                    gridLineColor: 'rgba(255, 255, 255, .1)',
                    lineWidth: 0,
                    tickWidth: 0,
                    labels: {
                        style: {
                            color: '#999',
                            fontWeight: 'bold'
                        }
                    },
                    title: {
                        style: {
                            color: '#AAA',
                            font: 'bold 12px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
                        }
                    }
                },
                legend: {
                    itemStyle: {
                        color: '#CCC'
                    },
                    itemHoverStyle: {
                        color: '#FFF'
                    },
                    itemHiddenStyle: {
                        color: '#333'
                    }
                },
                labels: {
                    style: {
                        color: '#CCC'
                    }
                },
                tooltip: {
                    backgroundColor: {
                        linearGradient: [0, 0, 0, 50],
                        stops: [
                            [0, 'rgba(96, 96, 96, .8)'],
                            [1, 'rgba(16, 16, 16, .8)']
                        ]
                    },
                    borderWidth: 0,
                    style: {
                        color: '#FFF'
                    }
                },


                plotOptions: {
                    line: {
                        dataLabels: {
                            color: '#CCC'
                        },
                        marker: {
                            lineColor: '#333'
                        }
                    },
                    spline: {
                        marker: {
                            lineColor: '#333'
                        }
                    },
                    scatter: {
                        marker: {
                            lineColor: '#333'
                        }
                    },
                    candlestick: {
                        lineColor: 'white'
                    }
                },

                toolbar: {
                    itemStyle: {
                        color: '#CCC'
                    }
                },

                navigation: {
                    buttonOptions: {
                        backgroundColor: {
                            linearGradient: [0, 0, 0, 20],
                            stops: [
                                [0.4, '#606060'],
                                [0.6, '#333333']
                            ]
                        },
                        borderColor: '#000000',
                        symbolStroke: '#C0C0C0',
                        hoverSymbolStroke: '#FFFFFF'
                    }
                },

                exporting: {
                    buttons: {
                        exportButton: {
                            symbolFill: '#55BE3B'
                        },
                        printButton: {
                            symbolFill: '#7797BE'
                        }
                    }
                },

                // scroll charts
                rangeSelector: {
                    buttonTheme: {
                        fill: {
                            linearGradient: [0, 0, 0, 20],
                            stops: [
                                [0.4, '#888'],
                                [0.6, '#555']
                            ]
                        },
                        stroke: '#000000',
                        style: {
                            color: '#CCC',
                            fontWeight: 'bold'
                        },
                        states: {
                            hover: {
                                fill: {
                                    linearGradient: [0, 0, 0, 20],
                                    stops: [
                                        [0.4, '#BBB'],
                                        [0.6, '#888']
                                    ]
                                },
                                stroke: '#000000',
                                style: {
                                    color: 'white'
                                }
                            },
                            select: {
                                fill: {
                                    linearGradient: [0, 0, 0, 20],
                                    stops: [
                                        [0.1, '#000'],
                                        [0.3, '#333']
                                    ]
                                },
                                stroke: '#000000',
                                style: {
                                    color: 'yellow'
                                }
                            }
                        }
                    },
                    inputStyle: {
                        backgroundColor: '#333',
                        color: 'silver'
                    },
                    labelStyle: {
                        color: 'silver'
                    }
                },

                navigator: {
                    handles: {
                        backgroundColor: '#666',
                        borderColor: '#AAA'
                    },
                    outlineColor: '#CCC',
                    maskFill: 'rgba(16, 16, 16, 0.5)',
                    series: {
                        color: '#7798BF',
                        lineColor: '#A6C7ED'
                    }
                },

                scrollbar: {
                    barBackgroundColor: {
                        linearGradient: [0, 0, 0, 20],
                        stops: [
                            [0.4, '#888'],
                            [0.6, '#555']
                        ]
                    },
                    barBorderColor: '#CCC',
                    buttonArrowColor: '#CCC',
                    buttonBackgroundColor: {
                        linearGradient: [0, 0, 0, 20],
                        stops: [
                            [0.4, '#888'],
                            [0.6, '#555']
                        ]
                    },
                    buttonBorderColor: '#CCC',
                    rifleColor: '#FFF',
                    trackBackgroundColor: {
                        linearGradient: [0, 0, 0, 10],
                        stops: [
                            [0, '#000'],
                            [1, '#333']
                        ]
                    },
                    trackBorderColor: '#666'
                },

                // special colors for some of the demo examples
                legendBackgroundColor: 'rgba(48, 48, 48, 0.8)',
                legendBackgroundColorSolid: 'rgb(70, 70, 70)',
                dataLabelsColor: '#444',
                textColor: '#E0E0E0',
                maskColor: 'rgba(255,255,255,0.3)'
            };

// Apply the theme
            var highchartsOptions = Highcharts.setOptions(Highcharts.theme);

            // create the chart
            chart = new Highcharts.StockChart({
                chart: {
                    renderTo: 'containerEOD',
                    alignTicks: false,
                    zoomType: 'x'
                },

                title: {
                    text: '<s:property value="stockCode"/>'
                },
                subtitle: {
                    text: 'CSE Daily Price Movements of <s:property value="stockCodeOnly"/> - CSEWatch'
                },
                rangeSelector: {
                    buttons: [
                        {
                            type: 'day',
                            count: 1,
                            text: '1d'
                        },
                        {
                            type: 'month',
                            count: 1,
                            text: '1m'
                        },
                        {
                            type: 'month',
                            count: 3,
                            text: '3m'
                        },
                        {
                            type: 'month',
                            count: 6,
                            text: '6m'
                        },
                        {
                            type: 'year',
                            count: 1,
                            text: '1y'
                        },
                        {
                            type: 'year',
                            count: 5,
                            text: '5y'
                        },
                        {
                            type: 'year',
                            count: 10,
                            text: '10y'
                        },
                        {
                            type: 'all',
                            text: 'All'
                        }
                    ],
                    inputEnabled: true, // it supports only days
                    selected: 5 // all
                },

                yAxis: [
                    {
                        title: {
                            text: '<s:property value="stockCodeOnly"/> Stock Price'
                        },
                        height: 300,
                        lineWidth: 2
                    },
                    {
                        title: {
                            text: 'Volume'
                        },
                        top: 400,
                        height: 100,
                        offset: 0,
                        lineWidth: 2
                    }
                ],

                series: [
                    {
                        type: 'spline',
                        name: '<s:property value="stockCodeOnly"/>',
                        data: ohlc,
                        id: 'dataseries',
                        dataGrouping: {
                            units: groupingUnits
                        },
                        fillColor: {
                            linearGradient: {
                                x1: 0.5,
                                y1: 0.5,
                                x2: 0,
                                y2: 0.5
                            },
                            stops: [
                                [0, Highcharts.getOptions().colors[0]],
                                [1, 'rgba(0,0,0)']
                            ]
                        }
                    },
                    {
                        type: 'column',
                        name: 'Volume',
                        data: volume,
                        yAxis: 1,
                        dataGrouping: {
                            units: groupingUnits
                        }
                    },
                    {
                        type: 'flags',
                        data: flagData,
                        onSeries: 'dataseries',
                        shape: 'circlepin',
                        width: 16
                    }
                ]
            });
        });
});
</script>
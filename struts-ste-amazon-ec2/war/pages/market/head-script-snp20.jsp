<script src="pages/hc/js/highstock.js"></script>
<script src="pages/hc/js/modules/exporting.js"></script>

<script type="text/javascript">

$(function () {

    Highcharts.theme = {
        colors:["#F87B27", "#7798BF", "#55BF3B", "#DF5353", "#aaeeee", "#ff0066", "#eeaaee",
            "#55BF3B", "#DF5353", "#7798BF", "#aaeeee"],
        chart:{
            backgroundColor:{
                linearGradient:[0, 0, 0, 400],
                stops:[
                    [0, 'rgb(96, 96, 96)'],
                    [1, 'rgb(16, 16, 16)']
                ]
            },
            borderWidth:0,
            borderRadius:15,
            plotBackgroundColor:null,
            plotShadow:false,
            plotBorderWidth:0
        },
        title:{
            style:{
                color:'#FFF',
                font:'16px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
            }
        },
        subtitle:{
            style:{
                color:'#DDD',
                font:'12px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
            }
        },
        xAxis:{
            gridLineWidth:0,
            lineColor:'#999',
            tickColor:'#999',
            labels:{
                style:{
                    color:'#999',
                    fontWeight:'bold'
                }
            },
            title:{
                style:{
                    color:'#AAA',
                    font:'bold 12px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
                }
            }
        },
        yAxis:{
            alternateGridColor:null,
            minorTickInterval:null,
            gridLineColor:'rgba(255, 255, 255, .1)',
            lineWidth:0,
            tickWidth:0,
            labels:{
                style:{
                    color:'#999',
                    fontWeight:'bold'
                }
            },
            title:{
                style:{
                    color:'#AAA',
                    font:'bold 12px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
                }
            }
        },
        legend:{
            itemStyle:{
                color:'#CCC'
            },
            itemHoverStyle:{
                color:'#FFF'
            },
            itemHiddenStyle:{
                color:'#333'
            }
        },
        labels:{
            style:{
                color:'#CCC'
            }
        },
        tooltip:{
            backgroundColor:{
                linearGradient:[0, 0, 0, 50],
                stops:[
                    [0, 'rgba(96, 96, 96, .8)'],
                    [1, 'rgba(16, 16, 16, .8)']
                ]
            },
            borderWidth:0,
            style:{
                color:'#FFF'
            }
        },

        plotOptions:{
            line:{
                dataLabels:{
                    color:'#CCC'
                },
                marker:{
                    lineColor:'#333'
                }
            },
            spline:{
                marker:{
                    lineColor:'#333'
                }
            },
            scatter:{
                marker:{
                    lineColor:'#333'
                }
            },
            candlestick:{
                lineColor:'white'
            }
        },

        toolbar:{
            itemStyle:{
                color:'#CCC'
            }
        },

        navigation:{
            buttonOptions:{
                backgroundColor:{
                    linearGradient:[0, 0, 0, 20],
                    stops:[
                        [0.4, '#606060'],
                        [0.6, '#333333']
                    ]
                },
                borderColor:'#000000',
                symbolStroke:'#C0C0C0',
                hoverSymbolStroke:'#FFFFFF'
            }
        },

        exporting:{
            buttons:{
                exportButton:{
                    symbolFill:'#55BE3B'
                },
                printButton:{
                    symbolFill:'#7797BE'
                }
            }
        },

        // scroll charts
        rangeSelector:{
            buttonTheme:{
                fill:{
                    linearGradient:[0, 0, 0, 20],
                    stops:[
                        [0.4, '#888'],
                        [0.6, '#555']
                    ]
                },
                stroke:'#000000',
                style:{
                    color:'#CCC',
                    fontWeight:'bold'
                },
                states:{
                    hover:{
                        fill:{
                            linearGradient:[0, 0, 0, 20],
                            stops:[
                                [0.4, '#BBB'],
                                [0.6, '#888']
                            ]
                        },
                        stroke:'#000000',
                        style:{
                            color:'white'
                        }
                    },
                    select:{
                        fill:{
                            linearGradient:[0, 0, 0, 20],
                            stops:[
                                [0.1, '#000'],
                                [0.3, '#333']
                            ]
                        },
                        stroke:'#000000',
                        style:{
                            color:'yellow'
                        }
                    }
                }
            },
            inputStyle:{
                backgroundColor:'#333',
                color:'silver'
            },
            labelStyle:{
                color:'silver'
            }
        },

        navigator:{
            handles:{
                backgroundColor:'#666',
                borderColor:'#AAA'
            },
            outlineColor:'#CCC',
            maskFill:'rgba(16, 16, 16, 0.5)',
            series:{
                color:'#7798BF',
                lineColor:'#A6C7ED'
            }
        },

        scrollbar:{
            barBackgroundColor:{
                linearGradient:[0, 0, 0, 20],
                stops:[
                    [0.4, '#888'],
                    [0.6, '#555']
                ]
            },
            barBorderColor:'#CCC',
            buttonArrowColor:'#CCC',
            buttonBackgroundColor:{
                linearGradient:[0, 0, 0, 20],
                stops:[
                    [0.4, '#888'],
                    [0.6, '#555']
                ]
            },
            buttonBorderColor:'#CCC',
            rifleColor:'#FFF',
            trackBackgroundColor:{
                linearGradient:[0, 0, 0, 10],
                stops:[
                    [0, '#000'],
                    [1, '#333']
                ]
            },
            trackBorderColor:'#666'
        },

        // special colors for some of the demo examples
        legendBackgroundColor:'rgba(48, 48, 48, 0.8)',
        legendBackgroundColorSolid:'rgb(70, 70, 70)',
        dataLabelsColor:'#444',
        textColor:'#E0E0E0',
        maskColor:'rgba(255,255,255,0.3)'
    };
    var highchartsOptions1 = Highcharts.setOptions(Highcharts.theme);


    var today = new Date();
    var toDate = today.getDate();
    var toMonth = today.getMonth();
    var toYear = today.getFullYear();

    var fromDate = 1;
    var fromMonth = toMonth - 3;
    var fromYear = toYear;

    window.chart3 = new Highcharts.StockChart({
        chart:{
            renderTo:'containerSNP', zoomType:'x'
        },

        rangeSelector:{
            selected:1
        },

        title:{
            text:'SNP20 Movements'
        },
        subtitle:{
            text:'CSE SNP20 Share Price Index - CSEWatch'
        },
        rangeSelector:{
            buttons:[
                {
                    type:'day',
                    count:1,
                    text:'1d'
                },
                {
                    type:'month',
                    count:1,
                    text:'1m'
                },
                {
                    type:'month',
                    count:3,
                    text:'3m'
                },
                {
                    type:'month',
                    count:6,
                    text:'6m'
                },
                {
                    type:'year',
                    count:1,
                    text:'1y'
                },
                {
                    type:'year',
                    count:5,
                    text:'5y'
                },
                {
                    type:'year',
                    count:10,
                    text:'10y'
                },
                {
                    type:'all',
                    text:'All'
                }
            ],
            inputEnabled:true, // it supports only days
            selected:2 // all
        },

        series:[
            {
                name:'SNP20',
                // data:data2,
                type:'areaspline',
                threshold:null,
                tooltip:{
                    valueDecimals:2
                },
                fillColor:{
                    linearGradient:{
                        x1:0.5,
                        y1:0.5,
                        x2:0,
                        y2:0.5
                    },
                    stops:[
                        [0, Highcharts.getOptions().colors[0]],
                        [1, 'rgba(0,0,0)']
                    ]
                }
            }
        ]
    });

    window.chart3 .showLoading();
    $.getJSON('http://localhost:8080/struts-site/hcMarketDataServlet.hcMarketDataServlet?type=HC_SNP&callback=?', function(data3){
        window.chart3.series[0].setData(data3);
        window.chart3.hideLoading();
        window.chart3.xAxis[0].setExtremes(Date.UTC(fromYear, fromMonth, fromDate), Date.UTC(toYear, toMonth, toDate));
    });

});

</script>
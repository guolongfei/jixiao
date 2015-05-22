
//$(document).ready(function () {
//    var test = '[{"Number":3,"jysj":"2013-09-27"},{"Number":21,"jysj":"2013-10-08"},{"Number":42,"jysj":"2013-10-09"},{"Number":3,"jysj":"2013-10-10"},{"Number":1,"jysj":"2013-10-12"},{"Number":5,"jysj":"2013-10-15"},{"Number":9,"jysj":"2013-10-16"},{"Number":1,"jysj":"2013-10-17"},{"Number":8,"jysj":"2013-10-18"},{"Number":1,"jysj":"2013-10-22"},{"Number":1,"jysj":"2013-11-07"},{"Number":2,"jysj":"2013-11-08"},{"Number":1,"jysj":"2013-11-12"},{"Number":1,"jysj":"2013-11-13"}]';
//    HighCharShow(test);
//})

function HighCharShow(result) {
    if (result != "" && result != null) {
        var test = eval('(' + result + ')');
        var charHeight = ($(window).height() - 40) / 2;
        chart = new Highcharts.Chart({
            chart: {
                renderTo: 'container3',
                margin: [50, 50, 100, 80],
                height: charHeight
            },
            colors: ['#79BC31'],
            title: {
                text: '收押人员信息曲线图'
            },
            xAxis: {
                categories: (function () {
                    var X_data = new Array();

                    for (i = 0; i < test.length; i++) {
                        var jysj = test[i].jysj; 
                        X_data.push(jysj);
                    }
                    return X_data;
                })()
            },
            tooltip: {
                formatter: function () {
                    var s;
                    if (this.point.name) { // the pie chart
                        s = '' + this.point.name + ': ' + this.y + ' fruits';
                    } else {
                        //  s = '' + this.x + '打印次数: ' + this.y;
                        s = '收押人数: ' + this.y;
                    }
                    return s;
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: '收押人数'
                }
            },
            labels: {
                items: [{
                    html: '',
                    style: {
                        left: '40px',
                        top: '8px',
                        color: 'black'
                    }
                }]
            },
            plotOptions: {//用于表示是否显示值
                series: {
                    dataLabels: {
                        enabled: true,
                        borderRadius: 5,
                        //   backgroundColor: 'rgba(252, 255, 197, 0.7)',
                        //   borderWidth: 1,
                        // borderColor: '#AAA',
                        y: -6
                    }
                }
            },
            exporting:{
            	buttons:{
	            	contextButton: {
		                menuItems: [{
		                    	text: '本周',
			                    onclick: function() {
			                        this.exportChart({
			                            width: 250
			                        });
		                    	}
	                	}, {
			                    text: '本月',
			                    onclick: function() {
			                        this.exportChart();
		                    },
		                    separator: false
		                },{
		                	text: '三个月',
		                    onclick: function() {
		                        this.exportChart();
		                        }
		                },{
		                	text: '半年',
		                    onclick: function() {
		                        this.exportChart();
		                        }
		                }]
	            	}
            	}
            },

            series: [{
                type: 'spline',
                name: '男',
                data: (function () {
                    var Y_data = new Array();

                    for (i = 0; i < test.length; i++) {
                        Y_data.push(parseFloat(test[i].Number));
                    }
                    return Y_data;
                })()
            }, {
                type: 'spline',
                name: '女',
                data: (function () {
                    var Y_data = new Array();

                    for (i = 0; i < test.length; i++) {
                        Y_data.push(parseFloat(test[i].Number));
                    }
                    return Y_data;
                })()
            },
                {
                    type: 'spline',
                    name: '总数',
                    data: (function () {
                        var Y_data = new Array();

                        for (i = 0; i < test.length; i++) {
                            Y_data.push(parseFloat(test[i].Number));
                        }
                        return Y_data;
                    })(),
                    marker: {
                        lineWidth: 1,
                        lineColor: Highcharts.getOptions().colors[3],
                        fillColor: 'white'
                    }
                }]
        })

    }
}

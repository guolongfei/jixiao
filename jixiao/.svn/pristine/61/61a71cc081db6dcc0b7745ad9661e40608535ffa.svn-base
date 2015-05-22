 //柱状图异步获得数据(显示两张图)
  function barPost(action,data){
	  $.post(action, data, function (data) {
			var name=data.resultName.split(',');
			var num=data.resultNum.split(',');
			barInit(name,num,1);	
			pieChartInit(name,num,2);
			},'json');
  }
  
  //饼状图异步获得数据
  function piePost(action,data){
	  $.post(action, data, function (data) {
			var name=data.resultName.split(',');
			var num=data.resultNum.split(',');
			pieChartInit(name,num,2);
			},'json');
  }
  
  //线性走势图异步获得数据
  function zoushiPost(action,data){
	  $.post(action, data, function (data) {
			var name=data.resultName.split(',');
			var womanResult=data.woman.split(',');
			var manResult=data.man.split(',');
			for(var i in womanResult){
				womanResult[i]=parseInt(womanResult[i]);
			}
			for(var i in manResult){
				manResult[i]=parseInt(manResult[i]);
			}
			zoushi(name,womanResult,manResult);
			},'json');
	  
  }
  
  //线性走势图
  function zoushi(resultName,woman,man) {
	  var colors = ['#4572A7','#994643'];
      $('#container3').highcharts({
          chart: {
              type: 'line'
          },
          title: {
              text: '最近一周在拘人员走势图'
          },
          subtitle: {
              text: '最近7天的在拘人员的男女人数'
          },
          xAxis: {
              categories: resultName
          },
          yAxis: {
              title: {
                  text: '人数 (人)'
              }
          },
          tooltip: {
              enabled: false,
              formatter: function() {
                  return '<b>'+ this.series.name +'</b><br/>'+
                      this.x +': '+ this.y +'°C';
              }
          },
          plotOptions: {
              line: {
                  dataLabels: {
                      enabled: true
                  },
                  enableMouseTracking: false
              }
          },
          series: [{
        	  name: '男',
        	  color: colors[0],
              data: man
          }, {
              name: '女',
              color: colors[1],
              data: woman
          }],
          exporting: {
              enabled: false
          }
      });
  };
  

  
  
  /*
	初始化柱状图
	*/
  function barInit(name,num,index){
	  var colors = ['#4572A7','#994643'];
	  var temp = new Array;
		for(var i in name){
			var temp1;
			if(i<10){
				 temp1 = {
					y: parseFloat(num[i]),
					color: colors[i]
				};
			}else{
				 temp1 = {
						y: parseFloat(num[i]),
						color: Highcharts.getOptions().colors[i-10]
					};
			}
    		temp.push(temp1);
		}
	      var categories = name,
	          name = 'Browser brands',
	          data = temp;
	  
	      function setChart(name, categories, data, color) {
				chart.xAxis[0].setCategories(categories, false);
				chart.series[0].remove(false);
				chart.addSeries({
					name: name,
					data: data,
					color: color 
				}, false);
				chart.redraw();
	      }
	  
	      var chart = $("#content"+index).highcharts({
	    	  chart: {
	                type: 'column',
	                margin: [ 30, 30, 50, 60]
	            },
	            title: {
	                text:'在拘人数分布'
	            },
	            xAxis: {
	               categories: categories,
	                labels: {
	                    rotation: -45,
	                    align: 'right',
	                    style: {
	                    	color:'#000000',
	                        fontSize: '12px',
	                        fontFamily: 'Verdana, sans-serif'
	                    }
	                }
	            },
	            yAxis: {
	               title: {
		                  text: '人数(人)'
		              }
	            },
	            legend: {
	                enabled: false
	            },
	            tooltip: {
	                formatter: function() {
		                  var s = this.x +':<b>'+ this.y ;
		                  return s;
		              }
	            },
	            series: [{
		              name: name,
		              data: data,
		              color: 'white'
		          }],
		            exporting: {
		                enabled: false
		            }
	      })
	      .highcharts(); // return chart
	  };
  
	  /*
		初始化饼状图
		*/
		function pieChartInit(name,num,index){
			 var colors = ['#4572A7','#994643'];
			 var temp = new Array;
				for(var i in name){
					temp1 = {
							name:name[i],
							y: parseFloat(num[i]),
							color: colors[i]
						};
		    		temp.push(temp1);
				}
				
			 $("#content"+index).highcharts({
		            chart: {
		                plotBackgroundColor: null,
		                plotBorderWidth: null,
		                plotShadow: false
		            },
		            title: {
		                text: '在拘人数比例'
		                
		            },
		            tooltip: {
		        	    pointFormat: '{series.name}: <b>{point.percentage}%</b>',
		            	percentageDecimals: 1
		            },
		            plotOptions: {
		                pie: {
		                    allowPointSelect: true,
		                    cursor: 'pointer',
		                    dataLabels: {
		                    	  enabled: false
		                    },
		                    showInLegend: true
		                }
		            },
		            series: [{
		                type: 'pie',
		                name: '所占比例为',
		                data: temp
		            }],
		            exporting: {
		                enabled: false
		            }
		        });
	  }
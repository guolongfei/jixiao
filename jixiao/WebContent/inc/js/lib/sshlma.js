(function() {
	/**
	 * current 当前页
	 * total 总页数
	 * show 显示数
	 */
	function Page(option){
		this.current = option.current;
		this.total = option.total;
		this.show = option.show;
		this.onPageChanged = option.onPageChanged;
		this.changetype = option.changetype;//0同步 1异步
		this.url = option.url;//0同步 1异步
		this.condition = option.condition;
		this.pageChanged();
		this.callback = option.callback;
	}
	
	Page.prototype = {
		initPage: function(){
			var disable_class = 'class="disabled"';
			var active_class = 'class="active"';
			var pageStr = '<div class="pagination nomargin"><ul><li '+(this.current==1?disable_class:'')+'><a href="#">首页</a></li>';
			pageStr += '<li '+(this.current==1?disable_class:'')+'><a href="#">上一页</a></li>';
			for(var i=0;i<this.show;i++){
				//if(this.current<this.total-Math.floor(this.show/2+1)){
				if((this.total-this.current<this.show/2)&&(this.total*1>=this.show)){//总页数-当前页<show-2 相当于页数偏移量在右半边。并且总页数大于show值
					pageStr += '<li '+((this.total-this.show+1+i)==this.current?active_class:'')+'><a href="#">'+(this.total-this.show+1+i)+'</a></li>';
				}else if(this.current<(this.show)/2||this.show*1>this.total){//总页数小于show值或页数偏移量在左半边
					if(this.show*1>this.total&&(i+1*1>this.total)) continue;
					pageStr += '<li '+((i+1)==this.current?active_class:'')+'><a href="#">'+(i+1)+'</a></li>';
				}
				else{//页数固定在一个点
					//pageStr += '<li '+((i+1)==this.current?active_class:'')+'><a href="#">'+(i+1)+'</a></li>';
					if(this.current*2==this.show){
						pageStr += '<li '+((i+1)==this.current?active_class:'')+'><a href="#">'+(i+1)+'</a></li>';
					}else{
						pageStr += '<li '+(((this.current-Math.floor(this.show/2))+i)==this.current?active_class:'')+'><a href="#">'+((this.current-Math.floor((this.show)/2))+i)+'</a></li>';
					}
					//console.debug(((this.current-Math.floor(this.show/2))+i))
				}
				//}
			}
			pageStr += '<li '+(this.current==this.total?disable_class:'')+'><a href="#">下一页</a></li><li '+(this.current==this.total?disable_class:'')+'><a href="#">末页</a></li></ul></div>';
			$('#page-info').html(pageStr);
		}	,
		pageChanged: function () {
			var page = this;
			$('#page-info').live('click',function(e){
					var target = $(e.target);
					if(target.is('a')){
						if(target.parent().attr('class')!='disabled'&&target.parent().attr('class')!='active'){
							if(target.html()=='首页'){
								page.current = 1;
							}else if(target.html()=='末页'){
								page.current = page.total;
							}else if(target.html()=='上一页'){
								page.current = page.current*1-1*1;
							}else if(target.html()=='下一页'){
								page.current = page.current*1+1*1;
							}else{
								page.current = target.html();
							}
							if(page.changetype==0){
								var _str = ""; 
								for(var o in page.condition){ 
									if(page.condition[o] != -1){ 
										_str += o + "=" + encodeURIComponent(page.condition[o]) + "&"; 
									} 
								} 
								_str = _str.substring(0, _str.length-1); 
								if(_str == ""){
									window.location.replace(page.url+'?page='+page.current);
								}else{
									window.location.replace(page.url+'?'+_str+'&page='+page.current);
								}
								page.initPage();
								if(!!page.onPageChanged)page.onPageChanged(page.current);
							}else{
								page.callback();
							}
						}
					}
			});
		}
	};
	window['sshlma']= {};
	window['sshlma']['Page'] = Page;
})();

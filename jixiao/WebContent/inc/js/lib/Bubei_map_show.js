$.fn.extend({
    map:function(mapOption){
        var elem = this;
        $(elem).data('mapOption');
        $(elem).data('mapOption', mapOption);
        //计算画布的大小及显示位置
        var svg_original_width = 650;
        var svg_original_height = 550;
        var obj = $(elem); //document.getElementById("risk_map");
        var obj_width = obj.width();
        var obj_height =obj.height();
        obj = $(elem)[0];
        var raphael_width = svg_original_width*(obj_width/svg_original_width);
        var raphael_height = svg_original_height*(obj_height/svg_original_height);
        var raphael_top = obj.offsetTop;
        var raphael_left = obj.offsetLeft;
        while (obj.offsetParent != undefined) {
            obj = obj.offsetParent;
            if (obj != undefined)
                raphael_top += obj.offsetTop;
            raphael_left += obj.offsetLeft;
        }
      /*  var paper=Raphael(raphael_left,raphael_top,raphael_width,raphael_height);//创建画布
        var attr={
            fill:"#aaa",
            stroke:"#fafafa",
            cursor:"pointer",
            num:"-1",
            region_id:"",
            transform:"matrix("+obj_width/svg_original_width+",0,0,"+obj_width/svg_original_width+",0,0)"
        };
        var elemOption = $(elem).data('mapOption');
        var mapData = null;
            function init(){
                var len=map.length;
                for(var i=0;i<len;i++){
                    paper.path(map[i].path).attr(attr);
                };
                for(var i=0;i<$('svg').length;i++){
                    $($('svg')[i]).attr('id','map_'+i);
                    initParameterAndClick('#map_'+i);
                }
              }
            function initParameterAndClick(svgId){
                $(svgId+' path').attr("transform",attr.transform);
                $(svgId+' path').attr("fill",attr.fill);
                $(svgId+' path').each(function(index, element) {
                    $(this).click(function(e){
                        var id = map[index].id;
                        var name = map[index].name;
                           $(this).attr('fill', elemOption.onClick(map[index].id, map[index].name,e));
                    });
                });
            }
        $(document).ready(function(e) {//加载地域ID
            init();
        });*/
        var elemOption = $(elem).data('mapOption');
        var paper=Raphael(raphael_left,raphael_top,raphael_width,raphael_height);//创建画布
        var attr={
            fill:"#aaa",
            stroke:"#fafafa",
            cursor:"pointer",
            num:"-1",
            region_id:"",
            region_name:"",
            transform:"matrix("+obj_width/svg_original_width+",0,0,"+obj_width/svg_original_width+",0,0)"
        };
        function init(){
            var len=map.length;
            for(var i=0;i<len;i++){
                paper.path(map[i].path).attr(attr);
            };
            for(var i=0;i<$('svg').length;i++){//给每个图加
                $($('svg')[i]).attr('id','map_'+i);
                initParameter('#map_'+i);
                initClick('#map_'+i);
                if(elemOption.url != undefined && elemOption.parameter != undefined && elemOption.url != "" && elemOption.parameter !=''){
                    intiColor('#map_'+i);
                }
            }
        }
        //加载属性
        function initParameter(svgId){
            $(svgId+' path').attr("transform",attr.transform);
            $(svgId+' path').attr("fill",attr.fill);
            $(svgId+' path').attr("region_id",attr.region_id);
            $(svgId+' path').attr("region_name",attr.region_name);
            $(svgId+' path').each(function(index, element) {
                if(elemOption.regionData != undefined && elemOption.regionData != ""){
                    var regionData = elemOption.regionData;
                    if(regionData != null && regionData.length>0){
                        for(var m=0;m<regionData.length;m++){
                            if(map[index].name == regionData[m].count){
                                $(this).attr('region_id',regionData[m].region_id);
                                $(this).attr('region_name',regionData[m].count);
                            }
                        }
                    }
                }else{
                    $(this).attr('region_id',map[index].id);
                    $(this).attr('region_name',map[index].name);
                }
            });
        }
        //点击事件
        function initClick(svgId){
            $(svgId+' path').each(function(index, element) {
                $(this).click(function(e){
                    var id = map[index].id;
                    var name = map[index].name;
                    if(elemOption.regionData != undefined && elemOption.regionData != "" && elemOption.url != undefined && elemOption.parameter != undefined && elemOption.url != "" && elemOption.parameter !=''){
                           elemOption.onClick(index,$(this).attr('region_id'),$(this).attr('region_name'),e);
                    }else{
                        $("path").attr("fill",attr.fill);
                        $(this).attr('fill',elemOption.onClick(index,$(this).attr('region_id'),$(this).attr('region_name'),e));//elemOption.onClick(index,$(this).attr('region_id'),$(this).attr('region_name'),e);
                    }
                });
            });
        }
        //加载高亮
        function intiColor(svgId){
                $.post(elemOption.url,elemOption.parameter,function(data){
                    data = eval("(" +$.trim(data)+ ")").result;
                    if(data.length>0){
                        mapData = data;
                        $(svgId+' path').each(function(index, element) {
                            for(var n=0;n<data.length;n++){
                                if($(this).attr('region_id') == data[n].region_id ){
                                    $(this).attr("num",parseInt(data[n].count));
                                }
                            }
                            var num = $(this).attr("num");
                            if(num<0)
                                return;
                            $(this).attr("fill",elemOption.color($(this).attr("num")));
                        });
                    }
                });
        }
        $(document).ready(function(e) {//加载地域ID
            init();
        });
       /*捕获窗体大小改变事件*/
        var timer;
        $(window).resize(function (){
            window.clearTimeout(timer);
            timer=window.setTimeout(function(){
                changeSize();
            },1000);
        });
        //画布大小改变
        function changeSize(){
            var svg_original_width = 650;//svg文件原始大小
            var svg_original_height = 500;
            var obj =$(elem); //document.getElementById("risk_map");
            var obj_change_width = obj.width();
            var objchange_height = obj.height();
            obj = $(elem)[0];
            //计算画布显示宽高及距离
            var raphael_new_width = svg_original_width*(obj_change_width/svg_original_width);
            var raphael_new_height = svg_original_height*(objchange_height/svg_original_height);
            var raphael_new_top = obj.offsetTop;
            var raphael_new_left = obj.offsetLeft;
            while (obj.offsetParent != undefined) {
                obj = obj.offsetParent;
                if (obj != undefined)
                    raphael_new_top += obj.offsetTop;
                raphael_new_left += obj.offsetLeft;
            }
            //改变画布的显示位置及大小
            paper.setSize(raphael_new_width,raphael_new_height);
            var new_tfm = 'S'+obj_change_width/svg_original_width+','+objchange_height/svg_original_height+',0,0';
            paper.forEach(function(obj){
                obj.transform(new_tfm);
            });
            for(var i=0;i<$('svg').length;i++){
                $($('svg')[i]).attr('id','map_'+i);
                $('#map_'+i).css({'top':raphael_new_top,'left':raphael_new_left});
            }
        }
    }
});

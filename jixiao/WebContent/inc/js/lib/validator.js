function Validator() {
	this.pattern = {
		require :   /.+/,
		email :     /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
		phone :     /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/,
		mobile :    /^((\(\d{2,3}\))|(\d{3}\-))?1\d{10}$/,
		url :       /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/,
		currency :  /^\d+(\.\d+)?$/,
		number :    /^\d+$/,
		zip :       /^[0-9]\d{5}$/,
		qq :        /^[1-9]\d{4,10}$/,
		integer :   /^[-\+]?\d+$/,
		double :    /^[-\+]?\d+(\.\d+)?$/,
		english :   /^[A-Za-z]+$/,
		char :      /^[A-Za-z\d\-_\.]+$/,
		chinese :   /^[\u4e00-\u9fa5]+$/,
		dByteCharacter : /^[^\x00-\xff]+$/,
		username :  /^[a-z\.\w]{3,}$/,
		unSafe :    /^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/,
		spec :      /^\d*(\.\d+)?(\*(\d+(\.\d+)?)?)*$/,
		specDouble :      /^\d+(\.\d+)?\d*(\.\d+)?(\*(\d+(\.\d+)?)?)*$/,
		squr :      /^\d+(\.\d+)?\*\d+(\.\d+)?$/,
		password:   /^[A-Za-z0-9]+$/,
		userCode:   /^[A-Za-z0-9]+$/,
		identityCard:  /^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/,
		positive :  'this.isPositive(_value)',
		safeString : 'this.isSafe(_value)',
		filter :    'this.doFilter(_value,$(elem).attr("accept"))',
		limit :     'this.limit(_value.length,$(elem).attr("min"), $(elem).attr("max"))',
		limitB :    'this.limit(this.LenB(_value), $(elem).attr("min"), $(elem).attr("max"))',
		date :      'this.isDate(_value, $(elem).attr("format"))',
		repeat :    '_value == $("#" + $(elem).attr("to")).val()',
		range :     'this.inRange(_value, $(elem).attr("min"), $(elem).attr("max"))',
		custom :    'this.exec(_value, $(elem).attr("pattern"))',
		select :    'this.isValidSelect(elem)'
	};
	this.errorMsg = '';
	this.error = {
		require :   '"非空的"',
		email :     '"标准的电子邮件，如：username@company.com"',
		phone :     '"标准的电话号码，<br/>区号分隔符必须是-，如：0123-12345678"',
		mobile :    '"标准的11位移动电话号码"',
		url :       '"标准的网址，如：http://www.sina.com.cn"',
		currency :  '"标准的货币格式，如：12.34"',
		number :    '"数字"',
		zip :       '"正确的6位数字编号"',
		qq :        '"4-10位数字"',
		integer :   '"整数"',
		double :    '"浮点数"',
		english :   '"英文字符"',
		char :      '"数字,英文字符,或「_」、「-」、「.」等符号"',
		chinese :   '"中文字符"',
		username :  '"至少三位字母、数字、下划线和「.」的组合并且必须以字母打头"',
		unSafe :    '"不包含不符合安全规则字符"',
		spec :      '"以*分隔的数字格式，如12.3*4.1"',
		specDouble :	'"以*分隔的数字格式，如12.3*4.1或数字"',
		squr :      '"必须是数字*数字的格式，如12.3*4.1"',
		password  : '"请输入规范密码，由数字字母组成"',
		userCode  : '"只能由数字字母组成"',
		identityCard  : '"请输入正确的身份证号码"',
		positive :  '"大于0的正数"',
		safeString : '"符合安全规则的密码"',
		filter :    '"规定的文件，只接受：" + $(elem).attr("accept")',
		limit :     '"规定长度(中文字符只当1位)，至少"+ $(elem).attr("min") +"位并且不超过"+ $(elem).attr("max") +"位"',
		limitB :    '"规定长度(中文字符相当2位)，至少"+ $(elem).attr("min") +"位并且不超过"+ $(elem).attr("max") +"位"',
		date :      '"请填写符合格式要求的日期（yyyy-mm-dd）"',
		repeat :    '"必须与〞"+$("#" + $(elem).attr("to")).attr("dataname")+"〞输入值一致"',
		range :     '"范围之内的数值，<br/>不小于"+ $(elem).attr("min") +"且不大于"+ $(elem).attr("max")',
		custom :    '$(elem).attr("msg")',
		select :    '"请选择合适的选项"'
	};
}
Validator.prototype = {
	check: function (elem) {
		var result = true;
		if (elem) {
			var input = $(elem);
			var type = input.attr('pattern');
			var pattern = this.pattern[type];
			var required = (input.attr('require') == 'true');
			var _value = input.val();
			if(required && $.trim(_value) == ''){
				this.errorMsg = this.error['require'];
				return false;
			}
			if (!required && _value == '') {
				return true;
			}
			if (pattern) {
			}
			else if (required) {
				pattern = this.pattern['require'];
			}
			else {
				return true;
			}
			if (typeof(pattern) == 'string') {
				if (!eval(pattern)) {
					result = false;
				}
				else {
				}
			}
			else if (/function\s+RegExp\(\)/.test(pattern.constructor)) {
				if (!pattern.test(_value)) {
					result = false;
				}
				else {
				}
			}
			if (!result) {
				this.errorMsg = this.error[type];
			}
		}
		return result;
	},
	limit : function(len, min, max) {
		min = min || 0;
		max = max || Number.MAX_VALUE;
		return min <= len && len <= max;
	},
	
	LenB : function(str) {
		return str.replace(/[^\x00-\xff]/g,"**").length;
	},
	
	exec : function(op, regexp) {
		return new RegExp(regexp,"g").test(op);
	},
	
	chineseOperator: {
		NotEqual: '不等于',
		GreaterThan: '大于',
		GreaterThanEqual: '大于等于',
		LessThan: '小于',
		LessThanEqual: '小于等于',
		Equal: '等于'
	},
	compare : function(value1, operator, value2) {
		switch (operator) {
		case "NotEqual":
			return (value1 != value2);
		case "GreaterThan":
			return (value1 >  value2);
		case "GreaterThanEqual":
			return (value1 >= value2);
		case "LessThan":
			return (value1 <  value2);
		case "LessThanEqual":
			return (value1 <= value2);
		default:
			return (value1 == value2); 
		}
	},
	
	MustChecked : function(name, min, max) {
		var groups = document.getElementsByName(name);
		var hasChecked = 0;
		min = min || 1;
		max = max || groups.length;
		
		for(var i=groups.length-1;i>=0;i--)
			if(groups[i].checked)
				hasChecked++;
			
		return min <= hasChecked && hasChecked <= max;
	},
	
	doFilter : function(input, filter) {
		return new RegExp("^.+\.(?=EXT)(EXT)$".replace(/EXT/g, filter.split(/\s*,\s*/).join("|")), "gi").test(input);
	},
	
	isSafe : function(str) {
		return !this.UnSafe.test(str);
	},
	
	inRange : function(value, min, max) {
		if(value == ""){
			return false;
		}else{
			return Number(min) <= Number(value) && Number(value) <= Number(max);
		}
	},
	
	isDate : function(op, format){
		format = format || "y-m-d";
		var m, year, month, day;
		switch(format){
		case "y-m-d" :
			/*m = op.match(new RegExp("^((\\d{4})|(\\d{2}))([-./])(\\d{1,2})\\4(\\d{1,2})$"));
			if(m==null) return false;
			day = m[6];
			month = m[5]*1;
			year = (m[2].length == 4) ? m[2] : GetFullYear(parseInt(m[3], 10));*/
			
			m = op.match(new RegExp("^((\\d{4})|(\\d{2}))-(\\d{1,2})-(\\d{1,2})$"));
			if(m==null) return false;
			day = m[5];
			month = m[4]*1;
			year = (m[2].length == 4) ? m[2] : GetFullYear(parseInt(m[3], 10));
			break;
		case "ymd" :
			/*m = op.match(new RegExp("^((\\d{4})|(\\d{2}))([-./])(\\d{1,2})\\4(\\d{1,2})$"));
			if(m==null) return false;
			day = m[6];
			month = m[5]*1;
			year = (m[2].length == 4) ? m[2] : GetFullYear(parseInt(m[3], 10));*/
			
			m = op.match(new RegExp("^((\\d{4})|(\\d{2}))(\\d{1,2})(\\d{1,2})$"));
			if(m==null) return false;
			day = m[5];
			month = m[4]*1;
			year = (m[2].length == 4) ? m[2] : GetFullYear(parseInt(m[3], 10));
			break;
		case "dmy" :
			/*m = op.match(new RegExp("^(\\d{1,2})([-./])(\\d{1,2})\\2((\\d{4})|(\\d{2}))$"));
			m = op.match(new RegExp("^((\\d{4})|(\\d{2}))(\\d{1,2})(\\d{1,2})$"));
			if( m==null ) return false;
			day = m[1];
			month = m[3]*1;
			year = (m[5].length == 4) ? m[5] : GetFullYear(parseInt(m[6], 10));*/
			
			m = op.match(new RegExp("^(\\d{1,2})(\\d{1,2})((\\d{4})|(\\d{2}))$"));
			if( m==null ) return false;
			day = m[1];
			month = m[2]*1;
			year = (m[4].length == 4) ? m[4] : GetFullYear(parseInt(m[5], 10));
			break;
		default :
			break;
		}
		if(!parseInt(month)) {
			return false;
		}
		month = month==0?12:month;
		var date = new Date(year, month-1, day);
		return typeof(date)=="object" && year==date.getFullYear() && month==(date.getMonth()+1) && day==date.getDate();
		
		function GetFullYear(y) {
			return ((y<30 ? "20" : "19") + y)|0;
		}
	},
	
	isValidEntry : function(marker) {
		return Element.visible(marker);
	},
	
	isValidSelect : function(elem) {
		return elem.value!=''&&elem.selectedIndex!=0;
	},
	
	isPositive : function(value) {
		return value > 0;
	},
	
	ErrorItems : [document.forms[0],0], //form 2 validate and the size of total error items
	getSize : function() {
		return this.ErrorItems[1];
	},
	
	getMessages : function() {
		var _errItem;
		var _msgs = [];
		for(var i in this.ErrorItems) {
			_errItem = this.ErrorItems[i];
			if(_errItem&&_errItem.element) {
				_msgs.push(_errItem.message);
			}
		}
		return _msgs;
	}
};
var validator = new Validator();

function validateForm(target) {
	var result = true;
	var form = $(target).closest('form');
	form.find('input,select').each(function (i, input) {
		var jqInput = $(input);
		var isValid = validator.check(input);
		result = result && isValid;
		if (!isValid) {
			jqInput.parents('.control-group').addClass('error');
			var elem = input;
			var helpInline = jqInput.next('span.help-inline');
			if (helpInline.length === 0) {
				jqInput.after('<span class="help-inline">' + eval(validator.errorMsg) + '</span>');
			}
		}
		jqInput.one('change', null, function () {
			jqInput.parents('.control-group').removeClass('error');
			jqInput.next('span.help-inline').remove();
		});
	});
	return result;
}
function showAlert(msg, timeout, callback) {
	var alertView = $('.alert');
	alertView.html(msg);
	alertView.fadeIn('fast', function () {
		if (!timeout) {
			timeout = 0;
		}
		setTimeout('hideAlert('+ callback + ');', timeout);
	});
}
function hideAlert(callback) {
	if (!callback) {
		callback = function () {};
	}
	var alertView = $('.alert');
	alertView.fadeOut('fast', function () {
		alertView.hide('blind', { direction: 'right' }, 'fast', callback);
	});
}



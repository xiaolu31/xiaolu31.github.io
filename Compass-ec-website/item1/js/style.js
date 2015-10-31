$(function(){
	//nav的定位
	(function(){
	var oUl_1=document.getElementsByClassName("nav_1")[0];
 	var oUl_2=document.getElementsByClassName("nav_2")[0];

 	var aLis_1=oUl_1.getElementsByTagName("li");
 	var aLis_2=oUl_2.getElementsByTagName("li");

 	for(var i=0;i<aLis_1.length;i++){
 		var aLinks_1=aLis_1[i].getElementsByTagName("a")[0];
 		var aLinks_2=aLis_2[i].getElementsByTagName("a")[0];
 		//console.log(aLinks_1);
 		aLinks_1.style.backgroundPosition=(-66*i)+"px"+" 0";
 		aLinks_2.style.backgroundPosition=(-66*(i+5))+"px"+" 0";
 		aLinks_1.onmouseover=function(i){
 			return function(){
 				this.style.backgroundPosition=(-66*i)+"px"+" -70px";
 			}
 		}(i);
 		aLinks_2.onmouseover=function(i){
 			return function(){
 				this.style.backgroundPosition=(-66*(i+5))+"px"+" -70px";
 			}
 		}(i);
 		aLinks_1.onmouseout=function(i){
 			return function(){
 				this.style.backgroundPosition=(-66*i)+"px"+" 0";
 			}
 		}(i);
 		aLinks_2.onmouseout=function(i){
 			return function(){
 				this.style.backgroundPosition=(-66*(i+5))+"px"+" 0";
 			}
 		}(i);
 	}
	})();
	//搜索切换
	(function(){
		var aLis=$("#menu li");
		var arrText=[
		'例如：荷塘鱼烧坊鱼 或 樱花日本料理',
		'例如：昌平区育新站龙旗广场2号楼609室',
		'例如：万达电影院双人情侣票',
		'例如：东莞出事了，大老虎是谁？',
		'例如：北京初春降雪，天气变幻莫测'
		];
		var iNow=0,
		oText=$(".form").find(".txt");
		oText.val(arrText[iNow]);
		aLis.each(function(index){
			$(this).click(function(){
				aLis.attr("class","");
				$(this).attr("class","active");
				iNow=index;
				oText.val(arrText[iNow]);

			})
		});
		oText.focus(function(){
			if($(this).val()==arrText[iNow]){
				$(this).val("");
			}
		});
		oText.blur(function(){
			if($(this).val()==""){
				$(this).val(arrText[iNow]);
			}
		})
	})();
	//update
	(function(){
		var oUl=$(".update ul");
		//console.log(oUl);
		var oDiv=$(".update");
		var iNow=0;
		var arrData = [
			{ 'name':'萱萱', 'time':4, 'title':'那些灿烂华美的瞬间', 'url':'http://www.miaov.com/2013/' },
			{ 'name':'畅畅', 'time':5, 'title':'广东3天抓获涉黄疑犯', 'url':'http://www.miaov.com/2013/#curriculum' },
			{ 'name':'萱萱', 'time':6, 'title':'国台办回应王郁琦', 'url':'http://www.miaov.com/2013/#about' },
			{ 'name':'畅畅', 'time':7, 'title':'那些灿烂华美的瞬间', 'url':'http://www.miaov.com/2013/#message' },
			{ 'name':'萱萱', 'time':8, 'title':'那些灿烂华美的瞬间', 'url':'http://www.miaov.com/2013/' },
			{ 'name':'畅畅', 'time':9, 'title':'广东3天抓获涉黄疑犯', 'url':'http://www.miaov.com/2013/#curriculum' },
			{ 'name':'萱萱', 'time':10, 'title':'国台办回应王郁琦', 'url':'http://www.miaov.com/2013/#about' },
			{ 'name':'畅畅', 'time':11, 'title':'那些灿烂华美的瞬间', 'url':'http://www.miaov.com/2013/#message' }
		];
		var str="";
		for(var i=0;i<arrData.length;i++){
			str+='<li><a href="'+ arrData[i].url +'"><strong>'+ arrData[i].name +'</strong> <span>'+ arrData[i].time +'分钟前</span> 写了一篇新文章：'+ arrData[i].title +'…</a></li>';
		}
		str+=str;
		oUl.html(str);
		var liHeight=oUl.find("li").height();
		var oUl_height=oUl.get(0).offsetHeight;
		var oUl_offsetTop=0,timer;
		var ObtnUp=$("#update_traingle_up");
		var ObtnDown=$("#update_traingle_down");
		//console.log(ObtnUp);
		ObtnUp.click(function(){
			if(iNow==0){
				iNow=-(arrData.length-1);
			}else{
				iNow++
			}
			doMove();
		});
		ObtnDown.click(function(){
			if(iNow==-(arrData.length-1)){
				iNow=0;
			}else{
				iNow--
			}
			doMove();
		});
		oDiv.hover(function(){
			clearInterval(timer);	
		},autoplay);
		function doMove(){
			oUl_offsetTop=oUl.get(0).offsetTop;
			if(oUl_offsetTop<=-oUl_height/2+liHeight){
				iNow=0;
			}
			if(oUl_offsetTop>0){
				iNow=-(arrData.length-1);
			}
			oUl.stop().animate({ 'top':liHeight*iNow }, 2500, 'elasticOut');
			
		}
		function autoplay(){
			timer=setInterval(function(){
				iNow--;
				doMove();
			},3000)
		}
		autoplay();
	})();
	//选项卡切换
	(function(){
		Tab($(".tabNav1"),$(".tabCon1"),"click");
		Tab($(".tabNav2"),$(".tabCon2"),"click");
		Tab($(".tabNav3"),$(".tabCon3"),"mouseover");
		Tab($(".tabNav4"),$(".tabCon4"),"mouseover");
		function Tab(oNav,aCon,sEvent){
			var aLis=oNav.children();
			aCon.hide().eq(0).show();
			aLis.each(function(index){
				$(this).on(sEvent,function(){
					aLis.removeClass("active");
					$(this).addClass("active");
					aLis.find("a").attr("class","traingle_down_gray");
					$(this).find("a").attr("class","traingle_down_red");
					aCon.hide().eq(index).show();

				})
			})
		}
	})();

	//自动播放的焦点图
	(function(){
		var oDiv=$("#fade");
		var oUl_li=oDiv.find("ul li");
		var oOl_li=oDiv.find("ol li");
		var oP=oDiv.find("p");
		var iNow=0,time=null;
		var arr = [ '爸爸去哪儿啦~', '人像摄影中的光影感', '娇柔妩媚、美艳大方' ];
		fnFade();
		autoplay();
		oOl_li.click(function(){
			iNow=$(this).index();
			fnFade();
		});
		oDiv.hover(function(){
			clearInterval(timer);

		},autoplay);
		function fnFade(){
			oUl_li.each(function(index){
				if(index!=iNow){
					$(this).fadeOut().css("zIndex",1);
					oOl_li.eq(index).removeClass("active");
				}else{
					$(this).fadeIn().css("zIndex",2);
					oOl_li.eq(index).addClass("active");
				}
			});
			oP.text(arr[iNow]);
		}
		function autoplay(){
			timer=setInterval(function(){
				iNow++;
				iNow%=arr.length;
				fnFade();

			},1800)
		}
	})();
	//日历提示说明
	(function(){
		var aSpan=$(".calendar h3 span");
		var aImg=$(".calendar .img");
		var oPrompt=$(".today_info");
		var oImg=oPrompt.find("img");
		var oStrong=oPrompt.find("strong");
		var oP=oPrompt.find("p");
		//console.log(aImg);
		aImg.hover(function(){

			var iTop=$(this).parent().position().top-30;
			var iLeft=$(this).parent().position().left+55;
			console.log($(this).parent().offset().left);
			oPrompt.show().css({"left":iLeft,"top":iTop});
			var index=$(this).parent().index()%aSpan.size();
			oP.text($(this).attr("info"));
			oImg.attr("src",$(this).attr("src"));
			oStrong.text(aSpan.eq(index).text());

		},function(){
			oPrompt.hide();
		})

	})();
	//BBS高亮显示
	(function(){
		$(".bbs ol li").mouseover(function(){
			$(".bbs ol li").removeClass("active");
			$(this).addClass("active");
		}) 
	})();
	//HOT区域
	(function(){
		var arr = [
			'',
			'用户1<br />人气1',
			'用户名：性感宝贝<br />区域：朝阳CBD<br />人气：124987',
			'用户3<br />人气3',
			'用户4<br />人气4',
			'用户5<br />人气5',
			'用户6<br />人气6',
			'用户7<br />人气7',
			'用户8<br />人气8',
			'用户9<br />人气9',
			'用户10<br />人气10'
		];
		$(".hot_area li").mouseover(function(){
			if($(this).index()==0) return;
			$(".hot_area li p").remove();
			$(this).append('<p style="width:'+ ($(this).width()-12) +'px; height:'+ ($(this).height()-12) +'px;">'+ arr[$(this).index()] +'</p>');
		})
	})();
});
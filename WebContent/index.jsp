<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

 		*{
            margin: 0px;
            padding: 0px;
        }
        
        .pinglun{
			width: 300px;
			height: 80px
		}
		button{
			
		
		}
		
        li{
            list-style: none;
        }

        .li1{
           background-color: greenyellow;
            width: 150px;
            float: left;
        }
        .li2{
            background-color: orange;
            width: 150px;
            float: right;
        }


</style>
</head>
<body>
<center>
<div>
<button onclick="num(0,0)">全部评论</button>
<button onclick="num(4,0)">好评</button>
<button onclick="num(2,0)">中评</button>
<button onclick="num(1,0)">差评</button>
</div>
<div style="width: 300px;height: 400px;border: black 2px solid">
<div class="pinglun">
		   	 <div style="height: 20px">
			        <ul >
			            <li class="li1">cname</li>
			            <li  class="li2">cline</li>
			        </ul>
		  	</div>
		    <div style="background-color: aqua;height: 40px">cdetail</div>
		    <div style="background-color: tomato;height: 20px">cdate</div>
</div>
</div>
<foot>



<button onclick="guding(0)">首页</button>
<button onclick="fanye(0)">上一页</button>
<span></span> 页/<span></span>页
<button onclick="fanye(5)">下一页</button>
<button onclick="guding(4)">尾页</button>

</foot>

</center>
<script src="js/jquery-3.1.1.js"></script>
<script type="text/javascript">
		/* 分类 */
		$(function(){
			p=0;
			num(0,0);
		});
		
		function num(j,k){
			$.ajax({
             type: "POST",
             url: "CommentServlet?typeId="+j+"&step="+k,
             data: {},
             dataType: "json",
             success: function(res){
            	 		//debugger;
            	 		p=j; 
            	 		n=res.data.countNum;
                         $(".pinglun").html("");
                         var str=""; 
                         $("span:eq(0)").html(res.data.step);
                         $("span:eq(1)").html(res.data.countNum); 
                         console.log(""+res.data);
                         console.log("step"+res.data.num);
                         console.log(res.data.countNum);
                         if(res.msg=="200"){       /* 200加载完毕 */
 
                             var jihe = res.data.listComment;             
                        	if(jihe.length>0){      
                         		for(var i=0; i<jihe.length;i++){
                         			var line=jihe[i].cline;
                         			var lin=xinxin(line);
                         			var detail=jihe[i].cdetail;
                         			var name=jihe[i].cname;
                         			var date=jihe[i].cdate;	                    	
                         			str+="<div class='pinglun'><div style='height: 20px'><ul><li class='li1'>"+name+"</li><li  class='li2'>"+lin+"</li></ul></div><div style='background-color: aqua;height: 40px'>"+detail+"</div><div style='background-color: tomato;height: 20px'>"+date+"</div></div>"
                         		}
                         	}
                           $(".pinglun").append(str);   
                         }
                      }
         	});
		}
		
		/*翻页  */
 		function fanye(k){
				num(p,k);
			
     }
		function guding(k){
			if(k==4){
				num(p,(n-1)*5);
			}else{
				num(p,k);
			}
		}
             
             
		/*星星  */
		function xinxin(line){
            	var xing="★"
                var kx="☆"
	 			if(line==1){
	 				line=xing+kx+kx+kx+kx;
	 			}else if(line ==2){
	 				line=xing+xing+kx+kx+kx;
	 			}else if(line==3){
	 				line=xing+xing+xing+kx+kx;
	 			}
	 			else if(line==4){
	 				line=xing+xing+xing+xing+kx;
	 			}
	 			else if(line==5){
	 				line=xing+xing+xing+xing+xing;
	 			}
				 return line;
		}
		
	

</script>
</body>
</html>
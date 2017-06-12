<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	int i=0;
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>预约</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css">
	
    <script src="${pageContext.request.contextPath}/lib/jquery-1.8.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/javascripts/layer/layer.js" type="text/javascript"></script>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/documents/css/reset.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/css/BeatPicker.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/documents/css/demos.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/documents/css/prism.css"/>
    <script src="${pageContext.request.contextPath}/lib/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/js/BeatPicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/documents/js/prism.js"></script>
    <!-- Demo page code -->
    
    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
        #dt {
			margin: 30px auto;
			height: 28px;
			width: 200px;
			padding: 0 6px;
			border: 1px solid #ccc;
			outline: none;
		}
        
    </style>
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/assets/ico/apple-touch-icon-57-precomposed.png">
  </head>

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7"> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8"> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9"> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
  <body> 
  <!--<![endif]-->
    
    <div class="navbar">
        <div class="navbar-inner">
            <div class="container-fluid">
                <ul class="nav pull-right">
                    
                     <li id="fat-menu" class="dropdown">
                        <a href="#" id="drop3" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i> ${user.name}
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                        	<s:if test="#session.user.type==3">
                        		<li><a tabindex="-1" href="adminservice!edit.action?id=<s:property value="#session.user.id" />">个人信息</a></li>
                        	</s:if>
                            <s:elseif test="#session.user.type==2">
                            	<li><a tabindex="-1" href="teacherservice!edit.action?id=<s:property value="#session.user.id" />">个人信息</a></li>
                            </s:elseif>
                            <s:elseif test="#session.user.type==1">
                            	<li><a tabindex="-1" href="studentservice!edit.action?id=<s:property value="#session.user.id" />">个人信息</a></li>
                            </s:elseif>
                            <li class="divider"></li>
                            <li><a tabindex="-1" href="Login!logout.action">注销</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="index.jsp"><span class="first">实验室</span> <span class="second">预约管理系统</span></a>
            </div>
        </div>
    </div>
    

    <div class="container-fluid">
        
        <div class="row-fluid">
            <div class="span3">
                <div class="sidebar-nav">
                  <div class="nav-header" data-toggle="collapse" data-target="#dashboard-menu"><i class="icon-dashboard"></i>预约管理</div>
                    <ul id="dashboard-menu" class="nav nav-list collapse in">
                        <s:if test="#session.user.type==3">
                        	<li><a href="scancourse?type=2">未审核预约</a></li>
                        	<li><a href="scancourse?type=0">预约记录</a></li>
                        </s:if>
                        <s:if test="#session.user.type==1">
                        	<li><a href="courseservice!book.action">预约</a></li>
                        	<li><a href="scancourse?type=0">预约记录</a></li>
                        </s:if>
                        <s:if test="#session.user.type==2">
                     
                        	<li><a href="scancourse?type=0">预约记录</a></li>
                        </s:if>
                    </ul>
                <div class="nav-header" data-toggle="collapse" data-target="#accounts-menu"><i class="icon-briefcase"></i>查看课表</div>
                <ul id="accounts-menu" class="nav nav-list collapse in">
                  <li ><a href="scancourse?type=1">查看课表</a></li>
                </ul>
                <s:if test="#session.user.type!=1">
				<div class="nav-header" data-toggle="collapse" data-target="#account-menu"><i class="icon-briefcase"></i>人员管理</div>
                <ul id="account-menu" class="nav nav-list collapse in">
                  <s:if test="#session.user.type==3">
                  	<li ><a href="${pageContext.request.contextPath}/admin/addadmin.jsp">增加管理员</a></li>
                  	<li ><a href="scanadmin">管理员管理</a></li>
                  	<li ><a href="${pageContext.request.contextPath}/admin/addteacher.jsp">增加教师</a></li>
                  	<li ><a href="scanteacher">教师管理</a></li>
                  </s:if>
                  <s:if test="#session.user.type==2">
                  	<li ><a href="studentservice!edit.action">设置课代表</a></li>
                  </s:if>
                  <li ><a href="scanstudent">查看课代表</a></li>
                </ul>
                </s:if>
                 <s:if test="#session.user.type==3">
                <div class="nav-header" data-toggle="collapse" data-target="#settings-menu"><i class="icon-exclamation-sign"></i>实验室管理</div>
                <ul id="settings-menu" class="nav nav-list collapse in">
                  <li ><a href="scanroom">实验室管理</a></li>
	              <li ><a href="${pageContext.request.contextPath}/admin/addroom.jsp">添加实验室</a></li>
                </ul>
                </s:if>
            </div>
            
        </div>
        <div class="span9">
            <h1 class="page-title">选择课表</h1>
<div class="well">
        <div class="well search-well">
                <form  action="courseservice!search.action">
                <div class="form-inline">
					<input type="text" data-beatpicker="true" id="dt" placeholder="选择日期" name="date" value="<s:property value="#session.date" />"/>
  					  </div>
					  
						 <div class="form-inline">

                    <label>课节：</label>
                    <select id="courseNo" name="courseNo">
                        <option value="1" selected="selected">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                    
                    <button class="btn" type="submit" id="submit"><i class="icon-search"></i></button>
                   </div>
                    </form>
         </div>
                
        <s:if test="#session.flag==1">
        <table class="table">
      <thead>
        <tr>
          <th>#</th>
          <th>教室名称</th>
          <th>教室位置</th>
          <th>教室状态</th>
          <th>容纳人数</th>
          <th style="width: 26px;"></th>
        </tr>
      </thead>
      <tbody>
        <s:iterator value="#session.rooms" id="infos">
      		<tr>
	      		<td><%=++i%></td>
	      		<td><a href="roomservice!edit.action?id=<s:property value="#infos.id" />"><s:property value="#infos.name" /></a></td>
				<td><s:property value="#infos.location" /></td>
	          	<td>
	          		<s:if test="#infos.state==0">可预约</s:if>
	          		<s:if test="#infos.state==1">不可预约</s:if>
	          	</td>
	          	<td><s:property value="#infos.stuNum" /></td>
	          	<s:if test="#infos.state==0">
	          	<td>
		            <a href="#myModal" role="button" data-toggle="modal" onclick="keep(<s:property value="#infos.id" />)"><i class="icon-ok"></i></a>
		        </td>
		        </s:if>
			</tr>
		</s:iterator>
      </tbody>
    </table>
       
        </div>
        <div class="pagination">
    <ul>
		<s:if test="#request.roomPage.hasPrePage==true">
		<li><a href="courseservice!frontPage.action?currentPage=<s:property value="roomPage.currentPage" />" class="btu">上一页</a></li>
		</s:if>
		<li><a href="#" class="btu active"><s:property value="roomPage.currentPage" /></a></li>
		<s:if test="#request.roomPage.currentPage+1<=#request.roomPage.totalPage">
		<li><a href="courseservice!nextPage.action?currentPage=<s:property value="roomPage.currentPage" />" class="btu"><s:property value="roomPage.currentPage+1" /></a></li>
		</s:if>
		<s:if test="#request.roomPage.currentPage+2<=#request.roomPage.totalPage">
		<li><a href="courseservice!nextPage.action?currentPage=<s:property value="roomPage.currentPage+1" />" class="btu"><s:property value="roomPage.currentPage+2" /></a></li>
		</s:if>
		<s:if test="#request.roomPage.currentPage+3<=#request.roomPage.totalPage">
		<li><a href="courseservice!nextPage.action?currentPage=<s:property value="roomPage.currentPage+2" />" class="btu"><s:property value="roomPage.currentPage+3" /></a></li>
		</s:if>
		<s:if test="#request.roomPage.hasNextPage==true">
		<li><a href="courseservice!nextPage.action?currentPage=<s:property value="roomPage.currentPage" />" class="btu">下一页</a></li>
		</s:if>
    </ul>
</div>
 </s:if>
</div>


        </div>
    </div>
    

    
   <footer>
        <hr>
        <p class="pull-right">Copyright <a title="重庆邮电大学" target="_blank">重庆邮电大学</a></p>
        <p>&copy; 2017 <a>重庆邮电大学</a></p>
    </footer>
    

    

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
    $("#submit").click(function(){
    	if($("#dt").val().length==0)
    	{
    		layer.msg('请选择时间！', {icon: 2});
    		return false;
    	}
    	if($("#course").val().length==0)
    	{
    		layer.msg('请输如课节！', {icon: 2});
    		return false;
    	}
    });
	function keep(id)
	{
		$.post("courseservice!keep.action",{'id':id,'courseNo':$('#courseNo').val(),'date':$('#dt').val()},function(result){
			if(result.stateCode==1){
				window.location.href='${pageContext.request.contextPath}/pub/editcourse.jsp';
			}else{
				layer.msg('预约失败：'+result.message, {icon: 2});
			}
		},"json");
	}
	$(function(){
		$('#courseNo').val(<s:property value="#session.courseNo" />);
	})
    </script>
    
    
    
    
    
    
    
    
    
    
    

  </body>
</html>



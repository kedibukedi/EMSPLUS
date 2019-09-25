<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" import="java.util.*" isELIgnored="false" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>update Emp</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css"
		  href="${pageContext.request.contextPath}/css/style.css" />
	<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
	<script type="application/javascript">
        $(function () {
            //查询所有部门
            $.ajax({
                url:"${pageContext.request.contextPath}/Dept/selectDep.go",
                type:"GET",
                dataType:"json",
                success:function (depts) {
                    //遍历部门数据渲染
                    for (var i=0;i<depts.length;i++){
                        var option=$("<option value='"+depts[i].id+"'>"+depts[i].department_name+"</option>")
                        if(depts[i].id==${emp.did}){
                            option.prop("selected","selected");
                        }
                        //把option标签放入select标签中
                        $("#dept").append(option);
                    }
                }
            });
        })
	</script>
</head>

<body>
<div id="wrap">
	<div id="top_content">
		<div id="header">
			<div id="rightheader">
				<p>
					<fmt:formatDate value="<%=new Date()%>"></fmt:formatDate>
					<br />
				</p>
			</div>
			<div id="topheader">
				<h1 id="title">
					<a href="#">Main</a>
				</h1>
			</div>
			<div id="navigation">
			</div>
		</div>
		<div id="content">
			<p id="whereami">
			</p>
			<h1>
				update Emp info:
			</h1>
			<form action="${pageContext.request.contextPath}/emp/update.go" method="post" enctype="multipart/form-data">
				<table cellpadding="0" cellspacing="0" border="0"
					   class="form_table">
					<tr>
						<td valign="middle" align="right">
							id:

						</td>
						<td valign="middle" align="left">
							<input type="text" readonly="readonly" class="inputgri" name="id" value="${requestScope.emp.id}"/>

						</td>
					</tr>
					<tr>
                        <td valign="middle" align="right">
                            头像:
                        </td>
                        <td valign="middle" align="left">
                        <img width="40px" height="40px" src="${pageContext.request.contextPath}/shangchuan/${requestScope.emp.headlike}" />
                            <input type="file" name="upload" />
                        </td>
                    </tr>
					<tr>
						<td valign="middle" align="right">
							用户名:
						</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="empname" value="${requestScope.emp.empname}"/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							工资:
						</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="salary" value="${requestScope.emp.salary}"/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							年龄:
						</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="age" value="${requestScope.emp.age}"/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							部门:
						</td>
						<td valign="middle" align="left">
							<select id="dept" name="did"></select>
						</td>
					</tr>
				</table>
				<p>
					<input type="submit" class="button" value="修改" />
				</p>
			</form>
		</div>
	</div>
	<div id="footer">
		<div id="footer_bg">
			ABC@126.com
		</div>
	</div>
</div>
</body>
</html>
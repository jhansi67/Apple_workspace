<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>

<%!int i =0; %>

<style>

li
{
color: transparent;


}


.middle_main{
      background: none repeat scroll 0 0 #fff;
    float: left;
    margin-right: 1%;
    padding: 10px;
    width: 75%; border-radius: 3px;}
.feed_main {
    float: left;
    height: 458px;
    overflow: hidden;
    width:100%;
}

.yammer_head{width:100%;float:left;}
.yamr_img{background:url('../images/yammer_icon.png') no-repeat;width:28px;height:28px;float:right;}
.yammer_text{ float: left;
    font-family: segoe ui;
    padding: 6px 10px;
    font-size: 16px;
font-weight: bold;
    }

.right_feed {
float: right;
width: 90%;
height: 127px;

}

.txt_feed{color: #0056d2;
float: left;
font-family: segoe ui;
font-size: 13px;
font-weight: bold;}

.txt_feed_left{color: #0056d2;
float: right;
font-family: segoe ui;
font-size: 13px;
font-weight: bold;}



.post_text{ color: #333;
    float: left;
    padding: 5px 0;
    width: 100%;}
    
.sub_txt {
color: #827a7a;
font-size: 12px;
height: 45px;
line-height: 17px;
overflow: hidden;
padding: 0 0 3px;
width: 80%;
text-overflow: ellipsis;
white-space: pre-line;
background-color:pink;
/*text-align: justify;*/
}

.yamr_feed {
float: left;
margin: 4px 4px;
padding: 12px 0.4px 5px;
width: 100%;


}







</style>
<script>

var req;

function onsubmitcomment(data,data2,event){
	
	if(event.which == 13)
		{
	
	   var posttosend = data2;

	  alert(posttosend);
	
	var descript = data;
	alert(descript);
	 	req=new XMLHttpRequest();
	  var url="tostorecomment.html?posttosend="+posttosend+"&description="+descript;
	  alert(url);	
	  req.onreadystatechange= getResponse;//This implies that whenever state changes, getResponse is called.
		req.open("GET", url, true);	//Here it is calling the servlet, so this will change the state and hence call getResponse.
	
		req.send(null);  }

}

function getResponse(){
	
		if (req.readyState==4) // if request is complete
			{

			alert("added successfully......");
			var s = req.responseText.toString().split(",");
			
		
		var x = s[0];
		var y = s[1];
		var z = s[2];
		  var ul = document.getElementById(s[3]);
		  var li = document.createElement("li");
		  var s = document.createElement("span");
		  s.innerHTML ="<div class='right_feed'> <img src='https://mug0.assets-yammer.com/mugshot/images/48x48/MDsBPCsCt-QVknJmXp6r95Sd9ZmzpljM' /> <div class='right_feed'><span class='txt_feed'>"+x+" </span><span class='txt_feed_left'> "+z+"</span> <p class='sub_txt'>"+y+"</p></div>";
		 li.appendChild(s);	 ul.appendChild(li); 
	
			}
}

function onsubmitpost(data,event){
	
	if(event.which == 13)
	{alert("dcsvuhvbsvcuj");
	
	alert("i m here"); alert(data)
	var descript = data;
	alert(descript);
	 	req=new XMLHttpRequest();
		
	  var url="tostorepost.html?description="+descript;
	  alert(url);	
	  req.onreadystatechange= getResponse123;//This implies that whenever state changes, getResponse is called.
		req.open("GET", url, true);	//Here it is calling the servlet, so this will change the state and hence call getResponse.
		//alert(source);
		req.send(null); 
		//alert(source);  
	}
	
}

function getResponse123(){
	
		if (req.readyState==4) // if request is complete
			{

			alert("added successfully......");
			var s = req.responseText.toString().split(",");
			
		alert(s[3]);
	
						//	document.getElementById("idForPost").innerHTML=s[0]+" "+s[1]+" "+s[2]+" "+s[3]+"<hr/>";	
							
							var x = s[0];
							var y = s[1];
							var z = s[2];
							  var ul = document.getElementById("idForPost");
							  var li = document.createElement("li");
							  var s = document.createElement("span");
							  s.innerHTML ="<div class='right_feed'> <img src='https://mug0.assets-yammer.com/mugshot/images/48x48/MDsBPCsCt-QVknJmXp6r95Sd9ZmzpljM' /> <div class='right_feed'><span class='txt_feed'>"+x+" </span><span class='txt_feed_left'> "+z+"</span> <p class='sub_txt'>"+y+"</p></div>";
							 li.appendChild(s);	 ul.appendChild(li); 
							
							
							var x = document.getElementById("descpost");
							x.setAttribute('type','hidden');
							var y = document.getElementById("newcomment");
							y.setAttribute('type','text');
							y.setAttribute('id',s[3]);
							var z = document.getElementById("spanele");
							z.setAttribute('id',s[3]);
						alert(	z.getAttribute('id'));
							
			
			}
}




</script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<!-- 

<input type="text" id="descpost" value="" onBlur="onsubmitpost(this.value)"/>
<ul id="idForPost"></ul>
<input type="hidden" id="newcomment" value="" onBlur="onsubmitcomment(this.value,this.id)" />
<ul id="spanele"></ul> -->

<br/><br/>


<article class="middle_main">
           
              <div class="yammer_head">
                <span class="yammer_text">Announcements</span>
               <span class="yamr_img">rgeeeeeeeeeeee</span>
              </div> 
              <div class="feed_main">
              
              
              <div class="right_feed">
               
               
                <img src="https://mug0.assets-yammer.com/mugshot/images/48x48/MDsBPCsCt-QVknJmXp6r95Sd9ZmzpljM" alt="img">
                  <div class="right_feed">
                   <span class="txt_feed"> <c:out value='${entry123.name}'/></span>
                   
   <input type="text" id="descpost" value="" onkeypress="onsubmitpost(this.value,event)" style="width: 100%;height:50px;line-height:6px;"/>
<ul id="idForPost"></ul>      </div>
              </div>


              
<c:forEach items="${askobject}" var="entry" begin="0" end="1000" step="1">


 <div class="yamr_feed" ><ul id="<c:out value='${entry.key.postId}'/>">
                 <img src="https://mug0.assets-yammer.com/mugshot/images/48x48/MDsBPCsCt-QVknJmXp6r95Sd9ZmzpljM" alt="img">
                  <div class="right_feed">
                   <span class="txt_feed"><c:out value='${entry.key.name}'/></span>
                    <span class="txt_feed_left"><c:out value='${entry.key.dateCreated}'/></span>
                <%--    <p class="post_text"><i>Posted on</i> <c:out value='${entry.key.dateCreated}'/> </p> --%>
                   <p class="sub_txt">

   <c:out value='${entry.key.description}'/></p>
                 </div>
              </div><c:forEach items="${entry.value}" var="entry123">
              <li>
           
               <div class="right_feed">
               
               
                <img src="https://mug0.assets-yammer.com/mugshot/images/48x48/MDsBPCsCt-QVknJmXp6r95Sd9ZmzpljM" alt="img">
                  <div class="right_feed">
                   <span class="txt_feed"> <c:out value='${entry123.name}'/></span>
                    <span class="txt_feed_left">   <c:out value='${entry123.dateCreated}'/></span>
                <%--    <p class="post_text"><i>Posted on</i> <c:out value='${entry.key.dateCreated}'/> </p> --%>
                   <p class="sub_txt">

     <c:out value='${entry123.description}'/></p>
                 </div>
              </div>
              </li>
               
               
               
               
               
               


  </c:forEach></div>
  <%i++;
 %>
<%-- <span id="<c:out value='${entry.key.postId}'/>"></span> --%>

<div class="right_feed">
               
               
                <img src="https://mug0.assets-yammer.com/mugshot/images/48x48/MDsBPCsCt-QVknJmXp6r95Sd9ZmzpljM" alt="img">
                  <div class="right_feed">
                   <span class="txt_feed"> <c:out value='${entry123.name}'/></span>
                   
    <input type="text" id="desc" value="" onkeypress="onsubmitcomment(this.value,${entry.key.postId},event)" style="width: 100%;height:50px;line-height:6px;"/>
                 </div>
              </div>

<br/>

 
  <input type="text" value="${entry.key.postId}"  id="postidajax"/>
  <hr/><hr/></ul>
</c:forEach>

<br/><br/><br/><br/><br/>

</body>
</html>
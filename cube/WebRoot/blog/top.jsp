<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="header">
    <div class="container">
        <div class="logo">
            <a href="index.html"><h1>undetermined2</h1></a>
        </div>
        <div class="pages">
            <ul>
                <li><a class="active" href="index.html">undetermined4</a></li>
                <li><a href="3dprinting.html">undetermined3</a></li>

            </ul>
        </div>
        <div class="navigation">
            <ul>
                <li><a href="contact.html">Advertise</a></li>
                <li><a href="about.html">About Us</a></li>
                <li><a class="active" href="contact.html">Contact Us</a></li>
            </ul>
        </div>
        <div class="clearfix"></div>
    </div>
</div>

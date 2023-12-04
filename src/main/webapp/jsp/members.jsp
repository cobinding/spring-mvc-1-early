<%@ page import="java.util.List" %>
<%@ page import="com.example.helloservlet.domain.member.Member" %>
<%@ page import="com.example.helloservlet.domain.member.MemberRepository" %><%--
  Created by IntelliJ IDEA.
  User: sebinchu
  Date: 2023/12/04
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  MemberRepository memberRepository = MemberRepository.getInstance();
  List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
  <thead>
  <th>id</th>
  <th>username</th>
  <th>age</th>
  </thead>
  <tbody>
  <%
    for (Member member : members) {
      out.write("    <tr>\n");
      out.write("              <td>" + member.getId() + "</td>");
      out.write("              <td>" + member.getUsername() + "</td>");
      out.write("              <td>" + member.getAge() + "</td>");
      out.write("    <tr>\n");
    }
    %>
  </tbody>
</table>
</body>
</html>
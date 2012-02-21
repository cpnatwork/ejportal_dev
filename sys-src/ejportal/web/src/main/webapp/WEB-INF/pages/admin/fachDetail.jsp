<%--
  Created by IntelliJ IDEA.
  User: ev55esul
  Date: 05.08.2010
  Time: 17:48:44
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Fach></title>
    <meta name="heading" content="Fach"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>

<s:url action="editFach" var="fachEdit">
    <s:param name="fachId" value="%{fach.fachId}"/>
</s:url>
<s:url action="deleteFach" var="fachDelete">
    <s:param name="fachId" value="%{fach.fachId}"/>
</s:url>

<div class="userActions">
  <a class="small gray awesome" onClick ="window.location.href='${fachEdit}'">Fach umbenennen</a> <br /><br />
  <a class="small gray awesome" onClick ="if (confirm('Fach wirklich entfernen? Das Fach wird von allen Journals entfernt.')) window.location.href='${fachDelete}';">Fach entfernen</a> <br /><br />  
</div>


<s:push value="fach">
    Fachname:       <s:property value="fachName" />
</s:push>
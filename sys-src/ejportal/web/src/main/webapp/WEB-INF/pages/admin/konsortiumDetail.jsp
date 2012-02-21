<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 03.08.2010
  Time: 15:39:58
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Konsortium</title>
    <meta name="heading" content="Konsortium"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>


<s:url action="editKonsortium" var="konsortiumEdit">
    <s:param name="konsortiumId" value="%{konsortium.konsortiumId}"/>
</s:url>
<s:url action="deleteKonsortium" var="konsortiumDelete">
    <s:param name="konsortiumId" value="%{konsortium.konsortiumId}"/>
</s:url>

<div class="userActions">
  <a class="small gray awesome" onClick ="window.location.href='${konsortiumEdit}'">Konsortium umbenennen</a> <br /><br />
  <a class="small gray awesome" onClick ="if (confirm('Konsortium wirklich entfernen?')) window.location.href='${konsortiumDelete}';">Konsortium entfernen</a> <br /><br />
</div>


<s:push value="konsortium">
    Konsortium:       <s:property value="konsortiumName" />
</s:push>



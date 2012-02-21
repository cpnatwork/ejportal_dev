<%--
  Created by IntelliJ IDEA.
  User: Janine
  Date: 19.07.2010
  Time: 13:44:36
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Paket</title>
    <meta name="heading" content="Paket von '<s:property value="journal.titel"/>' " />
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>


<s:push value="journal">
    Name des Pakets:  <s:property value="paket.paketName" />    <br>
</s:push>

<br><br>
<s:url action="searchPaket"  var="paketChange">
    <s:param name="id" value="%{journal.id}"/>
</s:url>
<a href="${paketChange}">Anderes Paket w&auml;hlen</a>

<br><br>
<s:url action="showJournalDetail" var="back">
    <s:param name="id" value="%{journal.id}"/>
</s:url>
<a href="${back}">zur&uuml;ck zum Journal</a>
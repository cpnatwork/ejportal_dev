<%--
  Created by IntelliJ IDEA.
  User: Tselmeg
  Date: 03.08.2010
  Time: 13:30:19
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Paket></title>
    <meta name="heading" content="Paket"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>

<s:url action="editPaket" var="paketEdit">
    <s:param name="paketId" value="%{paket.paketId}"/>
</s:url>
<s:url action="deletePaket" var="paketDelete">
    <s:param name="paketId" value="%{paket.paketId}"/>
</s:url>

<div class="userActions">
  <a class="small gray awesome" onClick ="window.location.href='${paketEdit}'">Paket umbenennen</a> <br /><br />
  <a class="small gray awesome" onClick ="if (confirm('Paket wirklich entfernen?')) window.location.href='${paketDelete}';">Paket entfernen</a> <br /><br />
</div>


<s:push value="paket">
    Paketname:       <s:property value="paketName" />
</s:push>




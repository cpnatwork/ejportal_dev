<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 09.08.2010
  Time: 13:04:46
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>


<head>
    <title>Lieferant</title>
    <meta name="heading" content="Besteller des Exemplars" />
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>
<jsp:include page="/common/exemplarMenu.jsp"/>

<authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE">

<s:url value="/admin/searchBesteller.html" var="bestellerChange">
    <s:param name="exemplarId" value="%{exemplarId}"/>
    <s:param name="journalId" value="%{journalId}"/>
</s:url>

<div class="userActions">
    <a class="small gray awesome" onClick ="window.location.href='${bestellerChange}'">Anderen Besteller w&auml;hlen</a> <br /><br />
  <br>
</div>

</authz:authorize>


<s:push value="exemplar">
    Besteller:  <s:property value="besteller.name" />    <br>
    Bibliothek: <s:property value="besteller.bibliothek" />    <br>
    Fakult&auml;t: <s:property value="besteller.fakultaet" />    <br>
    pers. Email: <s:property value="besteller.persEmail" />    <br>
    Ansprechpartner 1: <s:property value="besteller.bibAnsprechpartner1" /> <br>
    Ansprechpartner 2: <s:property value="besteller.bibAnsprechpartner2" />    <br>

    <br>

</s:push>
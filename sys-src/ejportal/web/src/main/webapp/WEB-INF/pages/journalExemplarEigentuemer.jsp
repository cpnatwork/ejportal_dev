<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 09.08.2010
  Time: 13:04:57
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>


<head>
    <title>Eigent&uuml;mer</title>
    <meta name="heading" content="Eigent&uuml;mer des Exemplars" />
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>
<jsp:include page="/common/exemplarMenu.jsp"/>


<authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE">

<%--<s:url action="searchEigentuemer" var="eigentuemerChange" escapeAmp="false">
    <s:param name="exemplarId" value="%{exemplarId}"/>
    <s:param name="journalId" value="%{journalId}"/>
</s:url>--%>

<s:url value="/admin/searchEigentuemer.html"var="eigentuemerChange">
    <s:param name="exemplarId" value="%{exemplarId}"/>
    <s:param name="journalId" value="%{journalId}"/>
</s:url>

<div class="userActions">
    <a class="small gray awesome" onClick ="window.location.href='${eigentuemerChange}'">Anderen Eigent&uuml;mer w&auml;hlen</a> <br /><br />
  <br>
</div>

</authz:authorize>


<s:push value="exemplar">
    Eigent&uuml;mer:  <s:property value="eigentuemer.name" />    <br>
    Bibliothek: <s:property value="eigentuemer.bibliothek" />    <br>
    Fakult&auml;t: <s:property value="eigentuemer.fakultaet" />    <br>
    pers. Email: <s:property value="eigentuemer.persEmail" />    <br>
    Ansprechpartner 1: <s:property value="eigentuemer.bibAnsprechpartner1" /> <br>
    Ansprechpartner 2: <s:property value="eigentuemer.bibAnsprechpartner2" />    <br>

    <br>

</s:push>
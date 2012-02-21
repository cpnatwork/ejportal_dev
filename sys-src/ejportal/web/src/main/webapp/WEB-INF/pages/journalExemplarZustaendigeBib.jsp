<%--
  Created by IntelliJ IDEA.
  User: uj32uvac
  Date: 09.08.2010
  Time: 14:41:34
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 09.08.2010
  Time: 13:04:57
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>


<head>
    <title>Zust&auml;ndige Bibliothek</title>
    <meta name="heading" content="Zust&auml;ndige Bibliothek des Exemplars" />
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>
<jsp:include page="/common/exemplarMenu.jsp"/>


<authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE">

<s:url value="/admin/searchZustaendigeBib.html" var="zustaendigeBibChange">
    <s:param name="exemplarId" value="%{exemplarId}"/>
    <s:param name="journalId" value="%{journalId}"/>
</s:url>

<div class="userActions">
    <a class="small gray awesome" onClick ="window.location.href='${zustaendigeBibChange}'">Andere zust&auml;ndige Bibliothek w&auml;hlen</a> <br /><br />
  <br>
</div>

</authz:authorize>

<s:push value="exemplar">
    Name:  <s:property value="zustaendigeBib.name" />    <br>
    Bibliothek: <s:property value="zustaendigeBib.bibliothek" />    <br>
    Fakult&auml;t:   <s:property value="zustaendigeBib.fakultaet" />    <br>
    pers. Email: <s:property value="zustaendigeBib.persEmail" />    <br>
    Ansprechpartner 1: <s:property value="zustaendigeBib.bibAnsprechpartner1" />    <br>
    Ansprechpartner 2: <s:property value="zustaendigeBib.bibAnsprechpartner2" />    <br>
</s:push>
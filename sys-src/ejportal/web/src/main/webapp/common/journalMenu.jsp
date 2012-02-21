<%--
  Created by IntelliJ IDEA.
  User: Stefan
  Date: Aug 5, 2010
  Time: 10:10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>

<b>
<hr/><h1>${titel}</h1> <hr/>    
<authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE,ROLE_PROJECT">
<s:url value="/showJournalDetail.html" var="journalSelect">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>
<s:url value="/showVerlagForJournal.html" var="verlagSelect" >
    <s:param name="journalId" value="%{journalId}"/>
</s:url>
<s:url value="/showProviderForJournal.html" var="providerSelect">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>
<s:url value="/showFachForJournal.html" var="fachSelect">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>
<s:url value="/showExemplarForJournal.html" var="exemplarSelect">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>
<s:url value="/showBibliotheksmitarbeiterForJournal.html" var="bibliotheksmitarbeiterSelect">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>
<s:url value="/showEzbDatenForJournal.html" var="ezbDatenSelect">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>
<s:url value="/project/showProjectCockpit.html" var="projektSelect">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>



    <a href="${journalSelect}">Journal</a>
    |
    <a href="${verlagSelect}">Verlag</a>
    |
    <a href="${providerSelect}">Provider</a>
    |
    <a href="${fachSelect}">F&auml;cher</a>
    |
    <a href="${exemplarSelect}">Exemplare</a>
    |
    <a href="${bibliotheksmitarbeiterSelect}">Bibliothek</a>
    |
    <a href="${ezbDatenSelect}">EZB Daten</a>
    |
    <a href="${projektSelect}">Projekt</a>



<br><br>
<hr/>
</authz:authorize>
</b>



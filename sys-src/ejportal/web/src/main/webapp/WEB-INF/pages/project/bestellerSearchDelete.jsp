<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 11.08.2010
  Time: 10:24:31
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Besteller w&auml;hlen</title>
    <meta name="heading" content="Besteller Suche"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>

<s:url value="/project/showProjectBestellerCreateForm.html" var="bestellerCreate" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
    <s:param name="interesseId" value="%{interesseId}"/>
    <s:param name="bestellerId" value="%{bestellerId}"/>
</s:url>

<div class="userActions">
    <a class="small gray awesome" onClick ="window.location.href='${bestellerCreate}'">Neuen Besteller erstellen</a> <br /><br />
</div>

<h1>Bitte w&auml;hlen Sie einen Besteller aus:</h1>

<s:form id="bestellerSearchForm" action="listProjectBestellerDelete" method="post" validate="true">

    <s:hidden name="journalId" value="%{journalId}"/>
    <s:hidden name="interesseId" value="%{interesseId}"/>
    <s:textfield label="Name" key="bestellerSearchTO.bestellerName" cssClass="text medium"/>
    <s:textfield label="Projekt" key="bestellerSearchTO.projekt" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="search" key="button.search" theme="simple"/>
    </li>
</s:form>

<s:url value="/project/showProjectCockpit.html" var="back" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>
<a href="${back}">zur&uuml;ck zur Projekt&uuml;bersicht</a>

<script type="text/javascript">
    Form.focusFirstElement($("bestellerSearchForm"));
</script>
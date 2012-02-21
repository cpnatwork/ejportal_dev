<%--
  Created by IntelliJ IDEA.
  User: Tselmeg
  Date: 10.08.2010
  Time: 11:15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Rechnung bearbeiten</title>
    <meta name="heading" content="Rechnung"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>

<s:url value="/project/deleteRechnung.html" var="rechnungDelete" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
    <s:param name="rechnungId" value="%{rechnungId}"/>
</s:url>
<div class="userActions">
    <a class="small gray awesome" onClick ="if (confirm('Rechnung wirklich entfernen?')) window.location.href='${rechnungDelete}'">Rechnung entfernen</a> <br /><br />
</div>

<s:form id="rechnungForm" action="editRechnung" method="post" validate="true">
    <s:hidden name="rechnungBaseTO.rechnungId" value="%{rechnungBaseTO.rechnungId}"/>
    <s:hidden name="journalId" value="%{journalId}"/>
    <s:textfield label="Betrag" key="rechnungBaseTO.betrag" required="true" cssClass="text medium"/>
    <s:textfield label="Bezugsform" key="rechnungBaseTO.bezugsform" required="true" cssClass="text medium"/>
    <s:textfield label="Bezugsjahr" key="rechnungBaseTO.bezugsjahr"  required="true" cssClass="text medium"/>


    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" label="Speichern" key="button.save" theme="simple"/>
    </li>

</s:form>

<s:url value="/project/showProjectCockpit.html" var="projectSelect">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>
<a href="${projectSelect}">zur&uuml;ck zur Projekt&uuml;bersicht</a>

<script type="text/javascrsipt">
    Form.focusFirstElement($("rechnungForm"));
</script>
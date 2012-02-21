<%--
  Created by IntelliJ IDEA.
  User: Nina
  Date: 10.08.2010
  Time: 09:39:17
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Nutzung bearbeiten</title>
    <meta name="heading" content="Nutzung"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>

<s:form id="nutzungForm" action="editNutzung" method="post" validate="true">
    <s:hidden name="journalId" value="%{journalId}"/>
    <s:hidden name="nutzungId" value="%{nutzungId}"/>
    <s:textfield label="Zugriffe" key="nutzung.zugriffe" required="true" cssClass="text medium"/>
    <s:textfield label="Zeitraum" key="nutzung.zeitraum" required="true" cssClass="text medium"/>
    <s:textfield label="Nutzungsjahr" key="nutzung.nutzungsjahr" required="true" cssClass="text medium"/>
    <s:textfield label="Rechnungsbetrag" key="nutzung.rechnungsbetrag" required="true" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" label="Speichern" key="button.save" theme="simple"/>
    </li>

</s:form>


<s:url action="showNutzungDetail" var="back">
    <s:param name="journalId" value="%{nutzung.journal.id}"/>
</s:url>
<a href="${back}">zurueck zum Journal</a>

<script type="text/javascrsipt">
    Form.focusFirstElement($("nutzungForm"));
</script>
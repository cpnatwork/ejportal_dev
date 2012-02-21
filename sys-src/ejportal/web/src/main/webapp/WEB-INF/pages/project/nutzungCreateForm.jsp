<%--
  Created by IntelliJ IDEA.
  User: Nina
  Date: 10.08.2010
  Time: 09:38:53
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Neue Nutzung anlegen</title>
    <meta name="heading" content="Neue Nutzung"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>

<s:form id="nutzungForm" action="createNutzung" method="post" validate="true">
    <s:hidden name="journalId" value="%{journalId}"/>
    <s:textfield label="Zugriffe" key="nutzung.zugriffe" required="true" cssClass="text medium"/>
    <s:textfield label="Zeitraum" key="nutzung.zeitraum" required="true" cssClass="text medium"/>
    <s:textfield label="Nutzungsjahr" key="nutzung.nutzungsjahr" required="true" cssClass="text medium"/>
    <s:textfield label="Rechnungsbetrag" key="nutzung.rechnungsbetrag" required="true" cssClass="text medium"/>
    
    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" label="Speichern" key="button.save" theme="simple"/>
    </li>
</s:form>

<s:url value="/project/showProjectCockpit.html" var="projectSelect">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>
<a href="${projectSelect}">zur&uuml;ck zur Projekt&uuml;bersicht</a>

<script type="text/javascript">
    Form.focusFirstElement($("nutzungForm"));
</script>
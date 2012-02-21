<%--
  Created by IntelliJ IDEA.
  User: Tselmeg
  Date: 10.08.2010
  Time: 11:14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Neue Rechnung anlegen</title>
    <meta name="heading" content="Neue Rechnung"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>

<s:form id="rechnungForm" action="createRechnung" method="post" validate="true">
    <s:hidden key="rechnungBaseTO.rechnungId" />
    <s:hidden name="journalId" value="%{journalId}"/>
    <s:hidden name="exemplarId" value="%{exemplarId}"/>
    <s:textfield label="Betrag" key="rechnungBaseTO.betrag" required="true" cssClass="text medium"/>
    <s:textfield label="Bezugsform" key="rechnungBaseTO.bezugsform" required="true" cssClass="text medium"/>
    <s:textfield label="Bezugsjahr" key="rechnungBaseTO.bezugsjahr" required="true" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" label="Speichern" key="button.save" theme="simple"/>
    </li>
</s:form>

<s:url value="/project/showProjectCockpit.html" var="projectSelect">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>
<a href="${projectSelect}">zur&uuml;ck zur Projekt&uuml;bersicht</a>

<script type="text/javascript">
    Form.focusFirstElement($("rechnungForm"));
</script>

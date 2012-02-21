<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 10.08.2010
  Time: 13:08:13
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Interesse bearbeiten</title>
    <meta name="heading" content="Interesse"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>



<s:form id="interesseForm" action="createInteresse" method="post" validate="true">
    <s:hidden name="journalId" value="%{journalId}"/>
    <s:hidden name="interesseBaseTO.interesseId" value="%{interesseBaseTO.interesseId}"/>
    <s:textfield label="Interesse" key="interesseBaseTO.interesse" required="true" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" label="Speichern" key="button.save" theme="simple"/>
    </li>

</s:form>

<s:url value="/project/showProjectCockpit.html" var="back" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>
<a href="${back}">zur&uuml;ck zur Projekt&uuml;bersicht</a>

<script type="text/javascrsipt">
    Form.focusFirstElement($("interesseForm"));
</script>
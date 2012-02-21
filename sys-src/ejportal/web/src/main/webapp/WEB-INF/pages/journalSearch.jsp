<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Florian
  Date: 24.06.2010
  Time: 16:02:48
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Journal Suche</title>
    <meta name="heading" content="Journal Suche"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<b>Journal suchen</b>
<br><br>
<hr/>

<s:form id="journalForm" action="listJournals" method="post" validate="true">

    <s:textfield key="journalSearchTO.titel"  cssClass="text medium"/>
    <s:textfield key="journalSearchTO.kurztitel"  cssClass="text medium"/>
    <s:textfield key="journalSearchTO.verlag"  cssClass="text medium"/>
    <s:textfield key="journalSearchTO.konsortium"  cssClass="text medium"/>
    <s:select label="Zugang über" key="journalSearchTO.zugangUeber"
              name="journalSearchTO.zugangUeber" value="%{journalSearchTO.zugangUeber}"
              list="listZugangUeber" headerKey="" headerValue="-- Bitte wählen --"/>
<authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE,ROLE_PROJECT">
    <s:textfield key="journalSearchTO.provider"  cssClass="text medium"/>
    <s:textfield key="journalSearchTO.paket"  cssClass="text medium"/>
</authz:authorize>
    
    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="search" key="button.search" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("journalForm"));
</script>

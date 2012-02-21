<%--
  Created by IntelliJ IDEA.
  User: Florian
  Date: 10.08.2010
  Time: 10:25:42
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>EZB Daten Suche</title>
    <meta name="heading" content="EZB Daten Suche"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>  

Suche EZB Daten f&uuml;r Journal:
<br>

<s:form id="ezbDatenSearch" action="listEzbDaten" method="post" validate="true">

    <s:hidden name="journalId" value="%{journalId}"/>
    <s:textfield key="ezbDatenSearchTO.ezbId" cssClass="text medium"/>
    <s:textfield key="ezbDatenSearchTO.titel" cssClass="text medium"/>
    <s:textfield key="ezbDatenSearchTO.zdbNummer" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="search" key="button.search" theme="simple"/>
    </li>
    <br
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("ezbDatenSearch"));
</script>
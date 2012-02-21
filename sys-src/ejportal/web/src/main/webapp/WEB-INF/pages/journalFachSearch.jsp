<%--
  Created by IntelliJ IDEA.
  User: ev55esul
  Date: 02.08.2010
  Time: 17:18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Fach Suche</title>
    <meta name="heading" content="Fach Suche"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>
Suche Fach f&uuml;r das Journal "<s:push value="journal"><s:property value="titel"/></s:push>":
<br>

<s:form id="fachSearch" action="listFach" method="post" validate="true">

    <s:hidden name="journalId" value="%{journal.id}"/>
    <s:textfield label="Name des Fachs" key="fachName" cssClass="text medium"/>


    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="search" key="button.search" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("fachSearch"));
</script>v
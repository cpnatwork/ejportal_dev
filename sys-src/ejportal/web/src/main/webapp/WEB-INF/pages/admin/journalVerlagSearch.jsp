<%--
  Created by IntelliJ IDEA.
  User: Florian
  Date: 05.07.2010
  Time: 09:31:30
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Verlag Suche</title>
    <meta name="heading" content="Verlag Suche"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>

Suche Verlag f&uuml;r das Journal "<s:push value="journal"><s:property value="titel"/></s:push>":
<br>

<s:form id="verlagSearch" action="listVerlage" method="post" validate="true">

    <s:hidden name="journalId" value="%{journal.id}"/>
    <s:textfield label="Name des Verlags" key="institutionSearchTO.name" cssClass="text medium"/>


    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="search" key="button.search" theme="simple"/>
    </li>
    <br>

</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("verlagSearch"));
</script>

<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 05.08.2010
  Time: 17:32:11
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Eigent&uuml;mer Suche</title>
    <meta name="heading" content="Eigent&uuml;mer Suche"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>
<jsp:include page="/common/exemplarMenu.jsp"/>


Suche Eigent&uuml;mer f&uuml;r das Exemplar:
<br>

<s:form id="eigentuemerSearch" action="listEigentuemer" method="post" validate="true">

    <s:hidden name="exemplarId" value="%{exemplarId}"/>
    <s:hidden name="journalId" value="%{journalId}"/>
    <s:textfield label="Name des Eigentuemers" key="sigelSearchTO.name" cssClass="text medium"/>
    <s:textfield label="Bibliothek" key="sigelSearchTO.bibliothek" cssClass="text medium"/>
    <s:textfield label="Fakultaet" key="sigelSearchTO.fakultaet" cssClass="text medium"/>


    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="search" key="button.search" theme="simple"/>
    </li>
    <%--<br>
    <s:url action="showExemplarDetail" var="lieferantSelect">
        <s:param name="journalId" value="%{journalId}"/>
        <s:param name="exemplarId" value="%{exemplarId}"/>
    </s:url>
    <a href="${lieferantSelect}">zur&uuml;ck zum Exemplar</a>--%>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("eigentuemerSearch"));
</script>
<%--
  Created by IntelliJ IDEA.
  User: Nina
  Date: 04.08.2010
  Time: 15:00:25
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Sigel Suche</title>
    <meta name="heading" content="Sigel Suche"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>

<s:form id="sigelForm" action="listSigels" method="post" validate="true">

    <s:textfield label="Sigelname" key="sigelSearchTO.name" cssClass="text medium"/>
    <s:textfield label="Bibliothek" key="sigelSearchTO.bibliothek" cssClass="text medium"/>
    <s:textfield label="Fakultät" key="sigelSearchTO.fakultaet" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="search" key="button.search" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("sigelForm"));
</script>
<%--
  Created by IntelliJ IDEA.
  User: ev55esul
  Date: 05.08.2010
  Time: 15:57:36
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Fach Suche</title>
    <meta name="heading" content="Fach Suche"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>

<s:form id="fachForm" action="listFachs" method="post" validate="true">

    <s:textfield label="Fachname" key="fachName" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="search" key="button.search" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("fachForm"));
</script>
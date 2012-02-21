<%--
  Created by IntelliJ IDEA.
  User: Tselmeg
  Date: 03.08.2010
  Time: 15:28:16
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Paket Suche</title>
    <meta name="heading" content="Paket Suche"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>

<s:form id="paketForm" action="listPakete" method="post" validate="true">

    <s:textfield label="Paketname" key="paketName" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="search" key="button.search" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("paketForm"));
</script>
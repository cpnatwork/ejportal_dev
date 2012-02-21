<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 03.08.2010
  Time: 15:44:22
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Konsortien Suche</title>
    <meta name="heading" content="Konsortien Suche"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>

<s:form id="konsortiumForm" action="listKonsortien" method="post" validate="true">

    <s:textfield label="Konsortium Name" key="konsortiumName" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="search" key="button.search" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("konsortiumForm"));
</script>
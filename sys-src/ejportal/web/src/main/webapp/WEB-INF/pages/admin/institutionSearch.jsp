<%--
  Created by IntelliJ IDEA.
  User: Tselmeg
  Date: 07.07.2010
  Time: 01:41:26
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Institutions Suche</title>
    <meta name="heading" content="Institutions Suche"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>

<s:form id="institutionForm" action="listInstitutions" method="post" validate="true">

    <s:textfield key="institutionSearchTO.name" cssClass="text medium"/>
   
    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="search" key="button.search" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("institutionForm"));
</script>
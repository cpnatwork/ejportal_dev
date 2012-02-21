<%--
  Created by IntelliJ IDEA.
  User: Nina
  Date: 04.08.2010
  Time: 15:29:12
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Sigel umbenennen</title>
    <meta name="heading" content="Sigel"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>

<s:form id="sigelForm" action="createSigel" method="post" validate="true">
    <s:textfield label="Sigelname" key="sigel.name" required="true" cssClass="text medium" labelposition="left"/>
    <s:textfield label="Bibliothek" key="sigel.bibliothek"  cssClass="text medium" labelposition="left"/>
    <s:textfield label="Fakultät" key="sigel.fakultaet"  cssClass="text medium" labelposition="left"/>
    <s:textfield label="E-Mail" key="sigel.persEmail" cssClass="text medium" labelposition="left"/>
    <s:textfield label="Ansprechpartner 1" key="sigel.bibAnsprechpartner1"  cssClass="text medium" labelposition="left"/>
    <s:textfield label="Ansprechpartner 2" key="sigel.bibAnsprechpartner2"  cssClass="text medium" labelposition="left"/>


    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" label="Speichern" key="button.save" theme="simple"/>
    </li>
</s:form>

<%--
<s:url action="listSigels" var="back">
    <s:param name="id" value="%{sigel.sigelId}"/>
</s:url>
<a href="${back}">Abbrechen</a>
--%>
<script type="text/javascript">
    Form.focusFirstElement($("sigelForm"));
</script>
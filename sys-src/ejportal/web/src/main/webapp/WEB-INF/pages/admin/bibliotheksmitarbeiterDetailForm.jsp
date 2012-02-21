<%--
  Created by IntelliJ IDEA.
  User: Nina
  Date: 05.08.2010
  Time: 12:11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Bibliothek bearbeiten</title>
    <meta name="heading" content="Bibliothek bearbeiten"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>

<s:form id="bibliotheksmitarbeiterForm" action="editBibliotheksmitarbeiter" method="post" validate="true">
<s:hidden key="bibliotheksmitarbeiter.bibId"/>
    <s:textfield label="Name" key="bibliotheksmitarbeiter.name" required="true" cssClass="text medium" labelposition="left"/>
    <s:textfield label="Abteilungshauptstelle" key="bibliotheksmitarbeiter.abteilungsHauptstelle"  cssClass="text medium" labelposition="left"/>
    <s:textfield label="Fensterumschlagadresse" key="bibliotheksmitarbeiter.fensterumschlagAdresse"  cssClass="text medium" labelposition="left"/>
    <s:textfield label="Hausanschrift" key="bibliotheksmitarbeiter.hausanschrift"  cssClass="text medium" labelposition="left"/>
    <s:textfield label="Postanschrift" key="bibliotheksmitarbeiter.postanschrift"  cssClass="text medium" labelposition="left"/>
    <s:textfield label="Telefon" key="bibliotheksmitarbeiter.telefon"  cssClass="text medium" labelposition="left"/>
    <s:textfield label="Fax" key="bibliotheksmitarbeiter.telefax"  cssClass="text medium" labelposition="left"/>
    <s:textfield label="E-Mail" key="bibliotheksmitarbeiter.emailanschrift"  cssClass="text medium" labelposition="left"/>
    <s:textfield label="URL" key="bibliotheksmitarbeiter.url"  cssClass="text medium" labelposition="left"/>
    <s:textfield label="Umsatzsteuer Nr" key="bibliotheksmitarbeiter.umstId"  cssClass="text medium" labelposition="left"/>
    <s:textfield label="Mitarbeiter" key="bibliotheksmitarbeiter.mitarbeiter"  cssClass="text medium" labelposition="left"/>
    <s:textfield label="Dienstort" key="bibliotheksmitarbeiter.dienstort"  cssClass="text medium" labelposition="left"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" label="Speichern" key="button.save" theme="simple"/>
    </li>
</s:form>

<%--
<s:url action="listBibliotheksmitarbeiterForEdit" var="back">
    <s:param name="id" value="%{bibliotheksmitarbeiter.bibId}"/>
</s:url>
<a href="${back}">Abbrechen</a>
--%>

<script type="text/javascript">
    Form.focusFirstElement($("bibliotheksmitarbeiterForm"));
</script>
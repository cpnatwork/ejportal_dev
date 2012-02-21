<%--
  Created by IntelliJ IDEA.
  User: Tselmeg
  Date: 14.07.2010
  Time: 00:03:31
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Neue Institution anlegen</title>
    <meta name="heading" content="Neue Institution"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>
                 
<s:form id="institutionForm" action="createInstitution" method="post" validate="true">
    <s:textfield label="Name der Institution" key="institutionBaseTO.name" labelposition="left" required="true" cssClass="text medium"/>
    <s:textfield label="Straße" key="institutionBaseTO.strasse" labelposition="left"  cssClass="text medium"/>
    <s:textfield label="Postfach" key="institutionBaseTO.postfach" labelposition="left" cssClass="text medium"/>
    <s:textfield label="Postleitzahl" key="institutionBaseTO.plz_ort" labelposition="left"  cssClass="text medium"/>
    <s:textfield label="Bundesland" key="institutionBaseTO.bundesland" labelposition="left"  cssClass="text medium"/>
    <s:textfield label="Land" key="institutionBaseTO.land" labelposition="left"  cssClass="text medium"/>
    <s:textfield label="Ansprechpartner" key="institutionBaseTO.ansprechpartner" labelposition="left"  cssClass="text medium"/>
    <s:textfield label="Abteilung" key="institutionBaseTO.abteilung" labelposition="left"  cssClass="text medium"/>
    <s:textfield label="E-Mail" key="institutionBaseTO.email" labelposition="left"  cssClass="text medium"/>
    <s:textfield label="Fax" key="institutionBaseTO.fax" labelposition="left"  cssClass="text medium"/>
    <s:textfield label="Telefon" key="institutionBaseTO.telefon" labelposition="left" cssClass="text medium"/>
    <s:select label="Bestellsprache" key="institutionBaseTO.bestellsprache" name="institutionBaseTO.bestellsprache" list="listBestellsprache"  headerKey="" headerValue="-- Bitte wählen --" />
    <s:textfield label="Status" key="institutionBaseTO.status" labelposition="left"  cssClass="text medium"/>
    <s:textfield label="Kommentar" key="institutionBaseTO.kommentar" labelposition="left" cssClass="text medium"/>
    <s:textfield label="Kennwort" key="institutionBaseTO.kennwort" labelposition="left" cssClass="text medium"/>
    <s:textfield label="Fernzugriff" key="institutionBaseTO.fernzugriff" labelposition="left"  cssClass="text medium"/>
    <s:select label="Bestellart" key="institutionBaseTO.bestellart" name="institutionBaseTO.bestellart" list="listBestellart"  headerKey="" headerValue="-- Bitte wählen --" />
    <s:textfield label="Fernzugriff Bemerkung" key="institutionBaseTO.fernzugriffErlaeuterung"  cssClass="text medium"/>
    <s:select label="Zugang" key="institutionBaseTO.zugang" name="institutionBaseTO.zugang" list="listZugang"  headerKey="" headerValue="-- Bitte wählen --" />
    <s:select label="Personengruppe" key="institutionBaseTO.personengruppe"  name="institutionBaseTO.personengruppe" list="listPersonengruppe"  headerKey="" headerValue="-- Bitte wählen --" />
    <s:textfield label="Zugangsdaten" key="institutionBaseTO.zugangsdaten" labelposition="left"  cssClass="text medium"/>
    <s:textfield label="Kommentar intern" key="institutionBaseTO.kommentarIntern" labelposition="left" cssClass="text medium"/>
    <s:textfield label="Homepage" key="institutionBaseTO.internetadresse" labelposition="left"  cssClass="text medium"/>
    <s:textfield label="Nutzungs URL" key="institutionBaseTO.nutzungsURL" labelposition="left" cssClass="text medium"/>
    <s:textfield label="Copyright URL" key="institutionBaseTO.copyrightURL" labelposition="left" cssClass="text medium"/>
    <s:textfield label="Account URL" key="institutionBaseTO.accountURL" labelposition="left"  cssClass="text medium"/>
    <s:textfield label="Statistik URL" key="institutionBaseTO.statstikURL" labelposition="left"  cssClass="text medium"/>
    <s:textfield label="SFX URL" key="institutionBaseTO.sfxURL" labelposition="left"  cssClass="text medium"/>
    <s:textfield label="UB-Logo URL" key="institutionBaseTO.ublogoURL" labelposition="left"  cssClass="text medium"/>
    <s:textfield label="Statistik Zugangsdaten" key="institutionBaseTO.statstikZugang" labelposition="left"  cssClass="text medium"/>
    <s:select label="Fernleihe" key="institutionBaseTO.fernleihe" name="institutionBaseTO.fernleihe" list="listFernleihe"  headerKey="" headerValue="-- Bitte wählen --" />
    <s:select label="Art der Lizenz" key="institutionBaseTO.lizenzArt" name="institutionBaseTO.lizenzArt" list="listLizenzArt"  headerKey="" headerValue="-- Bitte wählen --" />
    <s:textfield label="Abbestellmöglichkeit" key="institutionBaseTO.lizenzAbbest" labelposition="left"  cssClass="text medium"/>
    <s:textfield label="Titelpaket" key="institutionBaseTO.lizenzPaket" labelposition="left"  cssClass="text medium"/>
    <s:textfield label="Vorgänger / Nachfolger" key="institutionBaseTO.lizenzVorgang" labelposition="left"  cssClass="text medium"/>
    <s:textfield label="zuständige Bibliothek" key="institutionBaseTO.lizenzZust" labelposition="left"  cssClass="text medium"/>
    <s:textfield label="Besonderheiten" key="institutionBaseTO.lizenzBes" labelposition="left" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" label="Speichern" key="button.save" theme="simple"/>
        <c:if test="${not empty institution.id}">
            <s:submit cssClass="button" method="delete" key="button.delete" onclick="return confirmDelete('institution')" theme="simple"/>
        </c:if>
    </li>
</s:form>
<%--
<s:url action="masterdataMenu" var="back">
    <s:param name="id" value="%{institutionBaseTO.id}"/>
</s:url>
<a href="${back}">Abbrechen</a>
--%>


<script type="text/javascript">
    Form.focusFirstElement($("institutionForm"));
</script>

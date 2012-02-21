<%--
  Created by IntelliJ IDEA.
  User: Tselmeg
  Date: 07.07.2010
  Time: 17:26:03
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Institution bearbeiten</title>
    <meta name="heading" content="Institution"/>
    <meta name="menu" content="StammMenu"/>
</head>

<s:url action="showInstitutionDetail" var="back">
    <s:param name="id" value="%{institutionBaseTO.id}"/>
</s:url>

<jsp:include page="/common/stammMenu.jsp"/>


<s:form id="institutionForm" action="editInstitution" method="post" validate="true">
<s:hidden key="institutionBaseTO.id"/>
<%--<s:hidden name="institution.id" value="%{institution.id}"/>    --%>
    <s:textfield label="Name der Institution" key="institutionBaseTO.name" required="true" cssClass="text medium"/>
    <s:textfield label="Postfach" key="institutionBaseTO.postfach"  cssClass="text medium"/>
    <s:textfield label="Straße" key="institutionBaseTO.strasse"  cssClass="text medium"/>
    <s:textfield label="PLZ/Ort" key="institutionBaseTO.plz_ort"  cssClass="text medium"/>
    <s:textfield label="Bundesland" key="institutionBaseTO.bundesland"  cssClass="text medium"/>
    <s:textfield label="Land" key="institutionBaseTO.land"  cssClass="text medium"/>
    <s:textfield label="Ansprechpartner" key="institutionBaseTO.ansprechpartner"  cssClass="text medium"/>
    <s:textfield label="Abteilung" key="institutionBaseTO.abteilung" cssClass="text medium"/>
    <s:textfield label="Telefon" key="institutionBaseTO.telefon" cssClass="text medium"/>
    <s:textfield label="Fax" key="institutionBaseTO.fax"  cssClass="text medium"/>
    <s:textfield label="E-Mail" key="institutionBaseTO.email"  cssClass="text medium"/>
    <s:select label="Bestellsprache" key="institutionBaseTO.bestellsprache" name="institutionBaseTO.bestellsprache" value="%{institutionBaseTO.bestellsprache}" list="listBestellsprache" headerKey="" headerValue="-- Bitte waehlen --"/>
    <s:textfield label="Status" key="institutionBaseTO.status"  cssClass="text medium"/>
    <s:textfield label="Kommentar" key="institutionBaseTO.kommentar"  cssClass="text medium"/>
    <s:textfield label="Kennwort" key="institutionBaseTO.kennwort"  cssClass="text medium"/>
    <s:textfield label="Fernzugriff" key="institutionBaseTO.fernzugriff" cssClass="text medium"/>
    <s:select label="Bestellart" key="institutionBaseTO.bestellart" name="institutionBaseTO.bestellart" value="%{institutionBaseTO.bestellart}" list="listBestellart" headerKey="" headerValue="-- Bitte waehlen --" />
    <s:textfield label="Fernzugriff Bemerkung" key="institutionBaseTO.fernzugriffErlaeuterung"  cssClass="text medium" />
    <s:select label="Zugang" key="institutionBaseTO.zugang" name="institutionBaseTO.zugang" value="%{institutionBaseTO.zugang}" list="listZugang" headerKey="" headerValue="-- Bitte waehlen --" />
    <s:select label="Personengruppe" key="institutionBaseTO.personengruppe" name="institutionBaseTO.personengruppe" value="%{institutionBaseTO.personengruppe}" list="listPersonengruppe" headerKey="" headerValue="-- Bitte waehlen --"/>
    <s:textfield label="Zugangsdaten" key="institutionBaseTO.zugangsdaten"  cssClass="text medium"/>
    <s:textfield label="Kommentar intern" key="institutionBaseTO.kommentarIntern"  cssClass="text medium"/>
    <s:textfield label="Homepage" key="institutionBaseTO.internetadresse"  cssClass="text medium"/>
    <s:textfield label="Nutzungs URL" key="institutionBaseTO.nutzungsURL"  cssClass="text medium"/>
    <s:textfield label="Copyright URL" key="institutionBaseTO.copyrightURL"  cssClass="text medium"/>
    <s:textfield label="Account URL" key="institutionBaseTO.accountURL"  cssClass="text medium"/>
    <s:textfield label="Statistik URL" key="institutionBaseTO.statstikURL"  cssClass="text medium"/>
    <s:textfield label="SFX URL" key="institutionBaseTO.sfxURL"  cssClass="text medium"/>
    <s:textfield label="UB-Logo URL" key="institutionBaseTO.ublogoURL"  cssClass="text medium"/>
    <s:textfield label="Statistik Zugangsdaten" key="institutionBaseTO.statstikZugang"  cssClass="text medium"/>
    <s:select label="Fernleihe" key="institutionBaseTO.fernleihe" name="institutionBaseTO.fernleihe" value="%{institutionBaseTO.fernleihe}" list="listFernleihe" headerKey="" headerValue="-- Bitte waehlen --"/>
    <s:select label="Art der Lizenz" key="institutionBaseTO.lizenzArt" name="institutionBaseTO.lizenzArt" value="%{institutionBaseTO.lizenzArt}" list="listLizenzArt" headerKey="" headerValue="-- Bitte waehlen --" />
    <s:textfield label="Abbestellmöglichkeit" key="institutionBaseTO.lizenzAbbest"  cssClass="text medium"/>
    <s:textfield label="Titelpaket" key="institutionBaseTO.lizenzPaket"  cssClass="text medium"/>
    <s:textfield label="Vorgaenger / Nachfolger" key="institutionBaseTO.lizenzVorgang" cssClass="text medium"/>
    <s:textfield label="zustaendige Bibliothek" key="institutionBaseTO.lizenzZust"  cssClass="text medium"/>
    <s:textfield label="Besonderheiten" key="institutionBaseTO.lizenzBes" cssClass="text medium"/>
   
    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" label="Speichern" key="button.save" theme="simple"/>
              <%--<c:if test="${not empty institution.id}">
                   <s:submit cssClass="button" method="delete" key="button.delete" onclick="return confirmDelete('institution')" theme="simple"/>
               </c:if>
               <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>  --%>
    </li>
</s:form>
<%--
<s:url action="showInstitutionDetail" var="back">
    <s:param name="id" value="%{institutionBaseTO.id}"/>
</s:url>
<a href="${back}">Abbrechen (ohne Speichern)</a>
--%>

<script type="text/javascript">
    Form.focusFirstElement($("institutionForm"));
</script>
<%--
  Created by IntelliJ IDEA.
  User: Tselmeg
  Date: 07.07.2010
  Time: 17:33:22
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Institution</title>
    <meta name="heading" content="Institution"/>
    <meta name="menu" content="StammMenu"/>
</head>

<s:url action="editInstitution" var="institutionEdit">
    <s:param name="id" value="%{institution.id}"/>
</s:url>
<s:url action="deleteInstitution" var="institutionDelete">
    <s:param name="id" value="%{institution.id}"/>
</s:url>
<s:url action="createLizenzdetail"  var="createLizenzdetail">
    <s:param name="institutionId" value="%{id}"/>
</s:url>


<jsp:include page="/common/stammMenu.jsp"/>


<div class="userActions">
  <a class="small gray awesome" onClick ="window.location.href='${createLizenzdetail}'">Lizenzdetail hinzuf&uuml;gen</a> <br /><br />
  <a class="small gray awesome" onClick ="window.location.href='${institutionEdit}'">Institution bearbeiten</a> <br /><br />
  <a class="small gray awesome" onClick ="if (confirm('Institution wirklich entfernen?')) window.location.href='${institutionDelete}';">Institution entfernen</a> <br /><br />
</div>

<s:push value="institution">
    Name:       <s:property value="name" />
    <br>
    Postfach:   <s:property value="postfach" />
    <br>
    Adresse:    <s:property value="strasse" />   ,
                <s:property value="plz_ort" />    ,
                <s:property value="bundesland" />    ,
                <s:property value="land" />    
    <br>
    Ansprechpartner:    <s:property value="ansprechpartner" />
    <br>
    Abteilung:  <s:property value="abteilung" />
    <br>
    Telefon:    <s:property value="telefon" />
    <br>
    Fax:        <s:property value="fax" />
    <br>
    E-Mail:     <s:property value="email" />
    <br>
    Telefon:    <s:property value="telefon" />
    <br>
    Fax:        <s:property value="fax" />
    <br>
    E-Mail:     <s:property value="email" />
    <br>
    Bestellsprache: <s:property value="bestellsprache" />
    <br>
    Status:     <s:property value="status" />
    <br>
    Kommentar &ouml;ffentlich:  <s:property value="kommentar" />
    <br>
    Kennwort:   <s:property value="kennwort" />
    <br>
    Fernzugriff: <s:property value="fernzugriff" />
    <br>
    
    Bestellart: <s:property value="bestellart" />
    <br>
    Fernzugriff Bemerkung: <s:property value="fernzugriffErlaeuterung" />
    <br>
    Zugang: <s:property value="zugang" />
    <br>
    Personengruppe: <s:property value="personengruppe" />
    <br>
    Zugangsdaten: <s:property value="zugangsdaten" />
    <br>
    Kommentar intern: <s:property value="kommentarIntern" />
    <br>
    Homepage: <s:property value="internetadresse" />
    <br>
    Nutzungs URL: <s:property value="nutzungsURL" />
    <br>
    Copyright URL: <s:property value="copyrightURL" />
    <br>
    Account URL: <s:property value="accountURL" />
    <br>
    Statistik URL: <s:property value="statstikURL" />
    <br>
    SFX URL: <s:property value="sfxURL" />
    <br>
    UB-Logo URL: <s:property value="ublogoURL" />
    <br>
    Statistik Zugangsdaten: <s:property value="statstikZugang" />
    <br>
    Fernleihe: <s:property value="fernleihe" />
    <hr>
    <p><b>Lizenz</b>
    <br>
    Art der Lizenz: <s:property value="lizenzArt" />
    <br>
    Abbestellm&ouml;glichkeit: <s:property value="lizenzAbbest" />
    <br>
    Titelpaket: <s:property value="lizenzPaket" />
    <br>
    Vorg&auml;nger / Nachfolger: <s:property value="lizenzVorgang" />
    <br>
    zust&auml;ndige Bibliothek: <s:property value="lizenzZust" />
    <br>
    Besonderheiten: <s:property value="lizenzBes" />
    <br>
    </p>

    <p><b>Lizenzdetails</b></p>
    <s:url action="editLizenzdetail"  var="lizenzdetailChange">
        <s:param name="institutionId" value="%{id}"/>
    </s:url>
    <s:url action="deleteLizenzdetail"  var="lizenzdetailDelete">
        <s:param name="institutionId" value="%{id}"/>
    </s:url>

    <s:set name="lizenzdetails" value="verlagLizenzdetails" scope="request"/>
    <display:table name="lizenzdetails" class="table" requestURI="" id="lizenzdetailsList" export="false" pagesize="25">
        <display:column property="lizenzId" sortable="true" href="${lizenzdetailChange}"
        paramId="lizenzId" paramProperty="lizenzId" titleKey="lizenzdetail.lizenzId"/>
        <display:column property="beginn" sortable="true" titleKey="lizenzdetail.beginn"/>
        <display:column property="laufzeit" sortable="true" titleKey="lizenzdetail.laufzeit"/>
        <display:column property="verlaengerung" sortable="true" titleKey="lizenzdetail.verlaengerung"/>
        <display:column property="kosten" sortable="true" titleKey="lizenzdetail.kosten"/>
        <display:column property="readmeAktualisiert" sortable="true" titleKey="lizenzdetail.readmeAktualisiert"/>
        <display:column href="${lizenzdetailDelete}" value="Lizenzdetail entfernen" paramId="lizenzId" paramProperty="lizenzId"/>

        <display:setProperty name="paging.banner.item_name" value="Lizenzdetail"/>
        <display:setProperty name="paging.banner.items_name" value="Lizenzdetails"/>
        <display:setProperty name="basic.empty.showtable" value="false"/>
        <display:setProperty name="basic.msg.empty_list" value="Keine Lizenzdetails vorhanden."/>
        <display:setProperty name="paging.banner.one_item_found" value=""/>
        <display:setProperty name="paging.banner.all_items_found" value=""/>
    </display:table>

</s:push>


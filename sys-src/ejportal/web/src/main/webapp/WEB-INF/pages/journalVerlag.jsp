<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Florian
  Date: 29.06.2010
  Time: 13:22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Verlag</title>
    <meta name="heading" content="Verlag von '<s:property value="journal.titel"/>' " />
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>

<authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE">
<s:url value="/admin/searchVerlag.html"  var="verlagChange">
    <s:param name="journalId" value="%{journal.id}"/>
</s:url>

<div class="userActions">
  <a class="small gray awesome" onClick ="window.location.href='${verlagChange}'">Anderen Verlag w&auml;hlen</a> <br /><br />
  <br>
</div>

</authz:authorize>


<s:push value="journal">
    <p>
    Verlag:  <s:property value="verlag.name" />    <br>
    Strasse: <s:property value="verlag.strasse" />    <br>
    Postfach: <s:property value="verlag.postfach" />    <br>
    Ort: <s:property value="verlag.plz_ort" />    <br>
    Email: <s:property value="verlag.email" />    <br>
    Fax: <s:property value="verlag.fax" />    <br>
    Telefon: <s:property value="verlag.telefon" />    <br>
    Status: <s:property value="verlag.status" />    <br>
    Kommentar: <s:property value="verlag.kommentar" />    <br>
    Fernzugriff: <s:property value="verlag.fernzugriff" />    <br>
    Homepage: <s:property value="verlag.internetadresse" />    <br>
    Fernzugriff Erl&auml;uterung: <s:property value="verlag.fernzugriffErlaeuterung" />    <br>
    Nutzung URL: <s:property value="verlag.nutzungsURL" />    <br>
    Copyright URL: <s:property value="verlag.copyrightURL" />    <br>
    Account URL: <s:property value="verlag.accountURL" />    <br>
    </p>

    <p>
    <b>Lizenz</b> <br>
    Art der Lizenz: <s:property value="verlag.lizenzArt" /> <br>
    Abbestellm&ouml;glichkeit: <s:property value="verlag.lizenzAbbest" /> <br>
    Titelpaket: <s:property value="verlag.lizenzPaket" /> <br>
    Vorg&auml;nger / Nachfolger: <s:property value="verlag.lizenzVorgang" /> <br>
    zust&auml;ndige Bibliothek: <s:property value="verlag.lizenzZust" /><br>
    Besonderheiten: <s:property value="verlag.lizenzBes" /> <br>
    </p>

    <p><b>Lizenzdetails</b></p>
    <s:set name="lizenzdetails" value="verlag.verlagLizenzdetails" scope="request"/>
    <display:table name="lizenzdetails" class="table" requestURI="" id="lizenzdetailsList" export="false" pagesize="25">
        <display:column property="lizenzId" sortable="true" titleKey="lizenzdetail.lizenzId"/>
        <display:column property="beginn" sortable="true" titleKey="lizenzdetail.beginn"/>
        <display:column property="laufzeit" sortable="true" titleKey="lizenzdetail.laufzeit"/>
        <display:column property="verlaengerung" sortable="true" titleKey="lizenzdetail.verlaengerung"/>
        <display:column property="kosten" sortable="true" titleKey="lizenzdetail.kosten"/>
        <display:column property="readmeAktualisiert" sortable="true" titleKey="lizenzdetail.readmeAktualisiert"/>

        <display:setProperty name="paging.banner.item_name" value="Lizenzdetail"/>
        <display:setProperty name="paging.banner.items_name" value="Lizenzdetails"/>
        <display:setProperty name="basic.empty.showtable" value="false"/>
        <display:setProperty name="basic.msg.empty_list" value="Keine Lizenzdetails vorhanden.<br/>"/>
        <display:setProperty name="paging.banner.one_item_found" value=""/>
        <display:setProperty name="paging.banner.all_items_found" value=""/>
    </display:table>

</s:push>


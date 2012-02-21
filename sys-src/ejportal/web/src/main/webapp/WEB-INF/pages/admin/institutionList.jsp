<%--
  Created by IntelliJ IDEA.
  User: Tselmeg
  Date: 07.07.2010
  Time: 01:58:25
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Institution Ergebnis</title>
    <meta name="heading" content="Institution Ergebnis"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>

<%--
<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editInstitution.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />
--%>

<!-- test -->
<s:set name="institutions" value="institutions" scope="request"/>
<!-- test -->
<display:table name="institutions" class="table" requestURI="" id="institutionList" export="false" pagesize="25">
    <display:column property="id" sortable="true" href="showInstitutionDetail.html"
                    paramId="id" paramProperty="id" titleKey="institution.id"/>
    <<display:column property="name" sortable="true" titleKey="institution.name"/>
    <display:column property="strasse" sortable="true" titleKey="institution.strasse"/>
    <display:column property="plz_ort" sortable="true" titleKey="institution.plz_ort"/>
    <display:column property="bundesland" sortable="true" titleKey="institution.bundesland"/>
    <display:column property="land" sortable="true" titleKey="institution.land"/>
    <display:column property="ansprechpartner" sortable="true" titleKey="institution.ansprechpartner"/>
    <display:column property="abteilung" sortable="true" titleKey="institution.abteilung"/>         
    <%--
    <display:column property="email" sortable="true" titleKey="institution.email"/>
    <display:column property="fax" sortable="true" titleKey="institution.fax"/>
    <display:column property="telefon" sortable="true" titleKey="institution.telefon"/>
    <display:column property="bestellsprache" sortable="true" titleKey="institution.bestellsprache"/>
    <display:column property="status" sortable="true" titleKey="institution.status"/>
    <display:column property="kommentar" sortable="true" titleKey="institution.kommentar"/>
    <display:column property="kennwort" sortable="true" titleKey="institution.kennwort"/>
    <display:column property="fernzugriff" sortable="true" titleKey="institution.fernzugriff"/>
    --%>
    <display:setProperty name="paging.banner.item_name" value="Institution"/>
    <display:setProperty name="paging.banner.items_name" value="Institutionen"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Die Suche ergab keinen Treffer.<br/>"/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} gefunden, es werden die Treffer {2} bis {3} angezeigt.<br/>"/>
</display:table>

<%--<c:out value="${buttons}" escapeXml="false" /> --%>

<script type="text/javascript">
    highlightTableRows("institutionList");
</script>

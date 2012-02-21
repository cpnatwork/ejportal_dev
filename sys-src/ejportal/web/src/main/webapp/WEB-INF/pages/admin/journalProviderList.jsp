<%--
  Created by IntelliJ IDEA.
  User: Janine
  Date: 07.07.2010
  Time: 16:14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Provider Liste</title>
    <meta name="heading" content="Provider Liste"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>
W&auml;hlen Sie einen neuen Provider f&uuml;r das Journal:
<br><br>


<authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE">
    <s:url action="changeProvider"  var="providerChange">
        <s:param name="journalId" value="%{JournalId}"/>
    </s:url>

    <s:url action="searchProvider" var="providerSearch">
        <s:param name="journalId" value="%{journalId}"/>
    </s:url>

    <div class="userActions">
        <a class="small gray awesome" onClick ="window.location.href='${providerSearch}'">Neue Providersuche durchf&uuml;hren</a> <br /><br />
    </div>

</authz:authorize>


<s:set name="institutions" value="institutions" scope="request"/>
<display:table name="institutions" class="table" requestURI="" id="providerList" export="false" pagesize="25">
    <display:column property="id" sortable="true" href="${providerChange}"
        paramId="providerId" paramProperty="id" titleKey="institution.id"/>
    <display:column property="name" sortable="true" titleKey="institution.name"/>
    <display:column property="strasse" sortable="true" titleKey="institution.strasse"/>
    <display:column property="plz_ort" sortable="true" titleKey="institution.plz_ort"/>
    <display:column property="bundesland" sortable="true" titleKey="institution.bundesland"/>
    <display:column property="land" sortable="true" titleKey="institution.land"/>
    <display:column property="ansprechpartner" sortable="true" titleKey="institution.ansprechpartner"/>
    <display:column property="abteilung" sortable="true" titleKey="institution.abteilung"/>

    <display:setProperty name="paging.banner.item_name" value="Provider"/>
    <display:setProperty name="paging.banner.items_name" value="Provider"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Die Suche ergab keinen Treffer."/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} gefunden.<br/><br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} gefunden.<br/><br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} gefunden, es werden die Treffer {2} bis {3} angezeigt.<br/><br/>"/>
</display:table>
<br>
<%--
<s:url action="showProviderForJournal" var="providerSelect">
    <s:param name="id" value="%{JournalId}"/>
</s:url>
<a href="${providerSelect}">zur&uuml;ck zum Provider</a>
--%>
<script type="text/javascript">
    highlightTableRows("providerList");
</script>
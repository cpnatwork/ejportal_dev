<%--
  Created by IntelliJ IDEA.
  User: Nina
  Date: 04.08.2010
  Time: 14:59:26
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Sigel</title>
    <meta name="heading" content="Sigel"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>


<s:url action="editSigel" var="sigelEdit">
    <s:param name="sigelId" value="%{sigel.sigelId}"/>
</s:url>
<s:url action="deleteSigel" var="sigelDelete">
    <s:param name="sigelId" value="%{sigel.sigelId}"/>
</s:url>


<div class="userActions">
  <a class="small gray awesome" onClick ="window.location.href='${sigelEdit}'">Sigel bearbeiten</a> <br /><br />
  <a class="small gray awesome" onClick ="if (confirm('Sigel wirklich entfernen? Das Sigel wird von allen Exemplaren entfernt.')) window.location.href='${sigelDelete}';">Sigel entfernen</a> <br /><br />
</div>


<s:push value="sigel">
    Sigelname: <s:property value="name" />    <br>
    Bibliothek: <s:property value="bibliothek" />   <br>
    Fakult&auml;t: <s:property value="fakultaet" />     <br>
    E-Mail: <s:property value="persEmail" />   <br>
    Ansprechpartner: <s:property value="bibAnsprechpartner1" />,  <s:property value="bibAnsprechpartner2" />   <br>
</s:push>
<br><br>
<hr/>
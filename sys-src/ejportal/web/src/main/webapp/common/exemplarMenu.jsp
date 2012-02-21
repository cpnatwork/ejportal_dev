<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 09.08.2010
  Time: 12:47:00
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>
<div class="specialLink">
    <p>
    <h1 id="exemplarHead">Exemplar '${exemplarId}'</h1> <hr/>

    <b>
        <s:url value="/showExemplarDetail.html" var="exemplarSelect">
            <s:param name="journalId" value="%{journalId}"/>
            <s:param name="exemplarId" value="%{exemplarId}"/>
        </s:url>
        <s:url value="/showZustaendigeBibForExemplar.html" var="zustaendigeBibSelect">
            <s:param name="journalId" value="%{journalId}"/>
            <s:param name="exemplarId" value="%{exemplarId}"/>
        </s:url>
        <s:url value="/showEigentuemerForExemplar.html" var="eigentuemerSelect">
            <s:param name="journalId" value="%{journalId}"/>
            <s:param name="exemplarId" value="%{exemplarId}"/>
        </s:url>
        <s:url value="/showBestellerForExemplar.html" var="bestellerSelect">
            <s:param name="journalId" value="%{journalId}"/>
            <s:param name="exemplarId" value="%{exemplarId}"/>
        </s:url>
        <s:url value="/showLieferantForExemplar.html" var="lieferantSelect">
            <s:param name="journalId" value="%{journalId}"/>
            <s:param name="exemplarId" value="%{exemplarId}"/>
        </s:url>

        <a class="specialLink" href="${exemplarSelect}">Exemplar</a>
        |
        <a class="specialLink" href="${zustaendigeBibSelect}">Zust&auml;ndige Bibliothek</a>
        |
        <a class="specialLink" href="${eigentuemerSelect}">Eigent&uuml;mer</a>
        |
        <a class="specialLink" href="${bestellerSelect}">Besteller</a>
        |
        <a class="specialLink" href="${lieferantSelect}">Lieferant</a>

    </b>
    </p>
    <br><br>
    <hr/>
</div>
<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 05.08.2010
  Time: 11:18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Neues Exemplar anlegen</title>
    <meta name="heading" content="Neues Exemplar"/>
    <meta name="menu" content="MainMenu"/>

    <SCRIPT LANGUAGE="JavaScript" SRC="/scripts/CalendarPopup.js"></SCRIPT>
    <!-- This prints out the default stylehseets used by the DIV style calendar.
         Only needed if you are using the DIV style popup -->
    <SCRIPT LANGUAGE="JavaScript">document.write(getCalendarStyles());</SCRIPT>
</head>

<jsp:include page="/common/journalMenu.jsp"/>



<s:form id="exemplarForm" action="createExemplar" method="post" validate="true">
    <s:hidden name="journalId" value="%{journalId}"/>

    <s:select label="Beteiligung" key="exemplarBaseTO.beteiligung" name="exemplarBaseTO.beteiligung" list="listBeteiligung"  headerKey="" headerValue="-- Bitte wählen --" />
    <s:select label="Form" key="exemplarBaseTO.form" name="exemplarBaseTO.form" list="listForm"  headerKey="" headerValue="-- Bitte wählen --" />
    <s:select label="Zugangsart" key="exemplarBaseTO.zugangsart" name="exemplarBaseTO.zugangsart" list="listZugangsart"  headerKey="" headerValue="-- Bitte wählen --" />
    <s:select label="Status" key="exemplarBaseTO.status" name="exemplarBaseTO.status" list="listStatus"  headerKey="" headerValue="-- Bitte wählen --" />

    <s:textfield label="Bestellnummer" key="exemplarBaseTO.bestellnummer" required="true" cssClass="text medium"/>
    <s:textfield label="Kundenummer" key="exemplarBaseTO.kundennummer"  cssClass="text medium"/>
    <s:textfield label="Abonummer" key="exemplarBaseTO.abonummer"  cssClass="text medium"/>
    <s:textfield label="Privat Abo" key="exemplarBaseTO.privatabo"  cssClass="text medium"/>
    <s:textfield label="Ex Kommentar" key="exemplarBaseTO.exKommentar"  cssClass="text medium"/>
    <s:textfield label="Print Ex Bayern" key="exemplarBaseTO.printexBayern"  cssClass="text medium"/>

    <s:textfield label="Abbestellung" key="exemplarBaseTO.abbestellung"  cssClass="text medium"/>
    <li id="wwgrp_abbestellt" class="wwgrp">    <div         id="wwlbl_abbestellt" class="wwlbl">
    <label for="abbestellt" class="desc">            Abbestellt zum
    </label>        </div>
    <div id="wwctrl_abbestellt" class="wwctrl">
    <input type="text" name="exemplarBaseTO.abbestZum" value="<s:date name="exemplarBaseTO.abbestZum" format="dd.MM.yyyy"/>" id="abbestellt" class="text medium"/></div><SCRIPT LANGUAGE="JavaScript" ID="abbestelltX">
                var abbestelltCal = new CalendarPopup("abbestelltDiv");
                abbestelltCal.setMonthNames('Januar','Februar','Maerz','April','Mai','Juni','Juli','August','September','Oktober','November','Dezember');
                abbestelltCal.setDayHeaders('S','M','D','M','D','F','S');
                abbestelltCal.setWeekStartDay(1);
                abbestelltCal.setTodayText("Heute");
                abbestelltCal.showNavigationDropdowns();
                abbestelltCal.setYearSelectStartOffset(2);
            </SCRIPT>

            <SCRIPT LANGUAGE="JavaScript">writeSource("abbestelltX");</SCRIPT>
            <A HREF="#"
               onClick="abbestelltCal.select(exemplarForm.abbestellt,'abbestelltAnchor','dd.MM.yyyy'); return false;"
               TITLE="Datum auswaehlen" NAME="abbestelltAnchor" ID="abbestelltAnchor"> <img src="/images/iconCalendar.gif"/> </A>
        </li><div id="abbestelltDiv" STYLE="position:absolute;visibility:hidden;background-color:white;layer-background-color:white;"></div>
    <s:textfield label="Umbestellung" key="exemplarBaseTO.umbestellung"  cssClass="text medium"/>
    <li id="wwgrp_umbestellt" class="wwgrp">    <div         id="wwlbl_umbestellt" class="wwlbl">

    <label for="umbestellt" class="desc">            Umbestellt zum
    </label>        </div>
    <div id="wwctrl_umbestellt" class="wwctrl">
    <input type="text" name="exemplarBaseTO.umbestZum" value="<s:date name="exemplarBaseTO.umbestZum" format="dd.MM.yyyy"/>" id="umbestellt" class="text medium"/></div>   <A HREF="#"
               onClick="umbestelltCal.select(exemplarForm.umbestellt,'umbestelltAnchor','dd.MM.yyyy'); return false;"
               TITLE="Datum auswaehlen" NAME="umbestelltAnchor" ID="umbestelltAnchor"> <img src="/images/iconCalendar.gif"/> </A></li>

        <SCRIPT LANGUAGE="JavaScript" ID="umbestelltX">
                var umbestelltCal = new CalendarPopup("umbestelltDiv");
                umbestelltCal.setMonthNames('Januar','Februar','Maerz','April','Mai','Juni','Juli','August','September','Oktober','November','Dezember');
                umbestelltCal.setDayHeaders('S','M','D','M','D','F','S');
                umbestelltCal.setWeekStartDay(1);
                umbestelltCal.setTodayText("Heute");
                umbestelltCal.showNavigationDropdowns();
                umbestelltCal.setYearSelectStartOffset(2);
            </SCRIPT>
            <SCRIPT LANGUAGE="JavaScript">writeSource("umbestelltX");</SCRIPT>


        <div id="umbestelltDiv" STYLE="position:absolute;visibility:hidden;background-color:white;layer-background-color:white;"></div>




    <li class="buttonBar bottom">
       <s:submit cssClass="button" method="save" label="Speichern" key="button.save" theme="simple"/>
       <%--<c:if test="${not empty journal.id}">
            <s:submit cssClass="button" method="delete" key="button.delete" onclick="return confirmDelete('journal')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>  --%>
    </li>
</s:form>


<script type="text/javascript">
    Form.focusFirstElement($("exemplarForm"));
</script>

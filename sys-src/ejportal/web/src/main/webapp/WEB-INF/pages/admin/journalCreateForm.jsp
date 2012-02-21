<%--
  Created by IntelliJ IDEA.
  User: Nina
  Date: 16.06.2010
  Time: 10:31:21
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="journalDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='journalDetail.heading'/>"/>
    <meta name="menu" content="StammMenu"/>

    <SCRIPT LANGUAGE="JavaScript" SRC="/scripts/CalendarPopup.js"></SCRIPT>
    <!-- This prints out the default stylehseets used by the DIV style calendar.
         Only needed if you are using the DIV style popup -->
    <SCRIPT LANGUAGE="JavaScript">document.write(getCalendarStyles());</SCRIPT>
</head>


Erstellen eines Journals:

<s:form id="journalForm" action="createJournal" method="post" validate="true">
    <s:textfield key="journalBaseTO.titel" required="true" cssClass="text medium"/>
    <s:textfield key="journalBaseTO.kurztitel" cssClass="text medium"/>
    <s:textfield key="journalBaseTO.issn" cssClass="text medium"/>
    <s:textfield key="journalBaseTO.issnPrint" cssClass="text medium"/>
    <s:textfield key="journalBaseTO.kommentar" cssClass="text medium"/>
    <s:textfield key="journalBaseTO.kommentarAdmin" cssClass="text medium"/>
    <s:textfield key="journalBaseTO.kommentarIntranet" cssClass="text medium"/>
    <s:textfield key="journalBaseTO.anker" cssClass="text medium"/>

    <li id="wwgrp_anmeldedatumFeld" class="wwgrp">
        <div id="wwlbl_anmeldedatumFeld" class="wwlbl">

            <label for="anmeldedatumFeld" class="desc"> Anmeldedatum
                </label></div>
        <div id="wwctrl_anmeldedatumFeld" class="wwctrl">
            <input type="text" name="journalBaseTO.anmeldedatum" id="anmeldedatumFeld" class="text medium"/>
            <SCRIPT LANGUAGE="JavaScript" ID="anmeldeX">
                var anmeldeCal = new CalendarPopup("anmeldeDiv");
                anmeldeCal.setMonthNames('Januar', 'Februar', 'Maerz', 'April', 'Mai', 'Juni', 'Juli', 'August', 'September', 'Oktober', 'November', 'Dezember');
                anmeldeCal.setDayHeaders('S', 'M', 'D', 'M', 'D', 'F', 'S');
                anmeldeCal.setWeekStartDay(1);
                anmeldeCal.setTodayText("Heute");
                anmeldeCal.showNavigationDropdowns();
                anmeldeCal.setYearSelectStartOffset(2);
            </SCRIPT>
            <SCRIPT LANGUAGE="JavaScript">writeSource("anmeldeX");</SCRIPT>
            <A HREF="#"
               onClick="anmeldeCal.select(journalForm.anmeldedatumFeld,'anmeldeAnchor','dd.MM.yyyy'); return false;"
               TITLE="Datum auswaehlen" NAME="anmeldeAnchor" ID="anmeldeAnchor"> <img src="/images/iconCalendar.gif"/>
            </A>
        </div>
    </li>
    <div id="anmeldeDiv"
         STYLE="position:absolute;visibility:hidden;background-color:white;layer-background-color:white;"></div>


    <li id="wwgrp_freischaltdatumFeld" class="wwgrp">
        <div id="wwlbl_freischaltdatumFeld" class="wwlbl">
            <label for="freischaltdatumFeld" class="desc"> Freischaltdatum
               </label></div>
        <div id="wwctrl_freischaltdatumFeld" class="wwctrl">
            <input type="text" name="journalBaseTO.freischaltdatum" id="freischaltdatumFeld" class="text medium"/>
            <SCRIPT LANGUAGE="JavaScript" ID="freischaltX">
                var freischaltCal = new CalendarPopup("freischaltDiv");
                freischaltCal.setMonthNames('Januar', 'Februar', 'Maerz', 'April', 'Mai', 'Juni', 'Juli', 'August', 'September', 'Oktober', 'November', 'Dezember');
                freischaltCal.setDayHeaders('S', 'M', 'D', 'M', 'D', 'F', 'S');
                freischaltCal.setWeekStartDay(1);
                freischaltCal.setTodayText("Heute");
                freischaltCal.showNavigationDropdowns();
                freischaltCal.setYearSelectStartOffset(2);
            </SCRIPT>
            <SCRIPT LANGUAGE="JavaScript">writeSource("freischaltX");</SCRIPT>
            <A HREF="#"
               onClick="freischaltCal.select(journalForm.freischaltdatumFeld,'freischaltAnchor','dd.MM.yyyy'); return false;"
               TITLE="Datum auswaehlen" NAME="freischaltAnchor" ID="freischaltAnchor"> <img
                    src="/images/iconCalendar.gif"/> </A>
        </div>
    </li>
    <div id="freischaltDiv"
         STYLE="position:absolute;visibility:hidden;background-color:white;layer-background-color:white;"></div>


    <li id="wwgrp_bearbeitungsdatumFeld" class="wwgrp">
        <div id="wwlbl_bearbeitungsdatumFeld" class="wwlbl">
            <label for="bearbeitungsdatumFeld" class="desc"> Bearbeitungsdatum
                </label></div>
        <div id="wwctrl_bearbeitungsdatumFeld" class="wwctrl">
            <input type="text" name="journalBaseTO.bearbeitungsdatum" id="bearbeitungsdatumFeld"
                   class="text medium"/>
            <SCRIPT LANGUAGE="JavaScript" ID="bearbeitungsX">
                var bearbeitungsCal = new CalendarPopup("bearbeitungsDiv");
                bearbeitungsCal.setMonthNames('Januar', 'Februar', 'Maerz', 'April', 'Mai', 'Juni', 'Juli', 'August', 'September', 'Oktober', 'November', 'Dezember');
                bearbeitungsCal.setDayHeaders('S', 'M', 'D', 'M', 'D', 'F', 'S');
                bearbeitungsCal.setWeekStartDay(1);
                bearbeitungsCal.setTodayText("Heute");
                bearbeitungsCal.showNavigationDropdowns();
                bearbeitungsCal.setYearSelectStartOffset(2);
            </SCRIPT>
            <SCRIPT LANGUAGE="JavaScript">writeSource("bearbeitungsX");</SCRIPT>
            <A HREF="#"
               onClick="bearbeitungsCal.select(journalForm.bearbeitungsdatumFeld,'bearbeitungsAnchor','dd.MM.yyyy'); return false;"
               TITLE="Datum auswaehlen" NAME="bearbeitungsAnchor" ID="bearbeitungsAnchor"> <img
                    src="/images/iconCalendar.gif"/> </A>
        </div>
    </li>
    <div id="bearbeitungsDiv"
         STYLE="position:absolute;visibility:hidden;background-color:white;layer-background-color:white;"></div>


    <s:textfield key="journalBaseTO.zugangsId" cssClass="text medium"/>
    <s:textfield key="journalBaseTO.zugangsPasswort" cssClass="text medium"/>
    <s:select label="Nutzungsbestimmungen" key="journalBaseTO.nutzungsbestimmungen"
              name="journalBaseTO.nutzungsbestimmungen" value="%{journalBaseTO.nutzungsbestimmungen}"
              list="listNutzungsbestimmungen" headerKey="" headerValue="-- Bitte wählen --"/>
    <li id="wwgrp_rotschaltdatumFeld" class="wwgrp">
        <div id="wwlbl_rotschaltdatumFeld" class="wwlbl">
            <label for="rotschaltdatumFeld" class="desc"> Rotschaltungsdatum
                </label></div>
        <div id="wwctrl_rotschaltdatumFeld" class="wwctrl">
            <input type="text" name="journalBaseTO.rotschaltungsdatum" id="rotschaltdatumFeld" class="text medium"/>
            <SCRIPT LANGUAGE="JavaScript" ID="rotschaltX">
                var roschaltCal = new CalendarPopup("rotschaltDiv");
                roschaltCal.setMonthNames('Januar', 'Februar', 'Maerz', 'April', 'Mai', 'Juni', 'Juli', 'August', 'September', 'Oktober', 'November', 'Dezember');
                roschaltCal.setDayHeaders('S', 'M', 'D', 'M', 'D', 'F', 'S');
                roschaltCal.setWeekStartDay(1);
                roschaltCal.setTodayText("Heute");
                roschaltCal.showNavigationDropdowns();
                roschaltCal.setYearSelectStartOffset(2);
            </SCRIPT>
            <SCRIPT LANGUAGE="JavaScript">writeSource("rotschaltAnchor");</SCRIPT>
            <A style="text-align:right;" HREF="#"
               onClick="roschaltCal.select(journalForm.rotschaltdatumFeld,'rotschaltAnchor','dd.MM.yyyy'); return false;"
               TITLE="Datum auswaehlen" NAME="rotschaltAnchor" ID="rotschaltAnchor"> <img
                    src="/images/iconCalendar.gif"/> </A>
        </div>
    </li>
    <div id="rotschaltDiv"
         STYLE="position:absolute;visibility:hidden;background-color:white;layer-background-color:white;"></div>


    <s:textfield key="journalBaseTO.rotschaltungsbemerkungen" cssClass="text medium"/>
    <s:select label="Status" key="journalBaseTO.status" name="journalBaseTO.status" value="%{journalBaseTO.status}"
              list="listStatus" headerKey="" headerValue="-- Bitte wählen --"/>
    <s:textfield key="journalBaseTO.zdbNummer" cssClass="text medium"/>
    <s:checkbox key="journalBaseTO.readMeTitelbezogen" labelposition="left" cssClass="text medium"/>
    <%--wird nicht im frontend der altanwendung angezeigt--%>
    <%--<s:textfield key="journalBaseTO.importId" cssClass="text medium"/>--%>
    <s:textfield key="journalBaseTO.herausgeber" cssClass="text medium"/>
    <s:select label="Zugang über" key="journalBaseTO.zugangUeber"
              name="journalBaseTO.zugangUeber" value="%{journalBaseTO.zugangUeber}"
              list="listZugangUeber" headerKey="" headerValue="-- Bitte wählen --"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
    </li>
</s:form>
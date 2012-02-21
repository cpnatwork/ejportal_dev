@echo off

rem ***  Migration vorbereiten  ***
rem migration\input> subst_d_create.cmd

set EXECDIR=migration
set EXECCMD=mvn -P prod,mysql install
start /D %EXECDIR% /WAIT cmd /D/C %EXECCMD%

pause
GOTO :eof

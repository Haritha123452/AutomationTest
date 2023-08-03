set projectLocation=C:\Users\SSD\git\AutomationTest
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\TestNG.xml
pause

set ProjectPath=%~dp0
cd %ProjectPath%
echo %ProjectPath%
set p=%PATH%
echo Running TestNG...
java -javaagent:"%ProjectPath%\libraries\aspectjweaver-1.9.22.1.jar" -classpath "%ProjectPath%out\production\java-hybrid-framework-afc;%ProjectPath%libraries\*;" org.testng.TestNG "%ProjectPath%resources\runMagentoTests.xml"
echo Running Allure Report...
allure serve .\allure-results\
pause
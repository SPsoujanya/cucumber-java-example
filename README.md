# cucumber-java-example


***** Cucumber Setup for Appium and Selenium WebDriver *****

-----------------------------------------------
----- Running TestSuits from Command Line -----
-----------------------------------------------

##### --- Required Dependency/Library/Jar list ---

    1) cucumber-core-1.2.5.jar
       // https://mvnrepository.com/artifact/info.cukes/cucumber-core
       compile group: 'info.cukes', name: 'cucumber-core', version: '1.2.5'

    2) cucumber-java-1.2.5.jar
       // https://mvnrepository.com/artifact/info.cukes/cucumber-java
       compile group: 'info.cukes', name: 'cucumber-java', version: '1.2.5'

    3) cucumber-junit-1.2.5.jar
       // https://mvnrepository.com/artifact/info.cukes/cucumber-junit
       testCompile group: 'info.cukes', name: 'cucumber-junit', version: '1.2.5'

    4) cucumber-jvm-deps-1.0.6.jar
       // https://mvnrepository.com/artifact/io.cucumber/cucumber-jvm-deps
       provided group: 'io.cucumber', name: 'cucumber-jvm-deps', version: '1.0.6'

    5) cucumber-html-0.2.6.jar
       // https://mvnrepository.com/artifact/info.cukes/cucumber-html
       compile group: 'info.cukes', name: 'cucumber-html', version: '0.2.6'

    6) cucumber-reporting-3.10.0.jar //Other option for reporting
       // https://mvnrepository.com/artifact/net.masterthought/cucumber-reporting
       compile group: 'net.masterthought', name: 'cucumber-reporting', version: '3.10.0'

    7) gherkin-2.12.2.jar
       // https://mvnrepository.com/artifact/info.cukes/gherkin
       provided group: 'info.cukes', name: 'gherkin', version: '2.12.2'


##### Note:   While moving forward we may require more libraries or to modify existing one
#####        "provided" may be replace with "compileOnly"
#####        "compile" may be replace with "implementation"

### --- Required Plugin for IntelliJ or Android Studio ---

    1) Gherkin
    2) Cucumber for Java
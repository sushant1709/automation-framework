# automation-framework
<img width="485" alt="image" src="https://github.com/sushant1709/automation-framework/assets/19224353/90dc4a1f-cc26-40dc-bc4c-dd278eaf8254">

# Folder Structure!

<img width="224" alt="image" src="https://github.com/sushant1709/automation-framework/assets/19224353/e41ed493-4de3-44fd-96f9-67c51b19657a">

- # src/main/java
- ##### com.dmg.utils  : contains files to initilize driver,initilize property file, initilize server, ingest capability and Utils file for Logging

<img width="333" alt="image" src="https://github.com/sushant1709/automation-framework/assets/19224353/fc5d4ec7-f444-45c1-a161-c398d71f66ff">

- # src/test/java
- ##### com.dmg.automation.mobile : contains pages and stepdef files for Mobile Automation
- ##### com.dmg.automation.mobile  : contains  pages and stepdef files for Web Automation
- ##### com.dmg.runner            : it contains Runner file to execute test

- # src/test/resources
- ##### app : it contains app folder for excutable app file for android and iOS
- #### feature : it contains feature file for mobile and web scenario

- # Execution :
-  ##### RunnerTest : update the respected tag to execute the scenario and Run
-  #### Command Line: mvn test -Dcucumber.options= "-- tags @tag" -DplatformName="Android" -udid =" emulator-5554" -DdeviceName= "Pixel 7"
-  #### change the GlobalParameter according to requirement i.e to execute Web test change DplatformName="Web"

-  # Reports
- #### Mobile Scenario 1 and 2
-  <img width="941" alt="image" src="https://github.com/sushant1709/automation-framework/assets/19224353/3c3b7afb-3d4f-4d82-bb8c-1ce8b505e4d4">
- #### Web Scenario 1 
<img width="830" alt="image" src="https://github.com/sushant1709/automation-framework/assets/19224353/a3544507-e628-460f-bc58-9cca7026adba">
- #### Web Scenario 2
<img width="857" alt="image" src="https://github.com/sushant1709/automation-framework/assets/19224353/28330ee4-e767-431a-9ac7-0c808b78d074">









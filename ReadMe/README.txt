###############################################################################
Technologies Used
###############################################################################
Spring Boot, MVC		-- As it comes with embedded Tomcat server. So need of any other server to deploy the package.
Spring Data JPA			-- For embedded Database (H2).
Spring Security			-- For user authentication
Java 1.8
Maven					-- For auto injection of dependencies
HTML, CSS/Bootstrap, jQuery

###############################################################################
Steps to build and launch the application
###############################################################################
1) Import the project in eclipse as Maven general project (Preferably - Spring Tool Suite).
2) To Build 
	From eclipse - (Refer "Build From Eclipse.png" screenshot present in ReadMe directory)
		a) right click on project
		b) Run As - Run Configurations
		c) Double click on "Maven Build"
			Provide the project location in "Base Directory" 
			Enter "mvn clean -X" in goals (exclude double quotes)
		d) Under JRE Tab, select JDK 1.8
		e) Click on Apply and Run
	From command prompt
		a) Goto the project location
		b) Run below command
			mvn clean install -X		(NOTE: Maven has to be installed prior to build)
		
3) Project will be build in a minute. (First time build may take long time as the dependent JARs will be downloaded)
4) JAR file will be generated under "target" directory(at the project location) with name "Sorter-0.0.1-SNAPSHOT.jar"
5) Project can be deployed in two ways-
	From eclipse - Spring Tool Suite
		a) Right click on Project
		b) Run as "Spring Boot App"
	From command prompt
		a) Goto the target directory where the JAR file was generated after build
		b) Run the below command
			java -jar Sorter-0.0.1-SNAPSHOT.jar
		NOTE: Java Home has to be setup

###############################################################################
To access the webpage  (Refer screenshots present under ReadMe directory)
###############################################################################
1) Open below URL in a web browser
	http://localhost:8098/login
2) Enter below username and password
	TCS / tcs123
3) Click "Sort Numbers" Menu. Enter the comma separated numbers to be Sorted. (Client side validation is being added)
4) Click "List App Data" Menu to view the history of sorted data.

###############################################################################



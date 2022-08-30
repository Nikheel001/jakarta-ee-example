#make sure in windows bean-discoverymode is all in beans.xml
mvn clean package dependency:copy-dependencies
java -cp ".\target\dependency\*;.\target\jakartacditry.jar" com.headshot.jakartacditry.Main
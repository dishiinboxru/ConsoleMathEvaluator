# prerequisites 
- computer with Unix-based OS
- maven 
- java 
- Intellij IDEA ( just in case)

# steps
1. Download the files ( src folder and pom.xml) 
2. put them in a separate folder, say "ConsoleMathEvaluatorSources"
3. open terminal in this folder
4. do command ls and make sure src folder and pom.xml are there
5. perform mvn clean package
6. If the build is success go to step 7 , otherwise go to second approach
7. perform java -jar target/ConsoleMathEvaluator-1.0-SNAPSHOT.jar
8. follow along 

#second approach with ready jar
10. In case there are issues with the maven then download ConsoleMathEvaluator-1.0.jar 
11. place it in a separate folder, Say " ConsoleMathEvaluatorJar"
12.  open terminal in this folder
13. perform java -jar ConsoleMathEvaluator-1.0.jar 
14. follow along 
15. in case there are issues with Java go to third approach

#third approach - plain IDEA
20. If none of the above works try opening the folder with src and pom.xml via Intellij IDEA and run the Main class there.

## General notes
 * if you want the programme to calculate the expressions indefinetly, not just once per run , find this comment in the Main.java
"//If you want the programme to receive expressions indefinetly, not once per run, remove this line"

• for debugging purposes there are numerous lines with console output (System.out) which may help to understand how the application works if you outcomment them

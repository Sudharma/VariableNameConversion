# Building

Build using ant:

    ant jar

#Prerequisite to Run the program
  
•	Java 1.8 
•	If Eclipse , LUNA version.
•	Ant version > 1.9.0
•	Junit 4.0

# Running

Running with a Inputfile ,and varible to convert
java - jar variable-name-conversion.jar InputJavaFile someVariable

for help
     java  –h or --help

# Design overview

I have considered the variable conversion for 2 formats. 1. LocalToConstant and 2. ConstanttoLocalField. Approach I have used is , creation of Base Strategies for Method and Field changes. As of now the changes are only for Field but the extension is open to add for Method as well. 

FieldConversionStrategy is base visitor and other childern of the class just give the CaseFormat. The Strategy pattern usage here helps us to add many more conversions out of the box which will not change any Design level logic.

Also there is a extension for GenericVisitorAdapter and VoidVisitorAdapter this is because if we need to refactor the returntype of any methods or so , it comes handy.

I have used JavaParser and also guvava  as supporting libraries. 


#Usage : 


The program expects 2 inputs , one is the input java file and other is the variableName which you want to convert. 
run for --help in arguments for more details.
As of now the changes are displayed on the console for easy visualization. 
I assume always you give a correct Variablename because giving wrong does not make a sense and also not a valid usecase.
 
	   


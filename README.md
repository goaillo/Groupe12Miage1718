# OpenCompareReverseJSON
The purpose of this project is to generate a Java object representing a PCM (Product Comparison Matrix) from the JSON representation of this PCM.
You can use it as an API in other projects.

## Installation
Import the project as a Maven project in Eclipse for example.
You need an Internet connection in order to download all the libraries.

## Project structure
The project contains three packages :
- main : contains the class Execution, which is the main class of the project ;
- classes : contains an import class (PCMImporter), a parser for the PCM (PCMParser) and all the classes useful to represent a PCM object (PCM, Feature, Product, Cell and the interface ConvertibleToJSONObject) ;
- test : contains the test class (TestPCM). Obviously, the JUnit library is required to launch this test class.

## How to
The main class offers two ways to import the JSON representation of a PCM :
- import a JSON file : on the console, enter the name of the file you want to import.
    WARNING : this file has to be in the folder jsonFiles of the project ;
- import the JSON from opencompare.org (needs the ID of the PCM, for example 595facdd701c0a48caa86c3a) : on the console, enter the ID of the PCM.
    If the ID is not assigned to any PCM, the PCM object will be null.

Then, you can use your PCM object however you want. Enjoy ;)

## Test
Import the JSON representation of the PCM like in the main class. Then, if the PCM is not null, the object is converted to JSON which is reconverted to a PCM object. This operation is realised ten times and, each time a new PCM is created, the test checks if the new PCM equals to the original.
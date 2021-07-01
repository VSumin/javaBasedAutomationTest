# javaBasedAutomationTest

Env:
```
cd PetClinic
./mvnw package
./mvnw spring-boot:run
```
Tests:
```
mvn clean test
```

The framework is based on Selenide https://selenide.org/ https://github.com/selenide/selenide


* abstract actions - actions, where only the result is important.
For example: we can receive the name of the owner by id using request to 'view' or 'edit' pages.
The result will be the same, but the way of receiving the result differs.
If the 'view' request is blocked by the bug, then we simply replace it with 'edit' with no risk breaking tests using this method.

* exact actions - actions, where the result is as important as the actions sequence and actions itself.
We can't replace/change these actions without detailed check of any tests which is using these actions.

* elements - wrappers around Selenide Element, provides level of abstraction to implement logging for example. 
Support hierarchy, where one element may be a parent of another. This is imprtant for the elements structuring for difficult pages

* pages - page object pattern pages. Can consist of modules.

* tests do test only happy path. The negative and border cases are not implemented.

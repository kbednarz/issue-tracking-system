# Requirements

* czy wykorzystano co najmniej trzy wzorce projektowe :heavy_check_mark: 
    * Creational: Factory pattern (e.g AttachmentFactory class)
    * [Transfer Object Pattern](https://www.tutorialspoint.com/design_pattern/transfer_object_pattern.htm)
    * Structural: Composite pattern (e.g. TaskBulkChangeComposite class)
    * Behavioral: Chain of Responsibility pattern (e.g. MailService class)
* czy prawidłowo zdekomponowano odpowiedzialności :heavy_check_mark: 
* czy wykorzystano jakiś wzorzec architektoniczny :heavy_check_mark: (Model-View-Controller)
* czy projekt jest Mavenowy i czy poprawnie buduje się z linii komend :heavy_check_mark: 
    * `mvn spring-boot:run`
* czy budowany jest przez Mavena wykonywalny jar :heavy_check_mark: 
    * `mvn package`
* czy zrealizowano co najmniej 5 przykładowych testów jednostkowych :heavy_check_mark: 
    * `mvn test`
    * ilość testów jednostkowych i integracyjnych: **9**
* czy testy jednostkowe mają status PASSED w trakcie procesu budowania projektu przez Mavena :heavy_check_mark: 
* czy projekt został umieszczony pod kontrolą wersji za pomocą Gita :heavy_check_mark:
* czy struktura gałęzi repozytorium jest prawidłowo zarządzana :heavy_check_mark: 
* czy skorzystano z interfejsów i/lub klas abstrakcyjnych :heavy_check_mark: 
    * np. _CrudServiceInterface_
* czy skorzystano z polimorfizmu :heavy_check_mark: 
    * np. _Attachment_

*Spełnione punkty oznaczamy* :heavy_check_mark: 
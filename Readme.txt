Workflow
1. All the requests will be handled by controllers present in "com.digiplan.controllers". Each controller will have 5 methods to 'get data by id', 'get all',
   'add', 'update' and 'delete'. 
2. "com.digiplan.entities" contain DAO(Data Access Object) classes.
3. "com.digiplan.repositories" contains interfaces which implements JPA(provide all methods which will be used to interact with DB).
4. In "com.digiplan.repositories" package we have interfaces which contains all service methods.
5. In "com.digiplan.servicesImpl" we have implementation classes of interfaces present in "com.digiplan.services" package.
6. All the configurations has been done through annotations and through application.properties
7. We have replaced getter, setters and constructors in DAO classes with Lombok.

Table Mapping in (com.digiplan.entities)
 1. City - alignwise_citymaster
 2. Comment - comment
 3. Dealer  - boooking_dealer
 4. Diagnosis - alignwise_diagnosis
 5. Doctor - alignwise_basicinfo
 6. Draft - alignwise_drafts
 7. ForgeViewer - forge_viewer_data
 8. Gallery - gallery
 9. Image - alignwise_images
10. IncompleteForm - incompleteform 
11. Patient - alignwise_basicinfopatient
12. Query - alignwise_query
13. TreatmentMethod - alignwise_treatmentmethods
14. User - alignwise_users
15. UserGroup - alignwise_usergroups

Request URL Mapping (Ex - City)
1. get - gitCity/id
2. getAll - getAllCities
3. add - addCity
4. update - updateCity/id
5. delete - deleteCity/id
All request mappings are done in same manner.

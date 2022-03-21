# new feature
# Tags: optional

Feature: login exitoso de un usuario
  yo como usuario de la pagina
  quiero realizar el registro
  para poder ingresar al sistema

  Scenario: realizar el login exitoso de un usuario en el sistema
    Given dado que me encuentro en el login, ingreso el email "eve.holt@reqres.in" y el password "cityslicka"
    When estoy en el modulo de login
    Then el sistema debe generar el codigo de respuesta

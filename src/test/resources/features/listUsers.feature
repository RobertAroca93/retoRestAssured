# new feature
# Tags: optional

Feature: consulta exitosa de usuarios
yo como usuario de la pagina
  quiero consultar la lista de usuarios
  para verificar la informacion de dichos usuarios

  Scenario: realizar la consulta exitosa de una lista de usuarios
    Given dado que o requiero consultar la lista de usuarios
    When me encuentro en el modulo de usuarios
    Then el sistema me debe mostrar dicha lista
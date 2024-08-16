Feature: criacao de usuario

  Scenario: usuario chama endpoint e criado no banco
    When o client chama a api
    And os dados sao validos
    Then o usuario e criado no banco

  Scenario Outline: api chama endpoint real e usuario criado no banco
    When a aplicacao e chamada com payload <json>
    And o <email> esta correto
    Then o usuario foi criado no banco
    Examples:
      | email             | json                                                                                                                              |
      | "email@email.com" | "{\"id\":1,\"name\":\"Usuario\",\"email\":\"email@email.com\",\"register\":\"registro\",\"password\":\"123\",\"typeUser\":\"1\"}" |
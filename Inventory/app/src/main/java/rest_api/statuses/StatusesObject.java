package rest_api.statuses;

/**
 * Created by stas.savinov on 11/23/2016.
 */

public class StatusesObject
{
    private String name;

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    private String id;

    public String getId() { return this.id; }

    public void setId(String id) { this.id = id; }
}

/*
[
  {
    "name": "Broken",
    "id": "690f5ae3-954c-405d-9d87-ae563d436535"
  },
  {
    "name": "Normal",
    "id": "e5a47b8a-f19b-43e5-b0ab-4db56166c155"
  },
  {
    "name": "Fixed",
    "id": "b71fc27b-a605-4c1d-b0da-71b1653d8579"
  },
  {
    "name": "Lost",
    "id": "a01dcb5e-2b34-41e1-821b-a4bd5e96a8fb"
  }
]
*/
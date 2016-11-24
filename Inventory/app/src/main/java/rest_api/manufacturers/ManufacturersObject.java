package rest_api.manufacturers;

/**
 * Created by stas.savinov on 11/23/2016.
 */

public class ManufacturersObject
{
    private boolean approved;

    public boolean getApproved() { return this.approved; }

    public void setApproved(boolean approved) { this.approved = approved; }

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
    "approved": true,
    "name": "EchoStar",
    "id": "c5ec86c2-d136-46d8-a040-af2137db076d"
  },
  {
    "approved": true,
    "name": "Samsung",
    "id": "45253537-617e-4245-aed4-cd63fe023abf"
  },
  {
    "approved": true,
    "name": "Apple",
    "id": "9b656d01-6d2d-4992-815d-5009d0f8bafa"
  },
  {
    "approved": true,
    "name": "MSI",
    "id": "6d9eff9f-d8de-4f4f-b950-fc022c69fdb9"
  }
]
*/
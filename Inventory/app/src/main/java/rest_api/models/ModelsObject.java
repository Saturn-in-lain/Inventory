package rest_api.models;

/**
 * Created by stas.savinov on 11/23/2016.
 */

public class ModelsObject
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
    "name": "iPhone 6",
    "id": "91b87c49-4fea-437c-9eab-2dadb9f35fd6"
  },
  {
    "approved": true,
    "name": "iPhone 6S",
    "id": "dfe0bc96-7846-4fc7-b268-4bc8cc8698ad"
  },
  {
    "approved": true,
    "name": "iPhone 7",
    "id": "28c4c4dd-a9cb-42c3-841d-85b3e6bd49eb"
  },
  {
    "approved": true,
    "name": "Galaxy 7",
    "id": "6b91ce05-8a2c-48e5-bf63-93840411de4c"
  },
  {
    "approved": true,
    "name": "Galaxy 7 Edge",
    "id": "d865bc2d-7f0f-48ca-9c0d-31b212a83d8d"
  },
  {
    "approved": true,
    "name": "Galaxy Note 7",
    "id": "3746f20f-6314-40c9-9265-8ee6591f0022"
  },
  {
    "approved": true,
    "name": "Google Pixel",
    "id": "82391478-3dfa-4c2d-9630-6be2cca6f1fd"
  },
  {
    "approved": true,
    "name": "iPhone 6S Plus",
    "id": "c93df312-44eb-4fea-b2e3-16678e65dd0f"
  },
  {
    "approved": true,
    "name": "XiP913",
    "id": "8aadf383-78bb-4428-a47e-0afcd63c9731"
  },
  {
    "approved": true,
    "name": "\\\\ясчячс",
    "id": "3ab676f2-e5e2-429f-9888-ba2f9a668553"
  }
]
*/
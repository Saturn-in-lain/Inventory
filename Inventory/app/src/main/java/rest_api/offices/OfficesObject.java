package rest_api.offices;

/**
 * Created by stas.savinov on 11/23/2016.
 */

public class OfficesObject
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
    "name": "Kharkiv",
    "id": "56b987f4-3b59-4d6e-89cd-32e5543fdbda"
  },
  {
    "name": "Bangalore",
    "id": "3489c1fe-5596-481b-a11e-b5eb579e8d93"
  },
  {
    "name": "Denver",
    "id": "4d6416c5-1b66-41f5-9255-6e1cc7c49bb0"
  },
  {
    "name": "Equip in Ilch house",
    "id": "957b0493-2d1d-49b8-ac65-70c75133ee11"
  }
]
*/
package rest_api.equipment;

import java.util.Date;

/**
 * Created by stas.savinov on 11/23/2016.
 */

public class EquipmentObject
{

    private String category;

    public String getCategory() { return this.category; }

    public void setCategory(String category) { this.category = category; }

    private String owner;

    public String getOwner() { return this.owner; }

    public void setOwner(String owner) { this.owner = owner; }

    private String location;

    public String getLocation() { return this.location; }

    public void setLocation(String location) { this.location = location; }

    private String office;

    public String getOffice() { return this.office; }

    public void setOffice(String office) { this.office = office; }

    private String creator;

    public String getCreator() { return this.creator; }

    public void setCreator(String creator) { this.creator = creator; }

    private int version;

    public int getVersion() { return this.version; }

    public void setVersion(int version) { this.version = version; }

    private String serial;

    public String getSerial() { return this.serial; }

    public void setSerial(String serial) { this.serial = serial; }

    private String bar;

    public String getBar() { return this.bar; }

    public void setBar(String bar) { this.bar = bar; }

    private int accountingCode;

    public int getAccountingCode() { return this.accountingCode; }

    public void setAccountingCode(int accountingCode) { this.accountingCode = accountingCode; }

    private String comment;

    public String getComment() { return this.comment; }

    public void setComment(String comment) { this.comment = comment; }

    private Date modified;

    public Date getModified() { return this.modified; }

    public void setModified(Date modified) { this.modified = modified; }

    private String state;

    public String getState() { return this.state; }

    public void setState(String state) { this.state = state; }

    private Date guaranteeExpiration;

    public Date getGuaranteeExpiration() { return this.guaranteeExpiration; }

    public void setGuaranteeExpiration(Date guaranteeExpiration) { this.guaranteeExpiration = guaranteeExpiration; }

    private String parent;

    public String getParent() { return this.parent; }

    public void setParent(String parent) { this.parent = parent; }

    private String id;

    public String getId() { return this.id; }

    public void setId(String id) { this.id = id; }

    private boolean secure;

    public boolean getSecure() { return this.secure; }

    public void setSecure(boolean secure) { this.secure = secure; }

    private String model;

    public String getModel() { return this.model; }

    public void setModel(String model) { this.model = model; }

    private String manufacturer;

    public String getManufacturer() { return this.manufacturer; }

    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    private String receiverId;

    public String getReceiverId() { return this.receiverId; }

    public void setReceiverId(String receiverId) { this.receiverId = receiverId; }

}
/*
[
        {
        "category": "bb8de681-3af9-48fb-9325-03d3a369cd9b",
        "owner": "00000000-0000-0000-0000-000000000000",
        "location": "37d9443f-9585-4bda-a857-252d16f72f26",
        "office": "56b987f4-3b59-4d6e-89cd-32e5543fdbda",
        "creator": "00000000-0000-0000-0000-000000000000",
        "version": 2147483647,
        "serial": "123",
        "bar": "123",
        "accountingCode": 123,
        "comment": "Something should be in here",
        "modified": "2016-11-17T15:34:41.141Z",
        "state": "a01dcb5e-2b34-41e1-821b-a4bd5e96a8fb",
        "guaranteeExpiration": "0001-01-01T00:00:00Z",
        "parent": "23ea9950-a045-4a9c-a488-50bec66e2ff8",
        "id": "23ea9950-a045-4a9c-a488-50bec66e2ff8",
        "secure": true,
        "model": "8aadf383-78bb-4428-a47e-0afcd63c9731",
        "manufacturer": "c5ec86c2-d136-46d8-a040-af2137db076d",
        "receiverId": "159357"
        },
        {
        "category": "bb8de681-3af9-48fb-9325-03d3a369cd9b",
        "owner": "00000000-0000-0000-0000-000000000000",
        "location": "37d9443f-9585-4bda-a857-252d16f72f26",
        "office": "56b987f4-3b59-4d6e-89cd-32e5543fdbda",
        "creator": "00000000-0000-0000-0000-000000000000",
        "version": 2147483647,
        "serial": "123",
        "bar": "123",
        "accountingCode": 123,
        "comment": "Something should be in here",
        "modified": "2016-11-22T11:08:20.129Z",
        "state": "a01dcb5e-2b34-41e1-821b-a4bd5e96a8fb",
        "guaranteeExpiration": "0001-01-01T00:00:00Z",
        "parent": "7aad4fa9-8a78-4305-be22-de15e4ba4fad",
        "id": "7aad4fa9-8a78-4305-be22-de15e4ba4fad",
        "secure": true,
        "model": "8aadf383-78bb-4428-a47e-0afcd63c9731",
        "manufacturer": "c5ec86c2-d136-46d8-a040-af2137db076d",
        "receiverId": "159357"
        },
        {
        "category": "bb8de681-3af9-48fb-9325-03d3a369cd9b",
        "owner": "00000000-0000-0000-0000-000000000000",
        "location": "37d9443f-9585-4bda-a857-252d16f72f26",
        "office": "56b987f4-3b59-4d6e-89cd-32e5543fdbda",
        "creator": "00000000-0000-0000-0000-000000000000",
        "version": 2147483647,
        "serial": "123",
        "bar": "123",
        "accountingCode": 123,
        "comment": "Something should be in here",
        "modified": "2016-11-22T11:08:24.789Z",
        "state": "a01dcb5e-2b34-41e1-821b-a4bd5e96a8fb",
        "guaranteeExpiration": "0001-01-01T00:00:00Z",
        "parent": "9fbd18cb-52a0-4d8d-b53e-ec70042e7942",
        "id": "9fbd18cb-52a0-4d8d-b53e-ec70042e7942",
        "secure": true,
        "model": "8aadf383-78bb-4428-a47e-0afcd63c9731",
        "manufacturer": "c5ec86c2-d136-46d8-a040-af2137db076d",
        "receiverId": "159357"
        },
        {
        "category": "bb8de681-3af9-48fb-9325-03d3a369cd9b",
        "owner": "00000000-0000-0000-0000-000000000000",
        "location": "37d9443f-9585-4bda-a857-252d16f72f26",
        "office": "56b987f4-3b59-4d6e-89cd-32e5543fdbda",
        "creator": "00000000-0000-0000-0000-000000000000",
        "version": 2147483647,
        "serial": "123",
        "bar": "123",
        "accountingCode": 124,
        "comment": "Something should be in here",
        "modified": "2016-11-22T11:28:01.724Z",
        "state": "a01dcb5e-2b34-41e1-821b-a4bd5e96a8fb",
        "guaranteeExpiration": "0001-01-01T00:00:00Z",
        "parent": "8f17ca1e-a0fa-4326-9347-f17e4605d218",
        "id": "8f17ca1e-a0fa-4326-9347-f17e4605d218",
        "secure": false,
        "model": "8aadf383-78bb-4428-a47e-0afcd63c9731",
        "manufacturer": "c5ec86c2-d136-46d8-a040-af2137db076d",
        "receiverId": "159358"
        },
        {
        "category": "bb8de681-3af9-48fb-9325-03d3a369cd9b",
        "owner": "00000000-0000-0000-0000-000000000000",
        "location": "37d9443f-9585-4bda-a857-252d16f72f26",
        "office": "56b987f4-3b59-4d6e-89cd-32e5543fdbda",
        "creator": "00000000-0000-0000-0000-000000000000",
        "version": 2147483647,
        "serial": "123",
        "bar": "123",
        "accountingCode": 124,
        "comment": "Something should be in here",
        "modified": "2016-11-22T11:28:18.756Z",
        "state": "a01dcb5e-2b34-41e1-821b-a4bd5e96a8fb",
        "guaranteeExpiration": "0001-01-01T00:00:00Z",
        "parent": "5e8ea0df-9436-47a8-83ab-b706d9318998",
        "id": "5e8ea0df-9436-47a8-83ab-b706d9318998",
        "secure": false,
        "model": "8aadf383-78bb-4428-a47e-0afcd63c9731",
        "manufacturer": "c5ec86c2-d136-46d8-a040-af2137db076d",
        "receiverId": "159358"
        }
        ]
*/
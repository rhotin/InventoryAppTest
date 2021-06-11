package com.rhappdeveloper.inventoryapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PartObject implements Parcelable {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("cost")
    @Expose
    private double cost;
    @SerializedName("partNumber")
    @Expose
    private String partNumber;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("inStock")
    @Expose
    private int inStock;
    @SerializedName("_id")
    @Expose
    private String _id;

    // State of the item
    private boolean expanded;

    protected PartObject(Parcel in) {
        id = in.readInt();
        cost = in.readDouble();
        partNumber = in.readString();
        name = in.readString();
        notes = in.readString();
        description = in.readString();
        byte tmpIsActive = in.readByte();
        isActive = tmpIsActive == 0 ? null : tmpIsActive == 1;
        image = in.readString();
        inStock = in.readInt();
        _id = in.readString();
        expanded = in.readByte() != 0;
    }

    public static final Creator<PartObject> CREATOR = new Creator<PartObject>() {
        @Override
        public PartObject createFromParcel(Parcel in) {
            return new PartObject(in);
        }

        @Override
        public PartObject[] newArray(int size) {
            return new PartObject[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
    public boolean isExpanded() {
        return expanded;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(cost);
        dest.writeValue(partNumber);
        dest.writeValue(name);
        dest.writeValue(notes);
        dest.writeValue(description);
        dest.writeValue(isActive);
        dest.writeValue(image);
        dest.writeValue(inStock);
        dest.writeValue(_id);
    }
}

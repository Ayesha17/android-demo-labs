package com.example.small.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author TechBirds
 * @date 14-8-12
 * @time 下午5:56
 * @vsersion 1.0
 */
public class Person implements Parcelable{


    public int uid;
    public String name;



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(uid);
        parcel.writeString(name);

    }

    public static final Parcelable.Creator<Person> CREATOR
            = new Parcelable.Creator<Person>() {
        public Person createFromParcel(Parcel in) {

            Person person = new Person();
            person.uid = in.readInt();
            person.name = in.readString();

            return person;
        }

        public Person[] newArray(int size) {
            return new Person[size];
        }
    };



}

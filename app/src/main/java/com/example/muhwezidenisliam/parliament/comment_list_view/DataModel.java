package com.example.muhwezidenisliam.parliament.comment_list_view;

/**
 * Created by anupamchugh on 09/02/16.
 */
public class DataModel {

    String person_name;
    int person_image;
    String comment;
    String time_ago;


    public DataModel(String person_name, int person_image, String comment, String time_ago) {
        this.person_name = person_name;
        this.person_image = person_image;
        this.comment = comment;
        this.time_ago = time_ago;

    }


    public String getPerson_name() {
        return person_name;
    }


    public int getPerson_image() {
        return person_image;
    }


    public String getComment() {
        return comment;
    }


    public String getTime_ago() {
        return time_ago;
    }

}
